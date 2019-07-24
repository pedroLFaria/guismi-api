package caminho;

import especializacao.Especializacao;
import habilidade.Habilidade;
import habitos.Habito;
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
    String descricaoCaminho;


   Set<Habilidade> habilidades;

    Set<Especializacao> especializacoes;

    Set<Habito> habitos;
}