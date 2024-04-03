package j$.time.zone;

import j$.lang.a;
import j$.time.Duration;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.C0099b;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class b implements Comparable, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a  reason: collision with root package name */
    private final long f28509a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalDateTime f28510b;

    /* renamed from: c  reason: collision with root package name */
    private final ZoneOffset f28511c;

    /* renamed from: d  reason: collision with root package name */
    private final ZoneOffset f28512d;

    b(long j11, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f28509a = j11;
        this.f28510b = LocalDateTime.K(j11, 0, zoneOffset);
        this.f28511c = zoneOffset;
        this.f28512d = zoneOffset2;
    }

    b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        localDateTime.getClass();
        this.f28509a = C0099b.p(localDateTime, zoneOffset);
        this.f28510b = localDateTime;
        this.f28511c = zoneOffset;
        this.f28512d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean B() {
        return this.f28512d.I() > this.f28511c.I();
    }

    /* access modifiers changed from: package-private */
    public final void C(DataOutput dataOutput) {
        a.c(this.f28509a, dataOutput);
        a.d(this.f28511c, dataOutput);
        a.d(this.f28512d, dataOutput);
    }

    public final int compareTo(Object obj) {
        return a.a(this.f28509a, ((b) obj).f28509a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f28509a == bVar.f28509a && this.f28511c.equals(bVar.f28511c) && this.f28512d.equals(bVar.f28512d);
    }

    public final LocalDateTime f() {
        return this.f28510b.M((long) (this.f28512d.I() - this.f28511c.I()));
    }

    public final LocalDateTime g() {
        return this.f28510b;
    }

    public final Duration h() {
        return Duration.s((long) (this.f28512d.I() - this.f28511c.I()));
    }

    public final int hashCode() {
        return (this.f28510b.hashCode() ^ this.f28511c.hashCode()) ^ Integer.rotateLeft(this.f28512d.hashCode(), 16);
    }

    public final ZoneOffset k() {
        return this.f28512d;
    }

    public final ZoneOffset s() {
        return this.f28511c;
    }

    public final long toEpochSecond() {
        return this.f28509a;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Transition[");
        sb2.append(B() ? "Gap" : "Overlap");
        sb2.append(" at ");
        sb2.append(this.f28510b);
        sb2.append(this.f28511c);
        sb2.append(" to ");
        sb2.append(this.f28512d);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public final List v() {
        if (B()) {
            return Collections.emptyList();
        }
        return a.c(new Object[]{this.f28511c, this.f28512d});
    }
}
