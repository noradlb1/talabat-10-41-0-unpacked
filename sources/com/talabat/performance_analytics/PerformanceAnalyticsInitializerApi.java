package com.talabat.performance_analytics;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ys.i;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsInitializerApi;", "", "initialize", "", "params", "Lcom/talabat/performance_analytics/InitializeParams;", "Companion", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PerformanceAnalyticsInitializerApi {
    @NotNull
    public static final Companion Companion = Companion.f61180a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR#\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsInitializerApi$Companion;", "", "()V", "codec", "Lio/flutter/plugin/common/MessageCodec;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lkotlin/Lazy;", "setUp", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "api", "Lcom/talabat/performance_analytics/PerformanceAnalyticsInitializerApi;", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f61180a = new Companion();
        @NotNull
        private static final Lazy<PerformanceAnalyticsInitializerApiCodec> codec$delegate = LazyKt__LazyJVMKt.lazy(PerformanceAnalyticsInitializerApi$Companion$codec$2.INSTANCE);

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-1$lambda-0  reason: not valid java name */
        public static final void m10709setUp$lambda1$lambda0(PerformanceAnalyticsInitializerApi performanceAnalyticsInitializerApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.talabat.performance_analytics.InitializeParams");
            try {
                list = CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(performanceAnalyticsInitializerApi.initialize((InitializeParams) obj2)));
            } catch (Throwable th2) {
                list = PerformanceAnalyticsApi_gKt.wrapError(th2);
            }
            reply.reply(list);
        }

        @NotNull
        public final MessageCodec<Object> getCodec() {
            return codec$delegate.getValue();
        }

        public final void setUp(@NotNull BinaryMessenger binaryMessenger, @Nullable PerformanceAnalyticsInitializerApi performanceAnalyticsInitializerApi) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.PerformanceAnalyticsInitializerApi.initialize", getCodec());
            if (performanceAnalyticsInitializerApi != null) {
                basicMessageChannel.setMessageHandler(new i(performanceAnalyticsInitializerApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }
    }

    boolean initialize(@NotNull InitializeParams initializeParams);
}
