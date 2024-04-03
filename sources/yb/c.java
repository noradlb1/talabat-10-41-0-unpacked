package yb;

import android.app.Activity;
import com.instabug.bug.screenshot.f;
import java.util.List;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f47270b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f47271c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f47272d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Function0 f47273e;

    public /* synthetic */ c(f fVar, List list, Activity activity, Function0 function0) {
        this.f47270b = fVar;
        this.f47271c = list;
        this.f47272d = activity;
        this.f47273e = function0;
    }

    public final void run() {
        f.a(this.f47270b, this.f47271c, this.f47272d, this.f47273e);
    }
}
