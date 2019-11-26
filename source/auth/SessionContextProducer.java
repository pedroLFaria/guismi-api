package auth;

import io.undertow.server.HttpServerExchange;
import jogador.JogadorQueries;
import kikaha.core.modules.security.FixedUsernameAndRolesAccount;
import kikaha.urouting.api.ContextProducer;
import kikaha.urouting.api.RoutingException;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionContextProducer implements ContextProducer<Session> {

    @Inject
    JogadorQueries jogadorQueries;

    @Override
    public Session produce(HttpServerExchange exchange) throws RoutingException {
        val account = (FixedUsernameAndRolesAccount) exchange.getSecurityContext().getAuthenticatedAccount();
        return new Session( account , jogadorQueries.findByLogin(account.getPrincipal().getName()));
    }

}
