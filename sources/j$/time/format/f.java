package j$.time.format;

import java.util.ArrayList;

final class f implements g {

    /* renamed from: a  reason: collision with root package name */
    private final g[] f28347a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f28348b;

    f(ArrayList arrayList, boolean z11) {
        this((g[]) arrayList.toArray(new g[arrayList.size()]), z11);
    }

    f(g[] gVarArr, boolean z11) {
        this.f28347a = gVarArr;
        this.f28348b = z11;
    }

    public final f a() {
        return !this.f28348b ? this : new f(this.f28347a, false);
    }

    public final boolean f(v vVar, StringBuilder sb2) {
        int length = sb2.length();
        boolean z11 = this.f28348b;
        if (z11) {
            vVar.g();
        }
        try {
            for (g f11 : this.f28347a) {
                if (!f11.f(vVar, sb2)) {
                    sb2.setLength(length);
                    return true;
                }
            }
            if (z11) {
                vVar.a();
            }
            return true;
        } finally {
            if (z11) {
                vVar.a();
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        g[] gVarArr = this.f28347a;
        if (gVarArr != null) {
            boolean z11 = this.f28348b;
            sb2.append(z11 ? "[" : "(");
            for (g append : gVarArr) {
                sb2.append(append);
            }
            sb2.append(z11 ? "]" : ")");
        }
        return sb2.toString();
    }
}
