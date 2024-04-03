package j$.time.chrono;

import j$.time.b;
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
import org.threeten.bp.Year;

public final class z extends C0102e {

    /* renamed from: d  reason: collision with root package name */
    static final h f28326d = h.M(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a  reason: collision with root package name */
    private final transient h f28327a;

    /* renamed from: b  reason: collision with root package name */
    private transient A f28328b;

    /* renamed from: c  reason: collision with root package name */
    private transient int f28329c;

    z(h hVar) {
        if (!hVar.J(f28326d)) {
            this.f28328b = A.e(hVar);
            this.f28329c = (hVar.I() - this.f28328b.l().I()) + 1;
            this.f28327a = hVar;
            return;
        }
        throw new b("JapaneseDate before Meiji 6 is not supported");
    }

    private z I(h hVar) {
        return hVar.equals(this.f28327a) ? this : new z(hVar);
    }

    private z J(A a11, int i11) {
        x.f28324d.getClass();
        if (a11 instanceof A) {
            int I = (a11.l().I() + i11) - 1;
            if (i11 == 1 || (I >= -999999999 && I <= 999999999 && I >= a11.l().I() && a11 == A.e(h.M(I, 1, 1)))) {
                return I(this.f28327a.X(I));
            }
            throw new b("Invalid yearOfEra value");
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 4, this);
    }

    public final o C() {
        return this.f28328b;
    }

    /* access modifiers changed from: package-private */
    public final C0100c D(long j11) {
        return I(this.f28327a.Q(j11));
    }

    /* access modifiers changed from: package-private */
    public final C0100c E(long j11) {
        return I(this.f28327a.R(j11));
    }

    /* access modifiers changed from: package-private */
    public final C0100c F(long j11) {
        return I(this.f28327a.S(j11));
    }

    public final C0100c G(h hVar) {
        return (z) super.g(hVar);
    }

    /* renamed from: H */
    public final z a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return (z) super.a(j11, qVar);
        }
        a aVar = (a) qVar;
        if (s(aVar) == j11) {
            return this;
        }
        int[] iArr = y.f28325a;
        int i11 = iArr[aVar.ordinal()];
        h hVar = this.f28327a;
        if (i11 == 3 || i11 == 8 || i11 == 9) {
            int a11 = x.f28324d.n(aVar).a(j11, aVar);
            int i12 = iArr[aVar.ordinal()];
            if (i12 == 3) {
                return J(this.f28328b, a11);
            }
            if (i12 == 8) {
                return J(A.o(a11), this.f28329c);
            }
            if (i12 == 9) {
                return I(hVar.X(a11));
            }
        }
        return I(hVar.a(j11, qVar));
    }

    public final C0100c b(long j11, TemporalUnit temporalUnit) {
        return (z) super.b(j11, temporalUnit);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final l m8079b(long j11, TemporalUnit temporalUnit) {
        return (z) super.b(j11, temporalUnit);
    }

    public final boolean c(q qVar) {
        if (qVar == a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == a.ALIGNED_WEEK_OF_MONTH || qVar == a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return qVar instanceof a ? qVar.isDateBased() : qVar != null && qVar.f(this);
    }

    public final C0100c d(long j11, ChronoUnit chronoUnit) {
        return (z) super.d(j11, chronoUnit);
    }

    /* renamed from: d  reason: collision with other method in class */
    public final l m8080d(long j11, ChronoUnit chronoUnit) {
        return (z) super.d(j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            return this.f28327a.equals(((z) obj).f28327a);
        }
        return false;
    }

    public final l g(h hVar) {
        return (z) super.g(hVar);
    }

    public final n getChronology() {
        return x.f28324d;
    }

    public final u h(q qVar) {
        long j11;
        int i11;
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        if (c(qVar)) {
            a aVar = (a) qVar;
            int i12 = y.f28325a[aVar.ordinal()];
            if (i12 == 1) {
                i11 = this.f28327a.K();
            } else if (i12 == 2) {
                i11 = y();
            } else if (i12 != 3) {
                return x.f28324d.n(aVar);
            } else {
                int I = this.f28328b.l().I();
                A n11 = this.f28328b.n();
                j11 = (long) (n11 != null ? (n11.l().I() - I) + 1 : Year.MAX_VALUE - I);
                return u.j(1, j11);
            }
            j11 = (long) i11;
            return u.j(1, j11);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final int hashCode() {
        x.f28324d.getClass();
        return this.f28327a.hashCode() ^ -688086063;
    }

    public final long s(q qVar) {
        int i11;
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i12 = y.f28325a[((a) qVar).ordinal()];
        h hVar = this.f28327a;
        switch (i12) {
            case 2:
                if (this.f28329c != 1) {
                    i11 = hVar.G();
                    break;
                } else {
                    i11 = (hVar.G() - this.f28328b.l().G()) + 1;
                    break;
                }
            case 3:
                i11 = this.f28329c;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new t(c.a("Unsupported field: ", qVar));
            case 8:
                i11 = this.f28328b.getValue();
                break;
            default:
                return hVar.s(qVar);
        }
        return (long) i11;
    }

    public final long t() {
        return this.f28327a.t();
    }

    public final C0103f u(k kVar) {
        return C0105h.D(this, kVar);
    }

    public final int y() {
        A n11 = this.f28328b.n();
        h hVar = this.f28327a;
        int y11 = (n11 == null || n11.l().I() != hVar.I()) ? hVar.y() : n11.l().G() - 1;
        return this.f28329c == 1 ? y11 - (this.f28328b.l().G() - 1) : y11;
    }
}
