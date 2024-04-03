package x2;

import bo.app.i5;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class n0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44434a;

    public /* synthetic */ n0(y0 y0Var) {
        this.f44434a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44434a, (i5) obj);
    }
}
