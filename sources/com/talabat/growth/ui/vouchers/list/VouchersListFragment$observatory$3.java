package com.talabat.growth.ui.vouchers.list;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VouchersListFragment$observatory$3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public VouchersListFragment$observatory$3(Object obj) {
        super(1, obj, VouchersListFragment.class, "successRedeemPromoCode", "successRedeemPromoCode(Ljava/lang/Boolean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        ((VouchersListFragment) this.receiver).successRedeemPromoCode(bool);
    }
}
