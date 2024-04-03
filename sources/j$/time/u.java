package j$.time;

import com.google.android.exoplayer2.C;
import j$.time.chrono.C0098a;
import j$.time.chrono.C0099b;
import j$.time.format.A;
import j$.time.format.t;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

public final class u implements l, n, Comparable, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f28496b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a  reason: collision with root package name */
    private final int f28497a;

    static {
        t tVar = new t();
        tVar.k(a.YEAR, 4, 10, A.EXCEEDS_PAD);
        tVar.v(Locale.getDefault());
    }

    private u(int i11) {
        this.f28497a = i11;
    }

    public static u B(int i11) {
        a.YEAR.v((long) i11);
        return new u(i11);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 11, this);
    }

    /* renamed from: C */
    public final u b(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (u) temporalUnit.f(this, j11);
        }
        int i11 = t.f28439b[((ChronoUnit) temporalUnit).ordinal()];
        if (i11 == 1) {
            return D(j11);
        }
        if (i11 == 2) {
            return D(j$.lang.a.d(j11, (long) 10));
        }
        if (i11 == 3) {
            return D(j$.lang.a.d(j11, (long) 100));
        }
        if (i11 == 4) {
            return D(j$.lang.a.d(j11, (long) 1000));
        }
        if (i11 == 5) {
            a aVar = a.ERA;
            return a(j$.lang.a.e(s(aVar), j11), aVar);
        }
        throw new j$.time.temporal.t("Unsupported unit: " + temporalUnit);
    }

    public final u D(long j11) {
        return j11 == 0 ? this : B(a.YEAR.s(((long) this.f28497a) + j11));
    }

    /* renamed from: E */
    public final u a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return (u) qVar.k(this, j11);
        }
        a aVar = (a) qVar;
        aVar.v(j11);
        int i11 = t.f28438a[aVar.ordinal()];
        int i12 = this.f28497a;
        if (i11 == 1) {
            if (i12 < 1) {
                j11 = 1 - j11;
            }
            return B((int) j11);
        } else if (i11 == 2) {
            return B((int) j11);
        } else {
            if (i11 == 3) {
                return s(a.ERA) == j11 ? this : B(1 - i12);
            }
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    /* access modifiers changed from: package-private */
    public final void F(DataOutput dataOutput) {
        dataOutput.writeInt(this.f28497a);
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.YEAR || qVar == a.YEAR_OF_ERA || qVar == a.ERA : qVar != null && qVar.f(this);
    }

    public final int compareTo(Object obj) {
        return this.f28497a - ((u) obj).f28497a;
    }

    public final l d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return this.f28497a == ((u) obj).f28497a;
    }

    public final int f(q qVar) {
        return h(qVar).a(s(qVar), qVar);
    }

    public final l g(h hVar) {
        return (u) C0099b.a(hVar, this);
    }

    public final j$.time.temporal.u h(q qVar) {
        if (qVar != a.YEAR_OF_ERA) {
            return p.d(this, qVar);
        }
        return j$.time.temporal.u.j(1, this.f28497a <= 0 ? C.NANOS_PER_SECOND : 999999999);
    }

    public final int hashCode() {
        return this.f28497a;
    }

    public final l k(l lVar) {
        if (((C0098a) C0099b.r(lVar)).equals(j$.time.chrono.u.f28321d)) {
            return lVar.a((long) this.f28497a, a.YEAR);
        }
        throw new b("Adjustment only supported on ISO date-time");
    }

    public final long s(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i11 = t.f28438a[((a) qVar).ordinal()];
        int i12 = this.f28497a;
        int i13 = 1;
        if (i11 == 1) {
            if (i12 < 1) {
                i12 = 1 - i12;
            }
            return (long) i12;
        } else if (i11 == 2) {
            return (long) i12;
        } else {
            if (i11 == 3) {
                if (i12 < 1) {
                    i13 = 0;
                }
                return (long) i13;
            }
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    public final String toString() {
        return Integer.toString(this.f28497a);
    }

    public final Object v(s sVar) {
        return sVar == p.e() ? j$.time.chrono.u.f28321d : sVar == p.i() ? ChronoUnit.YEARS : p.c(this, sVar);
    }
}
