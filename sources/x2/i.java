package x2;

import bo.app.f6;
import bo.app.k6;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class i implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k6 f44425a;

    public /* synthetic */ i(k6 k6Var) {
        this.f44425a = k6Var;
    }

    public final void trigger(Object obj) {
        k6.a(this.f44425a, (f6) obj);
    }
}
