package com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel;

import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1$deflectionInfoDisplayModel$1 extends Lambda implements Function1<WalletCardDisplayModel, CharSequence> {
    public static final CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1$deflectionInfoDisplayModel$1 INSTANCE = new CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1$deflectionInfoDisplayModel$1();

    public CardViewWidgetsViewModelImpl$getDebitCardsDeflectionInfo$1$deflectionInfoDisplayModel$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull WalletCardDisplayModel walletCardDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "it");
        return walletCardDisplayModel.getBinNumber();
    }
}
