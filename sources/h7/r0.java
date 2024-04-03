package h7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35413a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.Commands f35414b;

    public /* synthetic */ r0(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        this.f35413a = eventTime;
        this.f35414b = commands;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAvailableCommandsChanged(this.f35413a, this.f35414b);
    }
}
