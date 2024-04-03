package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.base.Function;

public final /* synthetic */ class w implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnalyticsCollector f35280b;

    public /* synthetic */ w(AnalyticsCollector analyticsCollector) {
        this.f35280b = analyticsCollector;
    }

    public final Object apply(Object obj) {
        return ExoPlayer.Builder.lambda$setAnalyticsCollector$21(this.f35280b, (Clock) obj);
    }
}
