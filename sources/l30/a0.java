package l30;

import j$.util.function.Consumer;
import java.net.URI;
import java.util.Set;

public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f26459b;

    public /* synthetic */ a0(Set set) {
        this.f26459b = set;
    }

    public final void accept(Object obj) {
        this.f26459b.add((URI) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
