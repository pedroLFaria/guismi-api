package sanidade;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface SanidadeQueries {

    @SqlQuery("select sanidade.* from ficha " +
            "right join sanidade on ficha.IDSANIDADE = sanidade.IDSANIDADE " +
            "where ficha.idficha = :idFicha")
    Sanidade findByObject(@BindBean Ficha ficha);

    @SqlQuery("SELECT * FROM SANIDADE")
    Set<Sanidade> findByObject();

    @GetGeneratedKeys
    @SqlUpdate("insert into sanidade( NOMESANIDADE, DESCSANIDADE) values (:nomeSanidade, :descSanidade)")
    Long insert(@BindBean Sanidade sanidade);

    @SqlUpdate("update sanidade set NOMESANIDADE = :nomeSanidade, DESCSANIDADE = :descSanidade where IDSANIDADE = :idSanidade")
    Boolean update(@BindBean Sanidade sanidade);

    @SqlUpdate("delete from sanidade where IDSANIDADE = :idSanidade")
    Boolean delete(@BindBean Sanidade sanidade);
}
