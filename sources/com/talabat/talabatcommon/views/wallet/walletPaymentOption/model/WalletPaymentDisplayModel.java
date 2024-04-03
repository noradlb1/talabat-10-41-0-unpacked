package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentErrorType;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentTransactionStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "", "()V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "errorType", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentErrorType;", "getErrorType", "()Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentErrorType;", "setErrorType", "(Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentErrorType;)V", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "walletTransactionId", "getWalletTransactionId", "setWalletTransactionId", "walletTransactionStatus", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentTransactionStatus;", "getWalletTransactionStatus", "()Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentTransactionStatus;", "setWalletTransactionStatus", "(Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentTransactionStatus;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentDisplayModel {
    @NotNull
    private String errorMessage;
    @NotNull
    private WalletPaymentErrorType errorType;
    @NotNull
    private String redirectUrl;
    @NotNull
    private String walletTransactionId;
    @NotNull
    private WalletPaymentTransactionStatus walletTransactionStatus = WalletPaymentTransactionStatus.NONE;

    public WalletPaymentDisplayModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.redirectUrl = StringUtils.empty(stringCompanionObject);
        this.walletTransactionId = StringUtils.empty(stringCompanionObject);
        this.errorMessage = StringUtils.empty(stringCompanionObject);
        this.errorType = WalletPaymentErrorType.NO_ERROR;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final WalletPaymentErrorType getErrorType() {
        return this.errorType;
    }

    @NotNull
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @NotNull
    public final String getWalletTransactionId() {
        return this.walletTransactionId;
    }

    @NotNull
    public final WalletPaymentTransactionStatus getWalletTransactionStatus() {
        return this.walletTransactionStatus;
    }

    public final void setErrorMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMessage = str;
    }

    public final void setErrorType(@NotNull WalletPaymentErrorType walletPaymentErrorType) {
        Intrinsics.checkNotNullParameter(walletPaymentErrorType, "<set-?>");
        this.errorType = walletPaymentErrorType;
    }

    public final void setRedirectUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.redirectUrl = str;
    }

    public final void setWalletTransactionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.walletTransactionId = str;
    }

    public final void setWalletTransactionStatus(@NotNull WalletPaymentTransactionStatus walletPaymentTransactionStatus) {
        Intrinsics.checkNotNullParameter(walletPaymentTransactionStatus, "<set-?>");
        this.walletTransactionStatus = walletPaymentTransactionStatus;
    }
}
