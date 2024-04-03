package com.deliveryhero.performance.core.tapresponse;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "screenSimpleName", "", "viewContainer", "Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TapResponseTimeInitializer$initialize$2 extends Lambda implements Function2<String, AndroidComponentViewContainer, Unit> {
    public static final TapResponseTimeInitializer$initialize$2 INSTANCE = new TapResponseTimeInitializer$initialize$2();

    public TapResponseTimeInitializer$initialize$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (AndroidComponentViewContainer) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull AndroidComponentViewContainer androidComponentViewContainer) {
        Intrinsics.checkNotNullParameter(str, "screenSimpleName");
        Intrinsics.checkNotNullParameter(androidComponentViewContainer, "viewContainer");
        ActionTracker.INSTANCE.reportScreenStartMetrics$core_release(str, new OnViewUpdateRunner(androidComponentViewContainer));
    }
}
