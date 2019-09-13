package raca;

import descendencia.DescendenciaResource;
import especializacao.EspecializacaoResource;
import ficha.Ficha;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import idioma.IdiomaResource;
import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;
import patrono.PatronoResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Path("api/raca/")
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class RacaResource {

    @Inject
    RacaQueries queries;

    @Inject
    DescendenciaResource descendenciaResource;

    @Inject
    EspecializacaoResource especializacaoResource;

    @Inject
    HabilidadeResource habilidadeResource;

    @Inject
    HabitoResource habitoResource;

    @Inject
    IdiomaResource idiomaResource;

    @Inject
    PatronoResource patronoResource;



    public<T> Raca findByObject(T object){
        return preenche(queries.findByObject((Ficha) object));
    }


    public Set<Raca> findByObject(){
        Set<Raca> racas = queries.findByObject();
        for(Raca raca : racas)
            preenche(raca);
        return racas;
    }
    private Raca preenche(Raca raca){
        raca.setDescendencias(descendenciaResource.findByObject(raca));
        raca.setEspecializacoes(especializacaoResource.findByObject(raca));
        raca.setHabilidades(habilidadeResource.findByObject(raca));
        raca.setHabitos(habitoResource.findByObject(raca));
        raca.setIdiomas(idiomaResource.findByObject(raca));
        raca.setPatronos(patronoResource.findByObject(raca));
        return raca;
    }
}
