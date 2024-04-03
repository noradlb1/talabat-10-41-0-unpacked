package j$.time.format;

import j$.time.temporal.s;
import j$.time.x;

class r implements g {

    /* renamed from: a  reason: collision with root package name */
    private final s f28376a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28377b;

    r(s sVar, String str) {
        this.f28376a = sVar;
        this.f28377b = str;
    }

    public boolean f(v vVar, StringBuilder sb2) {
        x xVar = (x) vVar.f(this.f28376a);
        if (xVar == null) {
            return false;
        }
        sb2.append(xVar.e());
        return true;
    }

    public final String toString() {
        return this.f28377b;
    }
}
