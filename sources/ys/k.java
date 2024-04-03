package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsScreenTrackerApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class k implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsScreenTrackerApi f63086a;

    public /* synthetic */ k(PerformanceAnalyticsScreenTrackerApi performanceAnalyticsScreenTrackerApi) {
        this.f63086a = performanceAnalyticsScreenTrackerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsScreenTrackerApi.Companion.m10711setUp$lambda3$lambda2(this.f63086a, obj, reply);
    }
}
