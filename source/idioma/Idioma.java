package idioma;

import kikaha.jdbi.serializers.Column;
import kikaha.jdbi.serializers.Entity;
import lombok.Data;

@Data
@Entity
public class Idioma {

    @Column
    Long idIdioma;

    @Column
    String nomeIdioma;

    @Column
    String descIdioma;

}
