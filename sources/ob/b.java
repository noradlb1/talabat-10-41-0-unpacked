package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47178c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47179d;

    public /* synthetic */ b(k kVar, Activity activity, e eVar) {
        this.f47177b = kVar;
        this.f47178c = activity;
        this.f47179d = eVar;
    }

    public final void run() {
        this.f47177b.k(this.f47178c, this.f47179d);
    }
}
