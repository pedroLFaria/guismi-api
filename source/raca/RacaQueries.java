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
    @SqlUpdate
    Long insert(@BindBean Raca raca);

    @SqlUpdate
    Boolean update(@BindBean Raca raca);

    @SqlUpdate
    Boolean delete(@BindBean Raca raca);

    @SqlUpdate
    Boolean insertHasDescendencia(@BindBean Raca raca, Descendencia descendencia);

    @SqlUpdate
    Boolean insertHasEspecializacao(@BindBean Raca raca, Especializacao especializacao);

    @SqlUpdate
    Boolean insertHasHabilidade(@BindBean Raca raca, Habilidade habilidade);

    @SqlUpdate
    Boolean insertHasHabito(@BindBean Raca raca, Habito habito);

    @SqlUpdate
    Boolean insertHasIdioma(@BindBean Raca raca, Idioma idioma);

    @SqlUpdate
    Boolean insertHasPatronos(@BindBean Raca raca, Patrono patrono);

    default boolean cleanJunctionTables(Raca raca){
        boolean sucess;
        sucess = deleteHasEspecializacao(raca);
        sucess = deleteHasHabilidade(raca) && sucess;
        sucess = deleteHashabito(raca) && sucess;
        return sucess;
    }

    @SqlUpdate
    Boolean deleteHasDescendencia(@BindBean Raca raca);

    @SqlUpdate
    Boolean deleteHasEspecializacao(@BindBean Raca raca);

    @SqlUpdate
    Boolean deleteHasHabilidade(@BindBean Raca raca);

    @SqlUpdate
    Boolean deleteHashabito(@BindBean Raca raca);

    @SqlUpdate
    Boolean deleteHasIdioma(@BindBean Raca raca);

    @SqlUpdate
    Boolean deleteHasPatronos(@BindBean Raca raca);
}
