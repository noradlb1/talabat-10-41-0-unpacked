package o8;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35547b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f35548c;

    public /* synthetic */ i(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f35547b = eventDispatcher;
        this.f35548c = decoderCounters;
    }

    public final void run() {
        this.f35547b.lambda$enabled$0(this.f35548c);
    }
}
