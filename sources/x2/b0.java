package x2;

import bo.app.d5;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class b0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44412a;

    public /* synthetic */ b0(y0 y0Var) {
        this.f44412a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44412a, (d5) obj);
    }
}
