package configuration;

import enums.Level;
import logger.Logger;
import logger.LoggerImpl;
import sink.FileBasedSink;
import sink.Sink;
import sink.SinkConfiguration;
import subscriber.Subject;
import subscriber.Subscription;

/**
 * Setup logger and Sink. Wires them up.
 */
public class LoggerConfigurationLoader {
    public  static Logger getLogger(String namespace) {
        SinkConfiguration sinkConfiguration = SinkConfigurationLoader.getSinkConfiguration(Level.DEBUG);
        Subject subject = new Subject();
        Sink sink = new FileBasedSink(sinkConfiguration);
        Subscription subscription = subject.subscribe(sink);
        return new LoggerImpl(subject, namespace);

    }
}
