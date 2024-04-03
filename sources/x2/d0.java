package x2;

import bo.app.r6;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class d0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44416a;

    public /* synthetic */ d0(y0 y0Var) {
        this.f44416a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44416a, (r6) obj);
    }
}
