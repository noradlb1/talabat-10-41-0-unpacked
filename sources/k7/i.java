package k7;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f35504b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f35505c;

    public /* synthetic */ i(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f35504b = eventDispatcher;
        this.f35505c = drmSessionEventListener;
    }

    public final void run() {
        this.f35504b.lambda$drmKeysRemoved$4(this.f35505c);
    }
}
