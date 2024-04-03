package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35331a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f35332b;

    public /* synthetic */ f0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f35331a = eventTime;
        this.f35332b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioSinkError(this.f35331a, this.f35332b);
    }
}
