package sistema;

import caminho.CaminhoResource;
import cidade.CidadeResource;
import descendencia.DescendenciaResource;
import especializacao.EspecializacaoResource;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import idioma.IdiomaResource;
import kikaha.urouting.api.*;
import patrono.PatronoResource;
import raca.RacaResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Path("api/sistema")
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class SistemaResource {

    @Inject
    RacaResource racaResource;

    @Inject
    CaminhoResource caminhoResource;

    @Inject
    CidadeResource cidadeResource;

    @Inject
    DescendenciaResource descendenciaResource;

    @Inject
    HabilidadeResource habilidadeResource;

    @Inject
    HabitoResource habitoResource;

    @Inject
    IdiomaResource idiomaResource;

    @Inject
    PatronoResource patronoResource;

    @Inject
    EspecializacaoResource especializacaoResource;

    @GET
    @Path("")
    public Response findSistema(){
        Sistema sistema = new Sistema();
        sistema.setCaminhos(caminhoResource.findByObject());
        sistema.setCidades(cidadeResource.findByObject());
        sistema.setDescendencias(descendenciaResource.findByObject());
        sistema.setHabilidades(habilidadeResource.findByObject());
        sistema.setHabitos(habitoResource.findByObject());
        sistema.setIdiomas(idiomaResource.findByObject());
        sistema.setPatronos(patronoResource.findByObject());
        sistema.setRacas(racaResource.findByObject());
        sistema.setEspecializacoes(especializacaoResource.findByOject());
        return DefaultResponse.ok(sistema);
    }

}
