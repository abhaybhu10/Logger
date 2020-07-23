package subscriber;

import com.google.common.collect.Maps;
import pojo.Message;
import sink.Sink;

import java.util.Map;

/**
 * Class responsible for maintaining subscription of Sink. sends message for each subscriber on new message.
 */
public class Subject {
    Map<Sink, Subscription> subscriptionMap = Maps.newConcurrentMap();

    public Subscription subscribe(Sink observers) {
        Subscription subscription = new QueueSubscription(observers);
        subscriptionMap.putIfAbsent(observers, subscription);
        return subscription;
    }

    public void sendMessage(final Message message) {
        subscriptionMap.values().forEach(e -> e.put(message));
    }

    public void removeSubscription(Sink observers) {
        subscriptionMap.remove(observers);
    }
}
