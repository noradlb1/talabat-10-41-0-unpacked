package x2;

import bo.app.p3;
import bo.app.y0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class a0 implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44409a;

    public /* synthetic */ a0(y0 y0Var) {
        this.f44409a = y0Var;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44409a, (p3) obj);
    }
}
