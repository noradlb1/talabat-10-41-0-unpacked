package j$.time;

import j$.time.chrono.C0099b;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

public final class OffsetDateTime implements l, n, Comparable<OffsetDateTime>, Serializable {
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f28255a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f28256b;

    static {
        LocalDateTime localDateTime = LocalDateTime.f28251c;
        ZoneOffset zoneOffset = ZoneOffset.f28260g;
        localDateTime.getClass();
        B(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f28252d;
        ZoneOffset zoneOffset2 = ZoneOffset.f28259f;
        localDateTime2.getClass();
        B(localDateTime2, zoneOffset2);
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "dateTime");
        this.f28255a = localDateTime;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f28256b = zoneOffset;
    }

    public static OffsetDateTime B(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime C(Instant instant, x xVar) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(xVar, "zone");
        ZoneOffset d11 = xVar.B().d(instant);
        return new OffsetDateTime(LocalDateTime.K(instant.getEpochSecond(), instant.D(), d11), d11);
    }

    static OffsetDateTime E(ObjectInput objectInput) {
        LocalDateTime localDateTime = LocalDateTime.f28251c;
        h hVar = h.f28407d;
        return new OffsetDateTime(LocalDateTime.J(h.M(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.Q(objectInput)), ZoneOffset.N(objectInput));
    }

    private OffsetDateTime F(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f28255a != localDateTime || !this.f28256b.equals(zoneOffset)) ? new OffsetDateTime(localDateTime, zoneOffset) : this;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 10, this);
    }

    /* renamed from: D */
    public final OffsetDateTime b(long j11, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? F(this.f28255a.b(j11, temporalUnit), this.f28256b) : (OffsetDateTime) temporalUnit.f(this, j11);
    }

    public final l a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return (OffsetDateTime) qVar.k(this, j11);
        }
        a aVar = (a) qVar;
        int i11 = p.f28429a[aVar.ordinal()];
        ZoneOffset zoneOffset = this.f28256b;
        LocalDateTime localDateTime = this.f28255a;
        return i11 != 1 ? i11 != 2 ? F(localDateTime.a(j11, qVar), zoneOffset) : F(localDateTime, ZoneOffset.L(aVar.s(j11))) : C(Instant.E(j11, (long) localDateTime.D()), zoneOffset);
    }

    public final boolean c(q qVar) {
        return (qVar instanceof a) || (qVar != null && qVar.f(this));
    }

    public final int compareTo(Object obj) {
        int i11;
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        ZoneOffset zoneOffset = offsetDateTime.f28256b;
        ZoneOffset zoneOffset2 = this.f28256b;
        if (zoneOffset2.equals(zoneOffset)) {
            i11 = toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.f28255a;
            localDateTime.getClass();
            long p11 = C0099b.p(localDateTime, zoneOffset2);
            LocalDateTime localDateTime2 = offsetDateTime.f28255a;
            localDateTime2.getClass();
            int a11 = j$.lang.a.a(p11, C0099b.p(localDateTime2, offsetDateTime.f28256b));
            i11 = a11 == 0 ? localDateTime.toLocalTime().G() - localDateTime2.toLocalTime().G() : a11;
        }
        return i11 == 0 ? toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime()) : i11;
    }

    public final l d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        return this.f28255a.equals(offsetDateTime.f28255a) && this.f28256b.equals(offsetDateTime.f28256b);
    }

    public final int f(q qVar) {
        if (!(qVar instanceof a)) {
            return p.a(this, qVar);
        }
        int i11 = p.f28429a[((a) qVar).ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? this.f28255a.f(qVar) : this.f28256b.I();
        }
        throw new t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public final l g(h hVar) {
        return F(this.f28255a.g(hVar), this.f28256b);
    }

    public final u h(q qVar) {
        return qVar instanceof a ? (qVar == a.INSTANT_SECONDS || qVar == a.OFFSET_SECONDS) ? qVar.range() : this.f28255a.h(qVar) : qVar.g(this);
    }

    public final int hashCode() {
        return this.f28255a.hashCode() ^ this.f28256b.hashCode();
    }

    public final l k(l lVar) {
        a aVar = a.EPOCH_DAY;
        LocalDateTime localDateTime = this.f28255a;
        return lVar.a(localDateTime.O().t(), aVar).a(localDateTime.toLocalTime().R(), a.NANO_OF_DAY).a((long) this.f28256b.I(), a.OFFSET_SECONDS);
    }

    public final long s(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i11 = p.f28429a[((a) qVar).ordinal()];
        ZoneOffset zoneOffset = this.f28256b;
        LocalDateTime localDateTime = this.f28255a;
        if (i11 != 1) {
            return i11 != 2 ? localDateTime.s(qVar) : (long) zoneOffset.I();
        }
        localDateTime.getClass();
        return C0099b.p(localDateTime, zoneOffset);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f28255a;
    }

    public final String toString() {
        String localDateTime = this.f28255a.toString();
        String zoneOffset = this.f28256b.toString();
        return localDateTime + zoneOffset;
    }

    public final Object v(s sVar) {
        if (sVar == p.h() || sVar == p.j()) {
            return this.f28256b;
        }
        if (sVar == p.k()) {
            return null;
        }
        s f11 = p.f();
        LocalDateTime localDateTime = this.f28255a;
        return sVar == f11 ? localDateTime.O() : sVar == p.g() ? localDateTime.toLocalTime() : sVar == p.e() ? j$.time.chrono.u.f28321d : sVar == p.i() ? ChronoUnit.NANOS : sVar.a(this);
    }

    /* access modifiers changed from: package-private */
    public final void writeExternal(ObjectOutput objectOutput) {
        this.f28255a.S(objectOutput);
        this.f28256b.O(objectOutput);
    }
}
