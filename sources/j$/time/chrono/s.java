package j$.time.chrono;

import j$.lang.a;
import j$.time.b;
import j$.time.c;
import j$.time.h;
import j$.time.k;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.t;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;

public final class s extends C0102e {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a  reason: collision with root package name */
    private final transient q f28316a;

    /* renamed from: b  reason: collision with root package name */
    private final transient int f28317b;

    /* renamed from: c  reason: collision with root package name */
    private final transient int f28318c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f28319d;

    private s(q qVar, int i11, int i12, int i13) {
        qVar.B(i11, i12, i13);
        this.f28316a = qVar;
        this.f28317b = i11;
        this.f28318c = i12;
        this.f28319d = i13;
    }

    private s(q qVar, long j11) {
        int[] C = qVar.C((int) j11);
        this.f28316a = qVar;
        this.f28317b = C[0];
        this.f28318c = C[1];
        this.f28319d = C[2];
    }

    private int H() {
        return this.f28316a.v(this.f28317b, this.f28318c) + this.f28319d;
    }

    static s I(q qVar, int i11, int i12, int i13) {
        return new s(qVar, i11, i12, i13);
    }

    static s J(q qVar, long j11) {
        return new s(qVar, j11);
    }

    private s M(int i11, int i12, int i13) {
        q qVar = this.f28316a;
        int F = qVar.F(i11, i12);
        if (i13 > F) {
            i13 = F;
        }
        return new s(qVar, i11, i12, i13);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 6, this);
    }

    public final o C() {
        return t.AH;
    }

    /* access modifiers changed from: package-private */
    public final C0100c F(long j11) {
        if (j11 == 0) {
            return this;
        }
        long j12 = ((long) this.f28317b) + ((long) ((int) j11));
        int i11 = (int) j12;
        if (j12 == ((long) i11)) {
            return M(i11, this.f28318c, this.f28319d);
        }
        throw new ArithmeticException();
    }

    public final C0100c G(h hVar) {
        return (s) super.g(hVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public final s D(long j11) {
        return new s(this.f28316a, t() + j11);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public final s E(long j11) {
        if (j11 == 0) {
            return this;
        }
        long j12 = (((long) this.f28317b) * 12) + ((long) (this.f28318c - 1)) + j11;
        long b11 = a.b(j12, 12);
        q qVar = this.f28316a;
        if (b11 >= ((long) qVar.E()) && b11 <= ((long) qVar.D())) {
            return M((int) b11, ((int) a.f(j12, 12)) + 1, this.f28319d);
        }
        throw new b("Invalid Hijrah year: " + b11);
    }

    /* renamed from: N */
    public final s a(long j11, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (s) super.a(j11, qVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        q qVar2 = this.f28316a;
        qVar2.n(aVar).b(j11, aVar);
        int i11 = (int) j11;
        int i12 = r.f28315a[aVar.ordinal()];
        int i13 = this.f28319d;
        int i14 = this.f28318c;
        int i15 = this.f28317b;
        switch (i12) {
            case 1:
                return M(i15, i14, i11);
            case 2:
                return D((long) (Math.min(i11, y()) - H()));
            case 3:
                return D((j11 - s(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return D(j11 - ((long) (((int) a.f(t() + 3, (long) 7)) + 1)));
            case 5:
                return D(j11 - s(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return D(j11 - s(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new s(qVar2, j11);
            case 8:
                return D((j11 - s(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return M(i15, i11, i13);
            case 10:
                return E(j11 - (((((long) i15) * 12) + ((long) i14)) - 1));
            case 11:
                if (i15 < 1) {
                    i11 = 1 - i11;
                }
                return M(i11, i14, i13);
            case 12:
                return M(i11, i14, i13);
            case 13:
                return M(1 - i15, i14, i13);
            default:
                throw new t(c.a("Unsupported field: ", qVar));
        }
    }

    public final C0100c b(long j11, TemporalUnit temporalUnit) {
        return (s) super.b(j11, temporalUnit);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final l m8077b(long j11, TemporalUnit temporalUnit) {
        return (s) super.b(j11, temporalUnit);
    }

    public final C0100c d(long j11, ChronoUnit chronoUnit) {
        return (s) super.d(j11, chronoUnit);
    }

    /* renamed from: d  reason: collision with other method in class */
    public final l m8078d(long j11, ChronoUnit chronoUnit) {
        return (s) super.d(j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f28317b == sVar.f28317b && this.f28318c == sVar.f28318c && this.f28319d == sVar.f28319d && this.f28316a.equals(sVar.f28316a);
    }

    public final l g(h hVar) {
        return (s) super.g(hVar);
    }

    public final n getChronology() {
        return this.f28316a;
    }

    public final u h(q qVar) {
        long j11;
        int i11;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        if (C0099b.j(this, qVar)) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i12 = r.f28315a[aVar.ordinal()];
            q qVar2 = this.f28316a;
            if (i12 == 1) {
                i11 = qVar2.F(this.f28317b, this.f28318c);
            } else if (i12 == 2) {
                i11 = y();
            } else if (i12 != 3) {
                return qVar2.n(aVar);
            } else {
                j11 = 5;
                return u.j(1, j11);
            }
            j11 = (long) i11;
            return u.j(1, j11);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final int hashCode() {
        int hashCode = this.f28316a.e().hashCode();
        int i11 = this.f28317b;
        return (hashCode ^ (i11 & -2048)) ^ (((i11 << 11) + (this.f28318c << 6)) + this.f28319d);
    }

    public final boolean m() {
        return this.f28316a.A((long) this.f28317b);
    }

    public final long s(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.h(this);
        }
        int i11 = r.f28315a[((j$.time.temporal.a) qVar).ordinal()];
        int i12 = this.f28318c;
        int i13 = 1;
        int i14 = this.f28317b;
        int i15 = this.f28319d;
        switch (i11) {
            case 1:
                return (long) i15;
            case 2:
                return (long) H();
            case 3:
                return (long) (((i15 - 1) / 7) + 1);
            case 4:
                return (long) (((int) a.f(t() + 3, (long) 7)) + 1);
            case 5:
                return (long) (((i15 - 1) % 7) + 1);
            case 6:
                return (long) (((H() - 1) % 7) + 1);
            case 7:
                return t();
            case 8:
                return (long) (((H() - 1) / 7) + 1);
            case 9:
                return (long) i12;
            case 10:
                return ((((long) i14) * 12) + ((long) i12)) - 1;
            case 11:
                return (long) i14;
            case 12:
                return (long) i14;
            case 13:
                if (i14 <= 1) {
                    i13 = 0;
                }
                return (long) i13;
            default:
                throw new t(c.a("Unsupported field: ", qVar));
        }
    }

    public final long t() {
        return this.f28316a.B(this.f28317b, this.f28318c, this.f28319d);
    }

    public final C0103f u(k kVar) {
        return C0105h.D(this, kVar);
    }

    /* access modifiers changed from: package-private */
    public final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.f28316a);
        objectOutput.writeInt(p.a(this, j$.time.temporal.a.YEAR));
        objectOutput.writeByte(p.a(this, j$.time.temporal.a.MONTH_OF_YEAR));
        objectOutput.writeByte(p.a(this, j$.time.temporal.a.DAY_OF_MONTH));
    }

    public final int y() {
        return this.f28316a.G(this.f28317b);
    }
}
