package item;

import auth.Session;
import inventario.Inventario;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Path("api/item/")
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class ItemResource {

    @Inject
    ItemQueries queries;

    public <T> Set<Item> findByObject(T object){
        return queries.findByObject((Inventario) object);
    }

    public Set<Item> findByObject(){
        return queries.findByObject();
    }

    @POST
    public Response insert(Item item, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(item);
            return DefaultResponse
                    .created("api/item/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @PUT
    public Response update(Item item, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(item) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @DELETE
    public Response delete(Item item, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(item) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }
}
