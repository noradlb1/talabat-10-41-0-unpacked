package k7;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import java.util.List;

public final /* synthetic */ class t implements MediaDrm.OnKeyStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f35514a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnKeyStatusChangeListener f35515b;

    public /* synthetic */ t(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        this.f35514a = frameworkMediaDrm;
        this.f35515b = onKeyStatusChangeListener;
    }

    public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z11) {
        this.f35514a.lambda$setOnKeyStatusChangeListener$2(this.f35515b, mediaDrm, bArr, list, z11);
    }
}
