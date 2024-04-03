package j$.util.stream;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.s3  reason: case insensitive filesystem */
public final /* synthetic */ class C0287s3 implements C0257m2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29224a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0165m f29225b;

    public /* synthetic */ C0287s3(C0165m mVar, int i11) {
        this.f29224a = i11;
        this.f29225b = mVar;
    }

    public final void accept(double d11) {
        int i11 = this.f29224a;
        C0165m mVar = this.f29225b;
        switch (i11) {
            case 0:
                ((S2) mVar).accept(d11);
                return;
            default:
                mVar.accept(d11);
                return;
        }
    }

    public final /* synthetic */ void accept(int i11) {
        switch (this.f29224a) {
            case 0:
                C0314y0.k0();
                throw null;
            default:
                C0314y0.k0();
                throw null;
        }
    }

    public final /* synthetic */ void accept(long j11) {
        switch (this.f29224a) {
            case 0:
                C0314y0.l0();
                throw null;
            default:
                C0314y0.l0();
                throw null;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f29224a) {
            case 0:
                p((Double) obj);
                return;
            default:
                p((Double) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f29224a) {
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

    public final C0165m m(C0165m mVar) {
        switch (this.f29224a) {
            case 0:
                Objects.requireNonNull(mVar);
                return new C0159j(this, mVar);
            default:
                Objects.requireNonNull(mVar);
                return new C0159j(this, mVar);
        }
    }

    public final /* synthetic */ void p(Double d11) {
        switch (this.f29224a) {
            case 0:
                C0314y0.e0(this, d11);
                return;
            default:
                C0314y0.e0(this, d11);
                return;
        }
    }
}
