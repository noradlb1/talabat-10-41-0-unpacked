package x2;

import bo.app.e6;
import bo.app.k6;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class j implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k6 f44427a;

    public /* synthetic */ j(k6 k6Var) {
        this.f44427a = k6Var;
    }

    public final void trigger(Object obj) {
        k6.a(this.f44427a, (e6) obj);
    }
}
