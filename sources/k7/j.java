package k7;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f35506b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f35507c;

    public /* synthetic */ j(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f35506b = eventDispatcher;
        this.f35507c = drmSessionEventListener;
    }

    public final void run() {
        this.f35506b.lambda$drmKeysLoaded$1(this.f35507c);
    }
}
