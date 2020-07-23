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
    final String message;
    final Level level;
    final String namespace;
    final ZonedDateTime dateTime;
    final String threadId;

    public static Message from(final Level level, final String namespace, final String message) {
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
