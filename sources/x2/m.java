package x2;

import bo.app.i5;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class m implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bo.app.m f44431a;

    public /* synthetic */ m(bo.app.m mVar) {
        this.f44431a = mVar;
    }

    public final void trigger(Object obj) {
        bo.app.m.a(this.f44431a, (i5) obj);
    }
}
