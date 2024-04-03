package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpResponseScreenState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletPaymentThreeDsFragment$observatory$3 extends FunctionReferenceImpl implements Function1<WalletTopUpResponseScreenState, Unit> {
    public WalletPaymentThreeDsFragment$observatory$3(Object obj) {
        super(1, obj, WalletPaymentThreeDsFragment.class, "updateWalletTopUpResponseScreenState", "updateWalletTopUpResponseScreenState(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpResponseScreenState;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTopUpResponseScreenState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletTopUpResponseScreenState walletTopUpResponseScreenState) {
        ((WalletPaymentThreeDsFragment) this.receiver).updateWalletTopUpResponseScreenState(walletTopUpResponseScreenState);
    }
}
