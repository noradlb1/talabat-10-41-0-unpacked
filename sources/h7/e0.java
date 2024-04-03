package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35325a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioAttributes f35326b;

    public /* synthetic */ e0(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        this.f35325a = eventTime;
        this.f35326b = audioAttributes;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioAttributesChanged(this.f35325a, this.f35326b);
    }
}
