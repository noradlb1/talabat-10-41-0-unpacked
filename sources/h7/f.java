package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35329a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35330b;

    public /* synthetic */ f(AnalyticsListener.EventTime eventTime, String str) {
        this.f35329a = eventTime;
        this.f35330b = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVideoDecoderReleased(this.f35329a, this.f35330b);
    }
}
