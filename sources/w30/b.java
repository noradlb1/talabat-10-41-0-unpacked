package w30;

import j$.util.function.Consumer;
import java.util.Set;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f63584b;

    public /* synthetic */ b(Set set) {
        this.f63584b = set;
    }

    public final void accept(Object obj) {
        this.f63584b.add((Class) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
