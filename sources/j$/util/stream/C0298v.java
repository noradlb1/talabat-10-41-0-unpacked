package j$.util.stream;

import j$.util.function.B;
import j$.util.function.C0165m;
import j$.util.function.C0171p;
import j$.util.function.C0173q;
import j$.util.function.C0174s;
import j$.util.function.C0175t;
import j$.util.function.C0177v;
import j$.util.function.C0178w;
import j$.util.function.C0180y;
import j$.util.function.C0181z;

/* renamed from: j$.util.stream.v  reason: case insensitive filesystem */
final class C0298v extends C0237i2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29247b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0204c f29248c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0298v(C0204c cVar, C0272p2 p2Var, int i11) {
        super(p2Var);
        this.f29247b = i11;
        this.f29248c = cVar;
    }

    public final void accept(double d11) {
        int i11 = this.f29247b;
        C0272p2 p2Var = this.f29160a;
        C0204c cVar = this.f29248c;
        switch (i11) {
            case 0:
                p2Var.accept(((C0171p) ((C0303w) cVar).f29255u).apply(d11));
                return;
            case 1:
                p2Var.accept(((C0181z) ((B) ((C0308x) cVar).f29266u)).b(d11));
                return;
            case 2:
                p2Var.accept(((C0175t) ((C0177v) ((C0313y) cVar).f29273u)).a(d11));
                return;
            case 3:
                p2Var.accept(((C0178w) ((C0180y) ((C0317z) cVar).f29286u)).a(d11));
                return;
            case 4:
                if (((C0173q) ((C0174s) ((C0308x) cVar).f29266u)).e(d11)) {
                    p2Var.accept(d11);
                    return;
                }
                return;
            default:
                ((C0165m) ((C0308x) cVar).f29266u).accept(d11);
                p2Var.accept(d11);
                return;
        }
    }

    public final void f(long j11) {
        int i11 = this.f29247b;
        C0272p2 p2Var = this.f29160a;
        switch (i11) {
            case 4:
                p2Var.f(-1);
                return;
            default:
                p2Var.f(j11);
                return;
        }
    }
}
