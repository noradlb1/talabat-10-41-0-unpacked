package i1;

import android.location.Location;
import j$.util.function.Consumer;

public final /* synthetic */ class j0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ androidx.core.util.Consumer f11595b;

    public /* synthetic */ j0(androidx.core.util.Consumer consumer) {
        this.f11595b = consumer;
    }

    public final void accept(Object obj) {
        this.f11595b.accept((Location) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
