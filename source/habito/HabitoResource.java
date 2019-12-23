package habito;

import auth.Session;
import caminho.Caminho;
import descendencia.Descendencia;
import especializacao.EspecializacaoResource;
import ficha.Ficha;
import kikaha.urouting.api.*;
import lombok.var;
import raca.Raca;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Path("api/habito/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class HabitoResource {
    @Inject
    private HabitoQueries queries;

    @Inject
    private EspecializacaoResource especializacaoResource;

    public <T>Set<Habito> findByObject(T object) throws NoClassDefFoundError{
        switch (object.getClass().getName()) {
            case "descendencia.Descendencia":
                return preenche(queries.findByObject((Descendencia) object));
            case "caminho.Caminho":
                return preenche(queries.findByObject((Caminho) object));
            case "raca.Raca":
                return preenche(queries.findByObject((Raca) object));
            case "ficha.Ficha":
                return preenche(queries.findByObject((Ficha) object));
            default:
                throw new NoClassDefFoundError("Classe não definida no método.");
        }
    }
    public Set<Habito> findByObject(){
        return preenche(queries.findByObject());
    }
    private Set<Habito> preenche(Set<Habito> habitos){
        for(Habito habito : habitos){
            habito.setEspecializacoes(especializacaoResource.findByObject(habito));
        }
        return habitos;
    }

    @POST
    public Response insert(Habito habito, @Context Session session) {
        if (session.getMestre()) {
            Long id = queries.insert(habito);
            insertJunctionTables(habito);
            return DefaultResponse.created("api/habilidade/" + id).header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    public Response update(Habito habito, @Context Session session){
        if (session.getMestre()) {
            return queries.deleteHasEspecializacao(habito) && queries.update(habito)
                    && insertJunctionTables(habito) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    public Response delete(Habito habito, @Context Session session){
        if (session.getMestre()) {
            return queries.deleteHasEspecializacao(habito) && queries.delete(habito) ?
                    DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    private boolean insertJunctionTables(Habito habito){
        boolean success = true;
        if(habito.getEspecializacoes() != null)
            for(var especializacao : habito.getEspecializacoes())
                success = queries.insertHasEspecializacao(habito, especializacao) && success;
        return success;
    }
}
