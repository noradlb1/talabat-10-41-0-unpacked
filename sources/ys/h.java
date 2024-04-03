package ys;

import com.talabat.performance_analytics.PerformanceAnalyticsAppStartupListenerApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class h implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PerformanceAnalyticsAppStartupListenerApi f63083a;

    public /* synthetic */ h(PerformanceAnalyticsAppStartupListenerApi performanceAnalyticsAppStartupListenerApi) {
        this.f63083a = performanceAnalyticsAppStartupListenerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        PerformanceAnalyticsAppStartupListenerApi.Companion.m10708setUp$lambda1$lambda0(this.f63083a, obj, reply);
    }
}
