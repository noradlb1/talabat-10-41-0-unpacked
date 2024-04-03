package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35377a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f35378b;

    public /* synthetic */ m0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f35377a = eventTime;
        this.f35378b = decoderCounters;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onVideoDisabled$18(this.f35377a, this.f35378b, (AnalyticsListener) obj);
    }
}
