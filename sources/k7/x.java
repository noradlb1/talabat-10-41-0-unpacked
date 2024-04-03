package k7;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.OfflineLicenseHelper;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OfflineLicenseHelper f35516b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35517c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ byte[] f35518d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f35519e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Format f35520f;

    public /* synthetic */ x(OfflineLicenseHelper offlineLicenseHelper, int i11, byte[] bArr, SettableFuture settableFuture, Format format) {
        this.f35516b = offlineLicenseHelper;
        this.f35517c = i11;
        this.f35518d = bArr;
        this.f35519e = settableFuture;
        this.f35520f = format;
    }

    public final void run() {
        this.f35516b.lambda$acquireFirstSessionOnHandlerThread$2(this.f35517c, this.f35518d, this.f35519e, this.f35520f);
    }
}
