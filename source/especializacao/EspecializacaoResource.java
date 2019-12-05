package especializacao;

import auth.Session;
import ficha.Ficha;
import habito.Habito;
import kikaha.urouting.api.*;
import raca.Raca;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("api/especializacao/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class EspecializacaoResource {

    @Inject
    EspecializacaoQueries queries;

    public <T> Set<Especializacao> findByObject(T object){
        Set<Especializacao> especializacaos = new LinkedHashSet<>();
        switch (object.getClass().getName()){
            case "ficha.Ficha":
                especializacaos = queries.findByObject((Ficha) object);
                break;
            case "raca.Raca":
                especializacaos = queries.findByObject((Raca) object);
                break;
            case "habito.Habito":
                especializacaos = queries.findByObject((Habito) object);
                break;
        }
        return especializacaos;
    }

    public Set<Especializacao> findByOject(){
        return queries.findByObject();
    }

    @POST
    public Response insert(Especializacao especializacao, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(especializacao);
            return DefaultResponse
                    .created("api/especializacao/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    public Response update(Especializacao especializacao, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(especializacao) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    public Response delete(Especializacao especializacao, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(especializacao) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }
}
