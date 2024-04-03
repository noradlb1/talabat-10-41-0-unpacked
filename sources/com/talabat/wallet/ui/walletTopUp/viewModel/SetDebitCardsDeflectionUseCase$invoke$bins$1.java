package com.talabat.wallet.ui.walletTopUp.viewModel;

import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "Lkotlin/internal/NoInfer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SetDebitCardsDeflectionUseCase$invoke$bins$1 extends Lambda implements Function1<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel, CharSequence> {
    public static final SetDebitCardsDeflectionUseCase$invoke$bins$1 INSTANCE = new SetDebitCardsDeflectionUseCase$invoke$bins$1();

    public SetDebitCardsDeflectionUseCase$invoke$bins$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardAdapterDisplayModel, "it");
        return walletCardAdapterDisplayModel.getBinNumber();
    }
}
