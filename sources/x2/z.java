package x2;

import bo.app.x;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class z implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44445a;

    public /* synthetic */ z(y0 y0Var) {
        this.f44445a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44445a, (x) obj);
    }
}
