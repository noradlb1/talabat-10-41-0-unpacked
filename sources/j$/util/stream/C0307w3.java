package j$.util.stream;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.w3  reason: case insensitive filesystem */
public final /* synthetic */ class C0307w3 implements C0267o2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29263a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0152f0 f29264b;

    public /* synthetic */ C0307w3(C0152f0 f0Var, int i11) {
        this.f29263a = i11;
        this.f29264b = f0Var;
    }

    public final /* synthetic */ void accept(double d11) {
        switch (this.f29263a) {
            case 0:
                C0314y0.d0();
                throw null;
            default:
                C0314y0.d0();
                throw null;
        }
    }

    public final /* synthetic */ void accept(int i11) {
        switch (this.f29263a) {
            case 0:
                C0314y0.k0();
                throw null;
            default:
                C0314y0.k0();
                throw null;
        }
    }

    public final void accept(long j11) {
        int i11 = this.f29263a;
        C0152f0 f0Var = this.f29264b;
        switch (i11) {
            case 0:
                ((W2) f0Var).accept(j11);
                return;
            default:
                f0Var.accept(j11);
                return;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f29263a) {
            case 0:
                l((Long) obj);
                return;
            default:
                l((Long) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f29263a) {
            case 0:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ void end() {
    }

    public final /* synthetic */ void f(long j11) {
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final C0152f0 i(C0152f0 f0Var) {
        switch (this.f29263a) {
            case 0:
                Objects.requireNonNull(f0Var);
                return new C0146c0(this, f0Var);
            default:
                Objects.requireNonNull(f0Var);
                return new C0146c0(this, f0Var);
        }
    }

    public final /* synthetic */ void l(Long l11) {
        switch (this.f29263a) {
            case 0:
                C0314y0.i0(this, l11);
                return;
            default:
                C0314y0.i0(this, l11);
                return;
        }
    }
}
