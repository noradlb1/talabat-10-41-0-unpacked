package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35430a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f35431b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35432c;

    public /* synthetic */ u0(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        this.f35430a = eventTime;
        this.f35431b = z11;
        this.f35432c = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayWhenReadyChanged(this.f35430a, this.f35431b, this.f35432c);
    }
}
