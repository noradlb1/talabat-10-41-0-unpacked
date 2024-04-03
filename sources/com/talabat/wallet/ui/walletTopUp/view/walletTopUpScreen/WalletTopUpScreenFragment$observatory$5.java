package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpScreenFragment$observatory$5 extends FunctionReferenceImpl implements Function1<Failure, Unit> {
    public WalletTopUpScreenFragment$observatory$5(Object obj) {
        super(1, obj, WalletTopUpScreenFragment.class, "onWalletPaymentError", "onWalletPaymentError(Lcom/talabat/talabatcore/exception/Failure;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Failure) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Failure failure) {
        ((WalletTopUpScreenFragment) this.receiver).onWalletPaymentError(failure);
    }
}
