package inventario;

import auth.Session;
import ficha.Ficha;
import item.ItemResource;
import kikaha.urouting.api.*;
import lombok.val;

import javax.inject.Inject;
import java.util.Set;

@Path("inventario/")
public class InventarioResource {

    @Inject
    InventarioQueries queries;

    @Inject
    ItemResource itemResource;

   public <T>  Set<Inventario> findByObject(T object){
       val inventarios = queries.findByObject((Ficha)object);
       return preenche(inventarios);
    }

    private Set<Inventario> preenche(Set<Inventario> inventarios) {
        if (inventarios != null)
            for (Inventario inventario : inventarios)
                inventario.setItems(itemResource.findByObject(inventario));
        return inventarios;
   }

    @POST
    public Response insert(Inventario inventario, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(inventario);
            return DefaultResponse
                    .created("api/inventario/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @PUT
    public Response update(Inventario inventario, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(inventario) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @DELETE
    public Response delete(Inventario inventario, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(inventario) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }
}
