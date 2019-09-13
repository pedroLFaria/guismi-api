package raca;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Set;

@JDBI
public interface RacaQueries {

    @SqlQuery("select raca.* from ficha " +
            "right join raca on ficha.idraca = raca.idraca " +
            "where ficha.idficha = :idFicha")
    Raca findByObject(@BindBean Ficha ficha);

    @SqlQuery("select * from raca")
    Set<Raca> findByObject();
}
