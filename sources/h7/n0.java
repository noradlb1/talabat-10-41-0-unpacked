package h7;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35383a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f35384b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f35385c;

    public /* synthetic */ n0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f35383a = eventTime;
        this.f35384b = format;
        this.f35385c = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onAudioInputFormatChanged$5(this.f35383a, this.f35384b, this.f35385c, (AnalyticsListener) obj);
    }
}
