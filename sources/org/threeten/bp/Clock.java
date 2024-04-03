package org.threeten.bp;

import com.google.android.exoplayer2.C;
import java.io.Serializable;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAmount;

public abstract class Clock {

    public static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;
        private final Instant instant;
        private final ZoneId zone;

        public FixedClock(Instant instant2, ZoneId zoneId) {
            this.instant = instant2;
            this.zone = zoneId;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FixedClock)) {
                return false;
            }
            FixedClock fixedClock = (FixedClock) obj;
            if (!this.instant.equals(fixedClock.instant) || !this.zone.equals(fixedClock.zone)) {
                return false;
            }
            return true;
        }

        public ZoneId getZone() {
            return this.zone;
        }

        public int hashCode() {
            return this.instant.hashCode() ^ this.zone.hashCode();
        }

        public Instant instant() {
            return this.instant;
        }

        public long millis() {
            return this.instant.toEpochMilli();
        }

        public String toString() {
            return "FixedClock[" + this.instant + "," + this.zone + "]";
        }

        public Clock withZone(ZoneId zoneId) {
            if (zoneId.equals(this.zone)) {
                return this;
            }
            return new FixedClock(this.instant, zoneId);
        }
    }

    public static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;
        private final Clock baseClock;
        private final Duration offset;

        public OffsetClock(Clock clock, Duration duration) {
            this.baseClock = clock;
            this.offset = duration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetClock)) {
                return false;
            }
            OffsetClock offsetClock = (OffsetClock) obj;
            if (!this.baseClock.equals(offsetClock.baseClock) || !this.offset.equals(offsetClock.offset)) {
                return false;
            }
            return true;
        }

        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        public int hashCode() {
            return this.baseClock.hashCode() ^ this.offset.hashCode();
        }

        public Instant instant() {
            return this.baseClock.instant().plus((TemporalAmount) this.offset);
        }

        public long millis() {
            return Jdk8Methods.safeAdd(this.baseClock.millis(), this.offset.toMillis());
        }

        public String toString() {
            return "OffsetClock[" + this.baseClock + "," + this.offset + "]";
        }

        public Clock withZone(ZoneId zoneId) {
            if (zoneId.equals(this.baseClock.getZone())) {
                return this;
            }
            return new OffsetClock(this.baseClock.withZone(zoneId), this.offset);
        }
    }

    public static final class SystemClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        public SystemClock(ZoneId zoneId) {
            this.zone = zoneId;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.zone.equals(((SystemClock) obj).zone);
            }
            return false;
        }

        public ZoneId getZone() {
            return this.zone;
        }

        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        public long millis() {
            return System.currentTimeMillis();
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }

        public Clock withZone(ZoneId zoneId) {
            if (zoneId.equals(this.zone)) {
                return this;
            }
            return new SystemClock(zoneId);
        }
    }

    public static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        public TickClock(Clock clock, long j11) {
            this.baseClock = clock;
            this.tickNanos = j11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TickClock)) {
                return false;
            }
            TickClock tickClock = (TickClock) obj;
            if (!this.baseClock.equals(tickClock.baseClock) || this.tickNanos != tickClock.tickNanos) {
                return false;
            }
            return true;
        }

        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        public int hashCode() {
            int hashCode = this.baseClock.hashCode();
            long j11 = this.tickNanos;
            return hashCode ^ ((int) (j11 ^ (j11 >>> 32)));
        }

        public Instant instant() {
            if (this.tickNanos % 1000000 == 0) {
                long millis = this.baseClock.millis();
                return Instant.ofEpochMilli(millis - Jdk8Methods.floorMod(millis, this.tickNanos / 1000000));
            }
            Instant instant = this.baseClock.instant();
            return instant.minusNanos(Jdk8Methods.floorMod((long) instant.getNano(), this.tickNanos));
        }

        public long millis() {
            long millis = this.baseClock.millis();
            return millis - Jdk8Methods.floorMod(millis, this.tickNanos / 1000000);
        }

        public String toString() {
            return "TickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }

        public Clock withZone(ZoneId zoneId) {
            if (zoneId.equals(this.baseClock.getZone())) {
                return this;
            }
            return new TickClock(this.baseClock.withZone(zoneId), this.tickNanos);
        }
    }

    public static Clock fixed(Instant instant, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(instant, "fixedInstant");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return new FixedClock(instant, zoneId);
    }

    public static Clock offset(Clock clock, Duration duration) {
        Jdk8Methods.requireNonNull(clock, "baseClock");
        Jdk8Methods.requireNonNull(duration, "offsetDuration");
        if (duration.equals(Duration.ZERO)) {
            return clock;
        }
        return new OffsetClock(clock, duration);
    }

    public static Clock system(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return new SystemClock(zoneId);
    }

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public static Clock systemUTC() {
        return new SystemClock(ZoneOffset.UTC);
    }

    public static Clock tick(Clock clock, Duration duration) {
        Jdk8Methods.requireNonNull(clock, "baseClock");
        Jdk8Methods.requireNonNull(duration, "tickDuration");
        if (!duration.isNegative()) {
            long nanos = duration.toNanos();
            if (nanos % 1000000 != 0 && C.NANOS_PER_SECOND % nanos != 0) {
                throw new IllegalArgumentException("Invalid tick duration");
            } else if (nanos <= 1) {
                return clock;
            } else {
                return new TickClock(clock, nanos);
            }
        } else {
            throw new IllegalArgumentException("Tick duration must not be negative");
        }
    }

    public static Clock tickMinutes(ZoneId zoneId) {
        return new TickClock(system(zoneId), 60000000000L);
    }

    public static Clock tickSeconds(ZoneId zoneId) {
        return new TickClock(system(zoneId), C.NANOS_PER_SECOND);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public abstract ZoneId getZone();

    public int hashCode() {
        return super.hashCode();
    }

    public abstract Instant instant();

    public long millis() {
        return instant().toEpochMilli();
    }

    public abstract Clock withZone(ZoneId zoneId);
}
