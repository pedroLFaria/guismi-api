package reputacao;

import auth.Session;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Path("api/reputacao")
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class ReputacaoResource {

    @Inject
    ReputacaoQueries queries;

    public Set<Reputacao> findByObject(){
        Set<Reputacao> reputacaos = queries.findByObject();
        return reputacaos;
    }

    @POST
    public Response insert(Reputacao reputacao, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(reputacao);
            return DefaultResponse
                    .created("api/reputacao/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @PUT
    public Response update(Reputacao reputacao, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(reputacao) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @DELETE
    public Response delete(Reputacao reputacao, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(reputacao) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }
}
