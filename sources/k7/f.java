package k7;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f35496b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f35497c;

    public /* synthetic */ f(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f35496b = eventDispatcher;
        this.f35497c = drmSessionEventListener;
    }

    public final void run() {
        this.f35496b.lambda$drmSessionReleased$5(this.f35497c);
    }
}
