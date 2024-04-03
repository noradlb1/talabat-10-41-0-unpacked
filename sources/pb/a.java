package pb;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.automatictraces.c;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f47217b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47218c;

    public /* synthetic */ a(c cVar, Activity activity) {
        this.f47217b = cVar;
        this.f47218c = activity;
    }

    public final void run() {
        this.f47217b.a(this.f47218c);
    }
}
