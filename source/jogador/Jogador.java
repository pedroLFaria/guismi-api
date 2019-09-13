package jogador;

import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

@Data
@Entity
public class Jogador {

    @Column
    Long idJogador;

    @Column
    String nomeJogador;

    @Column
    Boolean mestre;

}
