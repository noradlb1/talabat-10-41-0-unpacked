package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;", "", "countryId", "", "productId", "", "verificationInfoDto", "Lcom/talabat/offering/data/remote/dtos/VerificationInfoDto;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/VerificationInfoDto;)V", "getCountryId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProductId", "()Ljava/lang/String;", "getVerificationInfoDto", "()Lcom/talabat/offering/data/remote/dtos/VerificationInfoDto;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/VerificationInfoDto;)Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendMobileOTPDto {
    @SerializedName("countryId")
    @Nullable
    private final Integer countryId;
    @SerializedName("productId")
    @Nullable
    private final String productId;
    @SerializedName("verificationInfo")
    @Nullable
    private final VerificationInfoDto verificationInfoDto;

    public SendMobileOTPDto() {
        this((Integer) null, (String) null, (VerificationInfoDto) null, 7, (DefaultConstructorMarker) null);
    }

    public SendMobileOTPDto(@Nullable Integer num, @Nullable String str, @Nullable VerificationInfoDto verificationInfoDto2) {
        this.countryId = num;
        this.productId = str;
        this.verificationInfoDto = verificationInfoDto2;
    }

    public static /* synthetic */ SendMobileOTPDto copy$default(SendMobileOTPDto sendMobileOTPDto, Integer num, String str, VerificationInfoDto verificationInfoDto2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = sendMobileOTPDto.countryId;
        }
        if ((i11 & 2) != 0) {
            str = sendMobileOTPDto.productId;
        }
        if ((i11 & 4) != 0) {
            verificationInfoDto2 = sendMobileOTPDto.verificationInfoDto;
        }
        return sendMobileOTPDto.copy(num, str, verificationInfoDto2);
    }

    @Nullable
    public final Integer component1() {
        return this.countryId;
    }

    @Nullable
    public final String component2() {
        return this.productId;
    }

    @Nullable
    public final VerificationInfoDto component3() {
        return this.verificationInfoDto;
    }

    @NotNull
    public final SendMobileOTPDto copy(@Nullable Integer num, @Nullable String str, @Nullable VerificationInfoDto verificationInfoDto2) {
        return new SendMobileOTPDto(num, str, verificationInfoDto2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendMobileOTPDto)) {
            return false;
        }
        SendMobileOTPDto sendMobileOTPDto = (SendMobileOTPDto) obj;
        return Intrinsics.areEqual((Object) this.countryId, (Object) sendMobileOTPDto.countryId) && Intrinsics.areEqual((Object) this.productId, (Object) sendMobileOTPDto.productId) && Intrinsics.areEqual((Object) this.verificationInfoDto, (Object) sendMobileOTPDto.verificationInfoDto);
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    public final VerificationInfoDto getVerificationInfoDto() {
        return this.verificationInfoDto;
    }

    public int hashCode() {
        Integer num = this.countryId;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.productId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        VerificationInfoDto verificationInfoDto2 = this.verificationInfoDto;
        if (verificationInfoDto2 != null) {
            i11 = verificationInfoDto2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.countryId;
        String str = this.productId;
        VerificationInfoDto verificationInfoDto2 = this.verificationInfoDto;
        return "SendMobileOTPDto(countryId=" + num + ", productId=" + str + ", verificationInfoDto=" + verificationInfoDto2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SendMobileOTPDto(Integer num, String str, VerificationInfoDto verificationInfoDto2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : verificationInfoDto2);
    }
}
