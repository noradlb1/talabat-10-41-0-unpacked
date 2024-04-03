package yb;

import com.instabug.bug.screenshot.f;
import com.instabug.bug.screenshot.viewhierarchy.b;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f47283b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f47284c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function0 f47285d;

    public /* synthetic */ g(f fVar, b bVar, Function0 function0) {
        this.f47283b = fVar;
        this.f47284c = bVar;
        this.f47285d = function0;
    }

    public final void run() {
        f.a(this.f47283b, this.f47284c, this.f47285d);
    }
}
