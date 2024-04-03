package j$.time;

import j$.time.chrono.C0099b;
import j$.time.chrono.C0100c;
import j$.time.chrono.C0103f;
import j$.time.chrono.C0108k;
import j$.time.chrono.n;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;
import j$.time.zone.b;
import j$.time.zone.f;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

public final class ZonedDateTime implements l, C0108k, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f28263a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f28264b;

    /* renamed from: c  reason: collision with root package name */
    private final x f28265c;

    private ZonedDateTime(LocalDateTime localDateTime, x xVar, ZoneOffset zoneOffset) {
        this.f28263a = localDateTime;
        this.f28264b = zoneOffset;
        this.f28265c = xVar;
    }

    private static ZonedDateTime B(long j11, int i11, x xVar) {
        ZoneOffset d11 = xVar.B().d(Instant.E(j11, (long) i11));
        return new ZonedDateTime(LocalDateTime.K(j11, i11, d11), xVar, d11);
    }

    public static ZonedDateTime C(Instant instant, x xVar) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(xVar, "zone");
        return B(instant.getEpochSecond(), instant.D(), xVar);
    }

    public static ZonedDateTime D(LocalDateTime localDateTime, x xVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(xVar, "zone");
        if (xVar instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, xVar, (ZoneOffset) xVar);
        }
        f B = xVar.B();
        List g11 = B.g(localDateTime);
        if (g11.size() == 1) {
            zoneOffset = (ZoneOffset) g11.get(0);
        } else if (g11.size() == 0) {
            b f11 = B.f(localDateTime);
            localDateTime = localDateTime.M(f11.h().getSeconds());
            zoneOffset = f11.k();
        } else if (zoneOffset == null || !g11.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) g11.get(0);
            Objects.requireNonNull(zoneOffset, "offset");
        }
        return new ZonedDateTime(localDateTime, xVar, zoneOffset);
    }

    static ZonedDateTime F(ObjectInput objectInput) {
        LocalDateTime localDateTime = LocalDateTime.f28251c;
        h hVar = h.f28407d;
        LocalDateTime J = LocalDateTime.J(h.M(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.Q(objectInput));
        ZoneOffset N = ZoneOffset.N(objectInput);
        x xVar = (x) s.a(objectInput);
        Objects.requireNonNull(xVar, "zone");
        if (!(xVar instanceof ZoneOffset) || N.equals(xVar)) {
            return new ZonedDateTime(J, xVar, N);
        }
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    }

    private ZonedDateTime G(ZoneOffset zoneOffset) {
        if (!zoneOffset.equals(this.f28264b)) {
            x xVar = this.f28265c;
            f B = xVar.B();
            LocalDateTime localDateTime = this.f28263a;
            if (B.g(localDateTime).contains(zoneOffset)) {
                return new ZonedDateTime(localDateTime, xVar, zoneOffset);
            }
        }
        return this;
    }

    public static ZonedDateTime now() {
        a aVar = new a(x.C(TimeZone.getDefault().getID(), x.f28502a));
        return C(aVar.instant(), aVar.b());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 6, this);
    }

    /* renamed from: E */
    public final ZonedDateTime b(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ZonedDateTime) temporalUnit.f(this, j11);
        }
        boolean isDateBased = temporalUnit.isDateBased();
        LocalDateTime L = this.f28263a.b(j11, temporalUnit);
        x xVar = this.f28265c;
        ZoneOffset zoneOffset = this.f28264b;
        if (isDateBased) {
            return D(L, xVar, zoneOffset);
        }
        Objects.requireNonNull(L, "localDateTime");
        Objects.requireNonNull(zoneOffset, "offset");
        Objects.requireNonNull(xVar, "zone");
        return xVar.B().g(L).contains(zoneOffset) ? new ZonedDateTime(L, xVar, zoneOffset) : B(C0099b.p(L, zoneOffset), L.D(), xVar);
    }

    public final LocalDateTime H() {
        return this.f28263a;
    }

    /* renamed from: I */
    public final ZonedDateTime g(h hVar) {
        return D(LocalDateTime.J(hVar, this.f28263a.toLocalTime()), this.f28265c, this.f28264b);
    }

    /* access modifiers changed from: package-private */
    public final void J(DataOutput dataOutput) {
        this.f28263a.S(dataOutput);
        this.f28264b.O(dataOutput);
        this.f28265c.G(dataOutput);
    }

    public final l a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return (ZonedDateTime) qVar.k(this, j11);
        }
        a aVar = (a) qVar;
        int i11 = z.f28506a[aVar.ordinal()];
        x xVar = this.f28265c;
        LocalDateTime localDateTime = this.f28263a;
        return i11 != 1 ? i11 != 2 ? D(localDateTime.a(j11, qVar), xVar, this.f28264b) : G(ZoneOffset.L(aVar.s(j11))) : B(j11, localDateTime.D(), xVar);
    }

    public final boolean c(q qVar) {
        return (qVar instanceof a) || (qVar != null && qVar.f(this));
    }

    public final l d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.f28263a.equals(zonedDateTime.f28263a) && this.f28264b.equals(zonedDateTime.f28264b) && this.f28265c.equals(zonedDateTime.f28265c);
    }

    public final int f(q qVar) {
        if (!(qVar instanceof a)) {
            return C0099b.g(this, qVar);
        }
        int i11 = z.f28506a[((a) qVar).ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? this.f28263a.f(qVar) : this.f28264b.I();
        }
        throw new t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    public final n getChronology() {
        return ((h) toLocalDate()).getChronology();
    }

    public final ZoneOffset getOffset() {
        return this.f28264b;
    }

    public final x getZone() {
        return this.f28265c;
    }

    public final u h(q qVar) {
        return qVar instanceof a ? (qVar == a.INSTANT_SECONDS || qVar == a.OFFSET_SECONDS) ? qVar.range() : this.f28263a.h(qVar) : qVar.g(this);
    }

    public final int hashCode() {
        return (this.f28263a.hashCode() ^ this.f28264b.hashCode()) ^ Integer.rotateLeft(this.f28265c.hashCode(), 3);
    }

    /* renamed from: k */
    public final /* synthetic */ int compareTo(C0108k kVar) {
        return C0099b.f(this, kVar);
    }

    public final C0108k p(x xVar) {
        Objects.requireNonNull(xVar, "zone");
        return this.f28265c.equals(xVar) ? this : D(this.f28263a, xVar, this.f28264b);
    }

    public final long s(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i11 = z.f28506a[((a) qVar).ordinal()];
        return i11 != 1 ? i11 != 2 ? this.f28263a.s(qVar) : (long) this.f28264b.I() : C0099b.q(this);
    }

    public final /* synthetic */ long toEpochSecond() {
        return C0099b.q(this);
    }

    public final C0100c toLocalDate() {
        return this.f28263a.O();
    }

    public final C0103f toLocalDateTime() {
        return this.f28263a;
    }

    public final k toLocalTime() {
        return this.f28263a.toLocalTime();
    }

    public final String toString() {
        String localDateTime = this.f28263a.toString();
        ZoneOffset zoneOffset = this.f28264b;
        String str = localDateTime + zoneOffset.toString();
        x xVar = this.f28265c;
        if (zoneOffset == xVar) {
            return str;
        }
        return str + "[" + xVar.toString() + "]";
    }

    public final Object v(s sVar) {
        return sVar == p.f() ? this.f28263a.O() : C0099b.n(this, sVar);
    }
}
