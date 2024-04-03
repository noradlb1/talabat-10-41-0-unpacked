package ob;

import android.app.Activity;
import com.instabug.apm.model.e;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.instabug.apm.handler.uitrace.k f47204b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47205c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47206d;

    public /* synthetic */ k(com.instabug.apm.handler.uitrace.k kVar, Activity activity, e eVar) {
        this.f47204b = kVar;
        this.f47205c = activity;
        this.f47206d = eVar;
    }

    public final void run() {
        this.f47204b.p(this.f47205c, this.f47206d);
    }
}
