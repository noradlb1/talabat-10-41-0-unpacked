package com.talabat.talabatlife.ui.redeemAndPay;

import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemOfferDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RedeemAndPayFragment$observatory$3 extends FunctionReferenceImpl implements Function1<RedeemOfferDisplayModel, Unit> {
    public RedeemAndPayFragment$observatory$3(Object obj) {
        super(1, obj, RedeemAndPayFragment.class, "updateRedeemOfferDetails", "updateRedeemOfferDetails(Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemOfferDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RedeemOfferDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RedeemOfferDisplayModel redeemOfferDisplayModel) {
        ((RedeemAndPayFragment) this.receiver).updateRedeemOfferDetails(redeemOfferDisplayModel);
    }
}
