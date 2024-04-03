package x2;

import bo.app.y0;
import com.braze.events.IEventSubscriber;
import java.util.concurrent.Semaphore;

public final /* synthetic */ class y implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f44443a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Semaphore f44444b;

    public /* synthetic */ y(y0 y0Var, Semaphore semaphore) {
        this.f44443a = y0Var;
        this.f44444b = semaphore;
    }

    public final void trigger(Object obj) {
        y0.a(this.f44443a, this.f44444b, (Throwable) obj);
    }
}
