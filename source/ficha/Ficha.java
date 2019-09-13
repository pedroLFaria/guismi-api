package ficha;

import caminho.Caminho;
import descendencia.Descendencia;
import habilidade.Habilidade;
import habito.Habito;
import idioma.Idioma;
import inventario.Inventario;
import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import kikaha.jdbi.serializers.Optional;
import lombok.Data;
import patrono.Patrono;
import raca.Raca;
import situacao.Situacao;

import java.util.Set;

@Data
@Entity
public class Ficha {

    @Column
    Long idFicha;

    @Optional
    @Column
    Long idRaca;

    @Optional
    @Column
    Long idCidade;

    @Optional
    @Column
    Long idJogador;

    @Optional
    @Column
    String nomePersonagem;

    @Optional
    @Column
    String img;

    @Optional
    @Column
    Long idade;

    @Optional
    @Column
    String afiliacao;

    @Optional
    @Column
    String cla;

    @Optional
    @Column
    Long sorteDia;

    @Optional
    @Column
    Long distForca;

    @Optional
    @Column
    Long distConstituicao;

    @Optional
    @Column
    Long distAgilidade;

    @Optional
    @Column
    Long distDestreza;

    @Optional
    @Column
    Long distInteligencia;

    @Optional
    @Column
    Long distSabedoria;

    @Optional
    @Column
    Long distCarisma;

    @Optional
    @Column
    Long nivelPersonagem;

    @Optional
    @Column
    Long expPersonagem;

    @Optional
    @Column
    String descPersonagem;

    @Optional
    @Column
    String histPersonagem;

    @Optional
    @Column
    String nota;

    @Optional
    @Column
    Long idSanidade;

    Raca raca;

    Set<Caminho> caminhos;

    Set<Descendencia> descendencias;

    Set<Habilidade> habilidades;

    Set<Habito> habitos;

    Set<Idioma> idiomas;

    Set<Inventario> inventarios;

    Set<Patrono> patronos;

    Set<Situacao> situacoes;
}

