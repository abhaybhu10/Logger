package logger;

import enums.Level;

/**
 * Every logger class needs to implement this.
 */
public interface Logger {
    void log(Level level, String message);
}
