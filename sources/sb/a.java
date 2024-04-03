package sb;

import android.app.Activity;
import com.instabug.apm.lifecycle.f;
import com.instabug.apm.model.e;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f47238b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f47239c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f47240d;

    public /* synthetic */ a(f fVar, e eVar, Activity activity) {
        this.f47238b = fVar;
        this.f47239c = eVar;
        this.f47240d = activity;
    }

    public final void run() {
        f.a(this.f47238b, this.f47239c, this.f47240d);
    }
}
