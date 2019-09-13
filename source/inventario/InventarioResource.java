package inventario;

import ficha.Ficha;
import item.ItemResource;
import kikaha.urouting.api.Path;
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
}