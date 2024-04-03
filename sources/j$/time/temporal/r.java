package j$.time.temporal;

import j$.time.ZoneOffset;
import j$.time.chrono.n;
import j$.time.h;
import j$.time.k;
import j$.time.x;

final class r implements s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28474a;

    public /* synthetic */ r(int i11) {
        this.f28474a = i11;
    }

    public final Object a(m mVar) {
        switch (this.f28474a) {
            case 0:
                return b(mVar);
            case 1:
                return (n) mVar.v(p.f28468b);
            case 2:
                return (TemporalUnit) mVar.v(p.f28469c);
            case 3:
                a aVar = a.OFFSET_SECONDS;
                if (mVar.c(aVar)) {
                    return ZoneOffset.L(mVar.f(aVar));
                }
                return null;
            case 4:
                return b(mVar);
            case 5:
                a aVar2 = a.EPOCH_DAY;
                if (mVar.c(aVar2)) {
                    return h.O(mVar.s(aVar2));
                }
                return null;
            default:
                a aVar3 = a.NANO_OF_DAY;
                if (mVar.c(aVar3)) {
                    return k.J(mVar.s(aVar3));
                }
                return null;
        }
    }

    public final x b(m mVar) {
        s sVar = p.f28467a;
        switch (this.f28474a) {
            case 0:
                return (x) mVar.v(sVar);
            default:
                x xVar = (x) mVar.v(sVar);
                return xVar != null ? xVar : (x) mVar.v(p.f28470d);
        }
    }

    public final String toString() {
        switch (this.f28474a) {
            case 0:
                return "ZoneId";
            case 1:
                return "Chronology";
            case 2:
                return "Precision";
            case 3:
                return "ZoneOffset";
            case 4:
                return "Zone";
            case 5:
                return "LocalDate";
            default:
                return "LocalTime";
        }
    }
}
