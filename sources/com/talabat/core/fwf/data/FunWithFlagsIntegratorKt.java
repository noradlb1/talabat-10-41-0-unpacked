package com.talabat.core.fwf.data;

import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016H\u0007\u001a\u0015\u0010\u0017\u001a\u00020\u0013*\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0001H\u0004\u001a\u0015\u0010\u0018\u001a\u00020\u0013*\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H\u0004\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\"\u001e\u0010\f\u001a\u00020\r*\u00020\r8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Observability", "Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "getObservability", "()Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "setObservability", "(Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;)V", "Tracker", "Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;", "getTracker", "()Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;", "setTracker", "(Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;)V", "set", "Lcom/talabat/core/fwf/data/FunWithFlagsIntegrator;", "getSet$annotations", "(Lcom/talabat/core/fwf/data/FunWithFlagsIntegrator;)V", "getSet", "(Lcom/talabat/core/fwf/data/FunWithFlagsIntegrator;)Lcom/talabat/core/fwf/data/FunWithFlagsIntegrator;", "FunWithFlagsIntegration", "", "integration", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "observability", "tracking", "tracker", "com_talabat_core_fwf_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FunWithFlagsIntegratorKt {
    @Nullable
    private static FunWithFlagsObservabilityPort Observability;
    @Nullable
    private static FunWithFlagsTrackingPort Tracker;

    @IntegrationDsl
    public static final void FunWithFlagsIntegration(@NotNull Function1<? super FunWithFlagsIntegrator, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "integration");
        function1.invoke(new FunWithFlagsIntegrator());
    }

    @Nullable
    public static final FunWithFlagsObservabilityPort getObservability() {
        return Observability;
    }

    @NotNull
    public static final FunWithFlagsIntegrator getSet(@NotNull FunWithFlagsIntegrator funWithFlagsIntegrator) {
        Intrinsics.checkNotNullParameter(funWithFlagsIntegrator, "<this>");
        return funWithFlagsIntegrator;
    }

    @IntegrationDsl
    public static /* synthetic */ void getSet$annotations(FunWithFlagsIntegrator funWithFlagsIntegrator) {
    }

    @Nullable
    public static final FunWithFlagsTrackingPort getTracker() {
        return Tracker;
    }

    @IntegrationDsl
    public static final void observability(@NotNull FunWithFlagsIntegrator funWithFlagsIntegrator, @NotNull FunWithFlagsObservabilityPort funWithFlagsObservabilityPort) {
        Intrinsics.checkNotNullParameter(funWithFlagsIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(funWithFlagsObservabilityPort, "observability");
        Observability = funWithFlagsObservabilityPort;
    }

    public static final void setObservability(@Nullable FunWithFlagsObservabilityPort funWithFlagsObservabilityPort) {
        Observability = funWithFlagsObservabilityPort;
    }

    public static final void setTracker(@Nullable FunWithFlagsTrackingPort funWithFlagsTrackingPort) {
        Tracker = funWithFlagsTrackingPort;
    }

    @IntegrationDsl
    public static final void tracking(@NotNull FunWithFlagsIntegrator funWithFlagsIntegrator, @NotNull FunWithFlagsTrackingPort funWithFlagsTrackingPort) {
        Intrinsics.checkNotNullParameter(funWithFlagsIntegrator, "<this>");
        Intrinsics.checkNotNullParameter(funWithFlagsTrackingPort, "tracker");
        Tracker = funWithFlagsTrackingPort;
    }
}
