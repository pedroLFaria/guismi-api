package sanidade;

import kikaha.urouting.api.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Path("api/sanidade")
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class SanidadeResource {

    @Inject
    SanidadeQueries queries;

    @GET
    @Path("sistema")
    public Set<Sanidade> findByObject(){
        Set<Sanidade> sanidades = queries.findByObject();
        return sanidades;
    }

}
