package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47180b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47181c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47182d;

    public /* synthetic */ c(k kVar, Activity activity, e eVar) {
        this.f47180b = kVar;
        this.f47181c = activity;
        this.f47182d = eVar;
    }

    public final void run() {
        this.f47180b.l(this.f47181c, this.f47182d);
    }
}
