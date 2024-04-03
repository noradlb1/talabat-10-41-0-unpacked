package k7;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;

public final /* synthetic */ class r implements MediaDrm.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f35512a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnEventListener f35513b;

    public /* synthetic */ r(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnEventListener onEventListener) {
        this.f35512a = frameworkMediaDrm;
        this.f35513b = onEventListener;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
        this.f35512a.lambda$setOnEventListener$1(this.f35513b, mediaDrm, bArr, i11, i12, bArr2);
    }
}
