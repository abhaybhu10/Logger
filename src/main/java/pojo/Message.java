package pojo;

import enums.Level;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Observable;

@Builder
@Data
@NonNull
public class Message extends Observable {
    String message;
    Level level;
    String namespace;
    ZonedDateTime dateTime;
    String threadId;

    public static Message from(Level level, String namespace, String message) {
        return Message.builder()
                .namespace(namespace)
                .message(message)
                .level(level)
                .threadId(Thread.currentThread().getName())
                .dateTime(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public String toString() {
        return String.join(" ", dateTime.toLocalDateTime().toString(), level.toString(), namespace, threadId, message);
    }
}
