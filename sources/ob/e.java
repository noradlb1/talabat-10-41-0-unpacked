package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47187c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ com.instabug.apm.model.e f47188d;

    public /* synthetic */ e(k kVar, Activity activity, com.instabug.apm.model.e eVar) {
        this.f47186b = kVar;
        this.f47187c = activity;
        this.f47188d = eVar;
    }

    public final void run() {
        this.f47186b.n(this.f47187c, this.f47188d);
    }
}
