package patrono;

import ficha.Ficha;
import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;
import raca.Raca;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.Set;

@Path("api/patrono/")
@Singleton
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class PatronoResource {

    @Inject
    PatronoQueries queries;

    public <T> Set<Patrono> findByObject(T object){
        switch (object.getClass().getName()){
            case "raca.Raca":
                return queries.findByObject((Raca) object);
            case "ficha.Ficha":
                return queries.findByObject((Ficha) object);
            default:
                return Collections.emptySet();
        }
    }

    public Set<Patrono> findByObject(){
        return queries.findByObject();
    }
}
