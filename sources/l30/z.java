package l30;

import j$.util.function.Consumer;
import java.util.List;

public final /* synthetic */ class z implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f26513b;

    public /* synthetic */ z(List list) {
        this.f26513b = list;
    }

    public final void accept(Object obj) {
        this.f26513b.add((Class) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
