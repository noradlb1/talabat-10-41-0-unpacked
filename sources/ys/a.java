package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsApi f63076a;

    public /* synthetic */ a(PerformanceAnalyticsApi performanceAnalyticsApi) {
        this.f63076a = performanceAnalyticsApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsApi.Companion.m10701setUp$lambda1$lambda0(this.f63076a, obj, reply);
    }
}
