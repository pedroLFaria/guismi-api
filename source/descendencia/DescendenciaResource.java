package descendencia;

import ficha.Ficha;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;
import raca.Raca;
import sanidade.SanidadeResource;
import situacao.SituacaoResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Path("descendencia/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class DescendenciaResource {

    @Inject
    DescendenciaQueries queries;

    @Inject
    HabilidadeResource habilidadeResource;

    @Inject
    HabitoResource habitoResource;

    @Inject
    SanidadeResource sanidadeResource;

    @Inject
    SituacaoResource situacaoResource;

    public <T> Set<Descendencia> findByObject(T object) throws ClassCastException{
        switch (object.getClass().getName()){
            case "raca.Raca":
               return preencher(queries.findByObject((Raca) object));
            case "ficha.Ficha":
                return preencher(queries.findByObject((Ficha) object));
            default:
                throw new ClassCastException("Método não pode receber está classe.");
        }
    }

    public Set<Descendencia> findByObject(){
        return preencher(queries.findByObject());
    }

    private Set<Descendencia> preencher(Set<Descendencia> descendencias){
        for(Descendencia descendencia : descendencias){
            descendencia.setHabilidades(habilidadeResource.findByObject(descendencia));
            descendencia.setHabitos(habitoResource.findByObject(descendencia));
            descendencia.setSituacoes(situacaoResource.findByObject(descendencia));
        }
        return descendencias;
    }
}
