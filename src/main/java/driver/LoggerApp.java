package driver;

import configuration.LoggerConfigurationLoader;
import enums.Level;
import logger.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demo class. Runs logger application end to end.
 * This class has 2 loggers which are sending 1000 message per second.
 */
public class LoggerApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("message written");
        Logger logger = LoggerConfigurationLoader.getLogger("test1");
        Logger logger2 = LoggerConfigurationLoader.getLogger("Test2");

        Runnable runnable = () -> {
            logger.log(Level.INFO, "test message to log " + Thread.currentThread().getId());
            logger2.log(Level.INFO, "test message to log " + Thread.currentThread().getId());
        };
        Executors.newScheduledThreadPool(1000).scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
        Thread.currentThread().join();
    }
}
