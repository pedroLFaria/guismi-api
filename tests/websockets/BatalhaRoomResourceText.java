package websockets;

import io.undertow.websockets.core.WebSocketChannel;
import io.undertow.websockets.spi.WebSocketHttpExchange;
import kikaha.core.modules.websocket.WebSocketSession;
import kikaha.core.test.KikahaRunner;
import kikaha.urouting.api.WebSocket;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.ArrayList;

@RunWith(KikahaRunner.class)
public class BatalhaRoomResourceText {

    @Inject BatalhaRoomResource resource;

    @Test
    public void tst(){
        String dados = "100000d6";
        val rolagemDeDados = resource.rolaDados(Integer.parseInt(dados.split("d")[0]),
                Integer.parseInt(dados.split("d")[1]));
        System.out.println(String.format("%s = %s", String.join(" + " ,rolagemDeDados), rolagemDeDados.stream().mapToInt(Integer::parseInt).sum()));
    }
}
