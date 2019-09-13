package patrono;

import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

@Data
@Entity
public class Patrono {

    @Column
    Long idPatrono;

    @Column
    String nomePatrono;

    @Column
    String descPatrono;
}
