package x2;

import android.location.Location;
import bo.app.o;
import j$.util.function.Consumer;

public final /* synthetic */ class n implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f44433b;

    public /* synthetic */ n(o oVar) {
        this.f44433b = oVar;
    }

    public final void accept(Object obj) {
        o.a(this.f44433b, (Location) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
