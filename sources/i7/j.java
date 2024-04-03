package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35466b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f35467c;

    public /* synthetic */ j(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f35466b = eventDispatcher;
        this.f35467c = decoderCounters;
    }

    public final void run() {
        this.f35466b.lambda$enabled$0(this.f35467c);
    }
}
