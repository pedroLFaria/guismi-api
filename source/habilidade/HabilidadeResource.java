package habilidade;

import acao.AcaoResource;
import auth.Session;
import caminho.Caminho;
import descendencia.Descendencia;
import ficha.Ficha;
import gasto.GastoResource;
import kikaha.urouting.api.*;
import lombok.var;
import raca.Raca;
import situacao.SituacaoResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("api/habilidade/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class HabilidadeResource {
    @Inject
    HabilidadeQueries queries;

    @Inject
    AcaoResource acaoResource;

    @Inject
    GastoResource gastoResource;

    @Inject
    SituacaoResource situacaoResource;

    public <T> Set<Habilidade> findByObject(T object) {
        Set<Habilidade> habilidades = new LinkedHashSet<>();
        switch (object.getClass().getName()) {
            case "raca.Raca":
                habilidades = queries.findByObject((Raca) object);
                break;
            case "caminho.Caminho":
                habilidades = queries.findByObject((Caminho) object);
                break;
            case "descendencia.Descendencia":
                habilidades = queries.findByObject((Descendencia) object);
                break;
            case "ficha.Ficha":
                habilidades = queries.findByObject((Ficha) object);
                break;
        }
        return preenche(habilidades);
    }

    public Set<Habilidade> findByObject() {
        return preenche(queries.findByObject());
    }

    private Set<Habilidade> preenche(Set<Habilidade> habilidades) {
        for (Habilidade habilidade : habilidades) {
            habilidade.setAcoes(acaoResource.findByObject(habilidade));
            habilidade.setSituacoes(situacaoResource.findByObject(habilidade));
            habilidade.setGasto(gastoResource.findByObject(habilidade));
        }
        return habilidades;
    }

    @POST
    public Response insert(Habilidade habilidade, @Context Session session) {
        if (session.getMestre()) {
            Long id = queries.insert(habilidade);
            insertJunctionTables(habilidade);
            return DefaultResponse.created("api/habilidade/" + id).header("Generated-Id", String.valueOf(id));
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @PUT
    public Response update(Habilidade habilidade, @Context Session session){
        if (session.getMestre()) {
            return queries.cleanJunctionTables(habilidade) && queries.update(habilidade)
                    && insertJunctionTables(habilidade) ? DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    @DELETE
    public Response delete(Habilidade habilidade, @Context Session session){
        if (session.getMestre()) {
            return queries.cleanJunctionTables(habilidade) && queries.delete(habilidade) ?
                    DefaultResponse.accepted() : DefaultResponse.badRequest();
        } else {
            return DefaultResponse.unauthorized();
        }
    }

    private boolean insertJunctionTables(Habilidade habilidade) {
        boolean success = true;
        if (habilidade.getAcoes() != null)
            for (var acao : habilidade.getAcoes())
                success = queries.insertHasAcao(habilidade, acao);
        if (habilidade.getGasto() != null)
            for (var gasto : habilidade.getGasto())
                success = queries.insertHasGasto(habilidade, gasto);
        if (habilidade.getSituacoes() != null)
            for (var situacao : habilidade.getSituacoes())
                success = queries.insertHasSituacao(habilidade, situacao);
        return success;
    }
}
