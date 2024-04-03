package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/ResultDto;", "", "isSubscribed", "", "type", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/talabat/offering/data/remote/dtos/ResultDto;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResultDto {
    @SerializedName("isSubscribed")
    @Nullable
    private final Boolean isSubscribed;
    @SerializedName("type")
    @Nullable
    private final String type;

    public ResultDto() {
        this((Boolean) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public ResultDto(@Nullable Boolean bool, @Nullable String str) {
        this.isSubscribed = bool;
        this.type = str;
    }

    public static /* synthetic */ ResultDto copy$default(ResultDto resultDto, Boolean bool, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = resultDto.isSubscribed;
        }
        if ((i11 & 2) != 0) {
            str = resultDto.type;
        }
        return resultDto.copy(bool, str);
    }

    @Nullable
    public final Boolean component1() {
        return this.isSubscribed;
    }

    @Nullable
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final ResultDto copy(@Nullable Boolean bool, @Nullable String str) {
        return new ResultDto(bool, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultDto)) {
            return false;
        }
        ResultDto resultDto = (ResultDto) obj;
        return Intrinsics.areEqual((Object) this.isSubscribed, (Object) resultDto.isSubscribed) && Intrinsics.areEqual((Object) this.type, (Object) resultDto.type);
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        Boolean bool = this.isSubscribed;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.type;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @Nullable
    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isSubscribed;
        String str = this.type;
        return "ResultDto(isSubscribed=" + bool + ", type=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResultDto(Boolean bool, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : str);
    }
}
