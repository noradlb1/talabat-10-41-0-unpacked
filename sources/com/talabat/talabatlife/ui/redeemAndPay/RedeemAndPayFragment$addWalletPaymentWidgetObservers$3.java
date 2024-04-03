package com.talabat.talabatlife.ui.redeemAndPay;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletVerifyQRCodeDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RedeemAndPayFragment$addWalletPaymentWidgetObservers$3 extends FunctionReferenceImpl implements Function1<WalletVerifyQRCodeDisplayModel, Unit> {
    public RedeemAndPayFragment$addWalletPaymentWidgetObservers$3(Object obj) {
        super(1, obj, RedeemAndPayFragment.class, "updateWalletQRCodeStatus", "updateWalletQRCodeStatus(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletVerifyQRCodeDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletVerifyQRCodeDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletVerifyQRCodeDisplayModel walletVerifyQRCodeDisplayModel) {
        ((RedeemAndPayFragment) this.receiver).updateWalletQRCodeStatus(walletVerifyQRCodeDisplayModel);
    }
}
