package j$.time.temporal;

import j$.time.b;
import j$.time.c;
import java.util.Objects;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    static final s f28467a = new r(0);

    /* renamed from: b  reason: collision with root package name */
    static final s f28468b = new r(1);

    /* renamed from: c  reason: collision with root package name */
    static final s f28469c = new r(2);

    /* renamed from: d  reason: collision with root package name */
    static final s f28470d = new r(3);

    /* renamed from: e  reason: collision with root package name */
    static final s f28471e = new r(4);

    /* renamed from: f  reason: collision with root package name */
    static final s f28472f = new r(5);

    /* renamed from: g  reason: collision with root package name */
    static final s f28473g = new r(6);

    public static int a(m mVar, q qVar) {
        u h11 = mVar.h(qVar);
        if (h11.h()) {
            long s11 = mVar.s(qVar);
            if (h11.i(s11)) {
                return (int) s11;
            }
            throw new b("Invalid value for " + qVar + " (valid values " + h11 + "): " + s11);
        }
        throw new t("Invalid field " + qVar + " for get() method, use getLong() instead");
    }

    public static l b(l lVar, long j11, ChronoUnit chronoUnit) {
        long j12;
        if (j11 == Long.MIN_VALUE) {
            lVar = lVar.b(Long.MAX_VALUE, chronoUnit);
            j12 = 1;
        } else {
            j12 = -j11;
        }
        return lVar.b(j12, chronoUnit);
    }

    public static Object c(m mVar, s sVar) {
        if (sVar == f28467a || sVar == f28468b || sVar == f28469c) {
            return null;
        }
        return sVar.a(mVar);
    }

    public static u d(m mVar, q qVar) {
        if (!(qVar instanceof a)) {
            Objects.requireNonNull(qVar, "field");
            return qVar.g(mVar);
        } else if (mVar.c(qVar)) {
            return qVar.range();
        } else {
            throw new t(c.a("Unsupported field: ", qVar));
        }
    }

    public static s e() {
        return f28468b;
    }

    public static s f() {
        return f28472f;
    }

    public static s g() {
        return f28473g;
    }

    public static s h() {
        return f28470d;
    }

    public static s i() {
        return f28469c;
    }

    public static s j() {
        return f28471e;
    }

    public static s k() {
        return f28467a;
    }
}
