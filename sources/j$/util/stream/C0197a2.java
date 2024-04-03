package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;

/* renamed from: j$.util.stream.a2  reason: case insensitive filesystem */
final class C0197a2 extends C0252l2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29080b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0204c f29081c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0197a2(C0204c cVar, C0272p2 p2Var, int i11) {
        super(p2Var);
        this.f29080b = i11;
        this.f29081c = cVar;
    }

    public final void accept(Object obj) {
        int i11 = this.f29080b;
        C0272p2 p2Var = this.f29177a;
        C0204c cVar = this.f29081c;
        switch (i11) {
            case 0:
                ((Consumer) ((C0303w) cVar).f29255u).accept(obj);
                p2Var.accept(obj);
                return;
            case 1:
                if (((Predicate) ((C0303w) cVar).f29255u).test(obj)) {
                    p2Var.accept(obj);
                    return;
                }
                return;
            case 2:
                p2Var.accept(((C0207c2) cVar).f29101u.apply(obj));
                return;
            case 3:
                p2Var.accept(((ToIntFunction) ((C0313y) cVar).f29273u).applyAsInt(obj));
                return;
            case 4:
                p2Var.accept(((ToLongFunction) ((C0317z) cVar).f29286u).applyAsLong(obj));
                return;
            default:
                p2Var.accept(((ToDoubleFunction) ((C0308x) cVar).f29266u).applyAsDouble(obj));
                return;
        }
    }

    public final void f(long j11) {
        int i11 = this.f29080b;
        C0272p2 p2Var = this.f29177a;
        switch (i11) {
            case 1:
                p2Var.f(-1);
                return;
            default:
                p2Var.f(j11);
                return;
        }
    }
}
