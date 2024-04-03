package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\b\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016¨\u00063"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/VendorsDto;", "", "activeEventDto", "Lcom/talabat/offering/data/remote/dtos/ActiveEventDto;", "areaId", "", "baseUrl", "", "maxCpcSlots", "midasRequestId", "priceTagDto", "Lcom/talabat/offering/data/remote/dtos/PriceTagDto;", "restaurants", "", "Ldatamodels/Restaurant;", "showCollections", "", "totalVendors", "(Lcom/talabat/offering/data/remote/dtos/ActiveEventDto;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/PriceTagDto;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getActiveEventDto", "()Lcom/talabat/offering/data/remote/dtos/ActiveEventDto;", "getAreaId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBaseUrl", "()Ljava/lang/String;", "getMaxCpcSlots", "getMidasRequestId", "getPriceTagDto", "()Lcom/talabat/offering/data/remote/dtos/PriceTagDto;", "getRestaurants", "()Ljava/util/List;", "getShowCollections", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTotalVendors", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/talabat/offering/data/remote/dtos/ActiveEventDto;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/PriceTagDto;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/talabat/offering/data/remote/dtos/VendorsDto;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsDto {
    @SerializedName("active_event")
    @Nullable
    private final ActiveEventDto activeEventDto;
    @SerializedName("area_id")
    @Nullable
    private final Integer areaId;
    @SerializedName("baseUrl")
    @Nullable
    private final String baseUrl;
    @SerializedName("max_cpc_slots")
    @Nullable
    private final Integer maxCpcSlots;
    @SerializedName("midas_request_id")
    @Nullable
    private final String midasRequestId;
    @SerializedName("price_tag")
    @Nullable
    private final PriceTagDto priceTagDto;
    @SerializedName("restaurants")
    @Nullable
    private final List<Restaurant> restaurants;
    @SerializedName("showCollections")
    @Nullable
    private final Boolean showCollections;
    @SerializedName("total_vendors")
    @Nullable
    private final Integer totalVendors;

    public VendorsDto() {
        this((ActiveEventDto) null, (Integer) null, (String) null, (Integer) null, (String) null, (PriceTagDto) null, (List) null, (Boolean) null, (Integer) null, 511, (DefaultConstructorMarker) null);
    }

    public VendorsDto(@Nullable ActiveEventDto activeEventDto2, @Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2, @Nullable PriceTagDto priceTagDto2, @Nullable List<? extends Restaurant> list, @Nullable Boolean bool, @Nullable Integer num3) {
        this.activeEventDto = activeEventDto2;
        this.areaId = num;
        this.baseUrl = str;
        this.maxCpcSlots = num2;
        this.midasRequestId = str2;
        this.priceTagDto = priceTagDto2;
        this.restaurants = list;
        this.showCollections = bool;
        this.totalVendors = num3;
    }

    public static /* synthetic */ VendorsDto copy$default(VendorsDto vendorsDto, ActiveEventDto activeEventDto2, Integer num, String str, Integer num2, String str2, PriceTagDto priceTagDto2, List list, Boolean bool, Integer num3, int i11, Object obj) {
        VendorsDto vendorsDto2 = vendorsDto;
        int i12 = i11;
        return vendorsDto.copy((i12 & 1) != 0 ? vendorsDto2.activeEventDto : activeEventDto2, (i12 & 2) != 0 ? vendorsDto2.areaId : num, (i12 & 4) != 0 ? vendorsDto2.baseUrl : str, (i12 & 8) != 0 ? vendorsDto2.maxCpcSlots : num2, (i12 & 16) != 0 ? vendorsDto2.midasRequestId : str2, (i12 & 32) != 0 ? vendorsDto2.priceTagDto : priceTagDto2, (i12 & 64) != 0 ? vendorsDto2.restaurants : list, (i12 & 128) != 0 ? vendorsDto2.showCollections : bool, (i12 & 256) != 0 ? vendorsDto2.totalVendors : num3);
    }

    @Nullable
    public final ActiveEventDto component1() {
        return this.activeEventDto;
    }

    @Nullable
    public final Integer component2() {
        return this.areaId;
    }

    @Nullable
    public final String component3() {
        return this.baseUrl;
    }

    @Nullable
    public final Integer component4() {
        return this.maxCpcSlots;
    }

    @Nullable
    public final String component5() {
        return this.midasRequestId;
    }

    @Nullable
    public final PriceTagDto component6() {
        return this.priceTagDto;
    }

    @Nullable
    public final List<Restaurant> component7() {
        return this.restaurants;
    }

    @Nullable
    public final Boolean component8() {
        return this.showCollections;
    }

    @Nullable
    public final Integer component9() {
        return this.totalVendors;
    }

    @NotNull
    public final VendorsDto copy(@Nullable ActiveEventDto activeEventDto2, @Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2, @Nullable PriceTagDto priceTagDto2, @Nullable List<? extends Restaurant> list, @Nullable Boolean bool, @Nullable Integer num3) {
        return new VendorsDto(activeEventDto2, num, str, num2, str2, priceTagDto2, list, bool, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorsDto)) {
            return false;
        }
        VendorsDto vendorsDto = (VendorsDto) obj;
        return Intrinsics.areEqual((Object) this.activeEventDto, (Object) vendorsDto.activeEventDto) && Intrinsics.areEqual((Object) this.areaId, (Object) vendorsDto.areaId) && Intrinsics.areEqual((Object) this.baseUrl, (Object) vendorsDto.baseUrl) && Intrinsics.areEqual((Object) this.maxCpcSlots, (Object) vendorsDto.maxCpcSlots) && Intrinsics.areEqual((Object) this.midasRequestId, (Object) vendorsDto.midasRequestId) && Intrinsics.areEqual((Object) this.priceTagDto, (Object) vendorsDto.priceTagDto) && Intrinsics.areEqual((Object) this.restaurants, (Object) vendorsDto.restaurants) && Intrinsics.areEqual((Object) this.showCollections, (Object) vendorsDto.showCollections) && Intrinsics.areEqual((Object) this.totalVendors, (Object) vendorsDto.totalVendors);
    }

    @Nullable
    public final ActiveEventDto getActiveEventDto() {
        return this.activeEventDto;
    }

    @Nullable
    public final Integer getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final Integer getMaxCpcSlots() {
        return this.maxCpcSlots;
    }

    @Nullable
    public final String getMidasRequestId() {
        return this.midasRequestId;
    }

    @Nullable
    public final PriceTagDto getPriceTagDto() {
        return this.priceTagDto;
    }

    @Nullable
    public final List<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    @Nullable
    public final Boolean getShowCollections() {
        return this.showCollections;
    }

    @Nullable
    public final Integer getTotalVendors() {
        return this.totalVendors;
    }

    public int hashCode() {
        ActiveEventDto activeEventDto2 = this.activeEventDto;
        int i11 = 0;
        int hashCode = (activeEventDto2 == null ? 0 : activeEventDto2.hashCode()) * 31;
        Integer num = this.areaId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.baseUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.maxCpcSlots;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.midasRequestId;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PriceTagDto priceTagDto2 = this.priceTagDto;
        int hashCode6 = (hashCode5 + (priceTagDto2 == null ? 0 : priceTagDto2.hashCode())) * 31;
        List<Restaurant> list = this.restaurants;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.showCollections;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num3 = this.totalVendors;
        if (num3 != null) {
            i11 = num3.hashCode();
        }
        return hashCode8 + i11;
    }

    @NotNull
    public String toString() {
        ActiveEventDto activeEventDto2 = this.activeEventDto;
        Integer num = this.areaId;
        String str = this.baseUrl;
        Integer num2 = this.maxCpcSlots;
        String str2 = this.midasRequestId;
        PriceTagDto priceTagDto2 = this.priceTagDto;
        List<Restaurant> list = this.restaurants;
        Boolean bool = this.showCollections;
        Integer num3 = this.totalVendors;
        return "VendorsDto(activeEventDto=" + activeEventDto2 + ", areaId=" + num + ", baseUrl=" + str + ", maxCpcSlots=" + num2 + ", midasRequestId=" + str2 + ", priceTagDto=" + priceTagDto2 + ", restaurants=" + list + ", showCollections=" + bool + ", totalVendors=" + num3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorsDto(com.talabat.offering.data.remote.dtos.ActiveEventDto r11, java.lang.Integer r12, java.lang.String r13, java.lang.Integer r14, java.lang.String r15, com.talabat.offering.data.remote.dtos.PriceTagDto r16, java.util.List r17, java.lang.Boolean r18, java.lang.Integer r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.remote.dtos.VendorsDto.<init>(com.talabat.offering.data.remote.dtos.ActiveEventDto, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, com.talabat.offering.data.remote.dtos.PriceTagDto, java.util.List, java.lang.Boolean, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
