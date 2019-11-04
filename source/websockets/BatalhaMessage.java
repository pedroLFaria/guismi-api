package websockets;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors( chain = true )
public class BatalhaMessage {

    String user;
    Type type;
    String message;

    public enum Type {
        DICE, MESSAGE, FICHA
    }
}
