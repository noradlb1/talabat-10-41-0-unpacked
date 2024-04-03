package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35316a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35317b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35318c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35319d;

    public /* synthetic */ d(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        this.f35316a = eventTime;
        this.f35317b = str;
        this.f35318c = j11;
        this.f35319d = j12;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onVideoDecoderInitialized$14(this.f35316a, this.f35317b, this.f35318c, this.f35319d, (AnalyticsListener) obj);
    }
}
