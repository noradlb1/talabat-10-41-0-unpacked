package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.VerifyWalletTransactionDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletPaymentThreeDsFragment$observatory$1 extends FunctionReferenceImpl implements Function1<VerifyWalletTransactionDisplayModel, Unit> {
    public WalletPaymentThreeDsFragment$observatory$1(Object obj) {
        super(1, obj, WalletPaymentThreeDsFragment.class, "navigateToTransactionResponseScreen", "navigateToTransactionResponseScreen(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/VerifyWalletTransactionDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VerifyWalletTransactionDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VerifyWalletTransactionDisplayModel verifyWalletTransactionDisplayModel) {
        ((WalletPaymentThreeDsFragment) this.receiver).navigateToTransactionResponseScreen(verifyWalletTransactionDisplayModel);
    }
}
