package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.video.VideoSize;

public final /* synthetic */ class z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35450a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoSize f35451b;

    public /* synthetic */ z(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f35450a = eventTime;
        this.f35451b = videoSize;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onVideoSizeChanged$57(this.f35450a, this.f35451b, (AnalyticsListener) obj);
    }
}
