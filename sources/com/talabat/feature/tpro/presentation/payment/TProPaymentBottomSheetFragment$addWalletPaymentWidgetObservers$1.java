package com.talabat.feature.tpro.presentation.payment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TProPaymentBottomSheetFragment$addWalletPaymentWidgetObservers$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public TProPaymentBottomSheetFragment$addWalletPaymentWidgetObservers$1(Object obj) {
        super(1, obj, TProPaymentBottomSheetFragment.class, "hideThePaymentWidgetLoading", "hideThePaymentWidgetLoading(Ljava/lang/Boolean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        ((TProPaymentBottomSheetFragment) this.receiver).hideThePaymentWidgetLoading(bool);
    }
}
