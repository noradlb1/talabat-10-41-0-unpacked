package com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinDetailRemoteResultDto;", "", "benefitBinRemotes", "", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinRemoteDto;", "benefitCardDeflectionExpiryDate", "", "(Ljava/util/List;Ljava/lang/String;)V", "getBenefitBinRemotes", "()Ljava/util/List;", "getBenefitCardDeflectionExpiryDate", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitBinDetailRemoteResultDto {
    @SerializedName("bins")
    @Nullable
    private final List<BenefitBinRemoteDto> benefitBinRemotes;
    @SerializedName("savedCardExpiryDate")
    @Nullable
    private final String benefitCardDeflectionExpiryDate;

    public BenefitBinDetailRemoteResultDto() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public BenefitBinDetailRemoteResultDto(@Nullable List<BenefitBinRemoteDto> list, @Nullable String str) {
        this.benefitBinRemotes = list;
        this.benefitCardDeflectionExpiryDate = str;
    }

    public static /* synthetic */ BenefitBinDetailRemoteResultDto copy$default(BenefitBinDetailRemoteResultDto benefitBinDetailRemoteResultDto, List<BenefitBinRemoteDto> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = benefitBinDetailRemoteResultDto.benefitBinRemotes;
        }
        if ((i11 & 2) != 0) {
            str = benefitBinDetailRemoteResultDto.benefitCardDeflectionExpiryDate;
        }
        return benefitBinDetailRemoteResultDto.copy(list, str);
    }

    @Nullable
    public final List<BenefitBinRemoteDto> component1() {
        return this.benefitBinRemotes;
    }

    @Nullable
    public final String component2() {
        return this.benefitCardDeflectionExpiryDate;
    }

    @NotNull
    public final BenefitBinDetailRemoteResultDto copy(@Nullable List<BenefitBinRemoteDto> list, @Nullable String str) {
        return new BenefitBinDetailRemoteResultDto(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BenefitBinDetailRemoteResultDto)) {
            return false;
        }
        BenefitBinDetailRemoteResultDto benefitBinDetailRemoteResultDto = (BenefitBinDetailRemoteResultDto) obj;
        return Intrinsics.areEqual((Object) this.benefitBinRemotes, (Object) benefitBinDetailRemoteResultDto.benefitBinRemotes) && Intrinsics.areEqual((Object) this.benefitCardDeflectionExpiryDate, (Object) benefitBinDetailRemoteResultDto.benefitCardDeflectionExpiryDate);
    }

    @Nullable
    public final List<BenefitBinRemoteDto> getBenefitBinRemotes() {
        return this.benefitBinRemotes;
    }

    @Nullable
    public final String getBenefitCardDeflectionExpiryDate() {
        return this.benefitCardDeflectionExpiryDate;
    }

    public int hashCode() {
        List<BenefitBinRemoteDto> list = this.benefitBinRemotes;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.benefitCardDeflectionExpiryDate;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        List<BenefitBinRemoteDto> list = this.benefitBinRemotes;
        String str = this.benefitCardDeflectionExpiryDate;
        return "BenefitBinDetailRemoteResultDto(benefitBinRemotes=" + list + ", benefitCardDeflectionExpiryDate=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BenefitBinDetailRemoteResultDto(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str);
    }
}
