package sanidade;

import ficha.Ficha;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class SanidadeResource {

    @Inject
    SanidadeQueries queries;

    public<T> Sanidade findByObject(T object){
        return queries.findByObject((Ficha) object);
    }

    public Set<Sanidade> findByObject(){
        Set<Sanidade> sanidades = queries.findByObject();
        return sanidades;
    }

}
