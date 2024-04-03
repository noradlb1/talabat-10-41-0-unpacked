package i7;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35457b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f35458c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f35459d;

    public /* synthetic */ f(AudioRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f35457b = eventDispatcher;
        this.f35458c = format;
        this.f35459d = decoderReuseEvaluation;
    }

    public final void run() {
        this.f35457b.lambda$inputFormatChanged$2(this.f35458c, this.f35459d);
    }
}
