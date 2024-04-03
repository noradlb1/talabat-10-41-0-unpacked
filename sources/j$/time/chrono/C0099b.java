package j$.time.chrono;

import j$.time.ZoneOffset;
import j$.time.c;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import java.util.Objects;

/* renamed from: j$.time.chrono.b  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0099b {
    public static l a(C0100c cVar, l lVar) {
        return lVar.a(cVar.t(), a.EPOCH_DAY);
    }

    public static l b(C0103f fVar, l lVar) {
        return lVar.a(fVar.toLocalDate().t(), a.EPOCH_DAY).a(fVar.toLocalTime().R(), a.NANO_OF_DAY);
    }

    public static l c(o oVar, l lVar) {
        return lVar.a((long) oVar.getValue(), a.ERA);
    }

    public static int d(C0100c cVar, C0100c cVar2) {
        int a11 = j$.lang.a.a(cVar.t(), cVar2.t());
        if (a11 != 0) {
            return a11;
        }
        return ((C0098a) cVar.getChronology()).compareTo(cVar2.getChronology());
    }

    public static int e(C0103f fVar, C0103f fVar2) {
        int z11 = fVar.toLocalDate().z(fVar2.toLocalDate());
        if (z11 != 0) {
            return z11;
        }
        int B = fVar.toLocalTime().compareTo(fVar2.toLocalTime());
        if (B != 0) {
            return B;
        }
        return ((C0098a) fVar.getChronology()).compareTo(fVar2.getChronology());
    }

    public static int f(C0108k kVar, C0108k kVar2) {
        int a11 = j$.lang.a.a(kVar.toEpochSecond(), kVar2.toEpochSecond());
        if (a11 != 0) {
            return a11;
        }
        int G = kVar.toLocalTime().G() - kVar2.toLocalTime().G();
        if (G != 0) {
            return G;
        }
        int w11 = kVar.toLocalDateTime().w(kVar2.toLocalDateTime());
        if (w11 != 0) {
            return w11;
        }
        int compareTo = kVar.getZone().e().compareTo(kVar2.getZone().e());
        if (compareTo != 0) {
            return compareTo;
        }
        return ((C0098a) kVar.getChronology()).compareTo(kVar2.getChronology());
    }

    public static int g(C0108k kVar, q qVar) {
        if (!(qVar instanceof a)) {
            return p.a(kVar, qVar);
        }
        int i11 = C0107j.f28297a[((a) qVar).ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? kVar.toLocalDateTime().f(qVar) : kVar.getOffset().I();
        }
        throw new t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public static int h(o oVar, a aVar) {
        return aVar == a.ERA ? oVar.getValue() : p.a(oVar, aVar);
    }

    public static long i(o oVar, q qVar) {
        if (qVar == a.ERA) {
            return (long) oVar.getValue();
        }
        if (!(qVar instanceof a)) {
            return qVar.h(oVar);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public static boolean j(C0100c cVar, q qVar) {
        return qVar instanceof a ? qVar.isDateBased() : qVar != null && qVar.f(cVar);
    }

    public static boolean k(o oVar, q qVar) {
        return qVar instanceof a ? qVar == a.ERA : qVar != null && qVar.f(oVar);
    }

    public static Object l(C0100c cVar, s sVar) {
        if (sVar == p.k() || sVar == p.j() || sVar == p.h() || sVar == p.g()) {
            return null;
        }
        return sVar == p.e() ? cVar.getChronology() : sVar == p.i() ? ChronoUnit.DAYS : sVar.a(cVar);
    }

    public static Object m(C0103f fVar, s sVar) {
        if (sVar == p.k() || sVar == p.j() || sVar == p.h()) {
            return null;
        }
        return sVar == p.g() ? fVar.toLocalTime() : sVar == p.e() ? fVar.getChronology() : sVar == p.i() ? ChronoUnit.NANOS : sVar.a(fVar);
    }

    public static Object n(C0108k kVar, s sVar) {
        return (sVar == p.j() || sVar == p.k()) ? kVar.getZone() : sVar == p.h() ? kVar.getOffset() : sVar == p.g() ? kVar.toLocalTime() : sVar == p.e() ? kVar.getChronology() : sVar == p.i() ? ChronoUnit.NANOS : sVar.a(kVar);
    }

    public static Object o(o oVar, s sVar) {
        return sVar == p.i() ? ChronoUnit.ERAS : p.c(oVar, sVar);
    }

    public static long p(C0103f fVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return ((fVar.toLocalDate().t() * 86400) + ((long) fVar.toLocalTime().S())) - ((long) zoneOffset.I());
    }

    public static long q(C0108k kVar) {
        return ((kVar.toLocalDate().t() * 86400) + ((long) kVar.toLocalTime().S())) - ((long) kVar.getOffset().I());
    }

    public static n r(m mVar) {
        Objects.requireNonNull(mVar, "temporal");
        n nVar = (n) mVar.v(p.e());
        u uVar = u.f28321d;
        if (nVar != null) {
            return nVar;
        }
        Objects.requireNonNull(uVar, "defaultObj");
        return uVar;
    }
}
