package com.talabat.wallet.ui.walletTopUp.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCashBackCampaignOfferDisplayModel;", "", "()V", "adapterPosition", "", "getAdapterPosition", "()I", "setAdapterPosition", "(I)V", "campaignText", "", "getCampaignText", "()Ljava/lang/String;", "setCampaignText", "(Ljava/lang/String;)V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCashBackCampaignOfferDisplayModel {
    private int adapterPosition = -1;
    @NotNull
    private String campaignText = StringUtils.empty(StringCompanionObject.INSTANCE);

    public final int getAdapterPosition() {
        return this.adapterPosition;
    }

    @NotNull
    public final String getCampaignText() {
        return this.campaignText;
    }

    public final void setAdapterPosition(int i11) {
        this.adapterPosition = i11;
    }

    public final void setCampaignText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.campaignText = str;
    }
}
