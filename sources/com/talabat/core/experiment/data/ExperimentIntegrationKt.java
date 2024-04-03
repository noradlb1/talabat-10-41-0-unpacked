package com.talabat.core.experiment.data;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\r\u001a\u00020\u00032\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u000fH\u0007\u001a!\u0010\u0004\u001a\u00020\u0003*\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0004\"6\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\b*\u00020\b8FX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"<set-?>", "Lkotlin/Function1;", "", "", "logError", "getLogError", "()Lkotlin/jvm/functions/Function1;", "set", "Lcom/talabat/core/experiment/data/ExperimentIntegration;", "getSet$annotations", "(Lcom/talabat/core/experiment/data/ExperimentIntegration;)V", "getSet", "(Lcom/talabat/core/experiment/data/ExperimentIntegration;)Lcom/talabat/core/experiment/data/ExperimentIntegration;", "ExperimentIntegration", "integration", "Lkotlin/ExtensionFunctionType;", "logger", "com_talabat_core_experiment_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExperimentIntegrationKt {
    @NotNull
    private static Function1<? super Throwable, Unit> logError = ExperimentIntegrationKt$logError$1.INSTANCE;

    @ExperimentIntegrationDsl
    public static final void ExperimentIntegration(@NotNull Function1<? super ExperimentIntegration, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "integration");
        function1.invoke(ExperimentIntegration.INSTANCE);
    }

    @NotNull
    public static final Function1<Throwable, Unit> getLogError() {
        return logError;
    }

    @NotNull
    public static final ExperimentIntegration getSet(@NotNull ExperimentIntegration experimentIntegration) {
        Intrinsics.checkNotNullParameter(experimentIntegration, "<this>");
        return experimentIntegration;
    }

    @ExperimentIntegrationDsl
    public static /* synthetic */ void getSet$annotations(ExperimentIntegration experimentIntegration) {
    }

    @ExperimentIntegrationDsl
    public static final void logError(@NotNull ExperimentIntegration experimentIntegration, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(experimentIntegration, "<this>");
        Intrinsics.checkNotNullParameter(function1, "logger");
        logError = function1;
    }
}
