package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpButtonDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpScreenFragment$observatory$6 extends FunctionReferenceImpl implements Function1<WalletTopUpButtonDisplayModel, Unit> {
    public WalletTopUpScreenFragment$observatory$6(Object obj) {
        super(1, obj, WalletTopUpScreenFragment.class, "updateTopUpButtons", "updateTopUpButtons(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpButtonDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTopUpButtonDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletTopUpButtonDisplayModel walletTopUpButtonDisplayModel) {
        ((WalletTopUpScreenFragment) this.receiver).updateTopUpButtons(walletTopUpButtonDisplayModel);
    }
}
