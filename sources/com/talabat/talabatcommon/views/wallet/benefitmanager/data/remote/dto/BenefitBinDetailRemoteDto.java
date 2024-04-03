package com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinDetailRemoteDto;", "", "remoteResultDto", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinDetailRemoteResultDto;", "(Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinDetailRemoteResultDto;)V", "getRemoteResultDto", "()Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinDetailRemoteResultDto;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitBinDetailRemoteDto {
    @SerializedName("result")
    @Nullable
    private final BenefitBinDetailRemoteResultDto remoteResultDto;

    public BenefitBinDetailRemoteDto() {
        this((BenefitBinDetailRemoteResultDto) null, 1, (DefaultConstructorMarker) null);
    }

    public BenefitBinDetailRemoteDto(@Nullable BenefitBinDetailRemoteResultDto benefitBinDetailRemoteResultDto) {
        this.remoteResultDto = benefitBinDetailRemoteResultDto;
    }

    public static /* synthetic */ BenefitBinDetailRemoteDto copy$default(BenefitBinDetailRemoteDto benefitBinDetailRemoteDto, BenefitBinDetailRemoteResultDto benefitBinDetailRemoteResultDto, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            benefitBinDetailRemoteResultDto = benefitBinDetailRemoteDto.remoteResultDto;
        }
        return benefitBinDetailRemoteDto.copy(benefitBinDetailRemoteResultDto);
    }

    @Nullable
    public final BenefitBinDetailRemoteResultDto component1() {
        return this.remoteResultDto;
    }

    @NotNull
    public final BenefitBinDetailRemoteDto copy(@Nullable BenefitBinDetailRemoteResultDto benefitBinDetailRemoteResultDto) {
        return new BenefitBinDetailRemoteDto(benefitBinDetailRemoteResultDto);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BenefitBinDetailRemoteDto) && Intrinsics.areEqual((Object) this.remoteResultDto, (Object) ((BenefitBinDetailRemoteDto) obj).remoteResultDto);
    }

    @Nullable
    public final BenefitBinDetailRemoteResultDto getRemoteResultDto() {
        return this.remoteResultDto;
    }

    public int hashCode() {
        BenefitBinDetailRemoteResultDto benefitBinDetailRemoteResultDto = this.remoteResultDto;
        if (benefitBinDetailRemoteResultDto == null) {
            return 0;
        }
        return benefitBinDetailRemoteResultDto.hashCode();
    }

    @NotNull
    public String toString() {
        BenefitBinDetailRemoteResultDto benefitBinDetailRemoteResultDto = this.remoteResultDto;
        return "BenefitBinDetailRemoteDto(remoteResultDto=" + benefitBinDetailRemoteResultDto + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BenefitBinDetailRemoteDto(BenefitBinDetailRemoteResultDto benefitBinDetailRemoteResultDto, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : benefitBinDetailRemoteResultDto);
    }
}
