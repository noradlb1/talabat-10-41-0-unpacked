package k7;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.OfflineLicenseHelper;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OfflineLicenseHelper f35491b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f35492c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DrmSession f35493d;

    public /* synthetic */ a0(OfflineLicenseHelper offlineLicenseHelper, SettableFuture settableFuture, DrmSession drmSession) {
        this.f35491b = offlineLicenseHelper;
        this.f35492c = settableFuture;
        this.f35493d = drmSession;
    }

    public final void run() {
        this.f35491b.lambda$getLicenseDurationRemainingSec$0(this.f35492c, this.f35493d);
    }
}
