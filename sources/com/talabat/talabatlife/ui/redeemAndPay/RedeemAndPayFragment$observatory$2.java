package com.talabat.talabatlife.ui.redeemAndPay;

import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemAndPayDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RedeemAndPayFragment$observatory$2 extends FunctionReferenceImpl implements Function1<RedeemAndPayDisplayModel, Unit> {
    public RedeemAndPayFragment$observatory$2(Object obj) {
        super(1, obj, RedeemAndPayFragment.class, "updateTransactionDetails", "updateTransactionDetails(Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RedeemAndPayDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RedeemAndPayDisplayModel redeemAndPayDisplayModel) {
        ((RedeemAndPayFragment) this.receiver).updateTransactionDetails(redeemAndPayDisplayModel);
    }
}
