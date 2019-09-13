package habito;

import caminho.Caminho;
import descendencia.Descendencia;
import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import raca.Raca;

import java.util.Set;

@JDBI
public interface HabitoQueries {

    @SqlQuery("select * from habito")
    Set<Habito> findByObject();

    @SqlQuery("select habito.*,qtddescendenciahabito from descendencia " +
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
}
