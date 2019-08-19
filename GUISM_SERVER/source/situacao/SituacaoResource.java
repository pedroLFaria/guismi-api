package situacao;

import ficha.Ficha;
import habilidade.Habilidade;
import kikaha.urouting.api.*;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("api/Situacao/")
@Singleton
@Produces(Mimes.JSON)
@Consumes(Mimes.JSON)
public class SituacaoResource {

    private String mensagemPadrao = "Situação não encontrada!";

    @Inject
    SituacaoQueries queries;

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
