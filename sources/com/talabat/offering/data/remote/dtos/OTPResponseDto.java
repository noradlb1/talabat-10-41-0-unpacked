package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0005\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/OTPResponseDto;", "", "errors", "", "Lcom/talabat/offering/data/remote/dtos/ErrorDto;", "isSuccess", "", "valueDto", "Lcom/talabat/offering/data/remote/dtos/ValueDto;", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/talabat/offering/data/remote/dtos/ValueDto;)V", "getErrors", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getValueDto", "()Lcom/talabat/offering/data/remote/dtos/ValueDto;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/talabat/offering/data/remote/dtos/ValueDto;)Lcom/talabat/offering/data/remote/dtos/OTPResponseDto;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTPResponseDto {
    @SerializedName("errors")
    @Nullable
    private final List<ErrorDto> errors;
    @SerializedName("isSuccess")
    @Nullable
    private final Boolean isSuccess;
    @SerializedName("value")
    @Nullable
    private final ValueDto valueDto;

    public OTPResponseDto() {
        this((List) null, (Boolean) null, (ValueDto) null, 7, (DefaultConstructorMarker) null);
    }

    public OTPResponseDto(@Nullable List<ErrorDto> list, @Nullable Boolean bool, @Nullable ValueDto valueDto2) {
        this.errors = list;
        this.isSuccess = bool;
        this.valueDto = valueDto2;
    }

    public static /* synthetic */ OTPResponseDto copy$default(OTPResponseDto oTPResponseDto, List<ErrorDto> list, Boolean bool, ValueDto valueDto2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = oTPResponseDto.errors;
        }
        if ((i11 & 2) != 0) {
            bool = oTPResponseDto.isSuccess;
        }
        if ((i11 & 4) != 0) {
            valueDto2 = oTPResponseDto.valueDto;
        }
        return oTPResponseDto.copy(list, bool, valueDto2);
    }

    @Nullable
    public final List<ErrorDto> component1() {
        return this.errors;
    }

    @Nullable
    public final Boolean component2() {
        return this.isSuccess;
    }

    @Nullable
    public final ValueDto component3() {
        return this.valueDto;
    }

    @NotNull
    public final OTPResponseDto copy(@Nullable List<ErrorDto> list, @Nullable Boolean bool, @Nullable ValueDto valueDto2) {
        return new OTPResponseDto(list, bool, valueDto2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OTPResponseDto)) {
            return false;
        }
        OTPResponseDto oTPResponseDto = (OTPResponseDto) obj;
        return Intrinsics.areEqual((Object) this.errors, (Object) oTPResponseDto.errors) && Intrinsics.areEqual((Object) this.isSuccess, (Object) oTPResponseDto.isSuccess) && Intrinsics.areEqual((Object) this.valueDto, (Object) oTPResponseDto.valueDto);
    }

    @Nullable
    public final List<ErrorDto> getErrors() {
        return this.errors;
    }

    @Nullable
    public final ValueDto getValueDto() {
        return this.valueDto;
    }

    public int hashCode() {
        List<ErrorDto> list = this.errors;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Boolean bool = this.isSuccess;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        ValueDto valueDto2 = this.valueDto;
        if (valueDto2 != null) {
            i11 = valueDto2.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    @NotNull
    public String toString() {
        List<ErrorDto> list = this.errors;
        Boolean bool = this.isSuccess;
        ValueDto valueDto2 = this.valueDto;
        return "OTPResponseDto(errors=" + list + ", isSuccess=" + bool + ", valueDto=" + valueDto2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OTPResponseDto(List list, Boolean bool, ValueDto valueDto2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : valueDto2);
    }
}
