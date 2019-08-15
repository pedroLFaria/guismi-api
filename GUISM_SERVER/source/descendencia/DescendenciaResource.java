package descendencia;

import ficha.Ficha;
import habilidade.Habilidade;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import kikaha.urouting.api.*;
import raca.Raca;
import sanidade.SanidadeResource;
import situacao.SituacaoResource;
import sun.security.krb5.internal.crypto.Des;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
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

    @GET
    @Path("sistema")
    public Response findAll(){
        Set<Descendencia> descendencias = new LinkedHashSet<>(queries.findAll());
        if(descendencias.isEmpty())
            return DefaultResponse.notFound().entity(descendencias);
        return DefaultResponse.ok(descendencias);
    }

    @GET
    @Path("ficha/{id}")
    public Response findByIdFicha(@PathParam("id")Long idFicha){
        Set<Descendencia> descendencias = new LinkedHashSet<>(queries.findAll());
        if(descendencias.isEmpty())
            return DefaultResponse.notFound().entity(descendencias);
        return DefaultResponse.ok(descendencias);
    }

    @GET
    @Path("raca/{id}")
    public Response findByIdRaca(@PathParam("id")Long id){
        Set<Descendencia> descendencias = new LinkedHashSet<>(queries.findByIdFicha(id));
        if(descendencias.isEmpty())
            return DefaultResponse.notFound().entity(descendencias);
        return DefaultResponse.ok(preencher(descendencias));
    }

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
