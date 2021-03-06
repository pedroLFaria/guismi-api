package acao;

import auth.Session;
import habilidade.Habilidade;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Path("api/acao/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class AcaoResource {
    @Inject
    AcaoQueries queries;

    @POST
    public Response insertNewAcao(Acao acao, @Context Session session) {
        if (session.getMestre()) {
            long id = queries.insert(acao);
            return DefaultResponse
                    .created("api/acao/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    public Response update(Acao acao, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(acao) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    public Response delete(Acao acao, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(acao) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    public <T> Set<Acao> findByObject(T object) {
        return queries.findByIdObject((Habilidade) object);
    }

    public Acao findByObject(Acao acao){
        return queries.findByIdObject(acao);
    }
}
