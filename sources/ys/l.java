package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsScreenTrackerApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class l implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsScreenTrackerApi f63087a;

    public /* synthetic */ l(PerformanceAnalyticsScreenTrackerApi performanceAnalyticsScreenTrackerApi) {
        this.f63087a = performanceAnalyticsScreenTrackerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsScreenTrackerApi.Companion.m10712setUp$lambda5$lambda4(this.f63087a, obj, reply);
    }
}
