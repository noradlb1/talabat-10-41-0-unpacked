package x2;

import bo.app.w;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class k0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44429a;

    public /* synthetic */ k0(y0 y0Var) {
        this.f44429a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44429a, (w) obj);
    }
}
