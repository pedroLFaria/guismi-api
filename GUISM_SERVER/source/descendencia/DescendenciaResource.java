package descendencia;

import habilidade.Habilidade;
import habilidade.HabilidadeResource;
import habitos.HabitoResource;
import kikaha.urouting.api.*;
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
        if(descendencias== null)
            return DefaultResponse.notFound().entity("Descendencias não encontradas!");
        return DefaultResponse.ok(descendencias);
    }

    @GET
    @Path("ficha/{id}")
    public Response findByIdFicha(@PathParam("id")Long idFicha){
        Set<Descendencia> descendencias = new LinkedHashSet<>(queries.findAll());
        if(descendencias.isEmpty())
            return DefaultResponse.notFound().entity("Descendencias não encontradas!");
        return DefaultResponse.ok(descendencias);
    }

    @GET
    @Path("raca/{id}")
    public Response findByIdRaca(@PathParam("id")Long id){
        Set<Descendencia> descendencias = new LinkedHashSet<>(queries.findByIdFicha(id));
        if(descendencias.isEmpty())
            return DefaultResponse.notFound().entity("Nenhuma descendencia encontrada!");
        return DefaultResponse.ok(preencher(descendencias));
    }

    private Set<Descendencia> preencher(Set<Descendencia> descendencias){
        for(Descendencia descendencia : descendencias){
            descendencia.setHabilidades((Set<Habilidade>) habilidadeResource.findByIdDescendencia(descendencia.idDescendencia).entity());
        }
        return descendencias;
    }
}
