package x2;

import bo.app.p0;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class j0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44428a;

    public /* synthetic */ j0(y0 y0Var) {
        this.f44428a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44428a, (p0) obj);
    }
}
