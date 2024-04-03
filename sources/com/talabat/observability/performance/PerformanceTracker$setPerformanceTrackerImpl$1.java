package com.talabat.observability.performance;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PerformanceTracker$setPerformanceTrackerImpl$1 extends Lambda implements Function2<Throwable, String, Unit> {
    public static final PerformanceTracker$setPerformanceTrackerImpl$1 INSTANCE = new PerformanceTracker$setPerformanceTrackerImpl$1();

    public PerformanceTracker$setPerformanceTrackerImpl$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
    }
}
