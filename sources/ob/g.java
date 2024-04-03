package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47192b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47193c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f47194d;

    public /* synthetic */ g(k kVar, Activity activity, long j11) {
        this.f47192b = kVar;
        this.f47193c = activity;
        this.f47194d = j11;
    }

    public final void run() {
        this.f47192b.b(this.f47193c, this.f47194d);
    }
}
