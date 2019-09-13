package sanidade;

import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Set;

@JDBI
public interface SanidadeQueries {

    @SqlQuery("SELECT * FROM SANIDADE")
    Set<Sanidade> findByObject();

}
