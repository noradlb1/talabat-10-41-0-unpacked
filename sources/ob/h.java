package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47196c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47197d;

    public /* synthetic */ h(k kVar, Activity activity, e eVar) {
        this.f47195b = kVar;
        this.f47196c = activity;
        this.f47197d = eVar;
    }

    public final void run() {
        this.f47195b.r(this.f47196c, this.f47197d);
    }
}
