package j$.time;

import com.google.android.exoplayer2.C;
import com.huawei.hms.push.constant.RemoteMessageConst;
import j$.time.chrono.C0099b;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public final class Instant implements l, n, Comparable<Instant>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Instant f28248c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a  reason: collision with root package name */
    private final long f28249a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28250b;

    static {
        E(-31557014167219200L, 0);
        E(31556889864403199L, 999999999);
    }

    private Instant(long j11, int i11) {
        this.f28249a = j11;
        this.f28250b = i11;
    }

    private static Instant B(long j11, int i11) {
        if ((((long) i11) | j11) == 0) {
            return f28248c;
        }
        if (j11 >= -31557014167219200L && j11 <= 31556889864403199L) {
            return new Instant(j11, i11);
        }
        throw new b("Instant exceeds minimum or maximum instant");
    }

    public static Instant C(m mVar) {
        if (mVar instanceof Instant) {
            return (Instant) mVar;
        }
        Objects.requireNonNull(mVar, "temporal");
        try {
            return E(mVar.s(a.INSTANT_SECONDS), (long) mVar.f(a.NANO_OF_SECOND));
        } catch (b e11) {
            String name2 = mVar.getClass().getName();
            throw new b("Unable to obtain Instant from TemporalAccessor: " + mVar + " of type " + name2, e11);
        }
    }

    public static Instant E(long j11, long j12) {
        return B(j$.lang.a.e(j11, j$.lang.a.b(j12, C.NANOS_PER_SECOND)), (int) j$.lang.a.f(j12, C.NANOS_PER_SECOND));
    }

    private Instant F(long j11, long j12) {
        if ((j11 | j12) == 0) {
            return this;
        }
        return E(j$.lang.a.e(j$.lang.a.e(this.f28249a, j11), j12 / C.NANOS_PER_SECOND), ((long) this.f28250b) + (j12 % C.NANOS_PER_SECOND));
    }

    public static Instant ofEpochMilli(long j11) {
        long j12 = (long) 1000;
        return B(j$.lang.a.b(j11, j12), ((int) j$.lang.a.f(j11, j12)) * 1000000);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 2, this);
    }

    public final int D() {
        return this.f28250b;
    }

    /* renamed from: G */
    public final Instant b(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.f(this, j11);
        }
        switch (f.f28334b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return F(0, j11);
            case 2:
                return F(j11 / 1000000, (j11 % 1000000) * 1000);
            case 3:
                return F(j11 / 1000, (j11 % 1000) * 1000000);
            case 4:
                return F(j11, 0);
            case 5:
                return F(j$.lang.a.d(j11, (long) 60), 0);
            case 6:
                return F(j$.lang.a.d(j11, (long) 3600), 0);
            case 7:
                return F(j$.lang.a.d(j11, (long) 43200), 0);
            case 8:
                return F(j$.lang.a.d(j11, (long) RemoteMessageConst.DEFAULT_TTL), 0);
            default:
                throw new t("Unsupported unit: " + temporalUnit);
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(DataOutput dataOutput) {
        dataOutput.writeLong(this.f28249a);
        dataOutput.writeInt(this.f28250b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r6 != r4) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r6 != r4) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.l a(long r6, j$.time.temporal.q r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof j$.time.temporal.a
            if (r0 == 0) goto L_0x0052
            r0 = r8
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            r0.v(r6)
            int[] r1 = j$.time.f.f28333a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            long r2 = r5.f28249a
            int r4 = r5.f28250b
            if (r0 == r1) goto L_0x0045
            r1 = 2
            if (r0 == r1) goto L_0x003f
            r1 = 3
            if (r0 == r1) goto L_0x0037
            r1 = 4
            if (r0 != r1) goto L_0x002b
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0050
            j$.time.Instant r6 = B(r6, r4)
            goto L_0x0058
        L_0x002b:
            j$.time.temporal.t r6 = new j$.time.temporal.t
            java.lang.String r7 = "Unsupported field: "
            java.lang.String r7 = j$.time.c.a(r7, r8)
            r6.<init>(r7)
            throw r6
        L_0x0037:
            int r6 = (int) r6
            r7 = 1000000(0xf4240, float:1.401298E-39)
            int r6 = r6 * r7
            if (r6 == r4) goto L_0x0050
            goto L_0x004b
        L_0x003f:
            int r6 = (int) r6
            int r6 = r6 * 1000
            if (r6 == r4) goto L_0x0050
            goto L_0x004b
        L_0x0045:
            long r0 = (long) r4
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 == 0) goto L_0x0050
            int r6 = (int) r6
        L_0x004b:
            j$.time.Instant r6 = B(r2, r6)
            goto L_0x0058
        L_0x0050:
            r6 = r5
            goto L_0x0058
        L_0x0052:
            j$.time.temporal.l r6 = r8.k(r5, r6)
            j$.time.Instant r6 = (j$.time.Instant) r6
        L_0x0058:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.Instant.a(long, j$.time.temporal.q):j$.time.temporal.l");
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.C(this, zoneOffset);
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.INSTANT_SECONDS || qVar == a.NANO_OF_SECOND || qVar == a.MICRO_OF_SECOND || qVar == a.MILLI_OF_SECOND : qVar != null && qVar.f(this);
    }

    public final int compareTo(Object obj) {
        Instant instant = (Instant) obj;
        int a11 = j$.lang.a.a(this.f28249a, instant.f28249a);
        return a11 != 0 ? a11 : this.f28250b - instant.f28250b;
    }

    public final l d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.f28249a == instant.f28249a && this.f28250b == instant.f28250b;
    }

    public final int f(q qVar) {
        if (!(qVar instanceof a)) {
            return p.d(this, qVar).a(qVar.h(this), qVar);
        }
        int i11 = f.f28333a[((a) qVar).ordinal()];
        int i12 = this.f28250b;
        if (i11 == 1) {
            return i12;
        }
        if (i11 == 2) {
            return i12 / 1000;
        }
        if (i11 == 3) {
            return i12 / 1000000;
        }
        if (i11 == 4) {
            a.INSTANT_SECONDS.s(this.f28249a);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final l g(h hVar) {
        return (Instant) C0099b.a(hVar, this);
    }

    public long getEpochSecond() {
        return this.f28249a;
    }

    public final u h(q qVar) {
        return p.d(this, qVar);
    }

    public final int hashCode() {
        long j11 = this.f28249a;
        return (this.f28250b * 51) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public boolean isAfter(Instant instant) {
        int a11 = j$.lang.a.a(this.f28249a, instant.f28249a);
        if (a11 == 0) {
            a11 = this.f28250b - instant.f28250b;
        }
        return a11 > 0;
    }

    public final l k(l lVar) {
        return lVar.a(this.f28249a, a.INSTANT_SECONDS).a((long) this.f28250b, a.NANO_OF_SECOND);
    }

    public Instant minus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.g(this);
    }

    public Instant plus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.f(this);
    }

    public final long s(q qVar) {
        int i11;
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i12 = f.f28333a[((a) qVar).ordinal()];
        int i13 = this.f28250b;
        if (i12 == 1) {
            return (long) i13;
        }
        if (i12 == 2) {
            i11 = i13 / 1000;
        } else if (i12 == 3) {
            i11 = i13 / 1000000;
        } else if (i12 == 4) {
            return this.f28249a;
        } else {
            throw new t(c.a("Unsupported field: ", qVar));
        }
        return (long) i11;
    }

    public long toEpochMilli() {
        long d11;
        int i11;
        long j11 = this.f28249a;
        int i12 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        int i13 = this.f28250b;
        if (i12 >= 0 || i13 <= 0) {
            d11 = j$.lang.a.d(j11, (long) 1000);
            i11 = i13 / 1000000;
        } else {
            d11 = j$.lang.a.d(j11 + 1, (long) 1000);
            i11 = (i13 / 1000000) - 1000;
        }
        return j$.lang.a.e(d11, (long) i11);
    }

    public final String toString() {
        return DateTimeFormatter.f28338f.a(this);
    }

    public final Object v(s sVar) {
        if (sVar == p.i()) {
            return ChronoUnit.NANOS;
        }
        if (sVar == p.e() || sVar == p.k() || sVar == p.j() || sVar == p.h() || sVar == p.f() || sVar == p.g()) {
            return null;
        }
        return sVar.a(this);
    }
}
