package k7;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f35508b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f35509c;

    public /* synthetic */ k(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f35508b = eventDispatcher;
        this.f35509c = drmSessionEventListener;
    }

    public final void run() {
        this.f35508b.lambda$drmKeysRestored$3(this.f35509c);
    }
}
