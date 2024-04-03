package o8;

import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35551b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoSize f35552c;

    public /* synthetic */ k(VideoRendererEventListener.EventDispatcher eventDispatcher, VideoSize videoSize) {
        this.f35551b = eventDispatcher;
        this.f35552c = videoSize;
    }

    public final void run() {
        this.f35551b.lambda$videoSizeChanged$5(this.f35552c);
    }
}
