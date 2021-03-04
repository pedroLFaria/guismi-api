package jogador;

import auth.Session;
import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Path("api/jogador/")
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class JogadorResource {
    @Inject JogadorQueries queries;

    @GET
    @Path("mestre")
    public Response isMestre(@Context Session session){
        return session.getMestre() ? DefaultResponse.noContent() : DefaultResponse.unauthorized();//xuxa
    }
}
