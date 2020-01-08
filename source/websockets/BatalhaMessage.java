package websockets;

import lombok.Data;
import lombok.experimental.Accessors;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.LocalDateTime;
import java.util.HashMap;

@Data
@Accessors( chain = true )
public class BatalhaMessage {

    Long idMesa;
    LocalDateTime date;
    String user;
    Type type;
    String message;

    public enum Type {
        DICE, MESSAGE, FICHA
    }

    public HashMap<String, AttributeValue> parseToDynamo(){
        HashMap<String, AttributeValue> dynamoInput = new HashMap<>();
        dynamoInput.put("idMesa",AttributeValue.builder().s(idMesa.toString()).build());
        dynamoInput.put("date",AttributeValue.builder().s(date.toString()).build());
        dynamoInput.put("user",AttributeValue.builder().s(user).build());
        dynamoInput.put("type",AttributeValue.builder().s(type.toString()).build());
        dynamoInput.put("message",AttributeValue.builder().s(message).build());
        return dynamoInput;
    }
}
