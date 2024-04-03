package j$.time;

import com.google.android.exoplayer2.C;
import com.huawei.hms.push.constant.RemoteMessageConst;
import j$.time.chrono.C0099b;
import j$.time.chrono.C0100c;
import j$.time.chrono.C0103f;
import j$.time.chrono.C0108k;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.TimeZone;

public final class LocalDateTime implements l, n, C0103f, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final LocalDateTime f28251c = J(h.f28407d, k.f28415e);

    /* renamed from: d  reason: collision with root package name */
    public static final LocalDateTime f28252d = J(h.f28408e, k.f28416f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a  reason: collision with root package name */
    private final h f28253a;

    /* renamed from: b  reason: collision with root package name */
    private final k f28254b;

    private LocalDateTime(h hVar, k kVar) {
        this.f28253a = hVar;
        this.f28254b = kVar;
    }

    private int B(LocalDateTime localDateTime) {
        int B = this.f28253a.B(localDateTime.f28253a);
        return B == 0 ? this.f28254b.compareTo(localDateTime.f28254b) : B;
    }

    public static LocalDateTime C(m mVar) {
        if (mVar instanceof LocalDateTime) {
            return (LocalDateTime) mVar;
        }
        if (mVar instanceof ZonedDateTime) {
            return ((ZonedDateTime) mVar).H();
        }
        if (mVar instanceof OffsetDateTime) {
            return ((OffsetDateTime) mVar).toLocalDateTime();
        }
        try {
            return new LocalDateTime(h.D(mVar), k.D(mVar));
        } catch (b e11) {
            String name2 = mVar.getClass().getName();
            throw new b("Unable to obtain LocalDateTime from TemporalAccessor: " + mVar + " of type " + name2, e11);
        }
    }

    public static LocalDateTime I(int i11) {
        return new LocalDateTime(h.M(i11, 12, 31), k.I(0));
    }

    public static LocalDateTime J(h hVar, k kVar) {
        Objects.requireNonNull(hVar, "date");
        Objects.requireNonNull(kVar, "time");
        return new LocalDateTime(hVar, kVar);
    }

    public static LocalDateTime K(long j11, int i11, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j12 = (long) i11;
        a.NANO_OF_SECOND.v(j12);
        long I = j11 + ((long) zoneOffset.I());
        long j13 = (long) RemoteMessageConst.DEFAULT_TTL;
        return new LocalDateTime(h.O(j$.lang.a.b(I, j13)), k.J((((long) ((int) j$.lang.a.f(I, j13))) * C.NANOS_PER_SECOND) + j12));
    }

    private LocalDateTime N(h hVar, long j11, long j12, long j13, long j14) {
        h hVar2 = hVar;
        int i11 = ((j11 | j12 | j13 | j14) > 0 ? 1 : ((j11 | j12 | j13 | j14) == 0 ? 0 : -1));
        k kVar = this.f28254b;
        if (i11 == 0) {
            return R(hVar2, kVar);
        }
        long j15 = j12 / 1440;
        long j16 = j11 / 24;
        long j17 = j16 + j15 + (j13 / 86400) + (j14 / 86400000000000L);
        long j18 = (long) 1;
        long j19 = (j12 % 1440) * 60000000000L;
        long j21 = ((j11 % 24) * 3600000000000L) + j19 + ((j13 % 86400) * C.NANOS_PER_SECOND) + (j14 % 86400000000000L);
        long R = kVar.R();
        long j22 = (j21 * j18) + R;
        long b11 = j$.lang.a.b(j22, 86400000000000L) + (j17 * j18);
        long f11 = j$.lang.a.f(j22, 86400000000000L);
        if (f11 != R) {
            kVar = k.J(f11);
        }
        return R(hVar2.Q(b11), kVar);
    }

    private LocalDateTime R(h hVar, k kVar) {
        return (this.f28253a == hVar && this.f28254b == kVar) ? this : new LocalDateTime(hVar, kVar);
    }

    public static LocalDateTime now() {
        a aVar = new a(x.C(TimeZone.getDefault().getID(), x.f28502a));
        Instant instant = aVar.instant();
        return K(instant.getEpochSecond(), instant.D(), aVar.b().B().d(instant));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 5, this);
    }

    public final int D() {
        return this.f28254b.G();
    }

    public final int E() {
        return this.f28254b.H();
    }

    public final int F() {
        return this.f28253a.I();
    }

    public final boolean G(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return B(localDateTime) > 0;
        }
        int i11 = (this.f28253a.t() > localDateTime.f28253a.t() ? 1 : (this.f28253a.t() == localDateTime.f28253a.t() ? 0 : -1));
        return i11 > 0 || (i11 == 0 && this.f28254b.R() > localDateTime.f28254b.R());
    }

    public final boolean H(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return B(localDateTime) < 0;
        }
        int i11 = (this.f28253a.t() > localDateTime.f28253a.t() ? 1 : (this.f28253a.t() == localDateTime.f28253a.t() ? 0 : -1));
        return i11 < 0 || (i11 == 0 && this.f28254b.R() < localDateTime.f28254b.R());
    }

    /* renamed from: L */
    public final LocalDateTime b(long j11, TemporalUnit temporalUnit) {
        long j12 = j11;
        TemporalUnit temporalUnit2 = temporalUnit;
        if (!(temporalUnit2 instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit2.f(this, j12);
        }
        int i11 = i.f28412a[((ChronoUnit) temporalUnit2).ordinal()];
        k kVar = this.f28254b;
        h hVar = this.f28253a;
        switch (i11) {
            case 1:
                return N(this.f28253a, 0, 0, 0, j11);
            case 2:
                LocalDateTime R = R(hVar.Q(j12 / 86400000000L), kVar);
                return R.N(R.f28253a, 0, 0, 0, (j12 % 86400000000L) * 1000);
            case 3:
                LocalDateTime R2 = R(hVar.Q(j12 / 86400000), kVar);
                return R2.N(R2.f28253a, 0, 0, 0, (j12 % 86400000) * 1000000);
            case 4:
                return M(j11);
            case 5:
                return N(this.f28253a, 0, j11, 0, 0);
            case 6:
                return N(this.f28253a, j11, 0, 0, 0);
            case 7:
                LocalDateTime R3 = R(hVar.Q(j12 / 256), kVar);
                return R3.N(R3.f28253a, (j12 % 256) * 12, 0, 0, 0);
            default:
                return R(hVar.b(j12, temporalUnit2), kVar);
        }
    }

    public final LocalDateTime M(long j11) {
        return N(this.f28253a, 0, 0, j11, 0);
    }

    public final h O() {
        return this.f28253a;
    }

    /* renamed from: P */
    public final LocalDateTime a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return (LocalDateTime) qVar.k(this, j11);
        }
        boolean isTimeBased = ((a) qVar).isTimeBased();
        k kVar = this.f28254b;
        h hVar = this.f28253a;
        return isTimeBased ? R(hVar, kVar.a(j11, qVar)) : R(hVar.a(j11, qVar), kVar);
    }

    /* renamed from: Q */
    public final LocalDateTime g(h hVar) {
        return R(hVar, this.f28254b);
    }

    /* access modifiers changed from: package-private */
    public final void S(DataOutput dataOutput) {
        this.f28253a.Y(dataOutput);
        this.f28254b.V(dataOutput);
    }

    public final boolean c(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar != null && qVar.f(this);
        }
        a aVar = (a) qVar;
        return aVar.isDateBased() || aVar.isTimeBased();
    }

    public final l d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.f28253a.equals(localDateTime.f28253a) && this.f28254b.equals(localDateTime.f28254b);
    }

    public final int f(q qVar) {
        return qVar instanceof a ? ((a) qVar).isTimeBased() ? this.f28254b.f(qVar) : this.f28253a.f(qVar) : p.a(this, qVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    public final j$.time.chrono.n getChronology() {
        return ((h) toLocalDate()).getChronology();
    }

    public final u h(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        if (!((a) qVar).isTimeBased()) {
            return this.f28253a.h(qVar);
        }
        k kVar = this.f28254b;
        kVar.getClass();
        return p.d(kVar, qVar);
    }

    public final int hashCode() {
        return this.f28253a.hashCode() ^ this.f28254b.hashCode();
    }

    public final C0108k i(ZoneOffset zoneOffset) {
        return ZonedDateTime.D(this, zoneOffset, (ZoneOffset) null);
    }

    public final l k(l lVar) {
        return C0099b.b(this, lVar);
    }

    public final long s(q qVar) {
        return qVar instanceof a ? ((a) qVar).isTimeBased() ? this.f28254b.s(qVar) : this.f28253a.s(qVar) : qVar.h(this);
    }

    public final C0100c toLocalDate() {
        return this.f28253a;
    }

    public final k toLocalTime() {
        return this.f28254b;
    }

    public final String toString() {
        String hVar = this.f28253a.toString();
        String kVar = this.f28254b.toString();
        return hVar + "T" + kVar;
    }

    public final Object v(s sVar) {
        return sVar == p.f() ? this.f28253a : C0099b.m(this, sVar);
    }

    /* renamed from: w */
    public final int compareTo(C0103f fVar) {
        return fVar instanceof LocalDateTime ? B((LocalDateTime) fVar) : C0099b.e(this, fVar);
    }
}
