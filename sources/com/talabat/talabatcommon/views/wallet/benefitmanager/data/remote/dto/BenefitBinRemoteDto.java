package com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0004\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinRemoteDto;", "", "binNumber", "", "isBenefitBin", "", "savedCardErrorMessage", "newCardErrorMessage", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNewCardErrorMessage", "getSavedCardErrorMessage", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinRemoteDto;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitBinRemoteDto {
    @SerializedName("binNumber")
    @Nullable
    private final String binNumber;
    @SerializedName("isBenefitBin")
    @Nullable
    private final Boolean isBenefitBin;
    @SerializedName("newCardErrorMessage")
    @Nullable
    private final String newCardErrorMessage;
    @SerializedName("savedCardErrorMessage")
    @Nullable
    private final String savedCardErrorMessage;

    public BenefitBinRemoteDto() {
        this((String) null, (Boolean) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public BenefitBinRemoteDto(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3) {
        this.binNumber = str;
        this.isBenefitBin = bool;
        this.savedCardErrorMessage = str2;
        this.newCardErrorMessage = str3;
    }

    public static /* synthetic */ BenefitBinRemoteDto copy$default(BenefitBinRemoteDto benefitBinRemoteDto, String str, Boolean bool, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = benefitBinRemoteDto.binNumber;
        }
        if ((i11 & 2) != 0) {
            bool = benefitBinRemoteDto.isBenefitBin;
        }
        if ((i11 & 4) != 0) {
            str2 = benefitBinRemoteDto.savedCardErrorMessage;
        }
        if ((i11 & 8) != 0) {
            str3 = benefitBinRemoteDto.newCardErrorMessage;
        }
        return benefitBinRemoteDto.copy(str, bool, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.binNumber;
    }

    @Nullable
    public final Boolean component2() {
        return this.isBenefitBin;
    }

    @Nullable
    public final String component3() {
        return this.savedCardErrorMessage;
    }

    @Nullable
    public final String component4() {
        return this.newCardErrorMessage;
    }

    @NotNull
    public final BenefitBinRemoteDto copy(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3) {
        return new BenefitBinRemoteDto(str, bool, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BenefitBinRemoteDto)) {
            return false;
        }
        BenefitBinRemoteDto benefitBinRemoteDto = (BenefitBinRemoteDto) obj;
        return Intrinsics.areEqual((Object) this.binNumber, (Object) benefitBinRemoteDto.binNumber) && Intrinsics.areEqual((Object) this.isBenefitBin, (Object) benefitBinRemoteDto.isBenefitBin) && Intrinsics.areEqual((Object) this.savedCardErrorMessage, (Object) benefitBinRemoteDto.savedCardErrorMessage) && Intrinsics.areEqual((Object) this.newCardErrorMessage, (Object) benefitBinRemoteDto.newCardErrorMessage);
    }

    @Nullable
    public final String getBinNumber() {
        return this.binNumber;
    }

    @Nullable
    public final String getNewCardErrorMessage() {
        return this.newCardErrorMessage;
    }

    @Nullable
    public final String getSavedCardErrorMessage() {
        return this.savedCardErrorMessage;
    }

    public int hashCode() {
        String str = this.binNumber;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isBenefitBin;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.savedCardErrorMessage;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.newCardErrorMessage;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode3 + i11;
    }

    @Nullable
    public final Boolean isBenefitBin() {
        return this.isBenefitBin;
    }

    @NotNull
    public String toString() {
        String str = this.binNumber;
        Boolean bool = this.isBenefitBin;
        String str2 = this.savedCardErrorMessage;
        String str3 = this.newCardErrorMessage;
        return "BenefitBinRemoteDto(binNumber=" + str + ", isBenefitBin=" + bool + ", savedCardErrorMessage=" + str2 + ", newCardErrorMessage=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BenefitBinRemoteDto(String str, Boolean bool, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3);
    }
}
