package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B]\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\rHÆ\u0003Ja\u0010\u001f\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006'"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponse;", "", "categoryTree", "", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/CategoryTreeResponse;", "lifestyleMission", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "productSwimlanes", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductSwimlanesResponse;", "topSwimlanes", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ItemResponse;", "highlightedSwimlanes", "metadata", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingMetadataResponse;", "(Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductSwimlanesResponse;Ljava/util/List;Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingMetadataResponse;)V", "getCategoryTree", "()Ljava/util/List;", "getHighlightedSwimlanes", "getLifestyleMission", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "getMetadata", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingMetadataResponse;", "getProductSwimlanes", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductSwimlanesResponse;", "getTopSwimlanes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingResponse {
    @NotNull
    private final List<CategoryTreeResponse> categoryTree;
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

    public VendorLandingResponse(@NotNull @Json(name = "category_tree") List<CategoryTreeResponse> list, @Nullable @Json(name = "lifestyle_missions") LifestyleMissionResponse lifestyleMissionResponse, @Nullable @Json(name = "product_swimlanes") ProductSwimlanesResponse productSwimlanesResponse, @Nullable @Json(name = "top_swimlanes") List<ItemResponse> list2, @Nullable @Json(name = "highlighted_swimlanes") List<ItemResponse> list3, @Nullable @Json(name = "metadata") VendorLandingMetadataResponse vendorLandingMetadataResponse) {
        Intrinsics.checkNotNullParameter(list, "categoryTree");
        this.categoryTree = list;
        this.lifestyleMission = lifestyleMissionResponse;
        this.productSwimlanes = productSwimlanesResponse;
        this.topSwimlanes = list2;
        this.highlightedSwimlanes = list3;
        this.metadata = vendorLandingMetadataResponse;
    }

    public static /* synthetic */ VendorLandingResponse copy$default(VendorLandingResponse vendorLandingResponse, List<CategoryTreeResponse> list, LifestyleMissionResponse lifestyleMissionResponse, ProductSwimlanesResponse productSwimlanesResponse, List<ItemResponse> list2, List<ItemResponse> list3, VendorLandingMetadataResponse vendorLandingMetadataResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = vendorLandingResponse.categoryTree;
        }
        if ((i11 & 2) != 0) {
            lifestyleMissionResponse = vendorLandingResponse.lifestyleMission;
        }
        LifestyleMissionResponse lifestyleMissionResponse2 = lifestyleMissionResponse;
        if ((i11 & 4) != 0) {
            productSwimlanesResponse = vendorLandingResponse.productSwimlanes;
        }
        ProductSwimlanesResponse productSwimlanesResponse2 = productSwimlanesResponse;
        if ((i11 & 8) != 0) {
            list2 = vendorLandingResponse.topSwimlanes;
        }
        List<ItemResponse> list4 = list2;
        if ((i11 & 16) != 0) {
            list3 = vendorLandingResponse.highlightedSwimlanes;
        }
        List<ItemResponse> list5 = list3;
        if ((i11 & 32) != 0) {
            vendorLandingMetadataResponse = vendorLandingResponse.metadata;
        }
        return vendorLandingResponse.copy(list, lifestyleMissionResponse2, productSwimlanesResponse2, list4, list5, vendorLandingMetadataResponse);
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

    @Nullable
    public final VendorLandingMetadataResponse component6() {
        return this.metadata;
    }

    @NotNull
    public final VendorLandingResponse copy(@NotNull @Json(name = "category_tree") List<CategoryTreeResponse> list, @Nullable @Json(name = "lifestyle_missions") LifestyleMissionResponse lifestyleMissionResponse, @Nullable @Json(name = "product_swimlanes") ProductSwimlanesResponse productSwimlanesResponse, @Nullable @Json(name = "top_swimlanes") List<ItemResponse> list2, @Nullable @Json(name = "highlighted_swimlanes") List<ItemResponse> list3, @Nullable @Json(name = "metadata") VendorLandingMetadataResponse vendorLandingMetadataResponse) {
        Intrinsics.checkNotNullParameter(list, "categoryTree");
        return new VendorLandingResponse(list, lifestyleMissionResponse, productSwimlanesResponse, list2, list3, vendorLandingMetadataResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorLandingResponse)) {
            return false;
        }
        VendorLandingResponse vendorLandingResponse = (VendorLandingResponse) obj;
        return Intrinsics.areEqual((Object) this.categoryTree, (Object) vendorLandingResponse.categoryTree) && Intrinsics.areEqual((Object) this.lifestyleMission, (Object) vendorLandingResponse.lifestyleMission) && Intrinsics.areEqual((Object) this.productSwimlanes, (Object) vendorLandingResponse.productSwimlanes) && Intrinsics.areEqual((Object) this.topSwimlanes, (Object) vendorLandingResponse.topSwimlanes) && Intrinsics.areEqual((Object) this.highlightedSwimlanes, (Object) vendorLandingResponse.highlightedSwimlanes) && Intrinsics.areEqual((Object) this.metadata, (Object) vendorLandingResponse.metadata);
    }

    @NotNull
    public final List<CategoryTreeResponse> getCategoryTree() {
        return this.categoryTree;
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
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        VendorLandingMetadataResponse vendorLandingMetadataResponse = this.metadata;
        if (vendorLandingMetadataResponse != null) {
            i11 = vendorLandingMetadataResponse.hashCode();
        }
        return hashCode5 + i11;
    }

    @NotNull
    public String toString() {
        List<CategoryTreeResponse> list = this.categoryTree;
        LifestyleMissionResponse lifestyleMissionResponse = this.lifestyleMission;
        ProductSwimlanesResponse productSwimlanesResponse = this.productSwimlanes;
        List<ItemResponse> list2 = this.topSwimlanes;
        List<ItemResponse> list3 = this.highlightedSwimlanes;
        VendorLandingMetadataResponse vendorLandingMetadataResponse = this.metadata;
        return "VendorLandingResponse(categoryTree=" + list + ", lifestyleMission=" + lifestyleMissionResponse + ", productSwimlanes=" + productSwimlanesResponse + ", topSwimlanes=" + list2 + ", highlightedSwimlanes=" + list3 + ", metadata=" + vendorLandingMetadataResponse + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorLandingResponse(java.util.List r7, com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse r8, com.talabat.feature.darkstores.vendorslanding.data.model.ProductSwimlanesResponse r9, java.util.List r10, java.util.List r11, com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingMetadataResponse r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r6 = this;
            r0 = r13 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r13 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r3 = r13 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r10
        L_0x0016:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r5 = r13 & 32
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r12
        L_0x0023:
            r8 = r6
            r9 = r7
            r10 = r0
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponse.<init>(java.util.List, com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse, com.talabat.feature.darkstores.vendorslanding.data.model.ProductSwimlanesResponse, java.util.List, java.util.List, com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingMetadataResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
