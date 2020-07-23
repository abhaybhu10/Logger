package subscriber;

import pojo.Message;

public interface Subscription {
    void put(final Message message);
}
