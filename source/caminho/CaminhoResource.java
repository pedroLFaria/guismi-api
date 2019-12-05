package caminho;

import auth.Session;
import especializacao.EspecializacaoResource;
import ficha.Ficha;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import kikaha.urouting.api.*;
import lombok.var;

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
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    Response update(Caminho caminho, @Context Session session) {
        if (session.getMestre()) {
            return queries.cleanJunctionTables(caminho) && queries.update(caminho)
                    && insertJunctionTables(caminho) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    Response delete(Caminho caminho, @Context Session session) {
        if (session.getMestre()) {
            return queries.cleanJunctionTables(caminho) && queries.delete(caminho) ?
                    DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    private boolean insertJunctionTables(Caminho caminho) {
        boolean success = true;
        if (caminho.getEspecializacoes() != null)
            for (var especializacao : caminho.getEspecializacoes())
                success = queries.insertHasEspecializacao(caminho, especializacao) && success;
        if (caminho.getHabilidades() != null)
            for (var habilidade : caminho.getHabilidades())
                success = queries.insertHasHabilidade(caminho, habilidade) && success;
        if (caminho.getHabitos() != null)
            for (var habito : caminho.getHabitos())
                success = queries.insertHasHabito(caminho, habito) && success;
        return success;
    }
}
