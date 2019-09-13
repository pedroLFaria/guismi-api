package caminho;

import especializacao.Especializacao;
import habilidade.Habilidade;
import habito.Habito;
import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Caminho {

    @Column
    Long idCaminho;

    @Column
    String nomeCaminho;

    @Column
    String descCaminho;

   Set<Habilidade> habilidades;

    Set<Especializacao> especializacoes;

    Set<Habito> habitos;
}
