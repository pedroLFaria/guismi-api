package habilidade;

import acao.AcaoResource;
import caminho.Caminho;
import descendencia.Descendencia;
import ficha.Ficha;
import gasto.GastoResource;
import kikaha.urouting.api.Consumes;
import kikaha.urouting.api.Mimes;
import kikaha.urouting.api.Path;
import kikaha.urouting.api.Produces;
import raca.Raca;
import situacao.SituacaoResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("habilidade/")
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

    public <T> Set<Habilidade> findByObject(T object){
        Set<Habilidade> habilidades = new LinkedHashSet<>();
        switch (object.getClass().getName()){
            case "raca.Raca":
                habilidades = queries.findByObject((Raca) object);
                break;
            case "caminho.Caminho":
                habilidades = queries.findByObject((Caminho) object);
                break;
            case "descendencia.Descendencia":
                habilidades = queries.findByObject((Descendencia) object);
                break;
            case"ficha.Ficha":
                habilidades = queries.findByObject((Ficha) object);
                break;
        }
        return preenche(habilidades);
    }
    public Set<Habilidade> findByObject(){
        return preenche(queries.findByObject());
    }

    private Set<Habilidade> preenche(Set<Habilidade> habilidades){
        for(Habilidade habilidade : habilidades){
            habilidade.setAcoes(acaoResource.findByObject(habilidade));
            habilidade.setSituacoes(situacaoResource.findByObject(habilidade));
            habilidade.setGasto(gastoResource.findByObject(habilidade));
        }
        return habilidades;
    }
}
