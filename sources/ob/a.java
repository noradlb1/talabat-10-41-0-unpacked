package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47174b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47175c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47176d;

    public /* synthetic */ a(k kVar, Activity activity, e eVar) {
        this.f47174b = kVar;
        this.f47175c = activity;
        this.f47176d = eVar;
    }

    public final void run() {
        this.f47174b.s(this.f47175c, this.f47176d);
    }
}
