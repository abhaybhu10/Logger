package logger;

import enums.Level;
import lombok.RequiredArgsConstructor;
import pojo.Message;
import subscriber.Subject;

@RequiredArgsConstructor
public class LoggerImpl implements Logger {
    final Subject subject;
    private final String namespace;
    public void log(Level level, String str) {
        Message message = Message.from(level, namespace, str);
        message.setLevel(level);
        subject.sendMessage(message);
    }
}
