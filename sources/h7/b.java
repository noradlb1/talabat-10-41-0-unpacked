package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35302a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Metadata f35303b;

    public /* synthetic */ b(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        this.f35302a = eventTime;
        this.f35303b = metadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMetadata(this.f35302a, this.f35303b);
    }
}
