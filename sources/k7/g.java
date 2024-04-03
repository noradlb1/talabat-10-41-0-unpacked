package k7;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f35498b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f35499c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Exception f35500d;

    public /* synthetic */ g(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, Exception exc) {
        this.f35498b = eventDispatcher;
        this.f35499c = drmSessionEventListener;
        this.f35500d = exc;
    }

    public final void run() {
        this.f35498b.lambda$drmSessionManagerError$2(this.f35499c, this.f35500d);
    }
}
