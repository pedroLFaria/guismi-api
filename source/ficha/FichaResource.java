package ficha;

import auth.Session;
import caminho.Caminho;
import caminho.CaminhoResource;
import descendencia.Descendencia;
import descendencia.DescendenciaResource;
import especializacao.EspecializacaoResource;
import habilidade.Habilidade;
import habilidade.HabilidadeResource;
import habito.Habito;
import habito.HabitoResource;
import idioma.Idioma;
import idioma.IdiomaResource;
import inventario.Inventario;
import inventario.InventarioResource;
import kikaha.urouting.api.*;
import lombok.val;
import patrono.Patrono;
import patrono.PatronoResource;
import raca.RacaResource;
import situacao.Situacao;
import situacao.SituacaoResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Path("api/ficha/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class FichaResource {

    @Inject
    FichaQueries queries;

    @Inject
    RacaResource racaResource;

    @Inject
    CaminhoResource caminhoResource;

    @Inject
    DescendenciaResource descendenciaResource;

    @Inject
    HabilidadeResource habilidadeResource;

    @Inject
    HabitoResource habitoResource;

    @Inject
    IdiomaResource idiomaResource;

    @Inject
    InventarioResource inventarioResource;

    @Inject
    PatronoResource patronoResource;

    @Inject
    SituacaoResource situacaoResource;

    @Inject
    EspecializacaoResource especializacaoResource;

    @GET
    @Path("id/{id}")
    public Response findById(@PathParam("id") Long id){
        Ficha ficha = queries.findById(id);
        if(ficha == null){
            return DefaultResponse.notFound().entity("Ficha não encontrada!");
        }
        return DefaultResponse.ok(preenche(ficha));
    }

    @GET
    @Path("jogador")
    public Response findByIdJogador(/*@Context Session session*/){
        val ficha = queries.findByIdJogador(1L);
        if(ficha == null){
            return DefaultResponse.notFound().entity(ficha);
        }
        return DefaultResponse.ok((ficha));
    }

    private Ficha preenche(Ficha ficha){
        ficha.setRaca(racaResource.findByObject(ficha));
        ficha.setHabilidades(habilidadeResource.findByObject(ficha));
        ficha.setCaminhos(caminhoResource.findByObject(ficha));
        ficha.setIdiomas(idiomaResource.findByObject(ficha));
        ficha.setPatronos(patronoResource.findByObject(ficha));
        ficha.setSituacoes(situacaoResource.findByObject(ficha));
        ficha.setDescendencias(descendenciaResource.findByObject(ficha));
        ficha.setHabitos(habitoResource.findByObject(ficha));
        ficha.setInventarios(inventarioResource.findByObject(ficha));
        ficha.setEspecializacoes(especializacaoResource.findByObject(ficha));
        return ficha;
    }

    @PUT
    public Response update(Ficha ficha) {
        queries.update(ficha);
        queries.cleanFichaJunctionTables(ficha);
        insertFichaJunctionTables(ficha);
        return DefaultResponse.accepted();
    }

    @POST
    public Response insert(Ficha ficha){
        Long id = queries.insert(ficha);
        ficha.setIdFicha(id);
        insertFichaJunctionTables(ficha);
        return DefaultResponse.created();
    }

    private void insertFichaJunctionTables(Ficha ficha){
        if(ficha.getHabitos() != null)
            for(Habito habito : ficha.getHabitos())
                queries.insertFichaHasHabito(ficha,habito);
        if(ficha.getHabilidades() != null)
            for(Habilidade habilidade : ficha.getHabilidades())
                queries.insertFichaHasHabilidade(ficha,habilidade);
        if(ficha.getCaminhos() != null)
            for(Caminho caminho : ficha.getCaminhos())
                queries.insertFichaHasCaminho(ficha,caminho);
        if(ficha.getDescendencias() != null)
            for(Descendencia descendencia : ficha.getDescendencias())
                queries.insertFichaHasDescendencia(ficha,descendencia);
        if(ficha.getIdiomas() != null)
            for(Idioma idioma : ficha.getIdiomas())
                queries.insertFichaHasIdidoma(ficha,idioma);
        if(ficha.getInventarios() != null)
            for(Inventario inventario : ficha.getInventarios())
                queries.insertFichaHasInventario(ficha,inventario);
        if(ficha.getPatronos() != null)
            for(Patrono patrono : ficha.getPatronos())
                queries.insertFichaHasPatrono(ficha,patrono);
        if(ficha.getSituacoes() != null)
            for(Situacao situacao : ficha.getSituacoes())
                queries.insertFichaHasSituacao(ficha,situacao);
    }
}
