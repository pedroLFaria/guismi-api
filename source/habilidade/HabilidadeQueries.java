package habilidade;

import acao.Acao;
import caminho.Caminho;
import descendencia.Descendencia;
import ficha.Ficha;
import gasto.Gasto;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import raca.Raca;
import situacao.Situacao;

import java.util.Set;

@JDBI
public interface HabilidadeQueries {

    @SqlQuery("select * from habilidade")
    Set<Habilidade> findByObject();

    @SqlQuery("select habilidade.* from raca " +
            "right join raca_has_habilidade on raca_has_habilidade.idraca = raca.idraca " +
            "right join habilidade on habilidade.idhabilidade = raca_has_habilidade.idhabilidade " +
            "where raca.idraca = :idRaca")
    Set<Habilidade> findByObject(@BindBean Raca raca);

    @SqlQuery("select habilidade.* from caminho " +
            "right join caminho_has_habilidade on caminho_has_habilidade.idcaminho = caminho.idcaminho " +
            "right join habilidade on habilidade.idhabilidade = caminho_has_habilidade.idhabilidade " +
            "where caminho.idcaminho = :idCaminho")
    Set<Habilidade> findByObject(@BindBean Caminho caminho);

    @SqlQuery("select habilidade.* from descendencia " +
            "right join descendencia_has_habilidade on descendencia_has_habilidade.iddescendencia = descendencia.iddescendencia " +
            "right join habilidade on habilidade.idhabilidade = descendencia_has_habilidade.idhabilidade " +
            "where descendencia.iddescendencia = :idDescendencia")
    Set<Habilidade> findByObject(@BindBean Descendencia descendencia);

    @SqlQuery("select habilidade.* from ficha " +
            "right join ficha_has_habilidade on ficha.idficha = ficha_has_habilidade.idficha " +
            "right join habilidade on ficha_has_habilidade.idhabilidade = habilidade.idhabilidade " +
            "where ficha.idficha =:idFicha")
    Set<Habilidade> findByObject(@BindBean Ficha ficha);

    @GetGeneratedKeys
    @SqlUpdate("insert into habilidade(NOMEHABILIDADE, ATRATACANTE, TIPOHABILIDADE, UTIHABILIDADE, DESCHABILIDADE, " +
            "PREREQUISITO, NIVELREQUERIDO) values (:nomeHabilidade, :atrAtacante, :tipoHabilidade, " +
            ":utiHabilidade, :descHabilidade, :prerequisito, :nivelRequerido)")
    Long insert(@BindBean Habilidade habilidade);

    @SqlUpdate("update habilidade set NOMEHABILIDADE = :nomeHabilidade, ATRATACANTE = :atrAtacante, " +
            "TIPOHABILIDADE = :tipoHabilidade, UTIHABILIDADE = :utiHabilidade, DESCHABILIDADE = :descHabilidade, " +
            "PREREQUISITO = :prerequisito, NIVELREQUERIDO = :nivelRequerido where :idHabilidade")
    Boolean update(@BindBean Habilidade habilidade);

    @SqlUpdate("delete from habilidade where IDHABILIDADE = :idHabilidade")
    Boolean delete(@BindBean Habilidade habilidade);

    @SqlUpdate("insert into habilidade_has_acao(IDHABILIDADE, IDACAO) values (:idHabilidade, :idAcao)")
    Boolean insertHasAcao(@BindBean Habilidade habilidade, @BindBean Acao acao);

    @SqlUpdate("insert into habilidade_has_gasto(IDHABILIDADE, IDGASTO) values (:idHabilidade, :idGasto)")
    Boolean insertHasGasto(@BindBean Habilidade habilidade, @BindBean Gasto gasto);

    @SqlUpdate("insert into habilidade_has_situacao(IDHABILIDADE, IDSITUACAO) values (:idHabilidade, :idSituacao)")
    Boolean insertHasSituacao(@BindBean Habilidade habilidade, @BindBean Situacao situacao);

    default boolean cleanJunctionTables(Habilidade habilidade) {
        boolean success;
        success = deleteHasAcao(habilidade);
        success = deleteHasGasto(habilidade) && success;
        success = deleteHasSituacao(habilidade) && success;
        return success;
    }

    @SqlUpdate("delete from habilidade_has_acao where IDHABILIDADE = :idHabilidade")
    Boolean deleteHasAcao(@BindBean Habilidade habilidade);

    @SqlUpdate("delete from habilidade_has_gasto where IDHABILIDADE = :idHabilidade")
    Boolean deleteHasGasto(@BindBean Habilidade habilidade);

    @SqlUpdate("delete from habilidade_has_situacao where IDHABILIDADE = :idHabilidade")
    Boolean deleteHasSituacao(@BindBean Habilidade habilidade);
}
