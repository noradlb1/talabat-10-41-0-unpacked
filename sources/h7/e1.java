package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35327a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35328b;

    public /* synthetic */ e1(AnalyticsListener.EventTime eventTime, int i11) {
        this.f35327a = eventTime;
        this.f35328b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlaybackStateChanged(this.f35327a, this.f35328b);
    }
}
