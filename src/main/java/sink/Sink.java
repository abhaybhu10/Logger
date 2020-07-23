package sink;

import pojo.Message;

public interface Sink {
    void update(final Message message);
}
