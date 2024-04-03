package com.talabat.talabatcommon.views.ramadan;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RamadanView$observatory$5 extends FunctionReferenceImpl implements Function1<RemainingTime, Unit> {
    public RamadanView$observatory$5(Object obj) {
        super(1, obj, RamadanView.class, "showRemainingTimeBeforeIftar", "showRemainingTimeBeforeIftar(Lcom/talabat/talabatcommon/views/ramadan/RemainingTime;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RemainingTime) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RemainingTime remainingTime) {
        ((RamadanView) this.receiver).showRemainingTimeBeforeIftar(remainingTime);
    }
}
