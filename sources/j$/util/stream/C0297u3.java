package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.stream.u3  reason: case insensitive filesystem */
public final /* synthetic */ class C0297u3 implements C0262n2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29245a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K f29246b;

    public /* synthetic */ C0297u3(K k11, int i11) {
        this.f29245a = i11;
        this.f29246b = k11;
    }

    public final /* synthetic */ void accept(double d11) {
        switch (this.f29245a) {
            case 0:
                C0314y0.d0();
                throw null;
            default:
                C0314y0.d0();
                throw null;
        }
    }

    public final void accept(int i11) {
        int i12 = this.f29245a;
        K k11 = this.f29246b;
        switch (i12) {
            case 0:
                ((U2) k11).accept(i11);
                return;
            default:
                k11.accept(i11);
                return;
        }
    }

    public final /* synthetic */ void accept(long j11) {
        switch (this.f29245a) {
            case 0:
                C0314y0.l0();
                throw null;
            default:
                C0314y0.l0();
                throw null;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f29245a) {
            case 0:
                g((Integer) obj);
                return;
            default:
                g((Integer) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f29245a) {
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

    public final /* synthetic */ void g(Integer num) {
        switch (this.f29245a) {
            case 0:
                C0314y0.g0(this, num);
                return;
            default:
                C0314y0.g0(this, num);
                return;
        }
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final K n(K k11) {
        switch (this.f29245a) {
            case 0:
                Objects.requireNonNull(k11);
                return new H(this, k11);
            default:
                Objects.requireNonNull(k11);
                return new H(this, k11);
        }
    }
}
