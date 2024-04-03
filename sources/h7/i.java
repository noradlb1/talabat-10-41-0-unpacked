package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35347a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f35348b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35349c;

    public /* synthetic */ i(AnalyticsListener.EventTime eventTime, Object obj, long j11) {
        this.f35347a = eventTime;
        this.f35348b = obj;
        this.f35349c = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onRenderedFirstFrame(this.f35347a, this.f35348b, this.f35349c);
    }
}
