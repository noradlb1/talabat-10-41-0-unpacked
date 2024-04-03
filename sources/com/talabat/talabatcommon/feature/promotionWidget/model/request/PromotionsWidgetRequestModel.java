package com.talabat.talabatcommon.feature.promotionWidget.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006'"}, d2 = {"Lcom/talabat/talabatcommon/feature/promotionWidget/model/request/PromotionsWidgetRequestModel;", "", "countryId", "", "areaId", "promotionTag", "", "module", "lat", "lng", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAreaId", "()I", "setAreaId", "(I)V", "getCountryId", "setCountryId", "getLat", "()Ljava/lang/String;", "setLat", "(Ljava/lang/String;)V", "getLng", "setLng", "getModule", "setModule", "getPromotionTag", "setPromotionTag", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetRequestModel {
    private int areaId;
    private int countryId;
    @NotNull
    private String lat;
    @NotNull
    private String lng;
    @NotNull
    private String module;
    @NotNull
    private String promotionTag;

    public PromotionsWidgetRequestModel(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "promotionTag");
        Intrinsics.checkNotNullParameter(str2, "module");
        Intrinsics.checkNotNullParameter(str3, "lat");
        Intrinsics.checkNotNullParameter(str4, "lng");
        this.countryId = i11;
        this.areaId = i12;
        this.promotionTag = str;
        this.module = str2;
        this.lat = str3;
        this.lng = str4;
    }

    public static /* synthetic */ PromotionsWidgetRequestModel copy$default(PromotionsWidgetRequestModel promotionsWidgetRequestModel, int i11, int i12, String str, String str2, String str3, String str4, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = promotionsWidgetRequestModel.countryId;
        }
        if ((i13 & 2) != 0) {
            i12 = promotionsWidgetRequestModel.areaId;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            str = promotionsWidgetRequestModel.promotionTag;
        }
        String str5 = str;
        if ((i13 & 8) != 0) {
            str2 = promotionsWidgetRequestModel.module;
        }
        String str6 = str2;
        if ((i13 & 16) != 0) {
            str3 = promotionsWidgetRequestModel.lat;
        }
        String str7 = str3;
        if ((i13 & 32) != 0) {
            str4 = promotionsWidgetRequestModel.lng;
        }
        return promotionsWidgetRequestModel.copy(i11, i14, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.countryId;
    }

    public final int component2() {
        return this.areaId;
    }

    @NotNull
    public final String component3() {
        return this.promotionTag;
    }

    @NotNull
    public final String component4() {
        return this.module;
    }

    @NotNull
    public final String component5() {
        return this.lat;
    }

    @NotNull
    public final String component6() {
        return this.lng;
    }

    @NotNull
    public final PromotionsWidgetRequestModel copy(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "promotionTag");
        Intrinsics.checkNotNullParameter(str2, "module");
        Intrinsics.checkNotNullParameter(str3, "lat");
        Intrinsics.checkNotNullParameter(str4, "lng");
        return new PromotionsWidgetRequestModel(i11, i12, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromotionsWidgetRequestModel)) {
            return false;
        }
        PromotionsWidgetRequestModel promotionsWidgetRequestModel = (PromotionsWidgetRequestModel) obj;
        return this.countryId == promotionsWidgetRequestModel.countryId && this.areaId == promotionsWidgetRequestModel.areaId && Intrinsics.areEqual((Object) this.promotionTag, (Object) promotionsWidgetRequestModel.promotionTag) && Intrinsics.areEqual((Object) this.module, (Object) promotionsWidgetRequestModel.module) && Intrinsics.areEqual((Object) this.lat, (Object) promotionsWidgetRequestModel.lat) && Intrinsics.areEqual((Object) this.lng, (Object) promotionsWidgetRequestModel.lng);
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

    @NotNull
    public final String getLng() {
        return this.lng;
    }

    @NotNull
    public final String getModule() {
        return this.module;
    }

    @NotNull
    public final String getPromotionTag() {
        return this.promotionTag;
    }

    public int hashCode() {
        return (((((((((this.countryId * 31) + this.areaId) * 31) + this.promotionTag.hashCode()) * 31) + this.module.hashCode()) * 31) + this.lat.hashCode()) * 31) + this.lng.hashCode();
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

    public final void setLng(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lng = str;
    }

    public final void setModule(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.module = str;
    }

    public final void setPromotionTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.promotionTag = str;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        int i12 = this.areaId;
        String str = this.promotionTag;
        String str2 = this.module;
        String str3 = this.lat;
        String str4 = this.lng;
        return "PromotionsWidgetRequestModel(countryId=" + i11 + ", areaId=" + i12 + ", promotionTag=" + str + ", module=" + str2 + ", lat=" + str3 + ", lng=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromotionsWidgetRequestModel(int i11, int i12, String str, String str2, String str3, String str4, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 1 : i11, (i13 & 2) != 0 ? -1 : i12, (i13 & 4) != 0 ? "" : str, (i13 & 8) != 0 ? "" : str2, str3, str4);
    }
}
