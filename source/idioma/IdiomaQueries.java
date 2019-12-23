package idioma;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import raca.Raca;

import java.util.Set;

@JDBI
public interface IdiomaQueries {

    @SqlQuery("select idioma.* from ficha " +
            "right join ficha_has_idioma on ficha.idficha = ficha_has_idioma.idficha " +
            "right join idioma on ficha_has_idioma.ididioma = idioma.ididioma " +
            "where ficha.idficha = :idFicha")
    Set<Idioma> findByObject(@BindBean Ficha Ficha);

    @SqlQuery("select idioma.* from raca " +
            "right join raca_has_idioma on raca_has_idioma.idraca = raca.idraca " +
            "right join idioma on idioma.ididioma = raca_has_idioma.ididioma " +
            "where raca.idraca = :idRaca")
    Set<Idioma> findByObject(@BindBean Raca raca);

    @SqlQuery("select * from idioma")
    Set<Idioma> findByObject();

    @GetGeneratedKeys
    @SqlUpdate("insert into idioma(NOMEIDIOMA, DESCIDIOMA) value(:nomeIdioma, :descIdioma)")
    Long insert(@BindBean Idioma idioma);

    @SqlUpdate("update idioma set NOMEIDIOMA = :nomeIdioma, DESCIDIOMA = :descIdioma where IDIDIOMA =:idIdioma")
    Boolean update(@BindBean Idioma idioma);

    @SqlUpdate("delete from idioma where IDIDIOMA =:idIdioma")
    Boolean delete(@BindBean Idioma idioma);
}
