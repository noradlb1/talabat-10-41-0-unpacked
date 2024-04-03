package o8;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f35557c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f35558d;

    public /* synthetic */ m(VideoRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f35556b = eventDispatcher;
        this.f35557c = format;
        this.f35558d = decoderReuseEvaluation;
    }

    public final void run() {
        this.f35556b.lambda$inputFormatChanged$2(this.f35557c, this.f35558d);
    }
}
