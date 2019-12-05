package sanidade;

import auth.Session;
import ficha.Ficha;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class SanidadeResource {

    @Inject
    SanidadeQueries queries;

    public<T> Sanidade findByObject(T object){
        return queries.findByObject((Ficha) object);
    }

    public Set<Sanidade> findByObject(){
        Set<Sanidade> sanidades = queries.findByObject();
        return sanidades;
    }

    @POST
    public Response insert(Sanidade sanidade, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(sanidade);
            return DefaultResponse
                    .created("api/sanidade/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    public Response update(Sanidade sanidade, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(sanidade) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    public Response delete(Sanidade sanidade, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(sanidade) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }
}
