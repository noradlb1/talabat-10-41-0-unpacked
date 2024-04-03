package j$.time.temporal;

import j$.time.chrono.C0098a;
import j$.time.chrono.C0099b;
import j$.time.chrono.u;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final q f28454a = g.QUARTER_OF_YEAR;

    /* renamed from: b  reason: collision with root package name */
    public static final q f28455b = g.WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: c  reason: collision with root package name */
    public static final q f28456c = g.WEEK_BASED_YEAR;

    /* renamed from: d  reason: collision with root package name */
    public static final TemporalUnit f28457d = h.WEEK_BASED_YEARS;

    static {
        g gVar = g.DAY_OF_QUARTER;
        h hVar = h.WEEK_BASED_YEARS;
    }

    static boolean a(m mVar) {
        return ((C0098a) C0099b.r(mVar)).equals(u.f28321d);
    }
}
