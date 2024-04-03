package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsInitializerApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class i implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsInitializerApi f63084a;

    public /* synthetic */ i(PerformanceAnalyticsInitializerApi performanceAnalyticsInitializerApi) {
        this.f63084a = performanceAnalyticsInitializerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsInitializerApi.Companion.m10709setUp$lambda1$lambda0(this.f63084a, obj, reply);
    }
}
