package x2;

import bo.app.h0;
import bo.app.u4;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class f implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h0 f44419a;

    public /* synthetic */ f(h0 h0Var) {
        this.f44419a = h0Var;
    }

    public final void trigger(Object obj) {
        h0.a(this.f44419a, (u4) obj);
    }
}
