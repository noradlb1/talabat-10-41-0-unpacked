package com.instabug.library.diagnostics.customtraces;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.diagnostics.customtraces.utils.b;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wc.a;

public final class IBGPendingTraceHandler {
    @NotNull
    public static final IBGPendingTraceHandler INSTANCE = new IBGPendingTraceHandler();
    private static long apmCPEndTime;
    private static long apmCPStartTime;
    private static long builderBGEndTime;
    private static long builderBGStartTime;
    private static long builderFGEndTime;
    private static long builderFGStartTime;
    private static long coreCPEndTime;
    private static long coreCPStartTime;
    private static long crashCPEndTime;
    private static long crashCPStartTime;
    private static boolean isTracesFlushed;

    private IBGPendingTraceHandler() {
    }

    /* access modifiers changed from: private */
    /* renamed from: flushTraces$lambda-2  reason: not valid java name */
    public static final void m9024flushTraces$lambda2(IBGPendingTraceHandler iBGPendingTraceHandler) {
        Intrinsics.checkNotNullParameter(iBGPendingTraceHandler, "this$0");
        synchronized (iBGPendingTraceHandler) {
            IBGPendingTraceHandler iBGPendingTraceHandler2 = INSTANCE;
            long j11 = (long) 1000;
            setCoreCPStartTime(getCoreCPStartTime() * j11);
            setCoreCPEndTime(getCoreCPEndTime() * j11);
            b bVar = b.f34240a;
            if (bVar.a("core-cp-init")) {
                IBGDiagnostics.logTrace("core-cp-init", getCoreCPStartTime(), getCoreCPEndTime());
                InstabugSDKLogger.privateVerbose("IBG-Core", "core-cp-init trace executed in " + (getCoreCPEndTime() - getCoreCPStartTime()) + " microseconds");
            }
            setCrashCPStartTime(getCrashCPStartTime() * j11);
            setCrashCPEndTime(getCrashCPEndTime() * j11);
            if (getCrashCPStartTime() != 0 && bVar.a("cr-cp-init")) {
                IBGDiagnostics.logTrace("cr-cp-init", getCrashCPStartTime(), getCrashCPEndTime());
                InstabugSDKLogger.privateVerbose("IBG-Core", "cr-cp-init trace executed in " + (getCrashCPEndTime() - getCrashCPStartTime()) + " microseconds");
            }
            setApmCPStartTime(getApmCPStartTime() * j11);
            setApmCPEndTime(getApmCPEndTime() * j11);
            if (getApmCPStartTime() != 0 && bVar.a("apm-cp-init")) {
                IBGDiagnostics.logTrace("apm-cp-init", getApmCPStartTime(), getApmCPEndTime());
                InstabugSDKLogger.privateVerbose("IBG-Core", "apm-cp-init trace executed in " + (getApmCPEndTime() - getApmCPStartTime()) + " microseconds");
            }
            if (bVar.a("builder-main")) {
                setBuilderFGStartTime(getBuilderFGStartTime() * j11);
                setBuilderFGEndTime(getBuilderFGEndTime() * j11);
                IBGDiagnostics.logTrace("builder-main", iBGPendingTraceHandler2.getFGStartTime(), iBGPendingTraceHandler2.getFGEndTime());
                InstabugSDKLogger.privateVerbose("IBG-Core", "builder-main trace executed in " + (iBGPendingTraceHandler2.getFGEndTime() - iBGPendingTraceHandler2.getFGStartTime()) + " microseconds");
            }
            if (getBuilderBGEndTime() != 0 && bVar.a("builder-bg")) {
                setBuilderBGStartTime(getBuilderBGStartTime() * j11);
                IBGDiagnostics.logTrace("builder-bg", getBuilderBGStartTime(), getBuilderBGEndTime() * j11);
                InstabugSDKLogger.privateVerbose("IBG-Core", "builder-bg trace executed in " + ((getBuilderBGEndTime() * j11) - getBuilderBGStartTime()) + " microseconds");
            }
            iBGPendingTraceHandler2.setTracesFlushed(true);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final long getApmCPEndTime() {
        return apmCPEndTime;
    }

    @JvmStatic
    public static /* synthetic */ void getApmCPEndTime$annotations() {
    }

    public static final long getApmCPStartTime() {
        return apmCPStartTime;
    }

    @JvmStatic
    public static /* synthetic */ void getApmCPStartTime$annotations() {
    }

    public static final long getBuilderBGEndTime() {
        return builderBGEndTime;
    }

    @JvmStatic
    public static /* synthetic */ void getBuilderBGEndTime$annotations() {
    }

    public static final long getBuilderBGStartTime() {
        return builderBGStartTime;
    }

    @JvmStatic
    public static /* synthetic */ void getBuilderBGStartTime$annotations() {
    }

    public static final long getBuilderFGEndTime() {
        return builderFGEndTime;
    }

    @JvmStatic
    public static /* synthetic */ void getBuilderFGEndTime$annotations() {
    }

    public static final long getBuilderFGStartTime() {
        return builderFGStartTime;
    }

    @JvmStatic
    public static /* synthetic */ void getBuilderFGStartTime$annotations() {
    }

    public static final long getCoreCPEndTime() {
        return coreCPEndTime;
    }

    @JvmStatic
    public static /* synthetic */ void getCoreCPEndTime$annotations() {
    }

    public static final long getCoreCPStartTime() {
        return coreCPStartTime;
    }

    @JvmStatic
    public static /* synthetic */ void getCoreCPStartTime$annotations() {
    }

    public static final long getCrashCPEndTime() {
        return crashCPEndTime;
    }

    @JvmStatic
    public static /* synthetic */ void getCrashCPEndTime$annotations() {
    }

    public static final long getCrashCPStartTime() {
        return crashCPStartTime;
    }

    @JvmStatic
    public static /* synthetic */ void getCrashCPStartTime$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isTracesFlushed$annotations() {
    }

    public static final void setApmCPEndTime(long j11) {
        apmCPEndTime = j11;
    }

    public static final void setApmCPStartTime(long j11) {
        apmCPStartTime = j11;
    }

    public static final void setBuilderBGEndTime(long j11) {
        IBGPendingTraceHandler iBGPendingTraceHandler = INSTANCE;
        synchronized (iBGPendingTraceHandler) {
            builderBGEndTime = j11;
            if (Instabug.isEnabled() && b.f34240a.a("builder-bg")) {
                long j12 = (long) 1000;
                setBuilderBGStartTime(getBuilderBGStartTime() * j12);
                builderBGEndTime *= j12;
                IBGDiagnostics.logTrace("builder-bg", getBuilderBGStartTime(), builderBGEndTime);
                InstabugSDKLogger.privateVerbose("IBG-Core", "builder-bg trace executed in " + (builderBGEndTime - getBuilderBGStartTime()) + " microseconds");
                builderBGEndTime = 0;
                iBGPendingTraceHandler.flushTraces();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void setBuilderBGStartTime(long j11) {
        builderBGStartTime = j11;
    }

    public static final void setBuilderFGEndTime(long j11) {
        builderFGEndTime = j11;
    }

    public static final void setBuilderFGStartTime(long j11) {
        builderFGStartTime = j11;
    }

    public static final void setCoreCPEndTime(long j11) {
        coreCPEndTime = j11;
    }

    public static final void setCoreCPStartTime(long j11) {
        coreCPStartTime = j11;
    }

    public static final void setCrashCPEndTime(long j11) {
        crashCPEndTime = j11;
    }

    public static final void setCrashCPStartTime(long j11) {
        crashCPStartTime = j11;
    }

    public final void flushTraces() {
        if (Instabug.isEnabled() && !isTracesFlushed) {
            InstabugSDKLogger.v("IBG-Core", "Instabug enabled, flushing launch traces");
            PoolProvider.postIOTask(new a(this));
        }
    }

    @VisibleForTesting
    public final long getFGEndTime() {
        long j11;
        long j12 = coreCPEndTime - coreCPStartTime;
        long j13 = builderFGEndTime - builderFGStartTime;
        long j14 = crashCPStartTime;
        long j15 = 0;
        if (j14 != 0) {
            j11 = crashCPEndTime - j14;
        } else {
            j11 = 0;
        }
        long j16 = apmCPStartTime;
        if (j16 != 0) {
            j15 = apmCPEndTime - j16;
        }
        return getFGStartTime() + j11 + j15 + j12 + j13;
    }

    @VisibleForTesting
    public final long getFGStartTime() {
        long j11 = crashCPStartTime;
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0 && apmCPStartTime == 0) {
            return coreCPStartTime;
        }
        if (i11 == 0) {
            return Math.min(coreCPStartTime, apmCPStartTime);
        }
        if (apmCPStartTime == 0) {
            return Math.min(coreCPStartTime, j11);
        }
        return Math.min(Math.min(coreCPStartTime, j11), apmCPStartTime);
    }

    public final boolean isTracesFlushed() {
        return isTracesFlushed;
    }

    public final void setTracesFlushed(boolean z11) {
        isTracesFlushed = z11;
    }
}
