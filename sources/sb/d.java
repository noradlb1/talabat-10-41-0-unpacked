package sb;

import android.app.Activity;
import com.instabug.apm.lifecycle.f;
import com.instabug.apm.model.e;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f47244b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f47245c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f47246d;

    public /* synthetic */ d(f fVar, e eVar, Activity activity) {
        this.f47244b = fVar;
        this.f47245c = eVar;
        this.f47246d = activity;
    }

    public final void run() {
        f.b(this.f47244b, this.f47245c, this.f47246d);
    }
}
