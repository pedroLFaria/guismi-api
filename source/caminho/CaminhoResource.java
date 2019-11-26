package caminho;

import auth.Session;
import especializacao.EspecializacaoResource;
import ficha.Ficha;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Path("api/caminho/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class CaminhoResource {

    @Inject
    CaminhoQueries queries;

    @Inject
    HabilidadeResource habilidadeResource;

    @Inject
    EspecializacaoResource especializacaoResource;

    @Inject
    HabitoResource habitoResource;

    public <T> Set<Caminho> findByObject(T object) {
        return preenche(queries.findByObject((Ficha) object));
    }

    public Set<Caminho> findByObject() {
        return preenche(queries.findByObject());
    }

    private Set<Caminho> preenche(Set<Caminho> caminhos) {
        for (Caminho caminho : caminhos) {
            caminho.setEspecializacoes(especializacaoResource.findByObject(caminho));
            caminho.setHabilidades(habilidadeResource.findByObject(caminho));
            caminho.setHabitos(habitoResource.findByObject(caminho));
        }
        return caminhos;
    }

    @POST
    Response insert(Caminho caminho, @Context Session session) {
        if (session.getMestre()) {
            Long id = queries.insert(caminho);
            insertJunctionTables(caminho);
            return DefaultResponse.created("api/caminho/" + id).header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @PUT
    Response update(Caminho caminho, @Context Session session){
        if (session.getMestre()) {
            return queries.cleanJunctionTables(caminho) && queries.update(caminho)
                    && insertJunctionTables(caminho) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @DELETE
    Response delete(Caminho caminho, @Context Session session){
        if (session.getMestre()) {
            return queries.cleanJunctionTables(caminho) && queries.delete(caminho) ?
                    DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    private void insertJunctionTables(Caminho caminho) {
        if (caminho.getEspecializacoes() != null) {
            caminho.getEspecializacoes().forEach(especializacao -> {
                queries.insertHasEspecializacao(caminho, especializacao);
            });
            caminho.getHabilidades().forEach(habilidade -> {
                queries.insertHasHabilidade(caminho, habilidade);
            });
            caminho.getHabitos().forEach(habito -> {
                queries.insertHasHabito(caminho, habito);
            });
        }
    }
}
