package j$.time;

import java.io.ObjectInputStream;
import java.io.Serializable;

final class a extends Clock implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    static final a f28266b = new a(ZoneOffset.UTC);
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a  reason: collision with root package name */
    private final x f28267a;

    static {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
    }

    a(x xVar) {
        this.f28267a = xVar;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }

    public final long a() {
        return System.currentTimeMillis();
    }

    public final x b() {
        return this.f28267a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f28267a.equals(((a) obj).f28267a);
    }

    public final int hashCode() {
        return this.f28267a.hashCode() + 1;
    }

    public final Instant instant() {
        return Instant.ofEpochMilli(System.currentTimeMillis());
    }

    public final String toString() {
        return "SystemClock[" + this.f28267a + "]";
    }
}
