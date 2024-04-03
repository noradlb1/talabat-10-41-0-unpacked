package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35371a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35372b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35373c;

    public /* synthetic */ l0(AnalyticsListener.EventTime eventTime, int i11, long j11) {
        this.f35371a = eventTime;
        this.f35372b = i11;
        this.f35373c = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDroppedVideoFrames(this.f35371a, this.f35372b, this.f35373c);
    }
}
