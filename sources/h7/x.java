package h7;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35441a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaItem f35442b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35443c;

    public /* synthetic */ x(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i11) {
        this.f35441a = eventTime;
        this.f35442b = mediaItem;
        this.f35443c = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMediaItemTransition(this.f35441a, this.f35442b, this.f35443c);
    }
}
