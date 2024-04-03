package com.talabat.talabatcommon.feature.walletCardManagement.model.request;

import com.google.gson.annotations.SerializedName;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;", "", "cToken", "", "countryId", "language", "binNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "setBinNumber", "(Ljava/lang/String;)V", "getCToken", "getCountryId", "setCountryId", "getLanguage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardRequestModel {
    @SerializedName("binNumber")
    @NotNull
    private String binNumber;
    @SerializedName("cToken")
    @NotNull
    private final String cToken;
    @SerializedName("countryId")
    @NotNull
    private String countryId;
    @SerializedName("lang")
    @NotNull
    private final String language;

    public WalletAddCardRequestModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cToken");
        Intrinsics.checkNotNullParameter(str2, "countryId");
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.ADJUST_LANGUAGE);
        Intrinsics.checkNotNullParameter(str4, "binNumber");
        this.cToken = str;
        this.countryId = str2;
        this.language = str3;
        this.binNumber = str4;
    }

    public static /* synthetic */ WalletAddCardRequestModel copy$default(WalletAddCardRequestModel walletAddCardRequestModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletAddCardRequestModel.cToken;
        }
        if ((i11 & 2) != 0) {
            str2 = walletAddCardRequestModel.countryId;
        }
        if ((i11 & 4) != 0) {
            str3 = walletAddCardRequestModel.language;
        }
        if ((i11 & 8) != 0) {
            str4 = walletAddCardRequestModel.binNumber;
        }
        return walletAddCardRequestModel.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.cToken;
    }

    @NotNull
    public final String component2() {
        return this.countryId;
    }

    @NotNull
    public final String component3() {
        return this.language;
    }

    @NotNull
    public final String component4() {
        return this.binNumber;
    }

    @NotNull
    public final WalletAddCardRequestModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cToken");
        Intrinsics.checkNotNullParameter(str2, "countryId");
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.ADJUST_LANGUAGE);
        Intrinsics.checkNotNullParameter(str4, "binNumber");
        return new WalletAddCardRequestModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletAddCardRequestModel)) {
            return false;
        }
        WalletAddCardRequestModel walletAddCardRequestModel = (WalletAddCardRequestModel) obj;
        return Intrinsics.areEqual((Object) this.cToken, (Object) walletAddCardRequestModel.cToken) && Intrinsics.areEqual((Object) this.countryId, (Object) walletAddCardRequestModel.countryId) && Intrinsics.areEqual((Object) this.language, (Object) walletAddCardRequestModel.language) && Intrinsics.areEqual((Object) this.binNumber, (Object) walletAddCardRequestModel.binNumber);
    }

    @NotNull
    public final String getBinNumber() {
        return this.binNumber;
    }

    @NotNull
    public final String getCToken() {
        return this.cToken;
    }

    @NotNull
    public final String getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    public int hashCode() {
        return (((((this.cToken.hashCode() * 31) + this.countryId.hashCode()) * 31) + this.language.hashCode()) * 31) + this.binNumber.hashCode();
    }

    public final void setBinNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.binNumber = str;
    }

    public final void setCountryId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryId = str;
    }

    @NotNull
    public String toString() {
        String str = this.cToken;
        String str2 = this.countryId;
        String str3 = this.language;
        String str4 = this.binNumber;
        return "WalletAddCardRequestModel(cToken=" + str + ", countryId=" + str2 + ", language=" + str3 + ", binNumber=" + str4 + ")";
    }
}
