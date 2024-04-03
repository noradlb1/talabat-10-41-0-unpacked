package com.talabat.wallet.ui.walletTopUp.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCalculateCashBackDisplayModel;", "", "()V", "amount", "", "getAmount", "()F", "setAmount", "(F)V", "isCampaignActive", "", "()Z", "setCampaignActive", "(Z)V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCalculateCashBackDisplayModel {
    private float amount;
    private boolean isCampaignActive;

    public final float getAmount() {
        return this.amount;
    }

    public final boolean isCampaignActive() {
        return this.isCampaignActive;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setCampaignActive(boolean z11) {
        this.isCampaignActive = z11;
    }
}
