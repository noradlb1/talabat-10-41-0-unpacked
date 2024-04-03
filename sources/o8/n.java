package o8;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35559b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f35560c;

    public /* synthetic */ n(VideoRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f35559b = eventDispatcher;
        this.f35560c = exc;
    }

    public final void run() {
        this.f35559b.lambda$videoCodecError$9(this.f35560c);
    }
}
