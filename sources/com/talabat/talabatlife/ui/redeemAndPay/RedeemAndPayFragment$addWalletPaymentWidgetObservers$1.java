package com.talabat.talabatlife.ui.redeemAndPay;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RedeemAndPayFragment$addWalletPaymentWidgetObservers$1 extends FunctionReferenceImpl implements Function1<WalletPaymentWidgetDisplayModel, Unit> {
    public RedeemAndPayFragment$addWalletPaymentWidgetObservers$1(Object obj) {
        super(1, obj, RedeemAndPayFragment.class, "updateButton", "updateButton(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletPaymentWidgetDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel) {
        ((RedeemAndPayFragment) this.receiver).updateButton(walletPaymentWidgetDisplayModel);
    }
}
