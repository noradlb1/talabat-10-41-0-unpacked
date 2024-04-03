package de;

import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.terminations.i0;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i0 f56694b;

    public /* synthetic */ b(i0 i0Var) {
        this.f56694b = i0Var;
    }

    public final void accept(Object obj) {
        this.f56694b.a((ActivityLifeCycleEvent) obj);
    }
}
