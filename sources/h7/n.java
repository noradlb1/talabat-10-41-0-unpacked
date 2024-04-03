package h7;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35381a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackException f35382b;

    public /* synthetic */ n(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f35381a = eventTime;
        this.f35382b = playbackException;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayerError(this.f35381a, this.f35382b);
    }
}
