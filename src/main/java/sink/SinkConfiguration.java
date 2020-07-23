package sink;

import enums.Level;
import lombok.Builder;
import lombok.Data;

import java.time.format.DateTimeFormatter;

/**
 * Sink configuration.
 */
@Data
@Builder
public class SinkConfiguration {
    /** Level afterward which sink will start receiving message*/
    Level level;
    /** Used for log time in log message.*/
    DateTimeFormatter formatter;
}
