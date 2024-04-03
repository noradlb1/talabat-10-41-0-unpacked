package j$.time.chrono;

import j$.time.c;
import j$.time.h;
import j$.time.k;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.q;
import j$.time.temporal.t;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

public final class K extends C0102e {
    private static final long serialVersionUID = -8722293800195731463L;

    /* renamed from: a  reason: collision with root package name */
    private final transient h f28283a;

    K(h hVar) {
        Objects.requireNonNull(hVar, "isoDate");
        this.f28283a = hVar;
    }

    private int H() {
        return this.f28283a.I() + 543;
    }

    private K J(h hVar) {
        return hVar.equals(this.f28283a) ? this : new K(hVar);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 8, this);
    }

    public final o C() {
        return H() >= 1 ? L.BE : L.BEFORE_BE;
    }

    /* access modifiers changed from: package-private */
    public final C0100c D(long j11) {
        return J(this.f28283a.Q(j11));
    }

    /* access modifiers changed from: package-private */
    public final C0100c E(long j11) {
        return J(this.f28283a.R(j11));
    }

    /* access modifiers changed from: package-private */
    public final C0100c F(long j11) {
        return J(this.f28283a.S(j11));
    }

    public final C0100c G(h hVar) {
        return (K) super.g(hVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r2 != 7) goto L_0x0062;
     */
    /* renamed from: I */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.chrono.K a(long r9, j$.time.temporal.q r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof j$.time.temporal.a
            if (r0 == 0) goto L_0x009a
            r0 = r11
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r8.s(r0)
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            return r8
        L_0x0010:
            int[] r1 = j$.time.chrono.J.f28282a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            j$.time.h r3 = r8.f28283a
            r4 = 7
            r5 = 6
            r6 = 4
            if (r2 == r6) goto L_0x004b
            r7 = 5
            if (r2 == r7) goto L_0x0027
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x004b
            goto L_0x0062
        L_0x0027:
            j$.time.chrono.I r11 = j$.time.chrono.I.f28281d
            j$.time.temporal.u r11 = r11.n(r0)
            r11.b(r9, r0)
            int r11 = r8.H()
            long r0 = (long) r11
            r4 = 12
            long r0 = r0 * r4
            int r11 = r3.H()
            long r4 = (long) r11
            long r0 = r0 + r4
            r4 = 1
            long r0 = r0 - r4
            long r9 = r9 - r0
            j$.time.h r9 = r3.R(r9)
            j$.time.chrono.K r9 = r8.J(r9)
            return r9
        L_0x004b:
            j$.time.chrono.I r2 = j$.time.chrono.I.f28281d
            j$.time.temporal.u r2 = r2.n(r0)
            int r2 = r2.a(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r6) goto L_0x0086
            if (r0 == r5) goto L_0x007b
            if (r0 == r4) goto L_0x006b
        L_0x0062:
            j$.time.h r9 = r3.a(r9, r11)
            j$.time.chrono.K r9 = r8.J(r9)
            return r9
        L_0x006b:
            int r9 = r8.H()
            int r1 = r1 - r9
            int r1 = r1 + -543
            j$.time.h r9 = r3.X(r1)
            j$.time.chrono.K r9 = r8.J(r9)
            return r9
        L_0x007b:
            int r2 = r2 + -543
            j$.time.h r9 = r3.X(r2)
            j$.time.chrono.K r9 = r8.J(r9)
            return r9
        L_0x0086:
            int r9 = r8.H()
            if (r9 < r1) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            int r2 = 1 - r2
        L_0x008f:
            int r2 = r2 + -543
            j$.time.h r9 = r3.X(r2)
            j$.time.chrono.K r9 = r8.J(r9)
            return r9
        L_0x009a:
            j$.time.chrono.c r9 = super.a((long) r9, (j$.time.temporal.q) r11)
            j$.time.chrono.K r9 = (j$.time.chrono.K) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.K.a(long, j$.time.temporal.q):j$.time.chrono.K");
    }

    public final C0100c b(long j11, TemporalUnit temporalUnit) {
        return (K) super.b(j11, temporalUnit);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final l m8075b(long j11, TemporalUnit temporalUnit) {
        return (K) super.b(j11, temporalUnit);
    }

    public final C0100c d(long j11, ChronoUnit chronoUnit) {
        return (K) super.d(j11, chronoUnit);
    }

    /* renamed from: d  reason: collision with other method in class */
    public final l m8076d(long j11, ChronoUnit chronoUnit) {
        return (K) super.d(j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof K) {
            return this.f28283a.equals(((K) obj).f28283a);
        }
        return false;
    }

    public final l g(h hVar) {
        return (K) super.g(hVar);
    }

    public final n getChronology() {
        return I.f28281d;
    }

    public final u h(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        if (C0099b.j(this, qVar)) {
            a aVar = (a) qVar;
            int i11 = J.f28282a[aVar.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                return this.f28283a.h(qVar);
            }
            if (i11 != 4) {
                return I.f28281d.n(aVar);
            }
            u range = a.YEAR.range();
            return u.j(1, H() <= 0 ? (-(range.e() + 543)) + 1 : 543 + range.d());
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final int hashCode() {
        I.f28281d.getClass();
        return this.f28283a.hashCode() ^ 146118545;
    }

    public final long s(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i11 = J.f28282a[((a) qVar).ordinal()];
        int i12 = 1;
        if (i11 != 4) {
            h hVar = this.f28283a;
            if (i11 == 5) {
                return ((((long) H()) * 12) + ((long) hVar.H())) - 1;
            }
            if (i11 == 6) {
                return (long) H();
            }
            if (i11 != 7) {
                return hVar.s(qVar);
            }
            if (H() < 1) {
                i12 = 0;
            }
            return (long) i12;
        }
        int H = H();
        if (H < 1) {
            H = 1 - H;
        }
        return (long) H;
    }

    public final long t() {
        return this.f28283a.t();
    }

    public final C0103f u(k kVar) {
        return C0105h.D(this, kVar);
    }
}
