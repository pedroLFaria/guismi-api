package descendencia;

import auth.Session;
import ficha.Ficha;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import kikaha.urouting.api.*;
import lombok.var;
import raca.Raca;
import sanidade.SanidadeResource;
import situacao.SituacaoResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Path("api/descendencia/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class DescendenciaResource {

    @Inject
    DescendenciaQueries queries;

    @Inject
    HabilidadeResource habilidadeResource;

    @Inject
    HabitoResource habitoResource;

    @Inject
    SanidadeResource sanidadeResource;

    @Inject
    SituacaoResource situacaoResource;

    public <T> Set<Descendencia> findByObject(T object) throws ClassCastException {
        switch (object.getClass().getName()) {
            case "raca.Raca":
                return preencher(queries.findByObject((Raca) object));
            case "ficha.Ficha":
                return preencher(queries.findByObject((Ficha) object));
            default:
                throw new ClassCastException("Método não pode receber está classe.");
        }
    }

    public Set<Descendencia> findByObject() {
        return preencher(queries.findByObject());
    }

    private Set<Descendencia> preencher(Set<Descendencia> descendencias) {
        for (Descendencia descendencia : descendencias) {
            descendencia.setHabilidades(habilidadeResource.findByObject(descendencia));
            descendencia.setHabitos(habitoResource.findByObject(descendencia));
            descendencia.setSituacoes(situacaoResource.findByObject(descendencia));
        }
        return descendencias;
    }

    @POST
    public Response insert(Descendencia descendencia, @Context Session session) {
        if (session.getMestre()) {
            Long id = queries.insert(descendencia);
            insertJunctionTables(descendencia);
            return DefaultResponse.created("api/descendencia/" + id).header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    public Response update(Descendencia descendencia, @Context Session session){
        if (session.getMestre()) {
            return queries.cleanJunctionTables(descendencia) && queries.update(descendencia)
                    && insertJunctionTables(descendencia) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    public Response delete(Descendencia descendencia, @Context Session session){
        if (session.getMestre()) {
            return queries.cleanJunctionTables(descendencia) && queries.delete(descendencia) ?
                    DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    private boolean insertJunctionTables(Descendencia descendencia) {
        boolean success = true;
        if (descendencia.getHabilidades() != null)
            for (var habilidade : descendencia.getHabilidades())
                success = queries.insertHasHabilidade(descendencia, habilidade) && success;
        if (descendencia.getHabitos() != null)
            for (var habitos : descendencia.getHabitos())
                success = queries.insertHasHabitos(descendencia, habitos) && success;
        if (descendencia.getSanidade() != null)
            success = queries.insertHasSanidade(descendencia, descendencia.getSanidade()) && success;
        if (descendencia.getSituacoes() != null)
            for (var situacao : descendencia.getSituacoes())
                success = queries.insertHasSituacao(descendencia, situacao) && success;
        return success;
    }
}
