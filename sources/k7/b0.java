package k7;

import com.google.android.exoplayer2.drm.OfflineLicenseHelper;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OfflineLicenseHelper f35494b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f35495c;

    public /* synthetic */ b0(OfflineLicenseHelper offlineLicenseHelper, SettableFuture settableFuture) {
        this.f35494b = offlineLicenseHelper;
        this.f35495c = settableFuture;
    }

    public final void run() {
        this.f35494b.lambda$releaseManagerOnHandlerThread$4(this.f35495c);
    }
}
