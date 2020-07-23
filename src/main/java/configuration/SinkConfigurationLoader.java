package configuration;

import enums.Level;
import sink.SinkConfiguration;

import java.time.format.DateTimeFormatter;

public class SinkConfigurationLoader {
    public static SinkConfiguration getSinkConfiguration(Level level) {
        return SinkConfiguration
                .builder()
                .level(level)
                .formatter(DateTimeFormatter.ISO_LOCAL_DATE_TIME).build();
    }
}
