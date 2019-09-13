package especializacao;

import ficha.Ficha;
import habito.Habito;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import raca.Raca;

import java.util.Set;

@JDBI
public interface EspecializacaoQueries {

    @SqlQuery("select especializacao.* from ficha " +
            "right join ficha_has_especializacao on ficha_has_especializacao.idficha = ficha.idficha " +
            "right join especializacao on ficha_has_especializacao.idespecializacao = especializacao.idespecializacao " +
            "where ficha.idficha = :idFicha")
    Set<Especializacao> findByObject(@BindBean Ficha ficha);

    @SqlQuery("select especializacao.* from raca " +
            "right join raca_has_especializacao on raca_has_especializacao.idraca = raca.idraca " +
            "right join especializacao on especializacao.idespecializacao = raca_has_especializacao.idespecializacao " +
            "where raca.idraca = :idRaca")
    Set<Especializacao> findByObject(@BindBean Raca raca);

    @SqlQuery("select especializacao.* from habito " +
            "right join habito_has_especializacao on habito_has_especializacao.idhabito = habito.idhabito " +
            "right join especializacao on especializacao.idespecializacao = habito_has_especializacao.idespecializacao " +
            "where habito.idhabito = :idHabito")
    Set<Especializacao> findByObject(@BindBean Habito habito);

    @SqlQuery("select * from especializacao")
    Set<Especializacao> findByObject();
}
