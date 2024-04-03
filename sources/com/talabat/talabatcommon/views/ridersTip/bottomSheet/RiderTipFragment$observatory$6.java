package com.talabat.talabatcommon.views.ridersTip.bottomSheet;

import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RiderTipFragment$observatory$6 extends FunctionReferenceImpl implements Function1<Failure, Unit> {
    public RiderTipFragment$observatory$6(Object obj) {
        super(1, obj, RiderTipFragment.class, "updateFailureMessage", "updateFailureMessage(Lcom/talabat/talabatcore/exception/Failure;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Failure) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Failure failure) {
        ((RiderTipFragment) this.receiver).updateFailureMessage(failure);
    }
}
