package com.talabat.talabatcommon.feature.walletCardManagement.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0002\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;", "", "isSuccessful", "", "technicalError", "", "displayMessage", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayMessage", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTechnicalError", "setTechnicalError", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletSetDefaultCardResult {
    @SerializedName("displayMessage")
    @Nullable
    private final String displayMessage;
    @SerializedName("isSuccess")
    @Nullable
    private final Boolean isSuccessful;
    @SerializedName("technicalError")
    @Nullable
    private String technicalError;

    public WalletSetDefaultCardResult() {
        this((Boolean) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public WalletSetDefaultCardResult(@Nullable Boolean bool, @Nullable String str, @Nullable String str2) {
        this.isSuccessful = bool;
        this.technicalError = str;
        this.displayMessage = str2;
    }

    public static /* synthetic */ WalletSetDefaultCardResult copy$default(WalletSetDefaultCardResult walletSetDefaultCardResult, Boolean bool, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = walletSetDefaultCardResult.isSuccessful;
        }
        if ((i11 & 2) != 0) {
            str = walletSetDefaultCardResult.technicalError;
        }
        if ((i11 & 4) != 0) {
            str2 = walletSetDefaultCardResult.displayMessage;
        }
        return walletSetDefaultCardResult.copy(bool, str, str2);
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
    public final String component3() {
        return this.displayMessage;
    }

    @NotNull
    public final WalletSetDefaultCardResult copy(@Nullable Boolean bool, @Nullable String str, @Nullable String str2) {
        return new WalletSetDefaultCardResult(bool, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletSetDefaultCardResult)) {
            return false;
        }
        WalletSetDefaultCardResult walletSetDefaultCardResult = (WalletSetDefaultCardResult) obj;
        return Intrinsics.areEqual((Object) this.isSuccessful, (Object) walletSetDefaultCardResult.isSuccessful) && Intrinsics.areEqual((Object) this.technicalError, (Object) walletSetDefaultCardResult.technicalError) && Intrinsics.areEqual((Object) this.displayMessage, (Object) walletSetDefaultCardResult.displayMessage);
    }

    @Nullable
    public final String getDisplayMessage() {
        return this.displayMessage;
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
        String str2 = this.displayMessage;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isSuccessful() {
        return this.isSuccessful;
    }

    public final void setTechnicalError(@Nullable String str) {
        this.technicalError = str;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isSuccessful;
        String str = this.technicalError;
        String str2 = this.displayMessage;
        return "WalletSetDefaultCardResult(isSuccessful=" + bool + ", technicalError=" + str + ", displayMessage=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletSetDefaultCardResult(Boolean bool, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Boolean.FALSE : bool, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
