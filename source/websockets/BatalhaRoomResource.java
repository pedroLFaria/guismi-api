package websockets;

import auth.Session;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.undertow.websockets.core.CloseMessage;
import kikaha.core.modules.websocket.WebSocketSession;
import kikaha.urouting.api.*;
import lombok.val;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

@Singleton
@Consumes(Mimes.JSON)
@WebSocket("chat/{room-id}")
public class BatalhaRoomResource {

    final DynamoDbClient dynamoDbClient = DynamoDbClient.create();

    @OnMessage
    public void onMessage(WebSocketSession session, BatalhaMessage batalhaMessage) {
        BatalhaMessage message;
        if (batalhaMessage.type.equals(BatalhaMessage.Type.DICE)) {
            val rolagemDeDados = rolaDados(Integer.parseInt(batalhaMessage.message.split("d")[0]),
                    Integer.parseInt(batalhaMessage.message.split("d")[1]));
            val mensagem = String.format("%s = %s", String.join(" + " ,rolagemDeDados), rolagemDeDados.stream().mapToInt(Integer::parseInt).sum());
            message = createMessage(session).setType(BatalhaMessage.Type.DICE).setMessage(mensagem);
        } else
            message =createMessage(session).setType(batalhaMessage.type).setMessage(batalhaMessage.getMessage());
        PutItemRequest request = PutItemRequest.builder()
                .tableName("chat-quadro-de-batalha")
                .item(message.parseToDynamo())
                .build();

        System.out.println(GetItemRequest.builder().key().tableName().projectionExpression());
        try {
            dynamoDbClient.putItem(request);
        } catch (ResourceNotFoundException e) {
            System.err.format("Error: The table \"%s\" can't be found.\n", "chat-quadro-de-batalha");
            System.err.println("Be sure that it exists and that you've typed its name correctly!");
            System.exit(1);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        session.broadcast(message);
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
        return new BatalhaMessage().setUser(session.userPrincipal().getName()).setIdMesa(1L).setDate(LocalDateTime.now());
    }
}
