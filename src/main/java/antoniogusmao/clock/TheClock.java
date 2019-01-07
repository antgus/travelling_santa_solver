package antoniogusmao.clock;

import java.time.Instant;

public class TheClock {
    private static Clock clock = new SystemClock();

    public static Instant now(){
        return clock.now();
    }

    public static void setClock(Clock clock) {
        TheClock.clock = clock;
    }

    public static void resetToDefault() {
        clock = new SystemClock();
    }
}
