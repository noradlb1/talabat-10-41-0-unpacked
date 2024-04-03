package yb;

import android.app.Activity;
import com.instabug.bug.screenshot.viewhierarchy.b;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f47280b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f47281c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function0 f47282d;

    public /* synthetic */ f(b bVar, Activity activity, Function0 function0) {
        this.f47280b = bVar;
        this.f47281c = activity;
        this.f47282d = function0;
    }

    public final void run() {
        com.instabug.bug.screenshot.f.a(this.f47280b, this.f47281c, this.f47282d);
    }
}
