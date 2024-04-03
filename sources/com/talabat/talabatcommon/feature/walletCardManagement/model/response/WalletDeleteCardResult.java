package com.talabat.talabatcommon.feature.walletCardManagement.model.response;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0002\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "", "isSuccessful", "", "technicalError", "", "error", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;)V", "getError", "()Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;", "setError", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTechnicalError", "()Ljava/lang/String;", "setTechnicalError", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;)Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDeleteCardResult {
    @Nullable
    private WalletDeleteCardErrorResult error;
    @Nullable
    private final Boolean isSuccessful;
    @Nullable
    private String technicalError;

    public WalletDeleteCardResult() {
        this((Boolean) null, (String) null, (WalletDeleteCardErrorResult) null, 7, (DefaultConstructorMarker) null);
    }

    public WalletDeleteCardResult(@Nullable @Json(name = "isSuccess") Boolean bool, @Nullable @Json(name = "technicalError") String str, @Nullable @Json(name = "error") WalletDeleteCardErrorResult walletDeleteCardErrorResult) {
        this.isSuccessful = bool;
        this.technicalError = str;
        this.error = walletDeleteCardErrorResult;
    }

    public static /* synthetic */ WalletDeleteCardResult copy$default(WalletDeleteCardResult walletDeleteCardResult, Boolean bool, String str, WalletDeleteCardErrorResult walletDeleteCardErrorResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = walletDeleteCardResult.isSuccessful;
        }
        if ((i11 & 2) != 0) {
            str = walletDeleteCardResult.technicalError;
        }
        if ((i11 & 4) != 0) {
            walletDeleteCardErrorResult = walletDeleteCardResult.error;
        }
        return walletDeleteCardResult.copy(bool, str, walletDeleteCardErrorResult);
    }

    @Nullable
    public final Boolean component1() {
        return this.isSuccessful;
    }

    @Nullable
    public final String component2() {
        return this.technicalError;
    }

    @Nullable
    public final WalletDeleteCardErrorResult component3() {
        return this.error;
    }

    @NotNull
    public final WalletDeleteCardResult copy(@Nullable @Json(name = "isSuccess") Boolean bool, @Nullable @Json(name = "technicalError") String str, @Nullable @Json(name = "error") WalletDeleteCardErrorResult walletDeleteCardErrorResult) {
        return new WalletDeleteCardResult(bool, str, walletDeleteCardErrorResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletDeleteCardResult)) {
            return false;
        }
        WalletDeleteCardResult walletDeleteCardResult = (WalletDeleteCardResult) obj;
        return Intrinsics.areEqual((Object) this.isSuccessful, (Object) walletDeleteCardResult.isSuccessful) && Intrinsics.areEqual((Object) this.technicalError, (Object) walletDeleteCardResult.technicalError) && Intrinsics.areEqual((Object) this.error, (Object) walletDeleteCardResult.error);
    }

    @Nullable
    public final WalletDeleteCardErrorResult getError() {
        return this.error;
    }

    @Nullable
    public final String getTechnicalError() {
        return this.technicalError;
    }

    public int hashCode() {
        Boolean bool = this.isSuccessful;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.technicalError;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        WalletDeleteCardErrorResult walletDeleteCardErrorResult = this.error;
        if (walletDeleteCardErrorResult != null) {
            i11 = walletDeleteCardErrorResult.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isSuccessful() {
        return this.isSuccessful;
    }

    public final void setError(@Nullable WalletDeleteCardErrorResult walletDeleteCardErrorResult) {
        this.error = walletDeleteCardErrorResult;
    }

    public final void setTechnicalError(@Nullable String str) {
        this.technicalError = str;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isSuccessful;
        String str = this.technicalError;
        WalletDeleteCardErrorResult walletDeleteCardErrorResult = this.error;
        return "WalletDeleteCardResult(isSuccessful=" + bool + ", technicalError=" + str + ", error=" + walletDeleteCardErrorResult + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletDeleteCardResult(Boolean bool, String str, WalletDeleteCardErrorResult walletDeleteCardErrorResult, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : walletDeleteCardErrorResult);
    }
}
