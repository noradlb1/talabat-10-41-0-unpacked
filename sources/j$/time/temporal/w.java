package j$.time.temporal;

import j$.time.d;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public final class w implements Serializable {

    /* renamed from: g  reason: collision with root package name */
    private static final ConcurrentHashMap f28488g = new ConcurrentHashMap(4, 0.75f, 2);

    /* renamed from: h  reason: collision with root package name */
    public static final TemporalUnit f28489h = i.f28457d;
    private static final long serialVersionUID = -1177360819670808121L;

    /* renamed from: a  reason: collision with root package name */
    private final d f28490a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28491b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final transient q f28492c = v.d(this);

    /* renamed from: d  reason: collision with root package name */
    private final transient q f28493d = v.i(this);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final transient q f28494e;

    /* renamed from: f  reason: collision with root package name */
    private final transient q f28495f;

    static {
        new w(d.MONDAY, 4);
        f(d.SUNDAY, 1);
    }

    private w(d dVar, int i11) {
        ChronoUnit chronoUnit = ChronoUnit.NANOS;
        this.f28494e = v.j(this);
        this.f28495f = v.e(this);
        Objects.requireNonNull(dVar, "firstDayOfWeek");
        if (i11 < 1 || i11 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.f28490a = dVar;
        this.f28491b = i11;
    }

    public static w f(d dVar, int i11) {
        String str = dVar.toString() + i11;
        ConcurrentHashMap concurrentHashMap = f28488g;
        w wVar = (w) concurrentHashMap.get(str);
        if (wVar != null) {
            return wVar;
        }
        concurrentHashMap.putIfAbsent(str, new w(dVar, i11));
        return (w) concurrentHashMap.get(str);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.f28490a != null) {
            int i11 = this.f28491b;
            if (i11 < 1 || i11 > 7) {
                throw new InvalidObjectException("Minimal number of days is invalid");
            }
            return;
        }
        throw new InvalidObjectException("firstDayOfWeek is null");
    }

    private Object readResolve() {
        try {
            return f(this.f28490a, this.f28491b);
        } catch (IllegalArgumentException e11) {
            String message = e11.getMessage();
            throw new InvalidObjectException("Invalid serialized WeekFields: " + message);
        }
    }

    public final q c() {
        return this.f28492c;
    }

    public final d d() {
        return this.f28490a;
    }

    public final int e() {
        return this.f28491b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return hashCode() == obj.hashCode();
        }
        return false;
    }

    public final q g() {
        return this.f28495f;
    }

    public final q h() {
        return this.f28493d;
    }

    public final int hashCode() {
        return (this.f28490a.ordinal() * 7) + this.f28491b;
    }

    public final q i() {
        return this.f28494e;
    }

    public final String toString() {
        return "WeekFields[" + this.f28490a + "," + this.f28491b + "]";
    }
}
