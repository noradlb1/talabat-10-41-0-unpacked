package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35350a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35351b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35352c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35353d;

    public /* synthetic */ i0(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        this.f35350a = eventTime;
        this.f35351b = i11;
        this.f35352c = j11;
        this.f35353d = j12;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioUnderrun(this.f35350a, this.f35351b, this.f35352c, this.f35353d);
    }
}
