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

    @SqlQuery("SELECT ESPECIALIZACAO.* FROM FICHA " +
            "RIGHT JOIN FICHA_HAS_ESPECIALIZACAO ON FICHA_HAS_ESPECIALIZACAO.IDFICHA = FICHA.IDFICHA " +
            "RIGHT JOIN ESPECIALIZACAO ON FICHA_HAS_ESPECIALIZACAO.IDESPECIALIZACAO = ESPECIALIZACAO.IDESPECIALIZACAO " +
            "WHERE FICHA.IDFICHA = :idFicha")
    Set<Especializacao> findByObject(@BindBean Ficha ficha);

    @SqlQuery("SELECT ESPECIALIZACAO.* FROM RACA " +
            "RIGHT JOIN RACA_HAS_ESPECIALIZACAO ON RACA_HAS_ESPECIALIZACAO.IDRACA = RACA.IDRACA " +
            "RIGHT JOIN ESPECIALIZACAO ON ESPECIALIZACAO.IDESPECIALIZACAO = RACA_HAS_ESPECIALIZACAO.IDESPECIALIZACAO " +
            "WHERE RACA.IDRACA = :idRaca")
    Set<Especializacao> findByObject(@BindBean Raca raca);

    @SqlQuery("SELECT ESPECIALIZACAO.* FROM HABITO " +
            "RIGHT JOIN HABITO_HAS_ESPECIALIZACAO ON HABITO_HAS_ESPECIALIZACAO.IDHABITO = HABITO.IDHABITO " +
            "RIGHT JOIN ESPECIALIZACAO ON ESPECIALIZACAO.IDESPECIALIZACAO = HABITO_HAS_ESPECIALIZACAO.IDESPECIALIZACAO " +
            "WHERE HABITO.IDHABITO = :idHabito")
    Set<Especializacao> findByObject(@BindBean Habito habito);

    @SqlQuery("SELECT * FROM ESPECIALIZACAO")
    Set<Especializacao> findByObject();
}
