package com.talabat.wallet.ui.walletDashboard.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletDashBoardIconsDisplayModel;", "", "()V", "shouldShowCardManagementIcon", "", "getShouldShowCardManagementIcon", "()Z", "setShouldShowCardManagementIcon", "(Z)V", "shouldShowMoreIcon", "getShouldShowMoreIcon", "setShouldShowMoreIcon", "shouldShowSendGiftIcon", "getShouldShowSendGiftIcon", "setShouldShowSendGiftIcon", "shouldShowTopUpIcon", "getShouldShowTopUpIcon", "setShouldShowTopUpIcon", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashBoardIconsDisplayModel {
    private boolean shouldShowCardManagementIcon;
    private boolean shouldShowMoreIcon;
    private boolean shouldShowSendGiftIcon;
    private boolean shouldShowTopUpIcon;

    public final boolean getShouldShowCardManagementIcon() {
        return this.shouldShowCardManagementIcon;
    }

    public final boolean getShouldShowMoreIcon() {
        return this.shouldShowMoreIcon;
    }

    public final boolean getShouldShowSendGiftIcon() {
        return this.shouldShowSendGiftIcon;
    }

    public final boolean getShouldShowTopUpIcon() {
        return this.shouldShowTopUpIcon;
    }

    public final void setShouldShowCardManagementIcon(boolean z11) {
        this.shouldShowCardManagementIcon = z11;
    }

    public final void setShouldShowMoreIcon(boolean z11) {
        this.shouldShowMoreIcon = z11;
    }

    public final void setShouldShowSendGiftIcon(boolean z11) {
        this.shouldShowSendGiftIcon = z11;
    }

    public final void setShouldShowTopUpIcon(boolean z11) {
        this.shouldShowTopUpIcon = z11;
    }
}
