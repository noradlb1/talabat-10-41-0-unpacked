package qb;

import android.app.Activity;
import android.os.Looper;
import com.instabug.apm.handler.uitrace.customuitraces.b;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f47233b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f47234c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f47235d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Looper f47236e;

    public /* synthetic */ c(b bVar, String str, Activity activity, Looper looper) {
        this.f47233b = bVar;
        this.f47234c = str;
        this.f47235d = activity;
        this.f47236e = looper;
    }

    public final void run() {
        this.f47233b.b(this.f47234c, this.f47235d, this.f47236e);
    }
}
