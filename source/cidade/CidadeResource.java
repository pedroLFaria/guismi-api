package cidade;
import auth.Session;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import java.util.Set;

@Path("api/cidade/")
public class CidadeResource {
    @Inject
    CidadeQueries queries;

    @POST
    public Response insert(Cidade cidade, @Context Session session){
        if (session.getMestre()) {
            long id = queries.insert(cidade);
            return DefaultResponse
                    .created("api/cidade/" + id)
                    .header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @PUT
    public Response update(Cidade cidade, @Context Session session) {
        if (session.getMestre()) {
            return queries.update(cidade) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @DELETE
    public Response delete(Cidade cidadeo, @Context Session session) {
        if (session.getMestre()) {
            return queries.delete(cidadeo) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    public Set<Cidade> findByObject(){
        return queries.findByObject();
    }
}
