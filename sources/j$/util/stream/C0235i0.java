package j$.util.stream;

import j$.util.function.C0152f0;
import j$.util.function.C0158i0;
import j$.util.function.C0160j0;
import j$.util.function.C0164l0;
import j$.util.function.C0166m0;
import j$.util.function.C0170o0;
import j$.util.function.C0172p0;
import j$.util.function.r0;
import j$.util.function.s0;
import j$.util.function.u0;

/* renamed from: j$.util.stream.i0  reason: case insensitive filesystem */
final class C0235i0 extends C0247k2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29158b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0204c f29159c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0235i0(C0204c cVar, C0272p2 p2Var, int i11) {
        super(p2Var);
        this.f29158b = i11;
        this.f29159c = cVar;
    }

    public final void accept(long j11) {
        int i11 = this.f29158b;
        C0204c cVar = this.f29159c;
        C0272p2 p2Var = this.f29169a;
        switch (i11) {
            case 0:
                p2Var.accept(((C0158i0) ((C0303w) cVar).f29255u).apply(j11));
                return;
            case 1:
                p2Var.accept((double) j11);
                return;
            case 2:
                p2Var.accept(((s0) ((u0) ((C0317z) cVar).f29286u)).b(j11));
                return;
            case 3:
                p2Var.accept(((C0172p0) ((r0) ((C0313y) cVar).f29273u)).a(j11));
                return;
            case 4:
                p2Var.accept(((C0166m0) ((C0170o0) ((C0308x) cVar).f29266u)).a(j11));
                return;
            case 5:
                if (((C0160j0) ((C0164l0) ((C0317z) cVar).f29286u)).e(j11)) {
                    p2Var.accept(j11);
                    return;
                }
                return;
            default:
                ((C0152f0) ((C0317z) cVar).f29286u).accept(j11);
                p2Var.accept(j11);
                return;
        }
    }

    public final void f(long j11) {
        int i11 = this.f29158b;
        C0272p2 p2Var = this.f29169a;
        switch (i11) {
            case 5:
                p2Var.f(-1);
                return;
            default:
                p2Var.f(j11);
                return;
        }
    }
}
