package com.talabat.wallet.ui.transactionslistheader;

import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/ui/transactionslistheader/TransactionsListHeaderDisplayModel;", "", "()V", "expiringCardDetailDisplayModel", "Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "getExpiringCardDetailDisplayModel", "()Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "setExpiringCardDetailDisplayModel", "(Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;)V", "shouldDisplayCobrandedCCBanner", "", "getShouldDisplayCobrandedCCBanner", "()Z", "setShouldDisplayCobrandedCCBanner", "(Z)V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TransactionsListHeaderDisplayModel {
    @NotNull
    private ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel = new ExpiringCardDetailDisplayModel();
    private boolean shouldDisplayCobrandedCCBanner;

    @NotNull
    public final ExpiringCardDetailDisplayModel getExpiringCardDetailDisplayModel() {
        return this.expiringCardDetailDisplayModel;
    }

    public final boolean getShouldDisplayCobrandedCCBanner() {
        return this.shouldDisplayCobrandedCCBanner;
    }

    public final void setExpiringCardDetailDisplayModel(@NotNull ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel2) {
        Intrinsics.checkNotNullParameter(expiringCardDetailDisplayModel2, "<set-?>");
        this.expiringCardDetailDisplayModel = expiringCardDetailDisplayModel2;
    }

    public final void setShouldDisplayCobrandedCCBanner(boolean z11) {
        this.shouldDisplayCobrandedCCBanner = z11;
    }
}
