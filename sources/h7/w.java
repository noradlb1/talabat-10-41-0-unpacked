package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35437a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f35438b;

    public /* synthetic */ w(AnalyticsListener.EventTime eventTime, long j11) {
        this.f35437a = eventTime;
        this.f35438b = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioPositionAdvancing(this.f35437a, this.f35438b);
    }
}
