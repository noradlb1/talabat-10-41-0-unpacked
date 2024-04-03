package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.k3  reason: case insensitive filesystem */
final class C0248k3 extends C0253l3 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    final Object[] f29170b;

    C0248k3(int i11) {
        this.f29170b = new Object[i11];
    }

    public final void accept(Object obj) {
        int i11 = this.f29178a;
        this.f29178a = i11 + 1;
        this.f29170b[i11] = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
