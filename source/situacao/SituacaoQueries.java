package situacao;

import ficha.Ficha;
import habilidade.Habilidade;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface SituacaoQueries {

    @SqlQuery("select situacao.* from habilidade " +
            "right join habilidade_has_situacao on habilidade_has_situacao.idhabilidade = habilidade.idhabilidade " +
            "right join situacao on habilidade_has_situacao.idsituacao = situacao.idsituacao " +
            "where habilidade.idhabilidade = :idHabilidade")
    Set<Situacao> findByObject(@BindBean Habilidade habilidade);

    @SqlQuery("select situacao.* from ficha " +
            "right join ficha_has_situacao on ficha.idficha = ficha_has_situacao.idficha " +
            "right join situacao on ficha_has_situacao.idsituacao = situacao.idsituacao " +
            "where ficha.idficha = :idFicha")
    Set<Situacao> findByObject(@BindBean Ficha ficha);

    @GetGeneratedKeys
    @SqlUpdate()
    Long insert(@BindBean Situacao situacao);

    @SqlUpdate()
    Boolean update(@BindBean Situacao situacao);

    @SqlUpdate()
    Boolean delete(@BindBean Situacao situacao);
}
