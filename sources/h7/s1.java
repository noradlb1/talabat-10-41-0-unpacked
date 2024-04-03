package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35424a;

    public /* synthetic */ s1(AnalyticsListener.EventTime eventTime) {
        this.f35424a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSeekStarted(this.f35424a);
    }
}
