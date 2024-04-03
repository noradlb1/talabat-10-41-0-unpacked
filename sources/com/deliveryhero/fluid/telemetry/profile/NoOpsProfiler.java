package com.deliveryhero.fluid.telemetry.profile;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/profile/NoOpsProfiler;", "Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "()V", "trace", "ResultT", "tag", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NoOpsProfiler implements Profiler {
    public <ResultT> ResultT trace(@NotNull String str, @NotNull Function0<? extends ResultT> function0) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function0, "block");
        return function0.invoke();
    }
}
