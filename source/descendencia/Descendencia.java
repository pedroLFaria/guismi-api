package descendencia;

import habilidade.Habilidade;
import habito.Habito;
import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;
import sanidade.Sanidade;
import situacao.Situacao;

import java.util.Set;

@Data
@Entity
public class Descendencia {

    @Column
    Long idDescendencia;

    @Column
    String nomeDescendencia;

    @Column
    String descDescendencia;

    Set<Habilidade> habilidades;

    Set<Habito> habitos;

    Sanidade sanidade;

    Set<Situacao> situacoes;
}
