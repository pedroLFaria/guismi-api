package situacao;

import ficha.Ficha;
import habilidade.Habilidade;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("api/Situacao/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class SituacaoResource {

    @Inject
    SituacaoQueries queries;

    @POST
    public Response insert(Situacao situacao) {
        long id = queries.insert(situacao);
        return DefaultResponse
                .created("api/situacao/" + id)
                .header("Generated-Id", String.valueOf(id));
    }

    @PUT
    public Response update(Situacao situacao) {
        queries.insert(situacao);
        return DefaultResponse
                .accepted();
    }

    @DELETE
    @Path("delete/{id}")
    public Response delete(@PathParam("id")Long id){
        queries.delete(id);
        return DefaultResponse.accepted();
    }

    public <T> Set<Situacao> findByObject(T object){
        Set<Situacao> situacaos = new LinkedHashSet<>();
        switch (object.getClass().getName()){
            case "ficha.Ficha":
                situacaos = queries.findByObject((Ficha) object);
                break;
            case "habilidade.Habilidade":
                situacaos = queries.findByObject((Habilidade) object);
                break;
        }
        return situacaos;
    }

}
