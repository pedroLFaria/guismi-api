package gasto;

import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

@Data
@Entity
public class Gasto {

    @Column
    Long idGasto;

    @Column
    String nome;
}
