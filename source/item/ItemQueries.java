package item;

import inventario.Inventario;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface ItemQueries {

    @SqlQuery("SELECT * FROM item")
    Set<Item> findByObject();

    @SqlQuery("SELECT item.*,inventario_has_item.QTDINVENTARIOITEM FROM inventario " +
            "left join inventario_has_item on inventario_has_item.IDINVENTARIO " +
            "left join item on item.IDITEM = inventario_has_item.IDITEM where inventario.IDINVENTARIO = :idInventario")
    Set<Item> findByObject(@BindBean Inventario inventario);

    @GetGeneratedKeys
    @SqlUpdate("insert into item(NOMEITEM, DESCITEM, PESOITEM, VALORMAGICO, VALORITEM, MOEDA, ICONEITEM) values(:nomeItem, " +
            ":descItem, :pesoItem, :valorMagico, :valorItem, :moeda, :iconeItem)")
    Long insert(@BindBean Item item);

    @SqlUpdate("update item set NOMEITEM = :nomeItem, DESCITEM = :descItem, PESOITEM = :pesoItem, VALORMAGICO = :valorMagico" +
            ", VALORITEM = :valorItem, MOEDA = :moeda, ICONEITEM = :iconeItem where IDITEM = :idItem")
    Boolean update(@BindBean Item item);

    @SqlUpdate("delete from item where IDITEM = :idItem")
    Boolean delete(@BindBean Item item);
}
