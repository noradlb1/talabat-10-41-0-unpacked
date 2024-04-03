package j$.time;

import com.google.android.exoplayer2.C;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapperKt;
import j$.time.chrono.C0099b;
import j$.time.chrono.C0100c;
import j$.time.chrono.C0103f;
import j$.time.chrono.u;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.threeten.bp.Year;

public final class h implements l, n, C0100c, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final h f28407d = M(Year.MIN_VALUE, 1, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final h f28408e = M(Year.MAX_VALUE, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a  reason: collision with root package name */
    private final int f28409a;

    /* renamed from: b  reason: collision with root package name */
    private final short f28410b;

    /* renamed from: c  reason: collision with root package name */
    private final short f28411c;

    static {
        M(1970, 1, 1);
    }

    private h(int i11, int i12, int i13) {
        this.f28409a = i11;
        this.f28410b = (short) i12;
        this.f28411c = (short) i13;
    }

    private static h C(int i11, int i12, int i13) {
        int i14 = 28;
        if (i13 > 28) {
            if (i12 != 2) {
                i14 = (i12 == 4 || i12 == 6 || i12 == 9 || i12 == 11) ? 30 : 31;
            } else if (u.f28321d.A((long) i11)) {
                i14 = 29;
            }
            if (i13 > i14) {
                if (i13 == 29) {
                    throw new b("Invalid date 'February 29' as '" + i11 + "' is not a leap year");
                }
                throw new b("Invalid date '" + m.E(i12).name() + " " + i13 + "'");
            }
        }
        return new h(i11, i12, i13);
    }

    public static h D(m mVar) {
        Objects.requireNonNull(mVar, "temporal");
        h hVar = (h) mVar.v(p.f());
        if (hVar != null) {
            return hVar;
        }
        String name2 = mVar.getClass().getName();
        throw new b("Unable to obtain LocalDate from TemporalAccessor: " + mVar + " of type " + name2);
    }

    private int E(q qVar) {
        int i11;
        int i12 = g.f28405a[((a) qVar).ordinal()];
        int i13 = this.f28409a;
        short s11 = this.f28411c;
        switch (i12) {
            case 1:
                return s11;
            case 2:
                return G();
            case 3:
                i11 = (s11 - 1) / 7;
                break;
            case 4:
                return i13 >= 1 ? i13 : 1 - i13;
            case 5:
                return F().getValue();
            case 6:
                i11 = (s11 - 1) % 7;
                break;
            case 7:
                return ((G() - 1) % 7) + 1;
            case 8:
                throw new t("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((G() - 1) / 7) + 1;
            case 10:
                return this.f28410b;
            case 11:
                throw new t("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return i13;
            case 13:
                return i13 >= 1 ? 1 : 0;
            default:
                throw new t(c.a("Unsupported field: ", qVar));
        }
        return i11 + 1;
    }

    public static h M(int i11, int i12, int i13) {
        a.YEAR.v((long) i11);
        a.MONTH_OF_YEAR.v((long) i12);
        a.DAY_OF_MONTH.v((long) i13);
        return C(i11, i12, i13);
    }

    public static h N(int i11, m mVar, int i12) {
        a.YEAR.v((long) i11);
        Objects.requireNonNull(mVar, "month");
        a.DAY_OF_MONTH.v((long) i12);
        return C(i11, mVar.getValue(), i12);
    }

    public static h O(long j11) {
        long j12;
        long j13 = j11;
        a.EPOCH_DAY.v(j13);
        long j14 = (j13 + 719528) - 60;
        if (j14 < 0) {
            long j15 = ((j14 + 1) / 146097) - 1;
            j12 = j15 * 400;
            j14 += (-j15) * 146097;
        } else {
            j12 = 0;
        }
        long j16 = ((j14 * 400) + 591) / 146097;
        long j17 = j14 - ((j16 / 400) + (((j16 / 4) + (j16 * 365)) - (j16 / 100)));
        if (j17 < 0) {
            j16--;
            j17 = j14 - ((j16 / 400) + (((j16 / 4) + (365 * j16)) - (j16 / 100)));
        }
        int i11 = (int) j17;
        int i12 = ((i11 * 5) + 2) / Opcodes.IFEQ;
        return new h(a.YEAR.s(j16 + j12 + ((long) (i12 / 10))), ((i12 + 2) % 12) + 1, (i11 - (((i12 * 306) + 5) / 10)) + 1);
    }

    private static h T(int i11, int i12, int i13) {
        int i14;
        if (i12 != 2) {
            if (i12 == 4 || i12 == 6 || i12 == 9 || i12 == 11) {
                i14 = 30;
            }
            return new h(i11, i12, i13);
        }
        i14 = u.f28321d.A((long) i11) ? 29 : 28;
        i13 = Math.min(i13, i14);
        return new h(i11, i12, i13);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 3, this);
    }

    /* access modifiers changed from: package-private */
    public final int B(h hVar) {
        int i11 = this.f28409a - hVar.f28409a;
        if (i11 != 0) {
            return i11;
        }
        int i12 = this.f28410b - hVar.f28410b;
        return i12 == 0 ? this.f28411c - hVar.f28411c : i12;
    }

    public final d F() {
        return d.B(((int) j$.lang.a.f(t() + 3, (long) 7)) + 1);
    }

    public final int G() {
        return (m.E(this.f28410b).B(m()) + this.f28411c) - 1;
    }

    public final int H() {
        return this.f28410b;
    }

    public final int I() {
        return this.f28409a;
    }

    public final boolean J(h hVar) {
        return hVar instanceof h ? B(hVar) < 0 : t() < hVar.t();
    }

    public final int K() {
        short s11 = this.f28410b;
        return s11 != 2 ? (s11 == 4 || s11 == 6 || s11 == 9 || s11 == 11) ? 30 : 31 : m() ? 29 : 28;
    }

    /* renamed from: L */
    public final h d(long j11, ChronoUnit chronoUnit) {
        return j11 == Long.MIN_VALUE ? b(Long.MAX_VALUE, chronoUnit).b(1, chronoUnit) : b(-j11, chronoUnit);
    }

    /* renamed from: P */
    public final h b(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (h) temporalUnit.f(this, j11);
        }
        switch (g.f28406b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return Q(j11);
            case 2:
                return Q(j$.lang.a.d(j11, (long) 7));
            case 3:
                return R(j11);
            case 4:
                return S(j11);
            case 5:
                return S(j$.lang.a.d(j11, (long) 10));
            case 6:
                return S(j$.lang.a.d(j11, (long) 100));
            case 7:
                return S(j$.lang.a.d(j11, (long) 1000));
            case 8:
                a aVar = a.ERA;
                return a(j$.lang.a.e(s(aVar), j11), aVar);
            default:
                throw new t("Unsupported unit: " + temporalUnit);
        }
    }

    public final h Q(long j11) {
        if (j11 == 0) {
            return this;
        }
        long j12 = ((long) this.f28411c) + j11;
        if (j12 > 0) {
            int i11 = (j12 > 28 ? 1 : (j12 == 28 ? 0 : -1));
            short s11 = this.f28410b;
            int i12 = this.f28409a;
            if (i11 <= 0) {
                return new h(i12, s11, (int) j12);
            }
            if (j12 <= 59) {
                long K = (long) K();
                if (j12 <= K) {
                    return new h(i12, s11, (int) j12);
                }
                if (s11 < 12) {
                    return new h(i12, s11 + 1, (int) (j12 - K));
                }
                int i13 = i12 + 1;
                a.YEAR.v((long) i13);
                return new h(i13, 1, (int) (j12 - K));
            }
        }
        return O(j$.lang.a.e(t(), j11));
    }

    public final h R(long j11) {
        if (j11 == 0) {
            return this;
        }
        long j12 = (((long) this.f28409a) * 12) + ((long) (this.f28410b - 1)) + j11;
        long j13 = (long) 12;
        return T(a.YEAR.s(j$.lang.a.b(j12, j13)), ((int) j$.lang.a.f(j12, j13)) + 1, this.f28411c);
    }

    public final h S(long j11) {
        return j11 == 0 ? this : T(a.YEAR.s(((long) this.f28409a) + j11), this.f28410b, this.f28411c);
    }

    /* renamed from: U */
    public final h a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return (h) qVar.k(this, j11);
        }
        a aVar = (a) qVar;
        aVar.v(j11);
        int i11 = g.f28405a[aVar.ordinal()];
        short s11 = this.f28410b;
        short s12 = this.f28411c;
        int i12 = this.f28409a;
        switch (i11) {
            case 1:
                int i13 = (int) j11;
                return s12 == i13 ? this : M(i12, s11, i13);
            case 2:
                return W((int) j11);
            case 3:
                return Q(j$.lang.a.d(j11 - s(a.ALIGNED_WEEK_OF_MONTH), (long) 7));
            case 4:
                if (i12 < 1) {
                    j11 = 1 - j11;
                }
                return X((int) j11);
            case 5:
                return Q(j11 - ((long) F().getValue()));
            case 6:
                return Q(j11 - s(a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return Q(j11 - s(a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return O(j11);
            case 9:
                return Q(j$.lang.a.d(j11 - s(a.ALIGNED_WEEK_OF_YEAR), (long) 7));
            case 10:
                int i14 = (int) j11;
                if (s11 == i14) {
                    return this;
                }
                a.MONTH_OF_YEAR.v((long) i14);
                return T(i12, i14, s12);
            case 11:
                return R(j11 - (((((long) i12) * 12) + ((long) s11)) - 1));
            case 12:
                return X((int) j11);
            case 13:
                return s(a.ERA) == j11 ? this : X(1 - i12);
            default:
                throw new t(c.a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: V */
    public final h g(n nVar) {
        return nVar instanceof h ? (h) nVar : (h) nVar.k(this);
    }

    public final h W(int i11) {
        if (G() == i11) {
            return this;
        }
        a aVar = a.YEAR;
        int i12 = this.f28409a;
        long j11 = (long) i12;
        aVar.v(j11);
        a.DAY_OF_YEAR.v((long) i11);
        boolean A = u.f28321d.A(j11);
        if (i11 != 366 || A) {
            m E = m.E(((i11 - 1) / 31) + 1);
            if (i11 > (E.C(A) + E.B(A)) - 1) {
                E = E.F();
            }
            return new h(i12, E.getValue(), (i11 - E.B(A)) + 1);
        }
        throw new b("Invalid date 'DayOfYear 366' as '" + i12 + "' is not a leap year");
    }

    public final h X(int i11) {
        if (this.f28409a == i11) {
            return this;
        }
        a.YEAR.v((long) i11);
        return T(i11, this.f28410b, this.f28411c);
    }

    /* access modifiers changed from: package-private */
    public final void Y(DataOutput dataOutput) {
        dataOutput.writeInt(this.f28409a);
        dataOutput.writeByte(this.f28410b);
        dataOutput.writeByte(this.f28411c);
    }

    public final boolean c(q qVar) {
        return C0099b.j(this, qVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return B((h) obj) == 0;
        }
        return false;
    }

    public final int f(q qVar) {
        return qVar instanceof a ? E(qVar) : p.a(this, qVar);
    }

    public final j$.time.chrono.n getChronology() {
        return u.f28321d;
    }

    public final j$.time.temporal.u h(q qVar) {
        int i11;
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        a aVar = (a) qVar;
        if (aVar.isDateBased()) {
            int i12 = g.f28405a[aVar.ordinal()];
            if (i12 == 1) {
                i11 = K();
            } else if (i12 == 2) {
                i11 = y();
            } else if (i12 == 3) {
                return j$.time.temporal.u.j(1, (m.E(this.f28410b) != m.FEBRUARY || m()) ? 5 : 4);
            } else if (i12 != 4) {
                return qVar.range();
            } else {
                return j$.time.temporal.u.j(1, this.f28409a <= 0 ? C.NANOS_PER_SECOND : 999999999);
            }
            return j$.time.temporal.u.j(1, (long) i11);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final int hashCode() {
        int i11 = this.f28409a;
        return (((i11 << 11) + (this.f28410b << 6)) + this.f28411c) ^ (i11 & -2048);
    }

    public final l k(l lVar) {
        return C0099b.a(this, lVar);
    }

    public final boolean m() {
        return u.f28321d.A((long) this.f28409a);
    }

    public final long s(q qVar) {
        return qVar instanceof a ? qVar == a.EPOCH_DAY ? t() : qVar == a.PROLEPTIC_MONTH ? ((((long) this.f28409a) * 12) + ((long) this.f28410b)) - 1 : (long) E(qVar) : qVar.h(this);
    }

    public final long t() {
        long j11;
        long j12 = (long) this.f28409a;
        long j13 = (long) this.f28410b;
        long j14 = (365 * j12) + 0;
        if (j12 >= 0) {
            j11 = ((j12 + 399) / 400) + (((3 + j12) / 4) - ((99 + j12) / 100)) + j14;
        } else {
            j11 = j14 - ((j12 / -400) + ((j12 / -4) - (j12 / -100)));
        }
        long j15 = (((367 * j13) - 362) / 12) + j11 + ((long) (this.f28411c - 1));
        if (j13 > 2) {
            j15--;
            if (!m()) {
                j15--;
            }
        }
        return j15 - 719528;
    }

    public final String toString() {
        int i11;
        int i12 = this.f28409a;
        int abs = Math.abs(i12);
        StringBuilder sb2 = new StringBuilder(10);
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
            if (i12 > 9999) {
                sb2.append(SignatureVisitor.EXTENDS);
            }
            sb2.append(i12);
        }
        String str = "-0";
        short s11 = this.f28410b;
        sb2.append(s11 < 10 ? str : SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        sb2.append(s11);
        short s12 = this.f28411c;
        if (s12 >= 10) {
            str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
        }
        sb2.append(str);
        sb2.append(s12);
        return sb2.toString();
    }

    public final C0103f u(k kVar) {
        return LocalDateTime.J(this, kVar);
    }

    public final Object v(s sVar) {
        return sVar == p.f() ? this : C0099b.l(this, sVar);
    }

    public final int y() {
        if (m()) {
            return 366;
        }
        return WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
    }

    /* renamed from: z */
    public final int compareTo(C0100c cVar) {
        return cVar instanceof h ? B((h) cVar) : C0099b.d(this, cVar);
    }
}
