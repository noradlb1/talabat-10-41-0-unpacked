package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35394a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f35395b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35396c;

    public /* synthetic */ o1(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f35394a = eventTime;
        this.f35395b = loadEventInfo;
        this.f35396c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadCompleted(this.f35394a, this.f35395b, this.f35396c);
    }
}
