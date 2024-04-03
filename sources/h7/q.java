package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35405a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35406b;

    public /* synthetic */ q(AnalyticsListener.EventTime eventTime, int i11) {
        this.f35405a = eventTime;
        this.f35406b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioSessionIdChanged(this.f35405a, this.f35406b);
    }
}
