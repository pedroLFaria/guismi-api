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
import util.Utils;

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
    public void insertUpdateDeleteComPermissao(){
        Acao acao = new Acao();
        Session session = Utils.session(true);
        acao.setNomeAcao("Teste unitário");
        var entityInsert = acaoResource.insertNewAcao(acao, session);
        var id = Long.parseLong(entityInsert.header("Generated-Id").values().get(0));
        acao.setIdAcao(Long.parseLong(entityInsert.header("Generated-Id").values().get(0)));
        assert acaoResource.findByObject(acao).getNomeAcao().equals("Teste unitário");
        acao.setNomeAcao("Teste unitário 2");
        var entityUpdate = acaoResource.update(acao, session);
        assert entityUpdate.statusCode() == 202;
        assert acaoResource.findByObject(acao).getNomeAcao().equals("Teste unitário 2");
        var entityDelete = acaoResource.delete(acao, session);
        assert entityDelete.statusCode() == 202;
        assert acaoResource.findByObject(acao) == null;
    }

    @Test
    public void insertUpdateDeleteSemPermissao(){
        Acao acao = new Acao();
        Session session = Utils.session(false);
        acao.setNomeAcao("Teste unitário");
        var entityInsert = acaoResource.insertNewAcao(acao, session);
        assert entityInsert.statusCode() == 403;
        var entityUpdate = acaoResource.update(acao, session);
        assert entityUpdate.statusCode() == 403;
        var entityDelete = acaoResource.delete(acao, session);
        assert entityDelete.statusCode() == 403;
    }
}
