package caminho;

import especializacao.EspecializacaoResource;
import ficha.Ficha;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Path("caminho/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class CaminhoResource {

    @Inject
    CaminhoQueries queries;

    @Inject
    HabilidadeResource habilidadeResource;

    @Inject
    EspecializacaoResource especializacaoResource;

    @Inject
    HabitoResource habitoResource;

    public <T> Set<Caminho> findByObject(T object){
        return preenche(queries.findByObject((Ficha) object));
    }

    public Set<Caminho> findByObject(){
        return preenche(queries.findByObject());
    }

    private Set<Caminho> preenche(Set<Caminho> caminhos){
        for(Caminho caminho : caminhos){
            caminho.setEspecializacoes(especializacaoResource.findByObject(caminho));
            caminho.setHabilidades(habilidadeResource.findByObject(caminho));
            caminho.setHabitos(habitoResource.findByObject(caminho));
        }
        return caminhos;
    }
}
