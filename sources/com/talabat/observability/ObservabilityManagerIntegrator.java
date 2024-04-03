package com.talabat.observability;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/talabat/observability/ObservabilityManagerIntegrator;", "", "()V", "perseusClientId", "Lkotlin/Function0;", "", "getPerseusClientId", "()Lkotlin/jvm/functions/Function0;", "setPerseusClientId", "(Lkotlin/jvm/functions/Function0;)V", "perseusSessionId", "getPerseusSessionId", "setPerseusSessionId", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservabilityManagerIntegrator {
    @NotNull
    public static final ObservabilityManagerIntegrator INSTANCE = new ObservabilityManagerIntegrator();
    @NotNull
    private static Function0<String> perseusClientId = ObservabilityManagerIntegrator$perseusClientId$1.INSTANCE;
    @NotNull
    private static Function0<String> perseusSessionId = ObservabilityManagerIntegrator$perseusSessionId$1.INSTANCE;

    private ObservabilityManagerIntegrator() {
    }

    @NotNull
    public final Function0<String> getPerseusClientId() {
        return perseusClientId;
    }

    @NotNull
    public final Function0<String> getPerseusSessionId() {
        return perseusSessionId;
    }

    public final void setPerseusClientId(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        perseusClientId = function0;
    }

    public final void setPerseusSessionId(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        perseusSessionId = function0;
    }
}
