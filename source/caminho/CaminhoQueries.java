package caminho;

import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

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
}
