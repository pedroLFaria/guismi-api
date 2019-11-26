package acao;

import auth.Session;
import habilidade.Habilidade;
import jogador.Jogador;
import kikaha.core.modules.security.FixedUsernameAndRolesAccount;
import kikaha.core.test.KikahaRunner;
import kikaha.urouting.api.Context;
import lombok.var;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
@RunWith(KikahaRunner.class)
public class AcaoResourceTest {

    @Inject AcaoResource acaoResource;

    @Test
    public void getAcao(){
        Habilidade habilidade = new Habilidade();
        habilidade.setIdHabilidade(1L);
        var setAcao = acaoResource.findByObject(habilidade);
        assert !setAcao.isEmpty();
    }

    @Test
    @Ignore
    public void insertUpdateDelete(){
        Acao acao = new Acao();
        acao.setNomeAcao("Teste unitário");
        var entityInsert = acaoResource.insertNewAcao(acao);
        var id = Long.parseLong(entityInsert.header("Generated-Id").values().get(0));
        acao.setIdAcao(Long.parseLong(entityInsert.header("Generated-Id").values().get(0)));
        assert acaoResource.findByObject(acao).getNomeAcao().equals("Teste unitário");
    }
}