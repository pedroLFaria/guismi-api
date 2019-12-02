package inventario;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface InventarioQueries {

    @SqlQuery("select inventario.* from ficha " +
            "right join ficha_has_inventario on ficha.idficha = ficha_has_inventario.idficha " +
            "right join inventario on ficha_has_inventario.idinventario = inventario.idinventario where ficha.idficha = :idFicha")
    Set<Inventario> findByObject(@BindBean Ficha ficha);

    @GetGeneratedKeys
    @SqlQuery("insert into inventario(NOMEINVENTARIO) values(:nomeInventario")
    Long insert(@BindBean Inventario inventario);

    @SqlUpdate("update inventario set NOMEINVENTARIO = :nomeInventario where IDINVENTARIO =:idInventario")
    Boolean update(@BindBean Inventario inventario);

    @SqlUpdate("delete from inventario where IDINVENTARIO =:idInventario")
    Boolean delete(@BindBean Inventario inventario);
}
