package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class d implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsApi f63079a;

    public /* synthetic */ d(PerformanceAnalyticsApi performanceAnalyticsApi) {
        this.f63079a = performanceAnalyticsApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsApi.Companion.m10706setUp$lambda7$lambda6(this.f63079a, obj, reply);
    }
}
