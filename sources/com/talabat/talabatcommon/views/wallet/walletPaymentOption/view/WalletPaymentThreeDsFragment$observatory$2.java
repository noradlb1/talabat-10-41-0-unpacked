package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletThreeDSURLRedirectionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletPaymentThreeDsFragment$observatory$2 extends FunctionReferenceImpl implements Function1<WalletThreeDSURLRedirectionState, Unit> {
    public WalletPaymentThreeDsFragment$observatory$2(Object obj) {
        super(1, obj, WalletPaymentThreeDsFragment.class, "updateWalletThreeDSRedirectionState", "updateWalletThreeDSRedirectionState(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletThreeDSURLRedirectionState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletThreeDSURLRedirectionState walletThreeDSURLRedirectionState) {
        ((WalletPaymentThreeDsFragment) this.receiver).updateWalletThreeDSRedirectionState(walletThreeDSURLRedirectionState);
    }
}
