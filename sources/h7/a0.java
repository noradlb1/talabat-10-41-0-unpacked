package h7;

import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35298a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Tracks f35299b;

    public /* synthetic */ a0(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        this.f35298a = eventTime;
        this.f35299b = tracks;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onTracksChanged(this.f35298a, this.f35299b);
    }
}
