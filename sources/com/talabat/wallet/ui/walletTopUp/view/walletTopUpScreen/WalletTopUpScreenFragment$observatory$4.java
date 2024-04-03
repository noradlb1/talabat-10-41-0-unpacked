package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpScreenFragment$observatory$4 extends FunctionReferenceImpl implements Function1<WalletPaymentDisplayModel, Unit> {
    public WalletTopUpScreenFragment$observatory$4(Object obj) {
        super(1, obj, WalletTopUpScreenFragment.class, "updatePaymentStatus", "updatePaymentStatus(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletPaymentDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletPaymentDisplayModel walletPaymentDisplayModel) {
        ((WalletTopUpScreenFragment) this.receiver).updatePaymentStatus(walletPaymentDisplayModel);
    }
}
