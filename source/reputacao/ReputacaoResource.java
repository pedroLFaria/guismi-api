package reputacao;

import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Path("api/reputacao")
@Consumes(Mimes.JSON)
@Produces(Mimes.JSON)
public class ReputacaoResource {

    @Inject
    ReputacaoQueries queries;

    public Set<Reputacao> findByObject(){
        Set<Reputacao> reputacaos = queries.findByObject();
        return reputacaos;
    }
}
