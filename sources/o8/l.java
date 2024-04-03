package o8;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35553b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35554c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f35555d;

    public /* synthetic */ l(VideoRendererEventListener.EventDispatcher eventDispatcher, long j11, int i11) {
        this.f35553b = eventDispatcher;
        this.f35554c = j11;
        this.f35555d = i11;
    }

    public final void run() {
        this.f35553b.lambda$reportVideoFrameProcessingOffset$4(this.f35554c, this.f35555d);
    }
}
