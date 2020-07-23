package sink;

import pojo.Message;

/**
 * Every sink need to implement this. This call should be non blocking.
 * Blocking this class can cause delay in other Sinks.
 */
public interface Sink {
    void update(final Message message);
}
