package sink;

import lombok.RequiredArgsConstructor;
import pojo.Message;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RequiredArgsConstructor
public class FileBasedSink implements Sink {
    private static final String PATH = "/tmp/test/";
    private final SinkConfiguration configuration;

    @Override
    public void update(Message message) {
        try {
            if (configuration.level.compareTo(message.getLevel()) >= 0) {
                logMessage(message.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void logMessage(final String message) {
        System.out.println("writing log to file");
        String fileName = "log";
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + "/" + fileName, true))) {
                writer.write(message + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
