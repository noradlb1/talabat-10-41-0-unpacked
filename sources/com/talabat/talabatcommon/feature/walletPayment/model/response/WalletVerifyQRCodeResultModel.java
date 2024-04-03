package com.talabat.talabatcommon.feature.walletPayment.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletVerifyQRCodeResultModel;", "", "message", "", "status", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getMessage", "()Ljava/lang/String;", "getStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletVerifyQRCodeResultModel;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletVerifyQRCodeResultModel {
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("status")
    @Nullable
    private final Boolean status;

    public WalletVerifyQRCodeResultModel() {
        this((String) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
    }

    public WalletVerifyQRCodeResultModel(@Nullable String str, @Nullable Boolean bool) {
        this.message = str;
        this.status = bool;
    }

    public static /* synthetic */ WalletVerifyQRCodeResultModel copy$default(WalletVerifyQRCodeResultModel walletVerifyQRCodeResultModel, String str, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletVerifyQRCodeResultModel.message;
        }
        if ((i11 & 2) != 0) {
            bool = walletVerifyQRCodeResultModel.status;
        }
        return walletVerifyQRCodeResultModel.copy(str, bool);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final Boolean component2() {
        return this.status;
    }

    @NotNull
    public final WalletVerifyQRCodeResultModel copy(@Nullable String str, @Nullable Boolean bool) {
        return new WalletVerifyQRCodeResultModel(str, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletVerifyQRCodeResultModel)) {
            return false;
        }
        WalletVerifyQRCodeResultModel walletVerifyQRCodeResultModel = (WalletVerifyQRCodeResultModel) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) walletVerifyQRCodeResultModel.message) && Intrinsics.areEqual((Object) this.status, (Object) walletVerifyQRCodeResultModel.status);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.message;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.status;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.message;
        Boolean bool = this.status;
        return "WalletVerifyQRCodeResultModel(message=" + str + ", status=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletVerifyQRCodeResultModel(String str, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : bool);
    }
}
