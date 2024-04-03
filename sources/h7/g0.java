package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35336a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35337b;

    public /* synthetic */ g0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f35336a = eventTime;
        this.f35337b = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDownstreamFormatChanged(this.f35336a, this.f35337b);
    }
}
