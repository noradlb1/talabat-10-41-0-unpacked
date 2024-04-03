package j$.time.format;

import j$.time.chrono.n;
import j$.time.chrono.u;
import j$.time.temporal.q;

final class p implements g {

    /* renamed from: a  reason: collision with root package name */
    private final q f28370a;

    /* renamed from: b  reason: collision with root package name */
    private final B f28371b;

    /* renamed from: c  reason: collision with root package name */
    private final x f28372c;

    /* renamed from: d  reason: collision with root package name */
    private volatile k f28373d;

    p(q qVar, B b11, x xVar) {
        this.f28370a = qVar;
        this.f28371b = b11;
        this.f28372c = xVar;
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        Long e11 = vVar.e(this.f28370a);
        if (e11 == null) {
            return false;
        }
        n nVar = (n) vVar.d().v(j$.time.temporal.p.e());
        String e12 = (nVar == null || nVar == u.f28321d) ? this.f28372c.e(this.f28370a, e11.longValue(), this.f28371b, vVar.c()) : this.f28372c.d(nVar, this.f28370a, e11.longValue(), this.f28371b, vVar.c());
        if (e12 == null) {
            if (this.f28373d == null) {
                this.f28373d = new k(this.f28370a, 1, 19, A.NORMAL);
            }
            return this.f28373d.f(vVar, sb2);
        }
        sb2.append(e12);
        return true;
    }

    public final String toString() {
        B b11 = B.FULL;
        q qVar = this.f28370a;
        B b12 = this.f28371b;
        if (b12 == b11) {
            return "Text(" + qVar + ")";
        }
        return "Text(" + qVar + "," + b12 + ")";
    }
}
