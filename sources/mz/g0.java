package mz;

import android.app.Activity;
import com.uxcam.internals.hk;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f23967b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f23968c;

    public /* synthetic */ g0(Activity activity, boolean z11) {
        this.f23967b = activity;
        this.f23968c = z11;
    }

    public final void run() {
        hk.a(this.f23967b, this.f23968c);
    }
}
