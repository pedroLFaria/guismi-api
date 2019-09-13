package sanidade;

import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

@Data
@Entity
public class Sanidade {

    @Column
    Long idSanidade;

    @Column
    String nomeSanidade;

    @Column
    String descSanidade;

}
