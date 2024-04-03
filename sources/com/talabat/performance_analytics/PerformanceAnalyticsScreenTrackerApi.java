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
import ys.j;
import ys.k;
import ys.l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsScreenTrackerApi;", "", "cancelScreenTrace", "", "traceName", "", "endScreenTrace", "attributes", "", "startScreenTrace", "params", "Lcom/talabat/performance_analytics/StartScreenTraceParams;", "Companion", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerformanceAnalyticsScreenTrackerApi {
    @NotNull
    public static final Companion Companion = Companion.f61181a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR#\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsScreenTrackerApi$Companion;", "", "()V", "codec", "Lio/flutter/plugin/common/MessageCodec;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lkotlin/Lazy;", "setUp", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "api", "Lcom/talabat/performance_analytics/PerformanceAnalyticsScreenTrackerApi;", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f61181a = new Companion();
        @NotNull
        private static final Lazy<PerformanceAnalyticsScreenTrackerApiCodec> codec$delegate = LazyKt__LazyJVMKt.lazy(PerformanceAnalyticsScreenTrackerApi$Companion$codec$2.INSTANCE);

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-1$lambda-0  reason: not valid java name */
        public static final void m10710setUp$lambda1$lambda0(PerformanceAnalyticsScreenTrackerApi performanceAnalyticsScreenTrackerApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.talabat.performance_analytics.StartScreenTraceParams");
            try {
                performanceAnalyticsScreenTrackerApi.startScreenTrace((StartScreenTraceParams) obj2);
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-3$lambda-2  reason: not valid java name */
        public static final void m10711setUp$lambda3$lambda2(PerformanceAnalyticsScreenTrackerApi performanceAnalyticsScreenTrackerApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                performanceAnalyticsScreenTrackerApi.endScreenTrace((String) obj2, (Map) list2.get(1));
                list = CollectionsKt__CollectionsJVMKt.listOf(null);
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-5$lambda-4  reason: not valid java name */
        public static final void m10712setUp$lambda5$lambda4(PerformanceAnalyticsScreenTrackerApi performanceAnalyticsScreenTrackerApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                performanceAnalyticsScreenTrackerApi.cancelScreenTrace((String) obj2);
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

        public final void setUp(@NotNull BinaryMessenger binaryMessenger, @Nullable PerformanceAnalyticsScreenTrackerApi performanceAnalyticsScreenTrackerApi) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsScreenTrackerApi.startScreenTrace", getCodec());
            if (performanceAnalyticsScreenTrackerApi != null) {
                basicMessageChannel.setMessageHandler(new j(performanceAnalyticsScreenTrackerApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsScreenTrackerApi.endScreenTrace", getCodec());
            if (performanceAnalyticsScreenTrackerApi != null) {
                basicMessageChannel2.setMessageHandler(new k(performanceAnalyticsScreenTrackerApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsScreenTrackerApi.cancelScreenTrace", getCodec());
            if (performanceAnalyticsScreenTrackerApi != null) {
                basicMessageChannel3.setMessageHandler(new l(performanceAnalyticsScreenTrackerApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }
    }

    void cancelScreenTrace(@NotNull String str);

    void endScreenTrace(@NotNull String str, @Nullable Map<String, String> map);

    void startScreenTrace(@NotNull StartScreenTraceParams startScreenTraceParams);
}
