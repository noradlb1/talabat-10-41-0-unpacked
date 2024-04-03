package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47183b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47184c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47185d;

    public /* synthetic */ d(k kVar, Activity activity, e eVar) {
        this.f47183b = kVar;
        this.f47184c = activity;
        this.f47185d = eVar;
    }

    public final void run() {
        this.f47183b.m(this.f47184c, this.f47185d);
    }
}
