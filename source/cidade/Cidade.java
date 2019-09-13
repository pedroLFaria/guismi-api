package cidade;

import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;


@Data
@Entity
public class Cidade {

    @Column
    Long idCidade;

    @Column
    String nomeCidade;

    @Column
    String descCidade;

    @Column
    String popCidade;

}
