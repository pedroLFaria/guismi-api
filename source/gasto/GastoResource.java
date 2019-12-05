package gasto;

import auth.Session;
import habilidade.Habilidade;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Path("api/gasto/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class GastoResource {
    @Inject
    GastoQueries queries;

    public <T> Set<Gasto> findByObject(T object){
        return  queries.findByObject((Habilidade) object);
    }

    @POST
    public Response insert(Gasto gasto, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(gasto);
            return DefaultResponse
                    .created("api/gasto/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    public Response update(Gasto gasto, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(gasto) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    public Response delete(Gasto gasto, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(gasto) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }
}
