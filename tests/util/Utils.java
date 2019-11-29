package util;

import auth.Session;
import jogador.Jogador;
import kikaha.core.modules.security.FixedUsernameAndRolesAccount;

public class Utils {
    static public Session session(boolean mestre){
        FixedUsernameAndRolesAccount fixedUsernameAndRolesAccount = new FixedUsernameAndRolesAccount("teste","admin");
        Jogador jogador = new Jogador();
        jogador.setIdJogador(1L);
        jogador.setMestre(mestre);
        jogador.setNomeJogador("teste unitario");
        return new Session(fixedUsernameAndRolesAccount, jogador);
    }
}
