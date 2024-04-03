package sb;

import android.app.Activity;
import com.instabug.apm.lifecycle.f;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f47247b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47248c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ com.instabug.apm.model.e f47249d;

    public /* synthetic */ e(f fVar, Activity activity, com.instabug.apm.model.e eVar) {
        this.f47247b = fVar;
        this.f47248c = activity;
        this.f47249d = eVar;
    }

    public final void run() {
        f.a(this.f47247b, this.f47248c, this.f47249d);
    }
}
