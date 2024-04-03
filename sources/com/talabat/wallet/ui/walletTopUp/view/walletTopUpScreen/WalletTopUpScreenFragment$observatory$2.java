package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import com.talabat.wallet.ui.walletTopUp.model.WalletCalculateCashBackDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpScreenFragment$observatory$2 extends FunctionReferenceImpl implements Function1<WalletCalculateCashBackDisplayModel, Unit> {
    public WalletTopUpScreenFragment$observatory$2(Object obj) {
        super(1, obj, WalletTopUpScreenFragment.class, "updateCalculatedCashBack", "updateCalculatedCashBack(Lcom/talabat/wallet/ui/walletTopUp/model/WalletCalculateCashBackDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCalculateCashBackDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletCalculateCashBackDisplayModel walletCalculateCashBackDisplayModel) {
        ((WalletTopUpScreenFragment) this.receiver).updateCalculatedCashBack(walletCalculateCashBackDisplayModel);
    }
}
