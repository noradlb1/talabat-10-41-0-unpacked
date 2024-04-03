package androidx.profileinstaller;

import android.view.Choreographer;

public final /* synthetic */ class a implements Choreographer.FrameCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f37406b;

    public /* synthetic */ a(Runnable runnable) {
        this.f37406b = runnable;
    }

    public final void doFrame(long j11) {
        this.f37406b.run();
    }
}
