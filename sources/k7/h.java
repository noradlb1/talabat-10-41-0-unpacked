package k7;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f35501b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSessionEventListener f35502c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f35503d;

    public /* synthetic */ h(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i11) {
        this.f35501b = eventDispatcher;
        this.f35502c = drmSessionEventListener;
        this.f35503d = i11;
    }

    public final void run() {
        this.f35501b.lambda$drmSessionAcquired$0(this.f35502c, this.f35503d);
    }
}
