package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47189b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47190c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47191d;

    public /* synthetic */ f(k kVar, Activity activity, e eVar) {
        this.f47189b = kVar;
        this.f47190c = activity;
        this.f47191d = eVar;
    }

    public final void run() {
        this.f47189b.o(this.f47190c, this.f47191d);
    }
}
