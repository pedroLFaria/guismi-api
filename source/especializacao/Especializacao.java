package especializacao;

import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

@Data
@Entity
public class Especializacao {

    @Column
    Long idEspecializacao;

    @Column
    String nomeEspecializacao;

    @Column
    String descEspecializacao;
}
