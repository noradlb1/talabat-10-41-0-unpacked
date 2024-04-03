package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35307c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35308d;

    public /* synthetic */ b1(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        this.f35305a = eventTime;
        this.f35306b = i11;
        this.f35307c = j11;
        this.f35308d = j12;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onBandwidthEstimate(this.f35305a, this.f35306b, this.f35307c, this.f35308d);
    }
}
