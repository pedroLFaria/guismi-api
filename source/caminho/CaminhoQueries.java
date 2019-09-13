package caminho;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Set;

@JDBI
public interface CaminhoQueries {

    @SqlQuery("select caminho.* from ficha " +
            "right join ficha_has_caminho on ficha.idficha = ficha_has_caminho.idficha " +
            "right join caminho on ficha_has_caminho.idcaminho = caminho.idcaminho " +
            "where ficha.idficha = :idFicha")
    Set<Caminho> findByObject(@BindBean Ficha ficha);

    @SqlQuery("select * from caminho")
    Set<Caminho> findByObject();
}
