package h7;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y0 implements ListenerSet.IterationFinishedEvent {
    public final void invoke(Object obj, FlagSet flagSet) {
        DefaultAnalyticsCollector.lambda$new$0((AnalyticsListener) obj, flagSet);
    }
}
