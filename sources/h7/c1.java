package h7;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35313a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f35314b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f35315c;

    public /* synthetic */ c1(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f35313a = eventTime;
        this.f35314b = format;
        this.f35315c = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onVideoInputFormatChanged$15(this.f35313a, this.f35314b, this.f35315c, (AnalyticsListener) obj);
    }
}
