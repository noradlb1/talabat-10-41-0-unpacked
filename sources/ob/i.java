package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47198b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47199c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47200d;

    public /* synthetic */ i(k kVar, Activity activity, e eVar) {
        this.f47198b = kVar;
        this.f47199c = activity;
        this.f47200d = eVar;
    }

    public final void run() {
        this.f47198b.t(this.f47199c, this.f47200d);
    }
}
