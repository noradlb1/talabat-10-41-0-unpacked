package com.talabat.talabatcommon.feature.walletCardManagement.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResponse;", "", "result", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;)V", "getResult", "()Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;", "setResult", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletSetDefaultCardResponse {
    @SerializedName("result")
    @Nullable
    private WalletSetDefaultCardResult result;

    public WalletSetDefaultCardResponse(@Nullable WalletSetDefaultCardResult walletSetDefaultCardResult) {
        this.result = walletSetDefaultCardResult;
    }

    public static /* synthetic */ WalletSetDefaultCardResponse copy$default(WalletSetDefaultCardResponse walletSetDefaultCardResponse, WalletSetDefaultCardResult walletSetDefaultCardResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletSetDefaultCardResult = walletSetDefaultCardResponse.result;
        }
        return walletSetDefaultCardResponse.copy(walletSetDefaultCardResult);
    }

    @Nullable
    public final WalletSetDefaultCardResult component1() {
        return this.result;
    }

    @NotNull
    public final WalletSetDefaultCardResponse copy(@Nullable WalletSetDefaultCardResult walletSetDefaultCardResult) {
        return new WalletSetDefaultCardResponse(walletSetDefaultCardResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletSetDefaultCardResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((WalletSetDefaultCardResponse) obj).result);
    }

    @Nullable
    public final WalletSetDefaultCardResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletSetDefaultCardResult walletSetDefaultCardResult = this.result;
        if (walletSetDefaultCardResult == null) {
            return 0;
        }
        return walletSetDefaultCardResult.hashCode();
    }

    public final void setResult(@Nullable WalletSetDefaultCardResult walletSetDefaultCardResult) {
        this.result = walletSetDefaultCardResult;
    }

    @NotNull
    public String toString() {
        WalletSetDefaultCardResult walletSetDefaultCardResult = this.result;
        return "WalletSetDefaultCardResponse(result=" + walletSetDefaultCardResult + ")";
    }
}
