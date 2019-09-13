package habilidade;

import caminho.Caminho;
import descendencia.Descendencia;
import ficha.Ficha;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import raca.Raca;

import java.util.Set;

@JDBI
public interface HabilidadeQueries {

    @SqlQuery("select * from habilidade")
    Set<Habilidade> findByObject();

    @SqlQuery("select habilidade.* from raca " +
            "right join raca_has_habilidade on raca_has_habilidade.idraca = raca.idraca " +
            "right join habilidade on habilidade.idhabilidade = raca_has_habilidade.idhabilidade " +
            "where raca.idraca = :idRaca")
    Set<Habilidade> findByObject(@BindBean Raca raca);

    @SqlQuery("select habilidade.* from caminho " +
            "right join caminho_has_habilidade on caminho_has_habilidade.idcaminho = caminho.idcaminho " +
            "right join habilidade on habilidade.idhabilidade = caminho_has_habilidade.idhabilidade " +
            "where caminho.idcaminho = :idCaminho")
    Set<Habilidade> findByObject(@BindBean Caminho caminho);

    @SqlQuery("select habilidade.* from descendencia " +
            "right join descendencia_has_habilidade on descendencia_has_habilidade.iddescendencia = descendencia.iddescendencia " +
            "right join habilidade on habilidade.idhabilidade = descendencia_has_habilidade.idhabilidade " +
            "where descendencia.iddescendencia = :idDescendencia")
    Set<Habilidade> findByObject(@BindBean Descendencia descendencia);

    @SqlQuery("select habilidade.* from ficha " +
            "right join ficha_has_habilidade on ficha.idficha = ficha_has_habilidade.idficha " +
            "right join habilidade on ficha_has_habilidade.idhabilidade = habilidade.idhabilidade " +
            "where ficha.idficha =:idFicha")
    Set<Habilidade> findByObject(@BindBean Ficha ficha);
}
