package j$.time.chrono;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapperKt;
import j$.time.c;
import j$.time.h;
import j$.time.k;
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
import java.io.Serializable;

/* renamed from: j$.time.chrono.e  reason: case insensitive filesystem */
abstract class C0102e implements C0100c, l, n, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    C0102e() {
    }

    static C0100c B(n nVar, l lVar) {
        C0100c cVar = (C0100c) lVar;
        C0098a aVar = (C0098a) nVar;
        if (aVar.equals(cVar.getChronology())) {
            return cVar;
        }
        String e11 = aVar.e();
        String e12 = cVar.getChronology().e();
        throw new ClassCastException("Chronology mismatch, expected: " + e11 + ", actual: " + e12);
    }

    public o C() {
        return getChronology().o(f(a.ERA));
    }

    /* access modifiers changed from: package-private */
    public abstract C0100c D(long j11);

    /* access modifiers changed from: package-private */
    public abstract C0100c E(long j11);

    /* access modifiers changed from: package-private */
    public abstract C0100c F(long j11);

    /* renamed from: G */
    public C0100c g(h hVar) {
        return B(getChronology(), C0099b.a(hVar, this));
    }

    public C0100c a(long j11, q qVar) {
        if (!(qVar instanceof a)) {
            return B(getChronology(), qVar.k(this, j11));
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public C0100c b(long j11, TemporalUnit temporalUnit) {
        boolean z11 = temporalUnit instanceof ChronoUnit;
        if (z11) {
            switch (C0101d.f28288a[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return D(j11);
                case 2:
                    return D(j$.lang.a.d(j11, (long) 7));
                case 3:
                    return E(j11);
                case 4:
                    return F(j11);
                case 5:
                    return F(j$.lang.a.d(j11, (long) 10));
                case 6:
                    return F(j$.lang.a.d(j11, (long) 100));
                case 7:
                    return F(j$.lang.a.d(j11, (long) 1000));
                case 8:
                    a aVar = a.ERA;
                    return a(j$.lang.a.e(s(aVar), j11), (q) aVar);
                default:
                    throw new t("Unsupported unit: " + temporalUnit);
            }
        } else if (!z11) {
            return B(getChronology(), temporalUnit.f(this, j11));
        } else {
            throw new t("Unsupported unit: " + temporalUnit);
        }
    }

    public /* synthetic */ boolean c(q qVar) {
        return C0099b.j(this, qVar);
    }

    public C0100c d(long j11, ChronoUnit chronoUnit) {
        return B(getChronology(), p.b(this, j11, chronoUnit));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0100c) {
            return C0099b.d(this, (C0100c) obj) == 0;
        }
        return false;
    }

    public final /* synthetic */ int f(q qVar) {
        return p.a(this, qVar);
    }

    public /* synthetic */ u h(q qVar) {
        return p.d(this, qVar);
    }

    public int hashCode() {
        long t11 = t();
        return ((int) (t11 ^ (t11 >>> 32))) ^ ((C0098a) getChronology()).hashCode();
    }

    public final /* synthetic */ l k(l lVar) {
        return C0099b.a(this, lVar);
    }

    public boolean m() {
        return getChronology().A(s(a.YEAR));
    }

    public long t() {
        return s(a.EPOCH_DAY);
    }

    public String toString() {
        long s11 = s(a.YEAR_OF_ERA);
        long s12 = s(a.MONTH_OF_YEAR);
        long s13 = s(a.DAY_OF_MONTH);
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(((C0098a) getChronology()).e());
        sb2.append(" ");
        sb2.append(C());
        sb2.append(" ");
        sb2.append(s11);
        String str = "-0";
        sb2.append(s12 < 10 ? str : SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        sb2.append(s12);
        if (s13 >= 10) {
            str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
        }
        sb2.append(str);
        sb2.append(s13);
        return sb2.toString();
    }

    public C0103f u(k kVar) {
        return C0105h.D(this, kVar);
    }

    public final /* synthetic */ Object v(s sVar) {
        return C0099b.l(this, sVar);
    }

    public int y() {
        if (m()) {
            return 366;
        }
        return WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
    }

    /* renamed from: z */
    public final /* synthetic */ int compareTo(C0100c cVar) {
        return C0099b.d(this, cVar);
    }
}
