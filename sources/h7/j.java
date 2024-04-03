package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35357a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f35358b;

    public /* synthetic */ j(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f35357a = eventTime;
        this.f35358b = decoderCounters;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onVideoEnabled$13(this.f35357a, this.f35358b, (AnalyticsListener) obj);
    }
}
