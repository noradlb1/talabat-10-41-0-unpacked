package h7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35386a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35387b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f35388c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f35389d;

    public /* synthetic */ n1(AnalyticsListener.EventTime eventTime, int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f35386a = eventTime;
        this.f35387b = i11;
        this.f35388c = positionInfo;
        this.f35389d = positionInfo2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onPositionDiscontinuity$43(this.f35386a, this.f35387b, this.f35388c, this.f35389d, (AnalyticsListener) obj);
    }
}
