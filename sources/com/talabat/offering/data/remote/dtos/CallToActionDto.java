package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/CallToActionDto;", "", "title", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/offering/data/remote/dtos/CallToActionDto;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallToActionDto {
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("type")
    @Nullable
    private final Integer type;

    public CallToActionDto() {
        this((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public CallToActionDto(@Nullable String str, @Nullable Integer num) {
        this.title = str;
        this.type = num;
    }

    public static /* synthetic */ CallToActionDto copy$default(CallToActionDto callToActionDto, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = callToActionDto.title;
        }
        if ((i11 & 2) != 0) {
            num = callToActionDto.type;
        }
        return callToActionDto.copy(str, num);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final Integer component2() {
        return this.type;
    }

    @NotNull
    public final CallToActionDto copy(@Nullable String str, @Nullable Integer num) {
        return new CallToActionDto(str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallToActionDto)) {
            return false;
        }
        CallToActionDto callToActionDto = (CallToActionDto) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) callToActionDto.title) && Intrinsics.areEqual((Object) this.type, (Object) callToActionDto.type);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.type;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        Integer num = this.type;
        return "CallToActionDto(title=" + str + ", type=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallToActionDto(String str, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num);
    }
}
