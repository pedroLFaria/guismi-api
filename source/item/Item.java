package item;

import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

@Data
@Entity
public class    Item {

    @Column
    Long idItem;

    @Column
    String nomeItem;

    @Column
    String descItem;

    @Column
    Long pesoItem;

    @Column
    Long valorMagico;

    @Column
    Long valorItem;

    @Column
    Long moeda;

    @Column
    String iconeItem;

}
