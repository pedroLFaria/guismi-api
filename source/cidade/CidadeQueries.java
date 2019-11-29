package cidade;

import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface CidadeQueries {

    @SqlQuery("select * from cidade")
    Set<Cidade> findByObject();

    @GetGeneratedKeys
    @SqlUpdate("insert into cidade(NOMECIDADE, DESCCIDADE, POPCIDADE) values(:nomeCidade,:descCidade,:popCidade)")
    Long insert(@BindBean Cidade cidade);

    @SqlUpdate("update cidade set NOMECIDADE = :nomeCidade , DESCCIDADE= :descCidade, POPCIDADE = :popCidade")
    Boolean update(@BindBean Cidade cidade);

    @SqlUpdate("delete from  cidade where IDCIDADE = :idCidade")
    Boolean delete(@BindBean Cidade cidade);
}
