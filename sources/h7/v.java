package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35433a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35434b;

    public /* synthetic */ v(AnalyticsListener.EventTime eventTime, String str) {
        this.f35433a = eventTime;
        this.f35434b = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioDecoderReleased(this.f35433a, this.f35434b);
    }
}
