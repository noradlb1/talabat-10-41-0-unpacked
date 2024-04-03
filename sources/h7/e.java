package h7;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35323a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackException f35324b;

    public /* synthetic */ e(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f35323a = eventTime;
        this.f35324b = playbackException;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayerErrorChanged(this.f35323a, this.f35324b);
    }
}
