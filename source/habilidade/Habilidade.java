package habilidade;

import acao.Acao;
import gasto.Gasto;
import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;
import situacao.Situacao;

import java.util.Set;

@Data
@Entity
public class Habilidade {

    @Column
    Long idHabilidade;

    @Column
    String nomeHabilidade;

    @Column
    String atrAtacante;

    @Column
    String tipoHabilidade;

    @Column
    String utiHabilidade;

    @Column
    String descHabilidade;

    @Column
    String prerequisito;

    @Column
    Long nivelRequerido;

    Set<Acao> acoes;

    Set<Gasto> gasto;

    Set<Situacao> situacoes;
}
