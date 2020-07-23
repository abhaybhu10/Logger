package enums;

/**
 * Logging level.
 */
public enum  Level {
    ERROR("error"),
    INFO("info"),
    DEBUG("debug");
    private final String level;
    Level(final String level) {
        this.level = level;
    }

}
