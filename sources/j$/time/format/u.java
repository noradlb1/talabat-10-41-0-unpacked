package j$.time.format;

import j$.time.chrono.C0100c;
import j$.time.chrono.n;
import j$.time.temporal.m;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.x;

final class u implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0100c f28391a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f28392b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ n f28393c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ x f28394d;

    u(C0100c cVar, m mVar, n nVar, x xVar) {
        this.f28391a = cVar;
        this.f28392b = mVar;
        this.f28393c = nVar;
        this.f28394d = xVar;
    }

    public final boolean c(q qVar) {
        C0100c cVar = this.f28391a;
        return (cVar == null || !qVar.isDateBased()) ? this.f28392b.c(qVar) : cVar.c(qVar);
    }

    public final /* synthetic */ int f(q qVar) {
        return p.a(this, qVar);
    }

    public final j$.time.temporal.u h(q qVar) {
        C0100c cVar = this.f28391a;
        return (cVar == null || !qVar.isDateBased()) ? this.f28392b.h(qVar) : cVar.h(qVar);
    }

    public final long s(q qVar) {
        C0100c cVar = this.f28391a;
        return (cVar == null || !qVar.isDateBased()) ? this.f28392b.s(qVar) : cVar.s(qVar);
    }

    public final String toString() {
        String str;
        String str2 = "";
        n nVar = this.f28393c;
        if (nVar != null) {
            str = " with chronology " + nVar;
        } else {
            str = str2;
        }
        x xVar = this.f28394d;
        if (xVar != null) {
            str2 = " with zone " + xVar;
        }
        return this.f28392b + str + str2;
    }

    public final Object v(s sVar) {
        return sVar == p.e() ? this.f28393c : sVar == p.k() ? this.f28394d : sVar == p.i() ? this.f28392b.v(sVar) : sVar.a(this);
    }
}
