package k7;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.OfflineLicenseHelper;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OfflineLicenseHelper f35524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f35525c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DrmSession f35526d;

    public /* synthetic */ z(OfflineLicenseHelper offlineLicenseHelper, SettableFuture settableFuture, DrmSession drmSession) {
        this.f35524b = offlineLicenseHelper;
        this.f35525c = settableFuture;
        this.f35526d = drmSession;
    }

    public final void run() {
        this.f35524b.lambda$acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread$1(this.f35525c, this.f35526d);
    }
}
