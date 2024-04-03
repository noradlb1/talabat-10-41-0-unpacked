package com.talabat.performance_analytics;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ys.a;
import ys.b;
import ys.c;
import ys.d;
import ys.e;
import ys.f;
import ys.g;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J&\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0013"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsApi;", "", "addTraceAttribute", "", "params", "Lcom/talabat/performance_analytics/TraceAttributeParams;", "addTraceCounter", "Lcom/talabat/performance_analytics/TraceCounterParams;", "cancelTrace", "traceName", "", "endTrace", "attributes", "", "putTraceMetric", "Lcom/talabat/performance_analytics/TraceMetricParams;", "resetTraces", "startTrace", "Companion", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerformanceAnalyticsApi {
    @NotNull
    public static final Companion Companion = Companion.f61178a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR#\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsApi$Companion;", "", "()V", "codec", "Lio/flutter/plugin/common/MessageCodec;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lkotlin/Lazy;", "setUp", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "api", "Lcom/talabat/performance_analytics/PerformanceAnalyticsApi;", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f61178a = new Companion();
        @NotNull
        private static final Lazy<PerformanceAnalyticsApiCodec> codec$delegate = LazyKt__LazyJVMKt.lazy(PerformanceAnalyticsApi$Companion$codec$2.INSTANCE);

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-1$lambda-0  reason: not valid java name */
        public static final void m10701setUp$lambda1$lambda0(PerformanceAnalyticsApi performanceAnalyticsApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                performanceAnalyticsApi.startTrace((String) obj2);
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-11$lambda-10  reason: not valid java name */
        public static final void m10702setUp$lambda11$lambda10(PerformanceAnalyticsApi performanceAnalyticsApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.talabat.performance_analytics.TraceMetricParams");
            try {
                performanceAnalyticsApi.putTraceMetric((TraceMetricParams) obj2);
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-13$lambda-12  reason: not valid java name */
        public static final void m10703setUp$lambda13$lambda12(PerformanceAnalyticsApi performanceAnalyticsApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            try {
                performanceAnalyticsApi.resetTraces();
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-3$lambda-2  reason: not valid java name */
        public static final void m10704setUp$lambda3$lambda2(PerformanceAnalyticsApi performanceAnalyticsApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                performanceAnalyticsApi.endTrace((String) obj2, (Map) list2.get(1));
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-5$lambda-4  reason: not valid java name */
        public static final void m10705setUp$lambda5$lambda4(PerformanceAnalyticsApi performanceAnalyticsApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                performanceAnalyticsApi.cancelTrace((String) obj2);
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-7$lambda-6  reason: not valid java name */
        public static final void m10706setUp$lambda7$lambda6(PerformanceAnalyticsApi performanceAnalyticsApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.talabat.performance_analytics.TraceAttributeParams");
            try {
                performanceAnalyticsApi.addTraceAttribute((TraceAttributeParams) obj2);
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-9$lambda-8  reason: not valid java name */
        public static final void m10707setUp$lambda9$lambda8(PerformanceAnalyticsApi performanceAnalyticsApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.talabat.performance_analytics.TraceCounterParams");
            try {
                performanceAnalyticsApi.addTraceCounter((TraceCounterParams) obj2);
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        @NotNull
        public final MessageCodec<Object> getCodec() {
            return codec$delegate.getValue();
        }

        public final void setUp(@NotNull BinaryMessenger binaryMessenger, @Nullable PerformanceAnalyticsApi performanceAnalyticsApi) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsApi.startTrace", getCodec());
            if (performanceAnalyticsApi != null) {
                basicMessageChannel.setMessageHandler(new a(performanceAnalyticsApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsApi.endTrace", getCodec());
            if (performanceAnalyticsApi != null) {
                basicMessageChannel2.setMessageHandler(new b(performanceAnalyticsApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsApi.cancelTrace", getCodec());
            if (performanceAnalyticsApi != null) {
                basicMessageChannel3.setMessageHandler(new c(performanceAnalyticsApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsApi.addTraceAttribute", getCodec());
            if (performanceAnalyticsApi != null) {
                basicMessageChannel4.setMessageHandler(new d(performanceAnalyticsApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsApi.addTraceCounter", getCodec());
            if (performanceAnalyticsApi != null) {
                basicMessageChannel5.setMessageHandler(new e(performanceAnalyticsApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsApi.putTraceMetric", getCodec());
            if (performanceAnalyticsApi != null) {
                basicMessageChannel6.setMessageHandler(new f(performanceAnalyticsApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsApi.resetTraces", getCodec());
            if (performanceAnalyticsApi != null) {
                basicMessageChannel7.setMessageHandler(new g(performanceAnalyticsApi));
            } else {
                basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }
    }

    void addTraceAttribute(@NotNull TraceAttributeParams traceAttributeParams);

    void addTraceCounter(@NotNull TraceCounterParams traceCounterParams);

    void cancelTrace(@NotNull String str);

    void endTrace(@NotNull String str, @Nullable Map<String, String> map);

    void putTraceMetric(@NotNull TraceMetricParams traceMetricParams);

    void resetTraces();

    void startTrace(@NotNull String str);
}
