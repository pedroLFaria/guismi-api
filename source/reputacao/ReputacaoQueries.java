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
    @SqlUpdate("insert into reputacao(NOMEREPUTACAO) values(:nomeReputacao)")
    Long insert(@BindBean Reputacao reputacao);

    @SqlUpdate("update reputacao set NOMEREPUTACAO = :nomeReputacao where IDREPUTACAO = :idReputacao")
    Boolean update(@BindBean Reputacao reputacao);

    @SqlUpdate("delete from reputacao where IDREPUTACAO = :idReputacao")
    Boolean delete(@BindBean Reputacao reputacao);
}
