package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class z0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35452a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f35453b;

    public /* synthetic */ z0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f35452a = eventTime;
        this.f35453b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioCodecError(this.f35452a, this.f35453b);
    }
}
