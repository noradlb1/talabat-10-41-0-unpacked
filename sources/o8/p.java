package o8;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35564b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35565c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35566d;

    public /* synthetic */ p(VideoRendererEventListener.EventDispatcher eventDispatcher, int i11, long j11) {
        this.f35564b = eventDispatcher;
        this.f35565c = i11;
        this.f35566d = j11;
    }

    public final void run() {
        this.f35564b.lambda$droppedFrames$3(this.f35565c, this.f35566d);
    }
}
