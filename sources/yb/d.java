package yb;

import android.app.Activity;
import com.instabug.bug.screenshot.f;
import com.instabug.bug.screenshot.viewhierarchy.b;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f47274b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList f47275c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f47276d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Activity f47277e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Function1 f47278f;

    public /* synthetic */ d(f fVar, ArrayList arrayList, b bVar, Activity activity, Function1 function1) {
        this.f47274b = fVar;
        this.f47275c = arrayList;
        this.f47276d = bVar;
        this.f47277e = activity;
        this.f47278f = function1;
    }

    public final void run() {
        f.a(this.f47274b, this.f47275c, this.f47276d, this.f47277e, this.f47278f);
    }
}
