package com.talabat.wallet.screens.walletTopUp.view;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpScreen$onCreate$1 extends FunctionReferenceImpl implements Function1<WalletPaymentDisplayModel, Unit> {
    public WalletTopUpScreen$onCreate$1(Object obj) {
        super(1, obj, WalletTopUpScreen.class, "updatePaymentStatus", "updatePaymentStatus(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletPaymentDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletPaymentDisplayModel walletPaymentDisplayModel) {
        ((WalletTopUpScreen) this.receiver).updatePaymentStatus(walletPaymentDisplayModel);
    }
}
