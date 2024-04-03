package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;
import java.io.IOException;

public final /* synthetic */ class x0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35444a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f35445b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35446c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ IOException f35447d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f35448e;

    public /* synthetic */ x0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        this.f35444a = eventTime;
        this.f35445b = loadEventInfo;
        this.f35446c = mediaLoadData;
        this.f35447d = iOException;
        this.f35448e = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadError(this.f35444a, this.f35445b, this.f35446c, this.f35447d, this.f35448e);
    }
}
