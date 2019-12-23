package auth;

import jogador.Jogador;
import kikaha.core.modules.security.FixedUsernameAndRolesAccount;
import lombok.Getter;

@Getter
public class Session extends Jogador {

    public Session(FixedUsernameAndRolesAccount account,Jogador jogador){
        this.setNomeJogador(account.getPrincipal().getName());
        this.setIdJogador(jogador.getIdJogador());
        this.setMestre(jogador.getMestre());
    }
}
