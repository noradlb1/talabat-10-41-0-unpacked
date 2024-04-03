package x2;

import bo.app.f1;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class i0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44426a;

    public /* synthetic */ i0(y0 y0Var) {
        this.f44426a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44426a, (f1) obj);
    }
}
