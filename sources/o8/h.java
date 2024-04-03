package o8;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35545b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f35546c;

    public /* synthetic */ h(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f35545b = eventDispatcher;
        this.f35546c = decoderCounters;
    }

    public final void run() {
        this.f35545b.lambda$disabled$8(this.f35546c);
    }
}
