package qb;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.customuitraces.b;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f47229b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47230c;

    public /* synthetic */ a(b bVar, Activity activity) {
        this.f47229b = bVar;
        this.f47230c = activity;
    }

    public final void run() {
        this.f47229b.b(this.f47230c);
    }
}
