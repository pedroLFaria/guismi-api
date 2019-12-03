package raca;

import auth.Session;
import descendencia.DescendenciaResource;
import especializacao.EspecializacaoResource;
import ficha.Ficha;
import habilidade.HabilidadeResource;
import habito.HabitoResource;
import idioma.IdiomaResource;
import kikaha.urouting.api.*;
import lombok.var;
import patrono.PatronoResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
@Path("api/raca/")
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class RacaResource {

    @Inject
    RacaQueries queries;

    @Inject
    DescendenciaResource descendenciaResource;

    @Inject
    EspecializacaoResource especializacaoResource;

    @Inject
    HabilidadeResource habilidadeResource;

    @Inject
    HabitoResource habitoResource;

    @Inject
    IdiomaResource idiomaResource;

    @Inject
    PatronoResource patronoResource;


    public <T> Raca findByObject(T object) {
        return preenche(queries.findByObject((Ficha) object));
    }


    public Set<Raca> findByObject() {
        Set<Raca> racas = queries.findByObject();
        for (Raca raca : racas)
            preenche(raca);
        return racas;
    }

    private Raca preenche(Raca raca) {
        raca.setDescendencias(descendenciaResource.findByObject(raca));
        raca.setEspecializacoes(especializacaoResource.findByObject(raca));
        raca.setHabilidades(habilidadeResource.findByObject(raca));
        raca.setHabitos(habitoResource.findByObject(raca));
        raca.setIdiomas(idiomaResource.findByObject(raca));
        raca.setPatronos(patronoResource.findByObject(raca));
        return raca;
    }

    @POST
    Response insert(Raca raca, @Context Session session) {
        if (session.getMestre()) {
            Long id = queries.insert(raca);
            insertJunctionTables(raca);
            return DefaultResponse.created("api/raca/" + id).header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @PUT
    Response update(Raca raca, @Context Session session) {
        if (session.getMestre()) {
            return queries.cleanJunctionTables(raca) && queries.update(raca)
                    && insertJunctionTables(raca) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    @DELETE
    Response delete(Raca raca, @Context Session session) {
        if (session.getMestre()) {
            return queries.cleanJunctionTables(raca) && queries.delete(raca) ?
                    DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.forbiden().entity("UNATHORIZED");
        }
    }

    private boolean insertJunctionTables(Raca raca) {
        boolean success = true;
        if (raca.getDescendencias() != null)
            for (var descendencia : raca.getDescendencias())
                success = queries.insertHasDescendencia(raca, descendencia);
        if (raca.getEspecializacoes() != null)
            for (var especializacao : raca.getEspecializacoes())
                success = queries.insertHasEspecializacao(raca, especializacao) && success;
        if (raca.getHabilidades() != null)
            for (var habilidade : raca.getHabilidades())
                success = queries.insertHasHabilidade(raca, habilidade) && success;
        if (raca.getHabitos() != null)
            for (var habito : raca.getHabitos())
                success = queries.insertHasHabito(raca, habito) && success;
        if (raca.getIdiomas() != null)
            for (var idioma : raca.getIdiomas())
                success = queries.insertHasIdioma(raca, idioma);
        if (raca.getPatronos() != null)
            for (var patrono : raca.getPatronos())
                success = queries.insertHasPatronos(raca, patrono);
        return success;
    }
}
