package o8;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35561b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f35562c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35563d;

    public /* synthetic */ o(VideoRendererEventListener.EventDispatcher eventDispatcher, Object obj, long j11) {
        this.f35561b = eventDispatcher;
        this.f35562c = obj;
        this.f35563d = j11;
    }

    public final void run() {
        this.f35561b.lambda$renderedFirstFrame$6(this.f35562c, this.f35563d);
    }
}
