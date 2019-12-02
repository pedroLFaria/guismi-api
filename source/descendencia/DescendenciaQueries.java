package descendencia;

import ficha.Ficha;
import habilidade.Habilidade;
import habito.Habito;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import raca.Raca;
import sanidade.Sanidade;
import situacao.Situacao;

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

    @GetGeneratedKeys
    @SqlUpdate("insert into descendencia(NOMEDESCENDENCIA, DESCDESCENDENCIA) values(:nomeDescendencia, :descDescendencia)")
    Long insert(@BindBean Descendencia descendencia);

    @SqlUpdate("update descendencia set NOMEDESCENDENCIA = :nomeDescendencia, DESCDESCENDENCIA= :descDescendencia where " +
            "IDDESCENDENCIA = :idDescendencia")
    Boolean update(@BindBean Descendencia descendencia);

    @SqlUpdate("delete from descendencia where IDDESCENDENCIA = :idDescendencia")
    Boolean delete(@BindBean Descendencia descendencia);

    @SqlUpdate("insert into descendencia_has_habilidade(IDDESCENDENCIA,IDHABILIDADE) value(:idDescendencia, :idHabilidade)")
    Boolean insertHasHabilidade(@BindBean Descendencia descendencia, @BindBean Habilidade habilidade);

    @SqlUpdate("insert into descendencia_has_habito(IDDESCENDENCIA, IDHABITO, QTDDESCENDENCIAHABITO) value(:idDescendencia, :idHabito, :qtdFichaHabito)")
    Boolean insertHasHabitos(@BindBean Descendencia descendencia, @BindBean Habito habito);

    @SqlUpdate("insert into descendencia_has_sanidade(IDDESCENDENCIA, IDSANIDADE) value(:idDescendencia, :idSanidade)")
    Boolean insertHasSanidade(@BindBean Descendencia descendencia, @BindBean Sanidade sanidade);

    @SqlUpdate("insert into descendencia_has_situacao(IDDESCENDENCIA, IDSITUACAO value(:idDescendencia, idSituacao)")
    Boolean insertHasSituacao(@BindBean Descendencia descendencia, @BindBean Situacao situacao);

    default boolean cleanJunctionTables(Descendencia descendencia){
        boolean succes;
        succes = deleteHasHabilidade(descendencia);
        succes = deleteHasHabitos(descendencia) && succes;
        succes = deleteHasSanidade(descendencia) && succes;
        succes = deleteHasSitaucao(descendencia) && succes;
        return succes;
    }

    @SqlUpdate("delete from descendencia_has_habilidade where IDDESCENDENCIA = :idDescendencia")
    Boolean deleteHasHabilidade(@BindBean Descendencia descendencia);

    @SqlUpdate("delete from descendencia_has_habito where IDDESCENDENCIA = :idDescendencia")
    Boolean deleteHasHabitos(@BindBean Descendencia descendencia);

    @SqlUpdate("delete from descendencia_has_sanidade where IDDESCENDENCIA =  :idDescendencia")
    Boolean deleteHasSanidade(@BindBean Descendencia descendencia);

    @SqlUpdate("delete from descendencia_has_situacao where IDDESCENDENCIA =  :idDescendencia")
    Boolean deleteHasSitaucao(@BindBean Descendencia descendencia);
}
