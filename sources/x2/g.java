package x2;

import bo.app.g5;
import bo.app.h0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class g implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h0 f44421a;

    public /* synthetic */ g(h0 h0Var) {
        this.f44421a = h0Var;
    }

    public final void trigger(Object obj) {
        h0.a(this.f44421a, (g5) obj);
    }
}
