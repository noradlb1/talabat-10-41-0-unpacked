package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35464b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f35465c;

    public /* synthetic */ i(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f35464b = eventDispatcher;
        this.f35465c = decoderCounters;
    }

    public final void run() {
        this.f35464b.lambda$disabled$6(this.f35465c);
    }
}
