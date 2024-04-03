package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35418a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f35419b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35420c;

    public /* synthetic */ s(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f35418a = eventTime;
        this.f35419b = loadEventInfo;
        this.f35420c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadCanceled(this.f35418a, this.f35419b, this.f35420c);
    }
}
