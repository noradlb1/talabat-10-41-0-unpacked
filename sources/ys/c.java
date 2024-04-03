package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class c implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsApi f63078a;

    public /* synthetic */ c(PerformanceAnalyticsApi performanceAnalyticsApi) {
        this.f63078a = performanceAnalyticsApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsApi.Companion.m10705setUp$lambda5$lambda4(this.f63078a, obj, reply);
    }
}
