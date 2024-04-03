package j$.time;

import com.google.android.exoplayer2.C;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
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
import j$.time.temporal.u;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class w implements l, n, Comparable, Serializable {
    private static final long serialVersionUID = 4183400860270640070L;

    /* renamed from: a  reason: collision with root package name */
    private final int f28500a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28501b;

    static {
        t tVar = new t();
        tVar.k(a.YEAR, 4, 10, A.EXCEEDS_PAD);
        tVar.e(SignatureVisitor.SUPER);
        tVar.m(a.MONTH_OF_YEAR, 2);
        tVar.v(Locale.getDefault());
    }

    private w(int i11, int i12) {
        this.f28500a = i11;
        this.f28501b = i12;
    }

    static w E(DataInput dataInput) {
        int readInt = dataInput.readInt();
        byte readByte = dataInput.readByte();
        a.YEAR.v((long) readInt);
        a.MONTH_OF_YEAR.v((long) readByte);
        return new w(readInt, readByte);
    }

    private w F(int i11, int i12) {
        return (this.f28500a == i11 && this.f28501b == i12) ? this : new w(i11, i12);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 12, this);
    }

    /* renamed from: B */
    public final w b(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (w) temporalUnit.f(this, j11);
        }
        switch (v.f28499b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return C(j11);
            case 2:
                return D(j11);
            case 3:
                return D(j$.lang.a.d(j11, (long) 10));
            case 4:
                return D(j$.lang.a.d(j11, (long) 100));
            case 5:
                return D(j$.lang.a.d(j11, (long) 1000));
            case 6:
                a aVar = a.ERA;
                return a(j$.lang.a.e(s(aVar), j11), aVar);
            default:
                throw new j$.time.temporal.t("Unsupported unit: " + temporalUnit);
        }
    }

    public final w C(long j11) {
        if (j11 == 0) {
            return this;
        }
        long j12 = (((long) this.f28500a) * 12) + ((long) (this.f28501b - 1)) + j11;
        long j13 = (long) 12;
        return F(a.YEAR.s(j$.lang.a.b(j12, j13)), ((int) j$.lang.a.f(j12, j13)) + 1);
    }

    public final w D(long j11) {
        return j11 == 0 ? this : F(a.YEAR.s(((long) this.f28500a) + j11), this.f28501b);
    }

    /* renamed from: G */
    public final w a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return (w) qVar.k(this, j11);
        }
        a aVar = (a) qVar;
        aVar.v(j11);
        int i11 = v.f28498a[aVar.ordinal()];
        int i12 = this.f28500a;
        if (i11 != 1) {
            int i13 = this.f28501b;
            if (i11 == 2) {
                return C(j11 - (((((long) i12) * 12) + ((long) i13)) - 1));
            }
            if (i11 == 3) {
                if (i12 < 1) {
                    j11 = 1 - j11;
                }
                int i14 = (int) j11;
                a.YEAR.v((long) i14);
                return F(i14, i13);
            } else if (i11 == 4) {
                int i15 = (int) j11;
                a.YEAR.v((long) i15);
                return F(i15, i13);
            } else if (i11 != 5) {
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
            } else if (s(a.ERA) == j11) {
                return this;
            } else {
                int i16 = 1 - i12;
                a.YEAR.v((long) i16);
                return F(i16, i13);
            }
        } else {
            int i17 = (int) j11;
            a.MONTH_OF_YEAR.v((long) i17);
            return F(i12, i17);
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(DataOutput dataOutput) {
        dataOutput.writeInt(this.f28500a);
        dataOutput.writeByte(this.f28501b);
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.YEAR || qVar == a.MONTH_OF_YEAR || qVar == a.PROLEPTIC_MONTH || qVar == a.YEAR_OF_ERA || qVar == a.ERA : qVar != null && qVar.f(this);
    }

    public final int compareTo(Object obj) {
        w wVar = (w) obj;
        int i11 = this.f28500a - wVar.f28500a;
        return i11 == 0 ? this.f28501b - wVar.f28501b : i11;
    }

    public final l d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f28500a == wVar.f28500a && this.f28501b == wVar.f28501b;
    }

    public final int f(q qVar) {
        return h(qVar).a(s(qVar), qVar);
    }

    public final l g(h hVar) {
        return (w) C0099b.a(hVar, this);
    }

    public final u h(q qVar) {
        if (qVar != a.YEAR_OF_ERA) {
            return p.d(this, qVar);
        }
        return u.j(1, this.f28500a <= 0 ? C.NANOS_PER_SECOND : 999999999);
    }

    public final int hashCode() {
        return (this.f28501b << 27) ^ this.f28500a;
    }

    public final l k(l lVar) {
        if (((C0098a) C0099b.r(lVar)).equals(j$.time.chrono.u.f28321d)) {
            return lVar.a(((((long) this.f28500a) * 12) + ((long) this.f28501b)) - 1, a.PROLEPTIC_MONTH);
        }
        throw new b("Adjustment only supported on ISO date-time");
    }

    public final long s(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        int i11 = v.f28498a[((a) qVar).ordinal()];
        int i12 = this.f28501b;
        int i13 = 1;
        if (i11 == 1) {
            return (long) i12;
        }
        int i14 = this.f28500a;
        if (i11 == 2) {
            return ((((long) i14) * 12) + ((long) i12)) - 1;
        }
        if (i11 == 3) {
            if (i14 < 1) {
                i14 = 1 - i14;
            }
            return (long) i14;
        } else if (i11 == 4) {
            return (long) i14;
        } else {
            if (i11 == 5) {
                if (i14 < 1) {
                    i13 = 0;
                }
                return (long) i13;
            }
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    public final String toString() {
        int i11;
        int i12 = this.f28500a;
        int abs = Math.abs(i12);
        StringBuilder sb2 = new StringBuilder(9);
        if (abs < 1000) {
            if (i12 < 0) {
                sb2.append(i12 - 10000);
                i11 = 1;
            } else {
                sb2.append(i12 + 10000);
                i11 = 0;
            }
            sb2.deleteCharAt(i11);
        } else {
            sb2.append(i12);
        }
        int i13 = this.f28501b;
        sb2.append(i13 < 10 ? "-0" : SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        sb2.append(i13);
        return sb2.toString();
    }

    public final Object v(s sVar) {
        return sVar == p.e() ? j$.time.chrono.u.f28321d : sVar == p.i() ? ChronoUnit.MONTHS : p.c(this, sVar);
    }
}
