package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ListenerSet;
import java.util.List;

public final /* synthetic */ class m1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35379a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f35380b;

    public /* synthetic */ m1(AnalyticsListener.EventTime eventTime, List list) {
        this.f35379a = eventTime;
        this.f35380b = list;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onCues(this.f35379a, (List<Cue>) this.f35380b);
    }
}
