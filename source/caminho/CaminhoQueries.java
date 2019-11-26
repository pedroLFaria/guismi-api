package caminho;

import especializacao.Especializacao;
import ficha.Ficha;
import habilidade.Habilidade;
import habito.Habito;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface CaminhoQueries {

    @SqlQuery("select caminho.*, ficha_has_caminho.NIVELCAMINHO from ficha " +
            "right join ficha_has_caminho on ficha_has_caminho.IDFICHA = ficha.IDFICHA " +
            "right join caminho on caminho.IDCAMINHO = ficha_has_caminho.IDCAMINHO " +
            "where ficha.idficha = :idFicha")
    Set<Caminho> findByObject(@BindBean Ficha ficha);

    @SqlQuery("select * from caminho")
    Set<Caminho> findByObject();

    @GetGeneratedKeys
    @SqlUpdate("insert into caminho(NOMECAMINHO, DESCCAMINHO) values (:nomeCaminho,:descCaminho)")
    Long insert(@BindBean Caminho caminho);

    @SqlUpdate("insert into caminho_has_especializacao(IDESPECIALIZACAO, IDCAMINHO) values (:idEspecializacao, :idCaminho)")
    Boolean insertHasEspecializacao(@BindBean Caminho caminho, @BindBean Especializacao especializacao);

    @SqlUpdate("insert into caminho_has_habilidade(IDHABILIDADE, IDCAMINHO) values (:idHabilidade, :idCaminho)")
    Boolean insertHasHabilidade(@BindBean Caminho caminho, @BindBean Habilidade habilidade);

    @SqlUpdate("insert into caminho_has_habito(IDHABITO, IDCAMINHO, QTDCAMINHOHABITO) values (:idHabito, :idCaminho)")
    Boolean insertHasHabito(@BindBean Caminho caminho, @BindBean Habito habito);

    default boolean cleanJunctionTables(Caminho caminho){
        boolean sucess;
        sucess = deleteHasEspecializacao(caminho);
        sucess = deleteHasHabilidade(caminho) && sucess;
        sucess = deleteHashabito(caminho) && sucess;
        return sucess;
    }

    @SqlUpdate("delete from caminho_has_especializacao where IDCAMINHO = :idCaminho")
    Boolean deleteHasEspecializacao(@BindBean Caminho caminho);

    @SqlUpdate("delete from caminho_has_habilidade where IDCAMINHO = :idCaminho")
    Boolean deleteHasHabilidade(@BindBean Caminho caminho);

    @SqlUpdate("delete from caminho_has_habito where IDCAMINHO = :idCaminho")
    Boolean deleteHashabito(@BindBean Caminho caminho);
}
