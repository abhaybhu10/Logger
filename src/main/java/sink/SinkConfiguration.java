package sink;

import enums.Level;
import lombok.Builder;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@Builder
public class SinkConfiguration {
    Level level;
    DateTimeFormatter formatter;
}
