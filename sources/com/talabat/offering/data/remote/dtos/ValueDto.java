package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/ValueDto;", "", "duration", "", "otpLength", "", "requestId", "", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOtpLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRequestId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/offering/data/remote/dtos/ValueDto;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ValueDto {
    @SerializedName("duration")
    @Nullable
    private final Long duration;
    @SerializedName("otpLength")
    @Nullable
    private final Integer otpLength;
    @SerializedName("requestId")
    @Nullable
    private final String requestId;

    public ValueDto() {
        this((Long) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public ValueDto(@Nullable Long l11, @Nullable Integer num, @Nullable String str) {
        this.duration = l11;
        this.otpLength = num;
        this.requestId = str;
    }

    public static /* synthetic */ ValueDto copy$default(ValueDto valueDto, Long l11, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = valueDto.duration;
        }
        if ((i11 & 2) != 0) {
            num = valueDto.otpLength;
        }
        if ((i11 & 4) != 0) {
            str = valueDto.requestId;
        }
        return valueDto.copy(l11, num, str);
    }

    @Nullable
    public final Long component1() {
        return this.duration;
    }

    @Nullable
    public final Integer component2() {
        return this.otpLength;
    }

    @Nullable
    public final String component3() {
        return this.requestId;
    }

    @NotNull
    public final ValueDto copy(@Nullable Long l11, @Nullable Integer num, @Nullable String str) {
        return new ValueDto(l11, num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValueDto)) {
            return false;
        }
        ValueDto valueDto = (ValueDto) obj;
        return Intrinsics.areEqual((Object) this.duration, (Object) valueDto.duration) && Intrinsics.areEqual((Object) this.otpLength, (Object) valueDto.otpLength) && Intrinsics.areEqual((Object) this.requestId, (Object) valueDto.requestId);
    }

    @Nullable
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    public final Integer getOtpLength() {
        return this.otpLength;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        Long l11 = this.duration;
        int i11 = 0;
        int hashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
        Integer num = this.otpLength;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.requestId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Long l11 = this.duration;
        Integer num = this.otpLength;
        String str = this.requestId;
        return "ValueDto(duration=" + l11 + ", otpLength=" + num + ", requestId=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ValueDto(Long l11, Integer num, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : l11, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : str);
    }
}
