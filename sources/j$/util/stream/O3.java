package j$.util.stream;

import j$.util.function.Consumer;

public final /* synthetic */ class O3 implements C0272p2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29004a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f29005b;

    public /* synthetic */ O3(Consumer consumer, int i11) {
        this.f29004a = i11;
        this.f29005b = consumer;
    }

    public final /* synthetic */ void accept(double d11) {
        switch (this.f29004a) {
            case 0:
                C0314y0.d0();
                throw null;
            default:
                C0314y0.d0();
                throw null;
        }
    }

    public final /* synthetic */ void accept(int i11) {
        switch (this.f29004a) {
            case 0:
                C0314y0.k0();
                throw null;
            default:
                C0314y0.k0();
                throw null;
        }
    }

    public final /* synthetic */ void accept(long j11) {
        switch (this.f29004a) {
            case 0:
                C0314y0.l0();
                throw null;
            default:
                C0314y0.l0();
                throw null;
        }
    }

    public final void accept(Object obj) {
        int i11 = this.f29004a;
        Consumer consumer = this.f29005b;
        switch (i11) {
            case 0:
                ((Z2) consumer).accept(obj);
                return;
            default:
                consumer.accept(obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f29004a) {
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
}
