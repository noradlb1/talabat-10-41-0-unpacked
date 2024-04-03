package o8;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35549b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f35550c;

    public /* synthetic */ j(VideoRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f35549b = eventDispatcher;
        this.f35550c = str;
    }

    public final void run() {
        this.f35549b.lambda$decoderReleased$7(this.f35550c);
    }
}
