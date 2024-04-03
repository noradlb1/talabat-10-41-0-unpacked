package pd;

import com.instabug.library.util.OnVideoFrameReady;
import com.instabug.library.util.VideoManipulationUtils;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f57172b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OnVideoFrameReady f57173c;

    public /* synthetic */ d(String str, OnVideoFrameReady onVideoFrameReady) {
        this.f57172b = str;
        this.f57173c = onVideoFrameReady;
    }

    public final void run() {
        VideoManipulationUtils.lambda$extractFirstVideoFrame$1(this.f57172b, this.f57173c);
    }
}
