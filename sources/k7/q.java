package k7;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;

public final /* synthetic */ class q implements MediaDrm.OnExpirationUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f35510a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnExpirationUpdateListener f35511b;

    public /* synthetic */ q(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        this.f35510a = frameworkMediaDrm;
        this.f35511b = onExpirationUpdateListener;
    }

    public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j11) {
        this.f35510a.lambda$setOnExpirationUpdateListener$3(this.f35511b, mediaDrm, bArr, j11);
    }
}
