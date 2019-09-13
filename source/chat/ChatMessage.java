package chat;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors( chain = true )
public class ChatMessage {

    String user;
    Action action;
    String message;

    public enum Action {
        SEND, JOINED, LEFT
    }
}
