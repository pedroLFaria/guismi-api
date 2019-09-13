package ficha;

import caminho.Caminho;
import descendencia.Descendencia;
import habilidade.Habilidade;
import habito.Habito;
import idioma.Idioma;
import inventario.Inventario;
import kikaha.jdbi.JDBI;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import patrono.Patrono;
import situacao.Situacao;

import java.util.Set;

@JDBI
public interface FichaQueries {

    @SqlQuery("select * from ficha where idficha = :id")
    Ficha findById(@Bind("id") Long id);

    @SqlQuery("select idficha, nomepersonagem, nivelpersonagem, img from guism.ficha where idjogador = :idJogador")
    Set<Ficha> findByIdJogador(@Bind("idJogador") Long id);

    @GetGeneratedKeys
    @SqlUpdate("insert into ficha(idraca,idcidade,idjogador,nomepersonagem,img,idade,afiliacao,cla,sortedia,distforca," +
            "distconstituicao,distagilidade,distdestreza,distinteligencia,distsabedoria,distcarisma,nivelpersonagem," +
            "exppersonagem,descpersonagem,histpersonagem,nota,idsanidade) values(:idRaca,:idCidade,:idJogador,:nomePersonagem," +
            ":img,:idade,:afiliacao,:cla,:sorteDia,:distForca,:distConstituicao,:distAgilidade,:distDestreza,:distInteligencia," +
            ":distSabedoria,:distCarisma,nivelpersonagem,:expPersonagem,:descPersonagem,:histPersonagem,:nota,:idSanidade)")
    Long insert(@BindBean Ficha ficha);

    @SqlUpdate("update ficha set idraca = :idRaca, idcidade = :idCidade, idjogador = :idJogador, nomepersonagem = :nomePersonagem, " +
            "img = :img, idade = :idade, afiliacao = :afiliacao, cla = :cla, sortedia = :sorteDia, distforca = :distForca," +
            " distconstituicao = :distConstituicao, distagilidade = :distAgilidade, distdestreza = :distDestreza, " +
            "distinteligencia = :distInteligencia, distsabedoria = :distSabedoria, distcarisma = :distCarisma, " +
            "nivelpersonagem = :nivelPersonagem, exppersonagem = :expPersonagem, descpersonagem = descPersonagem, " +
            "histpersonagem = :histPersonagem, nota = :nota, idsanidade = :idSanidade  where idficha = :idFicha")
    Boolean update(@BindBean Ficha ficha);

    @SqlUpdate("insert into ficha_has_caminho(idficha,idcaminho) values(:idFicha,:idCaminho)")
    Boolean insertFichaHasCaminho(@BindBean Ficha ficha, @BindBean Caminho caminho);

    @SqlUpdate("insert into ficha_has_descendencia(idficha,iddescendencia) values(:idFicha,:idDescendencia)")
    Boolean insertFichaHasDescendencia(@BindBean Ficha ficha, @BindBean Descendencia descendencia);

    @SqlUpdate("insert into ficha_has_habilidade(idficha,idhabilidade) values(:idFicha,:idHabilidade)")
    Boolean insertFichaHasHabilidade(@BindBean Ficha ficha, @BindBean Habilidade habilidade);

    @SqlUpdate("insert into ficha_has_habito(idficha,idhabito,qtdfichahabito) values(:idFicha,:idHabito,:qtdFichaHabito)")
    Boolean insertFichaHasHabito(@BindBean Ficha ficha, @ BindBean Habito habito);

    @SqlUpdate("insert into ficha_has_idioma(idficha,ididioma) values(:idFicha,:idIdioma)")
    Boolean insertFichaHasIdidoma(@BindBean Ficha ficha, @BindBean Idioma idioma);

    @SqlUpdate("insert into ficha_has_inventario(idficha,idinventario) values(:idFicha, :idInventario)")
    Boolean insertFichaHasInventario(@BindBean Ficha ficha, @BindBean Inventario inventario);

    @SqlUpdate("insert into ficha_has_patrono(idficha,idpatrono) values(:idFicha, :idPatrono)")
    Boolean insertFichaHasPatrono(@BindBean Ficha ficha, @BindBean Patrono patrono);

    @SqlUpdate("insert into ficha_has_situacao(idficha,idsituacao) values(:idFicha, :idSituacao)")
    Boolean insertFichaHasSituacao(@BindBean Ficha ficha, @BindBean Situacao situacao);

    default void cleanFichaJunctionTables(Ficha ficha){
        deleteFichaHasCaminho(ficha);
        deleteFichaHasDescendencia(ficha);
        deleteFichaHasHabilidade(ficha);
        deleteFichaHasHabito(ficha);
        deleteFichaHasIdidoma(ficha);
        deleteFichaHasInventario(ficha);
        deleteFichaHasPatrono(ficha);
        deleteFichaHasSituacao(ficha);
    }

    @SqlUpdate("delete from ficha_has_caminho where idficha = :idFicha")
    Boolean deleteFichaHasCaminho(@BindBean Ficha ficha);

    @SqlUpdate("delete from ficha_has_descendencia where idficha = :idFicha")
    Boolean deleteFichaHasDescendencia(@BindBean Ficha ficha);

    @SqlUpdate("delete from  ficha_has_habilidade where idficha = :idFicha")
    Boolean deleteFichaHasHabilidade(@BindBean Ficha ficha);

    @SqlUpdate("delete from  ficha_has_habito where idficha = :idFicha")
    Boolean deleteFichaHasHabito(@BindBean Ficha ficha);

    @SqlUpdate("delete from  ficha_has_idioma where idficha = :idFicha")
    Boolean deleteFichaHasIdidoma(@BindBean Ficha ficha);

    @SqlUpdate("delete from  ficha_has_inventario where idficha = :idFicha")
    Boolean deleteFichaHasInventario(@BindBean Ficha ficha);

    @SqlUpdate("delete from  ficha_has_patrono where idficha = :idFicha")
    Boolean deleteFichaHasPatrono(@BindBean Ficha fichao);

    @SqlUpdate("delete from  ficha_has_situacao where idficha = :idFicha")
    Boolean deleteFichaHasSituacao(@BindBean Ficha ficha);

}
