package com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.request;

import com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015¨\u0006+"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/request/LookingGlassRequestModel;", "", "countryId", "", "areaId", "productTag", "", "lat", "lng", "offset", "limit", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAreaId", "()I", "setAreaId", "(I)V", "getCountryId", "setCountryId", "getLat", "()Ljava/lang/String;", "setLat", "(Ljava/lang/String;)V", "getLimit", "setLimit", "getLng", "setLng", "getOffset", "setOffset", "getProductTag", "setProductTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassRequestModel {
    private int areaId;
    private int countryId;
    @NotNull
    private String lat;
    private int limit;
    @NotNull
    private String lng;
    private int offset;
    @NotNull
    private String productTag;

    public LookingGlassRequestModel(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, int i13, int i14) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PRODUCT_TAG);
        Intrinsics.checkNotNullParameter(str2, "lat");
        Intrinsics.checkNotNullParameter(str3, "lng");
        this.countryId = i11;
        this.areaId = i12;
        this.productTag = str;
        this.lat = str2;
        this.lng = str3;
        this.offset = i13;
        this.limit = i14;
    }

    public static /* synthetic */ LookingGlassRequestModel copy$default(LookingGlassRequestModel lookingGlassRequestModel, int i11, int i12, String str, String str2, String str3, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = lookingGlassRequestModel.countryId;
        }
        if ((i15 & 2) != 0) {
            i12 = lookingGlassRequestModel.areaId;
        }
        int i16 = i12;
        if ((i15 & 4) != 0) {
            str = lookingGlassRequestModel.productTag;
        }
        String str4 = str;
        if ((i15 & 8) != 0) {
            str2 = lookingGlassRequestModel.lat;
        }
        String str5 = str2;
        if ((i15 & 16) != 0) {
            str3 = lookingGlassRequestModel.lng;
        }
        String str6 = str3;
        if ((i15 & 32) != 0) {
            i13 = lookingGlassRequestModel.offset;
        }
        int i17 = i13;
        if ((i15 & 64) != 0) {
            i14 = lookingGlassRequestModel.limit;
        }
        return lookingGlassRequestModel.copy(i11, i16, str4, str5, str6, i17, i14);
    }

    public final int component1() {
        return this.countryId;
    }

    public final int component2() {
        return this.areaId;
    }

    @NotNull
    public final String component3() {
        return this.productTag;
    }

    @NotNull
    public final String component4() {
        return this.lat;
    }

    @NotNull
    public final String component5() {
        return this.lng;
    }

    public final int component6() {
        return this.offset;
    }

    public final int component7() {
        return this.limit;
    }

    @NotNull
    public final LookingGlassRequestModel copy(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, int i13, int i14) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PRODUCT_TAG);
        Intrinsics.checkNotNullParameter(str2, "lat");
        Intrinsics.checkNotNullParameter(str3, "lng");
        return new LookingGlassRequestModel(i11, i12, str, str2, str3, i13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LookingGlassRequestModel)) {
            return false;
        }
        LookingGlassRequestModel lookingGlassRequestModel = (LookingGlassRequestModel) obj;
        return this.countryId == lookingGlassRequestModel.countryId && this.areaId == lookingGlassRequestModel.areaId && Intrinsics.areEqual((Object) this.productTag, (Object) lookingGlassRequestModel.productTag) && Intrinsics.areEqual((Object) this.lat, (Object) lookingGlassRequestModel.lat) && Intrinsics.areEqual((Object) this.lng, (Object) lookingGlassRequestModel.lng) && this.offset == lookingGlassRequestModel.offset && this.limit == lookingGlassRequestModel.limit;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getLat() {
        return this.lat;
    }

    public final int getLimit() {
        return this.limit;
    }

    @NotNull
    public final String getLng() {
        return this.lng;
    }

    public final int getOffset() {
        return this.offset;
    }

    @NotNull
    public final String getProductTag() {
        return this.productTag;
    }

    public int hashCode() {
        return (((((((((((this.countryId * 31) + this.areaId) * 31) + this.productTag.hashCode()) * 31) + this.lat.hashCode()) * 31) + this.lng.hashCode()) * 31) + this.offset) * 31) + this.limit;
    }

    public final void setAreaId(int i11) {
        this.areaId = i11;
    }

    public final void setCountryId(int i11) {
        this.countryId = i11;
    }

    public final void setLat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lat = str;
    }

    public final void setLimit(int i11) {
        this.limit = i11;
    }

    public final void setLng(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lng = str;
    }

    public final void setOffset(int i11) {
        this.offset = i11;
    }

    public final void setProductTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productTag = str;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        int i12 = this.areaId;
        String str = this.productTag;
        String str2 = this.lat;
        String str3 = this.lng;
        int i13 = this.offset;
        int i14 = this.limit;
        return "LookingGlassRequestModel(countryId=" + i11 + ", areaId=" + i12 + ", productTag=" + str + ", lat=" + str2 + ", lng=" + str3 + ", offset=" + i13 + ", limit=" + i14 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LookingGlassRequestModel(int i11, int i12, String str, String str2, String str3, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? 1 : i11, (i15 & 2) != 0 ? -1 : i12, (i15 & 4) != 0 ? "" : str, str2, str3, (i15 & 32) != 0 ? 0 : i13, (i15 & 64) != 0 ? 100 : i14);
    }
}
