package o8;

import android.view.Display;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper;

public final /* synthetic */ class e implements VideoFrameReleaseHelper.DisplayHelper.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoFrameReleaseHelper f35544a;

    public /* synthetic */ e(VideoFrameReleaseHelper videoFrameReleaseHelper) {
        this.f35544a = videoFrameReleaseHelper;
    }

    public final void onDefaultDisplayChanged(Display display) {
        this.f35544a.updateDefaultDisplayRefreshRateParams(display);
    }
}
