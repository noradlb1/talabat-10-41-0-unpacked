package j$.util.stream;

import j$.util.function.Consumer;

final class T extends U {

    /* renamed from: b  reason: collision with root package name */
    final Consumer f29038b;

    T(Consumer consumer, boolean z11) {
        super(z11);
        this.f29038b = consumer;
    }

    public final void accept(Object obj) {
        this.f29038b.accept(obj);
    }
}
