package pb;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.automatictraces.c;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f47219b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47220c;

    public /* synthetic */ b(c cVar, Activity activity) {
        this.f47219b = cVar;
        this.f47220c = activity;
    }

    public final void run() {
        this.f47219b.b(this.f47220c);
    }
}
