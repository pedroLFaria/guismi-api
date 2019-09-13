package inventario;

import item.Item;
import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Inventario {

    @Column
    Long idInventario;

    @Column
    String nomeInventario;

    Set<Item> items;
}
