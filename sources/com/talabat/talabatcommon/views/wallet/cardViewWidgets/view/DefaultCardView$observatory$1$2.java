package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class DefaultCardView$observatory$1$2 extends FunctionReferenceImpl implements Function1<WalletCardDisplayModel, Unit> {
    public DefaultCardView$observatory$1$2(Object obj) {
        super(1, obj, DefaultCardView.class, "populateCardInformation", "populateCardInformation(Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCardDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WalletCardDisplayModel walletCardDisplayModel) {
        ((DefaultCardView) this.receiver).populateCardInformation(walletCardDisplayModel);
    }
}
