package br.com.hackerrankchallenges;

import java.time.Duration;
import java.time.Instant;

public abstract class Executor {

    private void setIn(String resourcePath) {
        System.setIn(Executor.class.getResourceAsStream(resourcePath));
    }

    protected abstract String getResourcePath();

    protected abstract void execute();

    protected final void executeMeasuringTime() {
        Instant start = Instant.now();
        setIn(getResourcePath());
        execute();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time elapsed: " + timeElapsed);
    }
}
