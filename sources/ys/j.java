package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsScreenTrackerApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class j implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsScreenTrackerApi f63085a;

    public /* synthetic */ j(PerformanceAnalyticsScreenTrackerApi performanceAnalyticsScreenTrackerApi) {
        this.f63085a = performanceAnalyticsScreenTrackerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsScreenTrackerApi.Companion.m10710setUp$lambda1$lambda0(this.f63085a, obj, reply);
    }
}
