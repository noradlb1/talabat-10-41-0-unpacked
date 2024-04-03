package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/MetadataDto;", "", "deepLink", "", "id", "", "productId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getDeepLink", "()Ljava/lang/String;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProductId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/offering/data/remote/dtos/MetadataDto;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetadataDto {
    @SerializedName("deepLink")
    @Nullable
    private final String deepLink;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f61097id;
    @SerializedName("productId")
    @Nullable
    private final String productId;

    public MetadataDto() {
        this((String) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public MetadataDto(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        this.deepLink = str;
        this.f61097id = num;
        this.productId = str2;
    }

    public static /* synthetic */ MetadataDto copy$default(MetadataDto metadataDto, String str, Integer num, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = metadataDto.deepLink;
        }
        if ((i11 & 2) != 0) {
            num = metadataDto.f61097id;
        }
        if ((i11 & 4) != 0) {
            str2 = metadataDto.productId;
        }
        return metadataDto.copy(str, num, str2);
    }

    @Nullable
    public final String component1() {
        return this.deepLink;
    }

    @Nullable
    public final Integer component2() {
        return this.f61097id;
    }

    @Nullable
    public final String component3() {
        return this.productId;
    }

    @NotNull
    public final MetadataDto copy(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        return new MetadataDto(str, num, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataDto)) {
            return false;
        }
        MetadataDto metadataDto = (MetadataDto) obj;
        return Intrinsics.areEqual((Object) this.deepLink, (Object) metadataDto.deepLink) && Intrinsics.areEqual((Object) this.f61097id, (Object) metadataDto.f61097id) && Intrinsics.areEqual((Object) this.productId, (Object) metadataDto.productId);
    }

    @Nullable
    public final String getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final Integer getId() {
        return this.f61097id;
    }

    @Nullable
    public final String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        String str = this.deepLink;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.f61097id;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.productId;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.deepLink;
        Integer num = this.f61097id;
        String str2 = this.productId;
        return "MetadataDto(deepLink=" + str + ", id=" + num + ", productId=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetadataDto(String str, Integer num, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : str2);
    }
}
