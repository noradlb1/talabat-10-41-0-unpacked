package x2;

import bo.app.r0;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class m0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44432a;

    public /* synthetic */ m0(y0 y0Var) {
        this.f44432a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44432a, (r0) obj);
    }
}
