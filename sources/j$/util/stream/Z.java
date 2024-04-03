package j$.util.stream;

import j$.util.function.IntFunction;
import j$.util.function.IntPredicate;
import j$.util.function.K;
import j$.util.function.P;
import j$.util.function.S;
import j$.util.function.T;
import j$.util.function.V;
import j$.util.function.W;
import j$.util.function.Y;

final class Z extends C0242j2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29072b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0204c f29073c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z(C0204c cVar, C0272p2 p2Var, int i11) {
        super(p2Var);
        this.f29072b = i11;
        this.f29073c = cVar;
    }

    public final void accept(int i11) {
        int i12 = this.f29072b;
        C0204c cVar = this.f29073c;
        C0272p2 p2Var = this.f29166a;
        switch (i12) {
            case 0:
                p2Var.accept(((IntFunction) ((C0303w) cVar).f29255u).apply(i11));
                return;
            case 1:
                ((K) ((C0313y) cVar).f29273u).accept(i11);
                p2Var.accept(i11);
                return;
            case 2:
                p2Var.accept((long) i11);
                return;
            case 3:
                p2Var.accept((double) i11);
                return;
            case 4:
                p2Var.accept(((W) ((Y) ((C0313y) cVar).f29273u)).b(i11));
                return;
            case 5:
                p2Var.accept(((T) ((V) ((C0317z) cVar).f29286u)).a(i11));
                return;
            case 6:
                p2Var.accept(((P) ((S) ((C0308x) cVar).f29266u)).a(i11));
                return;
            default:
                if (((IntPredicate) ((C0313y) cVar).f29273u).test(i11)) {
                    p2Var.accept(i11);
                    return;
                }
                return;
        }
    }

    public final void f(long j11) {
        int i11 = this.f29072b;
        C0272p2 p2Var = this.f29166a;
        switch (i11) {
            case 7:
                p2Var.f(-1);
                return;
            default:
                p2Var.f(j11);
                return;
        }
    }
}
