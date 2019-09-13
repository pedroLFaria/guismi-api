package idioma;

import ficha.Ficha;
import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;
import raca.Raca;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("api/idioma/")
@Singleton
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class IdiomaResource {

    @Inject
    IdiomaQueries queries;

    public <T> Set<Idioma> findByObject(T object){
        Set<Idioma> idiomas = new LinkedHashSet<>();
        switch (idiomas.getClass().getName()){
            case "raca.Raca":
                idiomas = queries.findByObject((Raca) object);
                break;
            case "ficha.Ficha":
                idiomas = queries.findByObject((Ficha) object);
                break;
        }
        return idiomas;
    }
    public Set<Idioma> findByObject(){
        return queries.findByObject();
    }
}
