package auth;

import kikaha.core.modules.security.FixedUsernameAndRolesAccount;
import lombok.Getter;

@Getter
public class Session {

    final String username;

    final Long id;

    public Session(FixedUsernameAndRolesAccount account, Long id){
        this.username = account.getPrincipal().getName();
        this.id = id;
    }

}
