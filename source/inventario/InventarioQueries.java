package inventario;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Set;

@JDBI
public interface InventarioQueries {

    @SqlQuery("select inventario.* from ficha " +
            "right join ficha_has_inventario on ficha.idficha = ficha_has_inventario.idficha " +
            "right join inventario on ficha_has_inventario.idinventario = inventario.idinventario where ficha.idficha = :idFicha")
    Set<Inventario> findByObject(@BindBean Ficha ficha);

    @SqlQuery("insert into inventario(nomeinventario) values(:nomeInventario")
    Long insert(@BindBean Inventario inventario);
}
