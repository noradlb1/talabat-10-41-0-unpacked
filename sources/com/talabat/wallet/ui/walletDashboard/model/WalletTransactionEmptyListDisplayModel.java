package com.talabat.wallet.ui.walletDashboard.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionEmptyListDisplayModel;", "", "()V", "shouldDisplayCobrandedCCBanner", "", "getShouldDisplayCobrandedCCBanner", "()Z", "setShouldDisplayCobrandedCCBanner", "(Z)V", "shouldShowEmptyList", "getShouldShowEmptyList", "setShouldShowEmptyList", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionEmptyListDisplayModel {
    private boolean shouldDisplayCobrandedCCBanner;
    private boolean shouldShowEmptyList;

    public final boolean getShouldDisplayCobrandedCCBanner() {
        return this.shouldDisplayCobrandedCCBanner;
    }

    public final boolean getShouldShowEmptyList() {
        return this.shouldShowEmptyList;
    }

    public final void setShouldDisplayCobrandedCCBanner(boolean z11) {
        this.shouldDisplayCobrandedCCBanner = z11;
    }

    public final void setShouldShowEmptyList(boolean z11) {
        this.shouldShowEmptyList = z11;
    }
}
