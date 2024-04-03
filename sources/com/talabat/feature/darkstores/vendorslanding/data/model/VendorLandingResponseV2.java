package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00032\u0010\b\u0003\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00063"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponseV2;", "", "categoryTree", "", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/CategoryTreeResponse;", "lifestyleMission", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "productSwimlanes", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductSwimlanesResponse;", "topSwimlanes", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ItemResponse;", "highlightedSwimlanes", "vendorInfo", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorInfoResponse;", "heroBanners", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/BannerResponse;", "banners", "metadata", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingMetadataResponse;", "(Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductSwimlanesResponse;Ljava/util/List;Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorInfoResponse;Ljava/util/List;Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingMetadataResponse;)V", "getBanners", "()Ljava/util/List;", "getCategoryTree", "getHeroBanners", "getHighlightedSwimlanes", "getLifestyleMission", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "getMetadata", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingMetadataResponse;", "getProductSwimlanes", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductSwimlanesResponse;", "getTopSwimlanes", "getVendorInfo", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorInfoResponse;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingResponseV2 {
    @Nullable
    private final List<BannerResponse> banners;
    @NotNull
    private final List<CategoryTreeResponse> categoryTree;
    @Nullable
    private final List<BannerResponse> heroBanners;
    @Nullable
    private final List<ItemResponse> highlightedSwimlanes;
    @Nullable
    private final LifestyleMissionResponse lifestyleMission;
    @Nullable
    private final VendorLandingMetadataResponse metadata;
    @Nullable
    private final ProductSwimlanesResponse productSwimlanes;
    @Nullable
    private final List<ItemResponse> topSwimlanes;
    @NotNull
    private final VendorInfoResponse vendorInfo;

    public VendorLandingResponseV2(@NotNull @Json(name = "category_tree") List<CategoryTreeResponse> list, @Nullable @Json(name = "lifestyle_missions") LifestyleMissionResponse lifestyleMissionResponse, @Nullable @Json(name = "product_swimlanes") ProductSwimlanesResponse productSwimlanesResponse, @Nullable @Json(name = "top_swimlanes") List<ItemResponse> list2, @Nullable @Json(name = "highlighted_swimlanes") List<ItemResponse> list3, @NotNull @Json(name = "vendor_info") VendorInfoResponse vendorInfoResponse, @Nullable @Json(name = "hero_banners") List<BannerResponse> list4, @Nullable @Json(name = "banners") List<BannerResponse> list5, @Nullable @Json(name = "metadata") VendorLandingMetadataResponse vendorLandingMetadataResponse) {
        Intrinsics.checkNotNullParameter(list, "categoryTree");
        Intrinsics.checkNotNullParameter(vendorInfoResponse, "vendorInfo");
        this.categoryTree = list;
        this.lifestyleMission = lifestyleMissionResponse;
        this.productSwimlanes = productSwimlanesResponse;
        this.topSwimlanes = list2;
        this.highlightedSwimlanes = list3;
        this.vendorInfo = vendorInfoResponse;
        this.heroBanners = list4;
        this.banners = list5;
        this.metadata = vendorLandingMetadataResponse;
    }

    public static /* synthetic */ VendorLandingResponseV2 copy$default(VendorLandingResponseV2 vendorLandingResponseV2, List list, LifestyleMissionResponse lifestyleMissionResponse, ProductSwimlanesResponse productSwimlanesResponse, List list2, List list3, VendorInfoResponse vendorInfoResponse, List list4, List list5, VendorLandingMetadataResponse vendorLandingMetadataResponse, int i11, Object obj) {
        VendorLandingResponseV2 vendorLandingResponseV22 = vendorLandingResponseV2;
        int i12 = i11;
        return vendorLandingResponseV2.copy((i12 & 1) != 0 ? vendorLandingResponseV22.categoryTree : list, (i12 & 2) != 0 ? vendorLandingResponseV22.lifestyleMission : lifestyleMissionResponse, (i12 & 4) != 0 ? vendorLandingResponseV22.productSwimlanes : productSwimlanesResponse, (i12 & 8) != 0 ? vendorLandingResponseV22.topSwimlanes : list2, (i12 & 16) != 0 ? vendorLandingResponseV22.highlightedSwimlanes : list3, (i12 & 32) != 0 ? vendorLandingResponseV22.vendorInfo : vendorInfoResponse, (i12 & 64) != 0 ? vendorLandingResponseV22.heroBanners : list4, (i12 & 128) != 0 ? vendorLandingResponseV22.banners : list5, (i12 & 256) != 0 ? vendorLandingResponseV22.metadata : vendorLandingMetadataResponse);
    }

    @NotNull
    public final List<CategoryTreeResponse> component1() {
        return this.categoryTree;
    }

    @Nullable
    public final LifestyleMissionResponse component2() {
        return this.lifestyleMission;
    }

    @Nullable
    public final ProductSwimlanesResponse component3() {
        return this.productSwimlanes;
    }

    @Nullable
    public final List<ItemResponse> component4() {
        return this.topSwimlanes;
    }

    @Nullable
    public final List<ItemResponse> component5() {
        return this.highlightedSwimlanes;
    }

    @NotNull
    public final VendorInfoResponse component6() {
        return this.vendorInfo;
    }

    @Nullable
    public final List<BannerResponse> component7() {
        return this.heroBanners;
    }

    @Nullable
    public final List<BannerResponse> component8() {
        return this.banners;
    }

    @Nullable
    public final VendorLandingMetadataResponse component9() {
        return this.metadata;
    }

    @NotNull
    public final VendorLandingResponseV2 copy(@NotNull @Json(name = "category_tree") List<CategoryTreeResponse> list, @Nullable @Json(name = "lifestyle_missions") LifestyleMissionResponse lifestyleMissionResponse, @Nullable @Json(name = "product_swimlanes") ProductSwimlanesResponse productSwimlanesResponse, @Nullable @Json(name = "top_swimlanes") List<ItemResponse> list2, @Nullable @Json(name = "highlighted_swimlanes") List<ItemResponse> list3, @NotNull @Json(name = "vendor_info") VendorInfoResponse vendorInfoResponse, @Nullable @Json(name = "hero_banners") List<BannerResponse> list4, @Nullable @Json(name = "banners") List<BannerResponse> list5, @Nullable @Json(name = "metadata") VendorLandingMetadataResponse vendorLandingMetadataResponse) {
        Intrinsics.checkNotNullParameter(list, "categoryTree");
        VendorInfoResponse vendorInfoResponse2 = vendorInfoResponse;
        Intrinsics.checkNotNullParameter(vendorInfoResponse2, "vendorInfo");
        return new VendorLandingResponseV2(list, lifestyleMissionResponse, productSwimlanesResponse, list2, list3, vendorInfoResponse2, list4, list5, vendorLandingMetadataResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorLandingResponseV2)) {
            return false;
        }
        VendorLandingResponseV2 vendorLandingResponseV2 = (VendorLandingResponseV2) obj;
        return Intrinsics.areEqual((Object) this.categoryTree, (Object) vendorLandingResponseV2.categoryTree) && Intrinsics.areEqual((Object) this.lifestyleMission, (Object) vendorLandingResponseV2.lifestyleMission) && Intrinsics.areEqual((Object) this.productSwimlanes, (Object) vendorLandingResponseV2.productSwimlanes) && Intrinsics.areEqual((Object) this.topSwimlanes, (Object) vendorLandingResponseV2.topSwimlanes) && Intrinsics.areEqual((Object) this.highlightedSwimlanes, (Object) vendorLandingResponseV2.highlightedSwimlanes) && Intrinsics.areEqual((Object) this.vendorInfo, (Object) vendorLandingResponseV2.vendorInfo) && Intrinsics.areEqual((Object) this.heroBanners, (Object) vendorLandingResponseV2.heroBanners) && Intrinsics.areEqual((Object) this.banners, (Object) vendorLandingResponseV2.banners) && Intrinsics.areEqual((Object) this.metadata, (Object) vendorLandingResponseV2.metadata);
    }

    @Nullable
    public final List<BannerResponse> getBanners() {
        return this.banners;
    }

    @NotNull
    public final List<CategoryTreeResponse> getCategoryTree() {
        return this.categoryTree;
    }

    @Nullable
    public final List<BannerResponse> getHeroBanners() {
        return this.heroBanners;
    }

    @Nullable
    public final List<ItemResponse> getHighlightedSwimlanes() {
        return this.highlightedSwimlanes;
    }

    @Nullable
    public final LifestyleMissionResponse getLifestyleMission() {
        return this.lifestyleMission;
    }

    @Nullable
    public final VendorLandingMetadataResponse getMetadata() {
        return this.metadata;
    }

    @Nullable
    public final ProductSwimlanesResponse getProductSwimlanes() {
        return this.productSwimlanes;
    }

    @Nullable
    public final List<ItemResponse> getTopSwimlanes() {
        return this.topSwimlanes;
    }

    @NotNull
    public final VendorInfoResponse getVendorInfo() {
        return this.vendorInfo;
    }

    public int hashCode() {
        int hashCode = this.categoryTree.hashCode() * 31;
        LifestyleMissionResponse lifestyleMissionResponse = this.lifestyleMission;
        int i11 = 0;
        int hashCode2 = (hashCode + (lifestyleMissionResponse == null ? 0 : lifestyleMissionResponse.hashCode())) * 31;
        ProductSwimlanesResponse productSwimlanesResponse = this.productSwimlanes;
        int hashCode3 = (hashCode2 + (productSwimlanesResponse == null ? 0 : productSwimlanesResponse.hashCode())) * 31;
        List<ItemResponse> list = this.topSwimlanes;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<ItemResponse> list2 = this.highlightedSwimlanes;
        int hashCode5 = (((hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.vendorInfo.hashCode()) * 31;
        List<BannerResponse> list3 = this.heroBanners;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<BannerResponse> list4 = this.banners;
        int hashCode7 = (hashCode6 + (list4 == null ? 0 : list4.hashCode())) * 31;
        VendorLandingMetadataResponse vendorLandingMetadataResponse = this.metadata;
        if (vendorLandingMetadataResponse != null) {
            i11 = vendorLandingMetadataResponse.hashCode();
        }
        return hashCode7 + i11;
    }

    @NotNull
    public String toString() {
        List<CategoryTreeResponse> list = this.categoryTree;
        LifestyleMissionResponse lifestyleMissionResponse = this.lifestyleMission;
        ProductSwimlanesResponse productSwimlanesResponse = this.productSwimlanes;
        List<ItemResponse> list2 = this.topSwimlanes;
        List<ItemResponse> list3 = this.highlightedSwimlanes;
        VendorInfoResponse vendorInfoResponse = this.vendorInfo;
        List<BannerResponse> list4 = this.heroBanners;
        List<BannerResponse> list5 = this.banners;
        VendorLandingMetadataResponse vendorLandingMetadataResponse = this.metadata;
        return "VendorLandingResponseV2(categoryTree=" + list + ", lifestyleMission=" + lifestyleMissionResponse + ", productSwimlanes=" + productSwimlanesResponse + ", topSwimlanes=" + list2 + ", highlightedSwimlanes=" + list3 + ", vendorInfo=" + vendorInfoResponse + ", heroBanners=" + list4 + ", banners=" + list5 + ", metadata=" + vendorLandingMetadataResponse + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorLandingResponseV2(java.util.List r14, com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse r15, com.talabat.feature.darkstores.vendorslanding.data.model.ProductSwimlanesResponse r16, java.util.List r17, java.util.List r18, com.talabat.feature.darkstores.vendorslanding.data.model.VendorInfoResponse r19, java.util.List r20, java.util.List r21, com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingMetadataResponse r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000a
        L_0x0009:
            r5 = r15
        L_0x000a:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0010
            r6 = r2
            goto L_0x0012
        L_0x0010:
            r6 = r16
        L_0x0012:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0018
            r7 = r2
            goto L_0x001a
        L_0x0018:
            r7 = r17
        L_0x001a:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0020
            r8 = r2
            goto L_0x0022
        L_0x0020:
            r8 = r18
        L_0x0022:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0028
            r10 = r2
            goto L_0x002a
        L_0x0028:
            r10 = r20
        L_0x002a:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0030
            r11 = r2
            goto L_0x0032
        L_0x0030:
            r11 = r21
        L_0x0032:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0038
            r12 = r2
            goto L_0x003a
        L_0x0038:
            r12 = r22
        L_0x003a:
            r3 = r13
            r4 = r14
            r9 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponseV2.<init>(java.util.List, com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse, com.talabat.feature.darkstores.vendorslanding.data.model.ProductSwimlanesResponse, java.util.List, java.util.List, com.talabat.feature.darkstores.vendorslanding.data.model.VendorInfoResponse, java.util.List, java.util.List, com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingMetadataResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
