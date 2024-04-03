package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35401a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f35402b;

    public /* synthetic */ p0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f35401a = eventTime;
        this.f35402b = decoderCounters;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onAudioEnabled$3(this.f35401a, this.f35402b, (AnalyticsListener) obj);
    }
}
