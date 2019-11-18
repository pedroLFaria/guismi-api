package sanidade;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Set;

@JDBI
public interface SanidadeQueries {

    @SqlQuery("select sanidade.* from ficha " +
            "right join sanidade on ficha.IDSANIDADE = sanidade.IDSANIDADE " +
            "where ficha.idficha = :idFicha")
    Sanidade findByObject(@BindBean Ficha ficha);

    @SqlQuery("SELECT * FROM SANIDADE")
    Set<Sanidade> findByObject();

}
