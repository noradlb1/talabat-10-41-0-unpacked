package h7;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35435a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f35436b;

    public /* synthetic */ v0(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        this.f35435a = eventTime;
        this.f35436b = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlaylistMetadataChanged(this.f35435a, this.f35436b);
    }
}
