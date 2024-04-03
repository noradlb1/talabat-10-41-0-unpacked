package z20;

import j$.util.function.Consumer;
import java.util.List;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f58047b;

    public /* synthetic */ k(List list) {
        this.f58047b = list;
    }

    public final void accept(Object obj) {
        this.f58047b.removeAll((List) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
