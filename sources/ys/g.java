package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class g implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsApi f63082a;

    public /* synthetic */ g(PerformanceAnalyticsApi performanceAnalyticsApi) {
        this.f63082a = performanceAnalyticsApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsApi.Companion.m10703setUp$lambda13$lambda12(this.f63082a, obj, reply);
    }
}
