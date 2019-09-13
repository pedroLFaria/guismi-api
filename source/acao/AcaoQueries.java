package acao;

import habilidade.Habilidade;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface AcaoQueries {

    @SqlQuery("select acao.* from habilidade " +
            "right join habilidade_has_acao on habilidade_has_acao.idhabilidade = habilidade.idhabilidade " +
            "right join acao on habilidade_has_acao.idacao = acao.idacao " +
            "where habilidade.idhabilidade =   :idHabilidade")
    Set<Acao> findByIdObject(@BindBean Habilidade habilidade);

    @GetGeneratedKeys
    @SqlUpdate("insert into acao(nome) values(:nome)")
    long insert(@BindBean Acao acao);


}
