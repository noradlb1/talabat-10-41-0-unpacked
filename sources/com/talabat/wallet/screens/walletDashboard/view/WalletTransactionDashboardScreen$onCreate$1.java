package com.talabat.wallet.screens.walletDashboard.view;

import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class WalletTransactionDashboardScreen$onCreate$1 extends FunctionReferenceImpl implements Function1<ExpiringCardDetailDisplayModel, Unit> {
    public WalletTransactionDashboardScreen$onCreate$1(Object obj) {
        super(1, obj, WalletTransactionDashboardScreen.class, "updateAdapter", "updateAdapter(Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ExpiringCardDetailDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel) {
        ((WalletTransactionDashboardScreen) this.receiver).updateAdapter(expiringCardDetailDisplayModel);
    }
}
