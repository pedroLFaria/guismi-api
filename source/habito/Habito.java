package habito;

import especializacao.Especializacao;
import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import kikaha.jdbi.serializers.Optional;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Habito {

    @Column
    Long idHabito;

    @Column
    String nomeHabito;

    @Column
    String descHabito;

    @Column
    @Optional
    Long qtdFichaHabito;

    Set<Especializacao> especializacoes;
}
