package gasto;

import habilidade.Habilidade;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Set;

@JDBI
public interface GastoQueries {

    @SqlQuery("select gasto.*,habilidade_has_gasto.quantidadehabilidadegasto from habilidade " +
            "right join habilidade_has_gasto on habilidade_has_gasto.idhabilidade = habilidade.idhabilidade " +
            "right join gasto on habilidade_has_gasto.idgasto = gasto.idgasto where habilidade.idhabilidade = :idHabilidade")
    Set<Gasto> findByObject(@BindBean Habilidade habilidade);

    @SqlQuery("select gasto * where idgasto = :id")
    Gasto findById(@Bind("id")Long id);

    @GetGeneratedKeys
    @SqlUpdate("insert into gasto(NOME) value (:nome)")
    Long insert(@BindBean Gasto gasto);

    @SqlUpdate("update gasto set NOME = :nome where IDGASTO = :idGasto")
    Boolean update(@BindBean Gasto gasto);

    @SqlUpdate("delete from gasto where IDGASTO = :idGasto")
    Boolean delete(@BindBean Gasto gasto);
}
