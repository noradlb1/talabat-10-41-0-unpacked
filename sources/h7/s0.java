package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35421a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35422b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35423c;

    public /* synthetic */ s0(AnalyticsListener.EventTime eventTime, int i11, int i12) {
        this.f35421a = eventTime;
        this.f35422b = i11;
        this.f35423c = i12;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSurfaceSizeChanged(this.f35421a, this.f35422b, this.f35423c);
    }
}
