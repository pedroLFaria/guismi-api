package situacao;

import auth.Session;
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
    public Response insert(Situacao situacao, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(situacao);
            return DefaultResponse
                    .created("api/situacao/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @PUT
    public Response update(Situacao situacao, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(situacao) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @DELETE
    public Response delete(Situacao situacao, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(situacao) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
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
