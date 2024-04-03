package x2;

import bo.app.g6;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class f0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44420a;

    public /* synthetic */ f0(y0 y0Var) {
        this.f44420a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44420a, (g6) obj);
    }
}
