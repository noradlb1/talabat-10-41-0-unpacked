package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35409a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f35410b;

    public /* synthetic */ q1(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f35409a = eventTime;
        this.f35410b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVideoCodecError(this.f35409a, this.f35410b);
    }
}
