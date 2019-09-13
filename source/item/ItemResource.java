package item;

import inventario.Inventario;
import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Path("api/item")
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
}
