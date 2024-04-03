package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class e implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsApi f63080a;

    public /* synthetic */ e(PerformanceAnalyticsApi performanceAnalyticsApi) {
        this.f63080a = performanceAnalyticsApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsApi.Companion.m10707setUp$lambda9$lambda8(this.f63080a, obj, reply);
    }
}
