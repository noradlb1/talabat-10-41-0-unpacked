package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f35309a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f35310b;

    public /* synthetic */ c(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        this.f35309a = eventTime;
        this.f35310b = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onTrackSelectionParametersChanged(this.f35309a, this.f35310b);
    }
}
