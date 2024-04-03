package x2;

import bo.app.p6;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class c0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44414a;

    public /* synthetic */ c0(y0 y0Var) {
        this.f44414a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44414a, (p6) obj);
    }
}
