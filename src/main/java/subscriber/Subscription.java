package subscriber;

import pojo.Message;

/**
 * Interface for each subscriber.
 */
public interface Subscription {
    void put(final Message message);
}
