package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35399c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35400d;

    public /* synthetic */ p(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        this.f35397a = eventTime;
        this.f35398b = str;
        this.f35399c = j11;
        this.f35400d = j12;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onAudioDecoderInitialized$4(this.f35397a, this.f35398b, this.f35399c, this.f35400d, (AnalyticsListener) obj);
    }
}
