package patrono;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import raca.Raca;

import java.util.Set;

@JDBI
public interface PatronoQueries {

    @SqlQuery("select * from patrono")
    Set<Patrono> findByObject();

    @SqlQuery("select patrono.* from ficha " +
            "right join ficha_has_patrono on ficha.idficha = ficha_has_patrono.idficha " +
            "right join patrono on ficha_has_patrono.IDpatrono = patrono.IDpatrono " +
            "where ficha.idficha = :idFicha")
    Set<Patrono> findByObject(@BindBean Ficha ficha);

    @SqlQuery("select patrono.* from raca " +
            "right join raca_has_patrono on raca_has_patrono.idraca = raca.idraca " +
            "right join patrono on patrono.idpatrono = raca_has_patrono.idpatrono " +
            "where raca.idraca = :idRaca")
    Set<Patrono> findByObject(@BindBean Raca raca);

    @GetGeneratedKeys
    @SqlUpdate
    Long insert(@BindBean Patrono patrono);

    @SqlUpdate
    Boolean update(@BindBean Patrono patrono);

    @SqlUpdate
    Boolean delete(@BindBean Patrono patrono);
}
