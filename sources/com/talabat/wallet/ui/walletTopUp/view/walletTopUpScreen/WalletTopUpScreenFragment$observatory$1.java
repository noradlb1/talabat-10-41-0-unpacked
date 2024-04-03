package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpSuggestionsAndLimitsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTopUpScreenFragment$observatory$1 extends FunctionReferenceImpl implements Function1<WalletTopUpSuggestionsAndLimitsDisplayModel, Unit> {
    public WalletTopUpScreenFragment$observatory$1(Object obj) {
        super(1, obj, WalletTopUpScreenFragment.class, "updateWalletTopUpSuggestionAndLimits", "updateWalletTopUpSuggestionAndLimits(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpSuggestionsAndLimitsDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTopUpSuggestionsAndLimitsDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletTopUpSuggestionsAndLimitsDisplayModel walletTopUpSuggestionsAndLimitsDisplayModel) {
        ((WalletTopUpScreenFragment) this.receiver).updateWalletTopUpSuggestionAndLimits(walletTopUpSuggestionsAndLimitsDisplayModel);
    }
}
