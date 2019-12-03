package reputacao;

import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface ReputacaoQueries {

    @SqlQuery("SELECT * FROM REPUTACAO")
    Set<Reputacao> findByObject();

    @GetGeneratedKeys
    @SqlUpdate
    Long insert(@BindBean Reputacao reputacao);

    @SqlUpdate
    Boolean update(@BindBean Reputacao reputacao);

    @SqlUpdate
    Boolean delete(@BindBean Reputacao reputacao);
}
