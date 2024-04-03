package y1;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Handler f44446b;

    public /* synthetic */ a(Handler handler) {
        this.f44446b = handler;
    }

    public final void execute(Runnable runnable) {
        this.f44446b.post(runnable);
    }
}
