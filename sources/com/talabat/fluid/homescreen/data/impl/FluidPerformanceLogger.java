package com.talabat.fluid.homescreen.data.impl;

import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.facebook.internal.NativeProtocol;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJM\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00110\u0010H\u0016¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0005H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/fluid/homescreen/data/impl/FluidPerformanceLogger;", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "tag", "", "minimumLevel", "Lcom/deliveryhero/fluid/telemetry/log/LogLevel;", "performanceLogger", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "(Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/LogLevel;Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;)V", "log", "", "level", "message", "throwable", "", "params", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;[Lkotlin/Pair;)V", "toObservabilityLevel", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability$Level;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidPerformanceLogger extends Logger {
    @NotNull
    private final HomeScreenPerformanceObservability performanceLogger;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            iArr[LogLevel.DEBUG.ordinal()] = 1;
            iArr[LogLevel.INFO.ordinal()] = 2;
            iArr[LogLevel.WARNING.ordinal()] = 3;
            iArr[LogLevel.ERROR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidPerformanceLogger(@NotNull String str, @NotNull LogLevel logLevel, @NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability) {
        super(str, logLevel);
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "minimumLevel");
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability, "performanceLogger");
        this.performanceLogger = homeScreenPerformanceObservability;
    }

    private final HomeScreenPerformanceObservability.Level toObservabilityLevel(LogLevel logLevel) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[logLevel.ordinal()];
        if (i11 == 1) {
            return HomeScreenPerformanceObservability.Level.DEBUG;
        }
        if (i11 == 2) {
            return HomeScreenPerformanceObservability.Level.INFO;
        }
        if (i11 == 3) {
            return HomeScreenPerformanceObservability.Level.WARNING;
        }
        if (i11 == 4) {
            return HomeScreenPerformanceObservability.Level.ERROR;
        }
        throw new NoWhenBranchMatchedException();
    }

    public void log(@NotNull String str, @NotNull LogLevel logLevel, @NotNull String str2, @Nullable Throwable th2, @NotNull Pair<String, ? extends Object>[] pairArr) {
        String str3;
        LogLevel logLevel2 = logLevel;
        Pair<String, ? extends Object>[] pairArr2 = pairArr;
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(logLevel2, "level");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "message");
        Intrinsics.checkNotNullParameter(pairArr2, NativeProtocol.WEB_DIALOG_PARAMS);
        HomeScreenPerformanceObservability homeScreenPerformanceObservability = this.performanceLogger;
        HomeScreenPerformanceObservability.Level observabilityLevel = toObservabilityLevel(logLevel2);
        String replace$default = StringsKt__StringsJVMKt.replace$default(str4, '_', '.', false, 4, (Object) null);
        Pair[] pairArr3 = new Pair[2];
        if (th2 != null) {
            str3 = th2.getMessage();
        } else {
            str3 = null;
        }
        String str5 = "";
        if (str3 == null) {
            str3 = str5;
        }
        boolean z11 = false;
        pairArr3[0] = TuplesKt.to("error", str3);
        if (pairArr2.length == 0) {
            z11 = true;
        }
        if (!z11) {
            str5 = ArraysKt___ArraysKt.joinToString$default((Object[]) pairArr, (CharSequence) ",\n", (CharSequence) "Params {\n", (CharSequence) "\n}", 0, (CharSequence) null, (Function1) FluidPerformanceLogger$log$$inlined$getAsString$1.INSTANCE, 24, (Object) null);
        }
        pairArr3[1] = TuplesKt.to("data", str5);
        homeScreenPerformanceObservability.traceEvent(observabilityLevel, replace$default, MapsKt__MapsKt.mapOf(pairArr3));
    }
}
