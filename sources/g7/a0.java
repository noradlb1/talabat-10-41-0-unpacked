package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.base.Function;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnalyticsCollector f35181b;

    public /* synthetic */ a0(AnalyticsCollector analyticsCollector) {
        this.f35181b = analyticsCollector;
    }

    public final Object apply(Object obj) {
        return ExoPlayer.Builder.lambda$new$13(this.f35181b, (Clock) obj);
    }
}
