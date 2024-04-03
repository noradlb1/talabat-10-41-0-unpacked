package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletSuggestionButtonsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpScreenFragment$observatory$7 extends FunctionReferenceImpl implements Function1<WalletSuggestionButtonsDisplayModel, Unit> {
    public WalletTopUpScreenFragment$observatory$7(Object obj) {
        super(1, obj, WalletTopUpScreenFragment.class, "updateSuggestionButtons", "updateSuggestionButtons(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletSuggestionButtonsDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletSuggestionButtonsDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletSuggestionButtonsDisplayModel walletSuggestionButtonsDisplayModel) {
        ((WalletTopUpScreenFragment) this.receiver).updateSuggestionButtons(walletSuggestionButtonsDisplayModel);
    }
}
