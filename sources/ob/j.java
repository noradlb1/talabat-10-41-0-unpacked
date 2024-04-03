package ob;

import android.app.Activity;
import com.instabug.apm.handler.uitrace.k;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47201b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47202c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f47203d;

    public /* synthetic */ j(k kVar, Activity activity, Runnable runnable) {
        this.f47201b = kVar;
        this.f47202c = activity;
        this.f47203d = runnable;
    }

    public final void run() {
        this.f47201b.a(this.f47202c, this.f47203d);
    }
}
