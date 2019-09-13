package especializacao;

import ficha.Ficha;
import habito.Habito;
import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;
import raca.Raca;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("especializacao/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class EspecializacaoResource {

    @Inject
    EspecializacaoQueries queries;

    public <T> Set<Especializacao> findByObject(T object){
        Set<Especializacao> especializacaos = new LinkedHashSet<>();
        switch (object.getClass().getName()){
            case "ficha.Ficha":
                especializacaos = queries.findByObject((Ficha) object);
                break;
            case "raca.Raca":
                especializacaos = queries.findByObject((Raca) object);
                break;
            case "habito.Habito":
                especializacaos = queries.findByObject((Habito) object);
                break;
        }
        return especializacaos;
    }

    public Set<Especializacao> findByOject(){
        return queries.findByObject();
    }
}
