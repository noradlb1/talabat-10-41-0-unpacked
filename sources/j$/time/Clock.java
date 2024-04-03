package j$.time;

public abstract class Clock {
    protected Clock() {
    }

    public static Clock systemUTC() {
        return a.f28266b;
    }

    public long a() {
        return instant().toEpochMilli();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public abstract Instant instant();
}
