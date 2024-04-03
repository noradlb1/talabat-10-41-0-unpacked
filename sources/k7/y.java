package k7;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.OfflineLicenseHelper;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OfflineLicenseHelper f35521b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DrmSession f35522c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f35523d;

    public /* synthetic */ y(OfflineLicenseHelper offlineLicenseHelper, DrmSession drmSession, SettableFuture settableFuture) {
        this.f35521b = offlineLicenseHelper;
        this.f35522c = drmSession;
        this.f35523d = settableFuture;
    }

    public final void run() {
        this.f35521b.lambda$acquireFirstSessionOnHandlerThread$3(this.f35522c, this.f35523d);
    }
}
