package habito;

import caminho.Caminho;
import descendencia.Descendencia;
import especializacao.Especializacao;
import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import raca.Raca;

import java.util.Set;

@JDBI
public interface HabitoQueries {

    @SqlQuery("select * from habito")
    Set<Habito> findByObject();

    @SqlQuery("select habito.*,descendencia_has_habito.qtddescendenciahabito from descendencia " +
            "right join descendencia_has_habito on descendencia_has_habito.iddescendencia = descendencia.iddescendencia " +
            "right join habito on habito.idhabito = descendencia_has_habito.idhabito where descendencia.iddescendencia = :idDescendencia")
    Set<Habito> findByObject(@BindBean Descendencia descendencia);

    @SqlQuery("select habito.*,caminho_has_habito.qtdcaminhohabito from caminho " +
            "right join caminho_has_habito on caminho_has_habito.idcaminho = caminho.idcaminho " +
            "right join habito on habito.idhabito = caminho_has_habito.idhabito where caminho.idcaminho = :idCaminho")
    Set<Habito> findByObject(@BindBean Caminho Caminho);


    @SqlQuery("select habito.*,raca_has_habito.qtdracahabito from raca " +
            "right join raca_has_habito on raca_has_habito.idraca = raca.idraca " +
            "right join habito on habito.idhabito = raca_has_habito.idhabito where raca.idraca = :idRaca")
    Set<Habito> findByObject(@BindBean Raca Raca);

    @SqlQuery("select habito.*,ficha_has_habito.qtdfichahabito from ficha " +
            "right join ficha_has_habito on ficha_has_habito.idficha = ficha.idficha " +
            "right join habito on habito.idhabito = ficha_has_habito.idhabito where ficha.idficha = :idFicha")
    Set<Habito> findByObject(@BindBean Ficha ficha);

    @GetGeneratedKeys
    @SqlUpdate("insert into habito(NOMEHABITO, DESCHABITO) value (:nomeHabito, :descHabito)")
    Long insert(@BindBean Habito habito);

    @SqlUpdate("update habito set NOMEHABITO = :nomeHabito, DESCHABITO = :descHabito where IDHABITO = :idHabito")
    Boolean update(@BindBean Habito habito);

    @SqlUpdate("delete from habito where IDHABITO = :idHabito")
    Boolean delete(@BindBean Habito habito);

    @SqlUpdate("insert into habito_has_especializacao(IDHABITO, IDESPECIALIZACAO) values (:idHabito, :idEspecializacao)")
    Boolean insertHasEspecializacao(@BindBean Habito habito, @BindBean Especializacao especializacao);

    @SqlUpdate("delete from habito_has_especializacao where IDHABITO = :idHabito")
    Boolean deleteHasEspecializacao(@BindBean Habito habito);
}
