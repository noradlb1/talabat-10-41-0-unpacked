package j$.time.format;

import j$.time.chrono.C0099b;
import j$.time.chrono.C0100c;
import j$.time.h;
import j$.time.temporal.q;
import java.util.Objects;

final class n extends k {

    /* renamed from: i  reason: collision with root package name */
    static final h f28366i = h.M(2000, 1, 1);

    /* renamed from: g  reason: collision with root package name */
    private final int f28367g;

    /* renamed from: h  reason: collision with root package name */
    private final C0100c f28368h;

    private n(q qVar, int i11, int i12, int i13, C0100c cVar, int i14) {
        super(qVar, i11, i12, A.NOT_NEGATIVE, i14);
        this.f28367g = i13;
        this.f28368h = cVar;
    }

    n(q qVar, h hVar) {
        this(qVar, 2, 2, 0, hVar, 0);
    }

    /* synthetic */ n(q qVar, h hVar, int i11) {
        this(qVar, 2, 2, 0, hVar, i11);
    }

    /* access modifiers changed from: package-private */
    public final long b(v vVar, long j11) {
        long abs = Math.abs(j11);
        C0100c cVar = this.f28368h;
        long f11 = (long) (cVar != null ? C0099b.r(vVar.d()).q(cVar).f(this.f28353a) : this.f28367g);
        int i11 = (j11 > f11 ? 1 : (j11 == f11 ? 0 : -1));
        long[] jArr = k.f28352f;
        if (i11 >= 0) {
            long j12 = jArr[this.f28354b];
            if (j11 < f11 + j12) {
                return abs % j12;
            }
        }
        return abs % jArr[this.f28355c];
    }

    /* access modifiers changed from: package-private */
    public final k c() {
        return this.f28357e == -1 ? this : new n(this.f28353a, this.f28354b, this.f28355c, this.f28367g, this.f28368h, -1);
    }

    /* access modifiers changed from: package-private */
    public final k d(int i11) {
        return new n(this.f28353a, this.f28354b, this.f28355c, this.f28367g, this.f28368h, this.f28357e + i11);
    }

    public final String toString() {
        Object valueOf = Integer.valueOf(this.f28367g);
        Object obj = this.f28368h;
        if (obj != null) {
            valueOf = obj;
        } else {
            Objects.requireNonNull(valueOf, "defaultObj");
        }
        return "ReducedValue(" + this.f28353a + "," + this.f28354b + "," + this.f28355c + "," + valueOf + ")";
    }
}
