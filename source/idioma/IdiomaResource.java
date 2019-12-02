package idioma;

import auth.Session;
import ficha.Ficha;
import kikaha.urouting.api.*;
import raca.Raca;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("api/idioma/")
@Singleton
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class IdiomaResource {

    @Inject
    IdiomaQueries queries;

    public <T> Set<Idioma> findByObject(T object){
        Set<Idioma> idiomas = new LinkedHashSet<>();
        switch (idiomas.getClass().getName()){
            case "raca.Raca":
                idiomas = queries.findByObject((Raca) object);
                break;
            case "ficha.Ficha":
                idiomas = queries.findByObject((Ficha) object);
                break;
        }
        return idiomas;
    }
    public Set<Idioma> findByObject(){
        return queries.findByObject();
    }

    @POST
    public Response insert(Idioma idioma, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(idioma);
            return DefaultResponse
                    .created("api/idioma/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @PUT
    public Response update(Idioma idioma, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(idioma) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @DELETE
    public Response delete(Idioma idioma, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(idioma) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }
}
