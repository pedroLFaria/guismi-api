package websockets;

import io.undertow.websockets.core.CloseMessage;
import kikaha.core.modules.websocket.WebSocketSession;
import kikaha.urouting.api.*;
import lombok.val;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Random;

@Singleton
@Consumes(Mimes.JSON)
@WebSocket("chat/{room-id}")
public class BatalhaRoomResource {

    @OnMessage
    public void onMessage(WebSocketSession session, BatalhaMessage batalhaMessage) {
        if (batalhaMessage.type.equals(BatalhaMessage.Type.DICE)) {
            val rolagemDeDados = rolaDados(Integer.parseInt(batalhaMessage.message.split("d")[0]),
                    Integer.parseInt(batalhaMessage.message.split("d")[1]));
            val mensagem = String.format("%s = %s", String.join(" + " ,rolagemDeDados), rolagemDeDados.stream().mapToInt(Integer::parseInt).sum());
            session.broadcast(
                    createMessage(session).setType(BatalhaMessage.Type.DICE)
                            .setMessage(mensagem)
            );
        } else
            session.broadcast(
                    createMessage(session).setType(batalhaMessage.type)
                            .setMessage(batalhaMessage.getMessage())
            );
    }

    public ArrayList<String> rolaDados(int numeroDeDados, int numeroDeLados) {
        val rolagemDosDados = new ArrayList<String>();
        Random random = new Random();
        for (int i = 0; i < numeroDeDados; i++) {
            rolagemDosDados.add(String.valueOf(random.nextInt(numeroDeLados) + 1));
        }
        return rolagemDosDados;
    }

    @OnOpen
    public void onOpen(WebSocketSession session) {
        session.broadcast(
                createMessage(session).setType(BatalhaMessage.Type.MESSAGE)
                        .setMessage("just joined the room")
        );
    }

    @OnClose
    public void onClose(WebSocketSession session, CloseMessage cm) {
        session.broadcast(
                createMessage(session).setType(BatalhaMessage.Type.MESSAGE)
                        .setMessage("just left the room")
        );
    }

    static BatalhaMessage createMessage(WebSocketSession session) {
        return new BatalhaMessage().setUser(session.userPrincipal().getName());
    }
}
