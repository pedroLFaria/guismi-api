package raca;

import descendencia.Descendencia;
import especializacao.Especializacao;
import habilidade.Habilidade;
import habito.Habito;
import idioma.Idioma;
import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;
import patrono.Patrono;

import java.util.Set;

@Data
@Entity
public class Raca{

    @Column
    Long idRaca;

    @Column
    String nomeRaca;

    @Column
    String raridadeRaca;

    @Column
    String descRaca;

    @Column
    String longevidadeRaca;

    @Column
    String tracosFisiologicos;

    @Column
    String culturaRaca;

    @Column
    String historiaRaca;

    @Column
    Long racaForca;

    @Column
    Long racaConstituicao;

    @Column
    Long racaAgilidade;

    @Column
    Long racaDestreza;

    @Column
    Long racaInteligencia;

    @Column
    Long racaSabedoria;

    @Column
    Long racaCarisma;

    @Column
    Long sangue;

    @Column
    Long vigor;

    Set<Descendencia> descendencias;

    Set<Especializacao> especializacoes;

    Set<Habilidade> habilidades;

    Set<Habito> habitos;

    Set<Idioma> idiomas;

    Set<Patrono> patronos;
}
