package h7;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35403a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f35404b;

    public /* synthetic */ p1(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        this.f35403a = eventTime;
        this.f35404b = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMediaMetadataChanged(this.f35403a, this.f35404b);
    }
}
