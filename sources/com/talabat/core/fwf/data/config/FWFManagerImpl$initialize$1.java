package com.talabat.core.fwf.data.config;

import com.talabat.core.fwf.data.FunWithFlagsIntegrator;
import com.talabat.core.fwf.data.FunWithFlagsIntegratorKt;
import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/core/fwf/data/FunWithFlagsIntegrator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FWFManagerImpl$initialize$1 extends Lambda implements Function1<FunWithFlagsIntegrator, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FunWithFlagsObservabilityPort f55941g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FunWithFlagsTrackingPort f55942h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FWFManagerImpl$initialize$1(FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, FunWithFlagsTrackingPort funWithFlagsTrackingPort) {
        super(1);
        this.f55941g = funWithFlagsObservabilityPort;
        this.f55942h = funWithFlagsTrackingPort;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FunWithFlagsIntegrator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FunWithFlagsIntegrator funWithFlagsIntegrator) {
        Intrinsics.checkNotNullParameter(funWithFlagsIntegrator, "$this$FunWithFlagsIntegration");
        FunWithFlagsIntegratorKt.observability(FunWithFlagsIntegratorKt.getSet(funWithFlagsIntegrator), this.f55941g);
        FunWithFlagsIntegratorKt.tracking(FunWithFlagsIntegratorKt.getSet(funWithFlagsIntegrator), this.f55942h);
    }
}
