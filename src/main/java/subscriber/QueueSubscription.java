package subscriber;

import lombok.EqualsAndHashCode;
import pojo.Message;
import sink.Sink;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Queue based subscription. stores message received from upstream into queue and calls update method on each
 * Observers(Sink).
 */
@EqualsAndHashCode
public class QueueSubscription implements Subscription {
    final Queue<Message> messageQueue;
    final Sink observer;
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public QueueSubscription(final Sink observer) {
        messageQueue = new LinkedList<>();
        this.observer = observer;
        startPoller();
    }

    public void put(final Message message) {
        System.out.println("QueueSubscription: Adding message");
        messageQueue.offer(message);
    }

    private void startPoller() {
        Runnable runnable = () -> {
            while (messageQueue.size() > 0) {
                observer.update(messageQueue.poll());
            }
        };
        executor.scheduleAtFixedRate(runnable, 4, 1, TimeUnit.MILLISECONDS);
    }
}
