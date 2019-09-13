package reputacao;

import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Set;

@JDBI
public interface ReputacaoQueries {

    @SqlQuery("SELECT * FROM REPUTACAO")
    Set<Reputacao> findByObject();
}
