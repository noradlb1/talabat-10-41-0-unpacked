package com.talabat.talabatcommon.feature.walletCardManagement.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResponse;", "", "result", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;)V", "getResult", "()Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "setResult", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDeleteCardResponse {
    @SerializedName("result")
    @Nullable
    private WalletDeleteCardResult result;

    public WalletDeleteCardResponse(@Nullable WalletDeleteCardResult walletDeleteCardResult) {
        this.result = walletDeleteCardResult;
    }

    public static /* synthetic */ WalletDeleteCardResponse copy$default(WalletDeleteCardResponse walletDeleteCardResponse, WalletDeleteCardResult walletDeleteCardResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletDeleteCardResult = walletDeleteCardResponse.result;
        }
        return walletDeleteCardResponse.copy(walletDeleteCardResult);
    }

    @Nullable
    public final WalletDeleteCardResult component1() {
        return this.result;
    }

    @NotNull
    public final WalletDeleteCardResponse copy(@Nullable WalletDeleteCardResult walletDeleteCardResult) {
        return new WalletDeleteCardResponse(walletDeleteCardResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletDeleteCardResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((WalletDeleteCardResponse) obj).result);
    }

    @Nullable
    public final WalletDeleteCardResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletDeleteCardResult walletDeleteCardResult = this.result;
        if (walletDeleteCardResult == null) {
            return 0;
        }
        return walletDeleteCardResult.hashCode();
    }

    public final void setResult(@Nullable WalletDeleteCardResult walletDeleteCardResult) {
        this.result = walletDeleteCardResult;
    }

    @NotNull
    public String toString() {
        WalletDeleteCardResult walletDeleteCardResult = this.result;
        return "WalletDeleteCardResponse(result=" + walletDeleteCardResult + ")";
    }
}
