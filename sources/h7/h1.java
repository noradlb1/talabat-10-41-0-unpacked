package h7;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35345a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackParameters f35346b;

    public /* synthetic */ h1(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        this.f35345a = eventTime;
        this.f35346b = playbackParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlaybackParametersChanged(this.f35345a, this.f35346b);
    }
}
