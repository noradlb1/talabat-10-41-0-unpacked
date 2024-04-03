package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47211c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47212d;

    public /* synthetic */ m(k kVar, Activity activity, e eVar) {
        this.f47210b = kVar;
        this.f47211c = activity;
        this.f47212d = eVar;
    }

    public final void run() {
        this.f47210b.q(this.f47211c, this.f47212d);
    }
}
