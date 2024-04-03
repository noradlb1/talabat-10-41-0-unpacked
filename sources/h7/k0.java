package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35364a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f35365b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35366c;

    public /* synthetic */ k0(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        this.f35364a = eventTime;
        this.f35365b = z11;
        this.f35366c = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayerStateChanged(this.f35364a, this.f35365b, this.f35366c);
    }
}
