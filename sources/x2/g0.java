package x2;

import bo.app.g3;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class g0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44422a;

    public /* synthetic */ g0(y0 y0Var) {
        this.f44422a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44422a, (g3) obj);
    }
}
