package raca;

import descendencia.Descendencia;
import especializacao.Especializacao;
import ficha.Ficha;
import habilidade.Habilidade;
import habito.Habito;
import idioma.Idioma;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import patrono.Patrono;

import java.util.Set;

@JDBI
public interface RacaQueries {

    @SqlQuery("select raca.* from ficha " +
            "right join raca on ficha.idraca = raca.idraca " +
            "where ficha.idficha = :idFicha")
    Raca findByObject(@BindBean Ficha ficha);

    @SqlQuery("select * from raca")
    Set<Raca> findByObject();

    @GetGeneratedKeys
    @SqlUpdate("insert into raca (NOMERACA, RARIDADERACA, DESCRACA, LONGEVIDADERACA, TRACOSFISIOLOGICOS, CULTURARACA, " +
            "HISTORIARACA, RACAFORCA, RACACONSTITUICAO, RACAAGILIDADE, RACADESTREZA, RACAINTELIGENCIA, RACASABEDORIA, " +
            "RACACARISMA, SANGUE, VIGOR) values (:nomeRaca, :raridadeRaca, :descRaca, :longevidadeRaca, :tracosFisiologicos, " +
            ":culturaRaca, :historiaRaca,:racaForca, :racaConstituicao, :racaAgilidade, :racaDestreza, :racaInteligencia, " +
            ":racaSabedoria, :racaCarisma, :sangue, :vigor)")
    Long insert(@BindBean Raca raca);

    @SqlUpdate("update raca set NOMERACA = :nomeRaca, RARIDADERACA = :raridadeRaca, DESCRACA = :descRaca, " +
            "LONGEVIDADERACA = :longevidadeRaca, TRACOSFISIOLOGICOS = :tracosFisiologicos, CULTURARACA = :culturaRaca, " +
            "HISTORIARACA = :historiaRaca, RACAFORCA = :racaForca, RACACONSTITUICAO = :racaConstituicao, " +
            "RACAAGILIDADE = :racaAgilidade, RACADESTREZA = :racaDestreza, RACAINTELIGENCIA = :racaInteligencia, " +
            "RACASABEDORIA = :racaSabedoria, RACACARISMA = :racaCarisma, SANGUE = :sangue, VIGOR = :vigor where IDRACA = :idRaca")
    Boolean update(@BindBean Raca raca);

    @SqlUpdate("delete from raca where IDRACA = :idRaca ")
    Boolean delete(@BindBean Raca raca);

    @SqlUpdate("insert into raca_has_descendencia(IDRACA, IDDESCENDENCIA) values(:idRaca, :idDescendencia)")
    Boolean insertHasDescendencia(@BindBean Raca raca, Descendencia descendencia);

    @SqlUpdate("insert into raca_has_especializacao(IDRACA, IDESPECIALIZACAO) values(:idRaca, :idEspecializacao)")
    Boolean insertHasEspecializacao(@BindBean Raca raca, Especializacao especializacao);

    @SqlUpdate("insert into raca_has_habilidade(IDRACA, IDHABILIDADE) values(:idRaca, :idHabilidade)")
    Boolean insertHasHabilidade(@BindBean Raca raca, Habilidade habilidade);

    @SqlUpdate("insert into raca_has_habito(IDRACA, IDHABITO) values(:idRaca, :idHabito)")
    Boolean insertHasHabito(@BindBean Raca raca, Habito habito);

    @SqlUpdate("insert into raca_has_idioma(IDRACA, IDIDIOMA) values(:idRaca, :idIdioma)")
    Boolean insertHasIdioma(@BindBean Raca raca, Idioma idioma);

    @SqlUpdate("insert into raca_has_patrono(IDRACA, IDPATRONO) values(:idRaca, :idPatrono)")
    Boolean insertHasPatronos(@BindBean Raca raca, Patrono patrono);

    default boolean cleanJunctionTables(Raca raca){
        boolean sucess;
        sucess = deleteHasEspecializacao(raca);
        sucess = deleteHasHabilidade(raca) && sucess;
        sucess = deleteHashabito(raca) && sucess;
        return sucess;
    }

    @SqlUpdate("delete from raca_has_descendencia where IDRACA = :idRaca")
    Boolean deleteHasDescendencia(@BindBean Raca raca);

    @SqlUpdate("delete from raca_has_especializacao where IDRACA = :idRaca")
    Boolean deleteHasEspecializacao(@BindBean Raca raca);

    @SqlUpdate("delete from raca_has_habilidade where IDRACA = :idRaca")
    Boolean deleteHasHabilidade(@BindBean Raca raca);

    @SqlUpdate("delete from raca_has_habito where IDRACA = :idRaca")
    Boolean deleteHashabito(@BindBean Raca raca);

    @SqlUpdate("delete from raca_has_idioma where IDRACA = :idRaca")
    Boolean deleteHasIdioma(@BindBean Raca raca);

    @SqlUpdate("delete from raca_has_patronos where IDRACA = :idRaca")
    Boolean deleteHasPatronos(@BindBean Raca raca);
}
