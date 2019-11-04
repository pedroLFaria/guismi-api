package ficha;

import habilidade.Habilidade;
import habito.Habito;
import kikaha.core.test.KikahaRunner;
import lombok.val;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.LinkedHashSet;
import java.util.Set;

@RunWith(KikahaRunner.class)
public class FichaResourceTest {

    @Inject FichaQueries fichaQueries;
    @Inject FichaResource fichaResource;

    @Test
    public void getFichaByID(){
        val getResponse = fichaResource.findById(1L);
        val entityFicha = (Ficha) getResponse.entity();
        assert entityFicha != null;
        assert entityFicha.idJogador ==1L;
        System.out.println(entityFicha);
    }

    @Test
    public void updateFicha(){
        val ficha = (Ficha) fichaResource.findById(1L).entity();
        ficha.setNomePersonagem("Dio");
        fichaResource.update(retornaFichaModificada(ficha));
    }

    @Test
    @Ignore
    public void insertFicha(){
        val ficha = fichaQueries.findById(1L);
        ficha.setNomePersonagem("Novo jojo");
        fichaResource.insert(ficha);
    }

    public Ficha retornaFichaModificada(Ficha ficha){
        ficha.setIdSanidade(1L);
        ficha.setHabilidades(retornoIdsDeHabilidade());
        ficha.setHabitos(retornaHabito());
        return ficha;
    }

    public Set<Habito> retornaHabito(){
        Habito habito = new Habito();
        habito.setIdHabito(2L);
        habito.setQtdFichaHabito(30L);
        Habito habito1 = new Habito();
        habito1.setIdHabito(3L);
        habito1.setQtdFichaHabito(20L);
        Set<Habito> habitos = new LinkedHashSet<>();
        habitos.add(habito1);
        habitos.add(habito);
        return habitos;
    }
    public Set<Habilidade> retornoIdsDeHabilidade(){
        Habilidade habilidade= new Habilidade();
        habilidade.setIdHabilidade(1L);
        Habilidade habilidade2 = new Habilidade();
        habilidade2.setIdHabilidade(2L);
        Set<Habilidade> habilidades = new LinkedHashSet<Habilidade>();
        habilidades.add(habilidade);
        habilidades.add(habilidade2);
        return habilidades;
    }
}
