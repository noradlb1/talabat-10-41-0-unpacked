package x2;

import bo.app.i6;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class x implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44442a;

    public /* synthetic */ x(y0 y0Var) {
        this.f44442a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44442a, (i6) obj);
    }
}
