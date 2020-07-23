package logger;

import enums.Level;

public interface Logger {
    void log(Level level, String message);
}
