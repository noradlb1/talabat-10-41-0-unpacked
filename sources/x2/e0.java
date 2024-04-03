package x2;

import bo.app.q1;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class e0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44418a;

    public /* synthetic */ e0(y0 y0Var) {
        this.f44418a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44418a, (q1) obj);
    }
}
