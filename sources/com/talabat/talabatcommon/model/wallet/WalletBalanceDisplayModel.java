package com.talabat.talabatcommon.model.wallet;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "", "()V", "amountCurrency", "", "getAmountCurrency", "()Ljava/lang/String;", "setAmountCurrency", "(Ljava/lang/String;)V", "isWalletBalanceLoaded", "", "()Z", "setWalletBalanceLoaded", "(Z)V", "serverErrorMessage", "getServerErrorMessage", "setServerErrorMessage", "walletBalance", "", "getWalletBalance", "()F", "setWalletBalance", "(F)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceDisplayModel {
    @NotNull
    private String amountCurrency = "";
    private boolean isWalletBalanceLoaded;
    @NotNull
    private String serverErrorMessage = "";
    private float walletBalance;

    @NotNull
    public final String getAmountCurrency() {
        return this.amountCurrency;
    }

    @NotNull
    public final String getServerErrorMessage() {
        return this.serverErrorMessage;
    }

    public final float getWalletBalance() {
        return this.walletBalance;
    }

    public final boolean isWalletBalanceLoaded() {
        return this.isWalletBalanceLoaded;
    }

    public final void setAmountCurrency(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.amountCurrency = str;
    }

    public final void setServerErrorMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serverErrorMessage = str;
    }

    public final void setWalletBalance(float f11) {
        this.walletBalance = f11;
    }

    public final void setWalletBalanceLoaded(boolean z11) {
        this.isWalletBalanceLoaded = z11;
    }
}
