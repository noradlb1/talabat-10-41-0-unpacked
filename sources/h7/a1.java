package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35300a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f35301b;

    public /* synthetic */ a1(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f35300a = eventTime;
        this.f35301b = decoderCounters;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onAudioDisabled$9(this.f35300a, this.f35301b, (AnalyticsListener) obj);
    }
}
