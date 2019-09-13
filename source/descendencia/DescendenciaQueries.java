package descendencia;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import raca.Raca;

import java.util.Set;

@JDBI
public interface DescendenciaQueries {


    @SqlQuery("select * from descendencia")
    Set<Descendencia> findByObject();

    @SqlQuery("select descendencia.* from ficha " +
            "right join ficha_has_descendencia on ficha_has_descendencia.idficha = ficha.idficha " +
            "right join descendencia on ficha_has_descendencia.iddescendencia = descendencia.iddescendencia " +
            "where ficha.idficha = :idFicha")
    Set<Descendencia> findByObject(@BindBean Ficha ficha);

    @SqlQuery("select descendencia.* from raca " +
            "right join raca_has_descendencia on raca_has_descendencia.idraca = raca.idraca " +
            "right join descendencia on descendencia.iddescendencia = raca_has_descendencia.iddescendencia " +
            "where raca.idraca = :idRaca")
    Set<Descendencia> findByObject(@BindBean Raca raca);
}
