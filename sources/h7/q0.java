package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35407a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35408b;

    public /* synthetic */ q0(AnalyticsListener.EventTime eventTime, int i11) {
        this.f35407a = eventTime;
        this.f35408b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onRepeatModeChanged(this.f35407a, this.f35408b);
    }
}
