package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletSuggestionButtonsDisplayModel;", "", "resetAllSuggestionButtons", "", "(Z)V", "getResetAllSuggestionButtons", "()Z", "setResetAllSuggestionButtons", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletSuggestionButtonsDisplayModel {
    private boolean resetAllSuggestionButtons;

    public WalletSuggestionButtonsDisplayModel() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public WalletSuggestionButtonsDisplayModel(boolean z11) {
        this.resetAllSuggestionButtons = z11;
    }

    public final boolean getResetAllSuggestionButtons() {
        return this.resetAllSuggestionButtons;
    }

    public final void setResetAllSuggestionButtons(boolean z11) {
        this.resetAllSuggestionButtons = z11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletSuggestionButtonsDisplayModel(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11);
    }
}
