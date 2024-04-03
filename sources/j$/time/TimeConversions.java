package j$.time;

import java.time.Duration;
import java.time.Instant;

public class TimeConversions {
    public static Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        return Duration.ofSeconds(duration.getSeconds(), (long) duration.getNano());
    }

    public static Instant convert(Instant instant) {
        if (instant == null) {
            return null;
        }
        return Instant.E(instant.getEpochSecond(), (long) instant.getNano());
    }

    public static Instant convert(Instant instant) {
        if (instant == null) {
            return null;
        }
        return Instant.ofEpochSecond(instant.getEpochSecond(), (long) instant.D());
    }
}
