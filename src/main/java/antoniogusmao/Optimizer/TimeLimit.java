package antoniogusmao.Optimizer;

import antoniogusmao.clock.TheClock;

import java.time.Instant;

public class TimeLimit implements TerminationCriteria {
    private Instant start;
    private final long maxDurationInMillis;

    public TimeLimit(long millis) {
        maxDurationInMillis = millis;
    }

    public void init() {
        this.start = TheClock.now();
    }

    @Override
    public boolean hasEnded() {
        return TheClock.now().toEpochMilli() - start.toEpochMilli() >= maxDurationInMillis;
    }
}
