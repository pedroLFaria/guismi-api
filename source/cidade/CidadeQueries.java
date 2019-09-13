package cidade;

import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Set;

@JDBI
public interface CidadeQueries {

    @SqlQuery("select * from cidade")
    Set<Cidade> findByObject();
}
