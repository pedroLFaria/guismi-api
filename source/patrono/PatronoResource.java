package patrono;

import auth.Session;
import ficha.Ficha;
import kikaha.urouting.api.*;
import raca.Raca;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.Set;

@Path("api/patrono/")
@Singleton
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class PatronoResource {

    @Inject
    PatronoQueries queries;

    public <T> Set<Patrono> findByObject(T object){
        switch (object.getClass().getName()){
            case "raca.Raca":
                return queries.findByObject((Raca) object);
            case "ficha.Ficha":
                return queries.findByObject((Ficha) object);
            default:
                return Collections.emptySet();
        }
    }

    public Set<Patrono> findByObject(){
        return queries.findByObject();
    }

    @POST
    public Response insert(Patrono patrono, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(patrono);
            return DefaultResponse
                    .created("api/patrono/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    public Response update(Patrono patrono, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(patrono) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    public Response delete(Patrono patrono, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(patrono) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }
}
