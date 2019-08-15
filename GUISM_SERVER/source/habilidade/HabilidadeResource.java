package habilidade;

import acao.Acao;
import acao.AcaoResource;
import caminho.Caminho;
import descendencia.Descendencia;
import ficha.Ficha;
import gasto.Gasto;
import gasto.GastoResource;
import kikaha.urouting.api.*;
import lombok.val;
import raca.Raca;
import situacao.Situacao;
import situacao.SituacaoResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("habilidade/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class HabilidadeResource {
    @Inject
    HabilidadeQueries queries;

    @Inject
    AcaoResource acaoResource;

    @Inject
    GastoResource gastoResource;

    @Inject
    SituacaoResource situacaoResource;

    @GET
    @Path("sistema")
    public  Response findAll(){
        Set<Habilidade> habilidades = queries.findAll();
        if(habilidades.isEmpty())
            return DefaultResponse.notFound().entity(habilidades);
        return DefaultResponse.ok(preenche(habilidades));
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id){
        Habilidade habilidade = queries.findById(id);
        if(habilidade == null)
           return DefaultResponse.notFound().entity("Nenhuma habilidade encontrada!");
        habilidade.setAcoes(acaoResource.findByObject(habilidade));
        habilidade.setSituacoes(situacaoResource.findByObject(habilidade));
        habilidade.setGasto(gastoResource.findByObject(habilidade));
        return DefaultResponse.ok(habilidade);
    }

    @GET
    @Path("raca/{id}")
    public Response findByIdRacas(@PathParam("id")Long idRaca){
        Set<Habilidade> habilidades = queries.findByIdRacas(idRaca);
        if(habilidades.isEmpty())
            return DefaultResponse.notFound().entity(habilidades);
        return DefaultResponse.ok(preenche(habilidades));
    }

    @GET
    @Path("caminho/{id}")
    public Response findByIdCaminho(@PathParam("id")Long idCaminho){
        Set<Habilidade> habilidades = queries.findByIdCaminho(idCaminho);
        if(habilidades.isEmpty())
            return DefaultResponse.notFound().entity(habilidades);
        return DefaultResponse.ok(preenche(habilidades));
    }

    @GET
    @Path("descendencia/{id}")
    public Response findByIdDescendencia(@PathParam("id")Long idDescendencia){
        Set<Habilidade> habilidades = queries.findByIdDescendencia(idDescendencia);
        if(habilidades.isEmpty())
            return DefaultResponse.notFound().entity(habilidades);
        return DefaultResponse.ok(preenche(habilidades));
    }

    @GET
    @Path("ficha/{id}")
    public Response findByIdFicha(@PathParam("id")Long id){
        Set<Habilidade> habilidades = queries.findByIdFicha(id);
        if(habilidades.isEmpty())
            return DefaultResponse.notFound().entity(habilidades);
        return DefaultResponse.ok(preenche(habilidades));
    }

    public <T> Set<Habilidade> findByObject(T object){
        Set<Habilidade> habilidades = new LinkedHashSet<>();
        switch (object.getClass().getName()){
            case "raca.Raca":
                habilidades = queries.findByObject((Raca) object);
                break;
            case "caminho.Caminho":
                habilidades = queries.findByObject((Caminho) object);
                break;
            case "descendencia.Descendencia":
                habilidades = queries.findByObject((Descendencia) object);
                break;
            case"ficha.Ficha":
                habilidades = queries.findByObject((Ficha) object);
                break;
        }
        return preenche(habilidades);
    }
    public Set<Habilidade> findByObject(){
        return preenche(queries.findByObject());
    }

    private Set<Habilidade> preenche(Set<Habilidade> habilidades){
        for(Habilidade habilidade : habilidades){
            habilidade.setAcoes(acaoResource.findByObject(habilidade));
            habilidade.setSituacoes(situacaoResource.findByObject(habilidade));
            habilidade.setGasto(gastoResource.findByObject(habilidade));
        }
        return habilidades;
    }
}
