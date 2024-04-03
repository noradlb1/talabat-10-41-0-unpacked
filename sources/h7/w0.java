package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35439a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CueGroup f35440b;

    public /* synthetic */ w0(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        this.f35439a = eventTime;
        this.f35440b = cueGroup;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onCues(this.f35439a, this.f35440b);
    }
}
