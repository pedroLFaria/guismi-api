package websockets;

import io.undertow.websockets.core.CloseMessage;
import kikaha.core.modules.websocket.WebSocketSession;
import kikaha.urouting.api.*;
import lombok.val;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
@Consumes(Mimes.JSON)
@WebSocket( "chat/{room-id}" )
public class BatalhaRoomResource {

    @OnMessage
    public void onMessage(WebSocketSession session, BatalhaMessage batalhaMessage ) {
        if(batalhaMessage.type.equals(BatalhaMessage.Type.DICE)){
            val rolagemDeDados = rolaDados(batalhaMessage.message);
            val rolagemDeDadosString = String.format("%s = %s", rolagemDeDados, rolagemDeDados.stream().mapToInt(Integer::intValue).sum());
            createMessage(session).setType(BatalhaMessage.Type.DICE )
                    .setMessage( batalhaMessage.getMessage() );
        }
        session.broadcast(
            createMessage(session).setType(BatalhaMessage.Type.FICHA )
                .setMessage( batalhaMessage.getMessage() )
        );
    }

    public ArrayList<Integer> rolaDados(String dados){
        val rolagemDosDados = new ArrayList<Integer>();
        val quantidadeDeDados = Integer.parseInt(dados.substring(0,0));
        val numeroDeLados = Integer.parseInt(dados.substring(3,3));
        for(int i=0; i < quantidadeDeDados; i++){
            rolagemDosDados.add((int)(Math.random()*numeroDeLados + 1));
        }
        return rolagemDosDados;
    }

    @OnOpen
    public void onOpen( WebSocketSession session ) {
        session.broadcast(
            createMessage(session).setType( BatalhaMessage.Type.MESSAGE )
                .setMessage( "just joined the room" )
        );
    }

    @OnClose
    public void onClose(WebSocketSession session, CloseMessage cm ) {
        session.broadcast(
            createMessage(session).setType( BatalhaMessage.Type.MESSAGE )
                .setMessage( "just left the room" )
        );
    }

    static BatalhaMessage createMessage(WebSocketSession session ){
        return new BatalhaMessage().setUser( session.userPrincipal().getName() );
    }
}
