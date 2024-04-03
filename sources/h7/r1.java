package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35415a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f35416b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35417c;

    public /* synthetic */ r1(AnalyticsListener.EventTime eventTime, long j11, int i11) {
        this.f35415a = eventTime;
        this.f35416b = j11;
        this.f35417c = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVideoFrameProcessingOffset(this.f35415a, this.f35416b, this.f35417c);
    }
}
