package com.checkout.frames.usecase;

import com.checkout.base.usecase.UseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/checkout/frames/usecase/ClosePaymentFlowUseCase;", "Lcom/checkout/base/usecase/UseCase;", "", "onClose", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "execute", "data", "(Lkotlin/Unit;)V", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClosePaymentFlowUseCase implements UseCase<Unit, Unit> {
    @NotNull
    private final Function0<Unit> onClose;

    public ClosePaymentFlowUseCase(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClose");
        this.onClose = function0;
    }

    public /* bridge */ /* synthetic */ Object execute(Object obj) {
        execute((Unit) obj);
        return Unit.INSTANCE;
    }

    public void execute(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "data");
        this.onClose.invoke();
    }
}
