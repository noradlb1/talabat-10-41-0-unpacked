package h7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultAnalyticsCollector f35428a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player f35429b;

    public /* synthetic */ u(DefaultAnalyticsCollector defaultAnalyticsCollector, Player player) {
        this.f35428a = defaultAnalyticsCollector;
        this.f35429b = player;
    }

    public final void invoke(Object obj, FlagSet flagSet) {
        this.f35428a.lambda$setPlayer$1(this.f35429b, (AnalyticsListener) obj, flagSet);
    }
}
