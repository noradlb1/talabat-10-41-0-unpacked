package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35354a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f35355b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35356c;

    public /* synthetic */ i1(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f35354a = eventTime;
        this.f35355b = loadEventInfo;
        this.f35356c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadStarted(this.f35354a, this.f35355b, this.f35356c);
    }
}
