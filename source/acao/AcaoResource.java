package acao;

import habilidade.Habilidade;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Path("api/acao/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class AcaoResource {
    @Inject
    AcaoQueries queries;

    @POST
    public Response insertNewAcao(Acao acao) {
        long id = queries.insert(acao);
        return DefaultResponse
                .created("api/acao/" + id)
                .header("Generated-Id", String.valueOf(id));
    }

    public <T> Set<Acao> findByObject(T object){
        return queries.findByIdObject((Habilidade) object);
    }
}
