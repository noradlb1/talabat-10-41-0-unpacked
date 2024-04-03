package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;", "", "code", "", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTPCodeModelDto {
    @SerializedName("code")
    @Nullable
    private final String code;

    public OTPCodeModelDto() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public OTPCodeModelDto(@Nullable String str) {
        this.code = str;
    }

    public static /* synthetic */ OTPCodeModelDto copy$default(OTPCodeModelDto oTPCodeModelDto, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = oTPCodeModelDto.code;
        }
        return oTPCodeModelDto.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final OTPCodeModelDto copy(@Nullable String str) {
        return new OTPCodeModelDto(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OTPCodeModelDto) && Intrinsics.areEqual((Object) this.code, (Object) ((OTPCodeModelDto) obj).code);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        String str = this.code;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.code;
        return "OTPCodeModelDto(code=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OTPCodeModelDto(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }
}
