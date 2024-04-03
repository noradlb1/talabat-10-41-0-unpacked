package com.talabat.wallet.ui.qrCodeScanner.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/model/WalletPaymentDisplayModel;", "", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "serverErrorMessage", "getServerErrorMessage", "setServerErrorMessage", "walletTransactionId", "getWalletTransactionId", "setWalletTransactionId", "walletTransactionStatus", "", "getWalletTransactionStatus", "()I", "setWalletTransactionStatus", "(I)V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentDisplayModel {
    @NotNull
    private String message = "";
    @NotNull
    private String serverErrorMessage = "";
    @NotNull
    private String walletTransactionId = "";
    private int walletTransactionStatus = -1;

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getServerErrorMessage() {
        return this.serverErrorMessage;
    }

    @NotNull
    public final String getWalletTransactionId() {
        return this.walletTransactionId;
    }

    public final int getWalletTransactionStatus() {
        return this.walletTransactionStatus;
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setServerErrorMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serverErrorMessage = str;
    }

    public final void setWalletTransactionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.walletTransactionId = str;
    }

    public final void setWalletTransactionStatus(int i11) {
        this.walletTransactionStatus = i11;
    }
}
