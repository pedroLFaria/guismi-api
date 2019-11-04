package websockets;

import kikaha.core.modules.websocket.WebSocketSession;
import kikaha.core.test.KikahaServerRunner;
import kikaha.urouting.api.WebSocket;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

public class BatalhaRoomResourceTest {

    @Inject BatalhaRoomResource batalhaRoomResource;

    @Test
    public void diceRollTest(){
        val batalhaMessage = new BatalhaMessage().setUser("teste unitário").setType(BatalhaMessage.Type.DICE).setMessage("1D6");
        WebSocketSession
    }
}
