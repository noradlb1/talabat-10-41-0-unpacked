package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductSwimlanesResponse;", "", "items", "", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ItemResponse;", "pageInfo", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/PageInfoResponse;", "requestId", "", "(Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/PageInfoResponse;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getPageInfo", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/PageInfoResponse;", "getRequestId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductSwimlanesResponse {
    @Nullable
    private final List<ItemResponse> items;
    @Nullable
    private final PageInfoResponse pageInfo;
    @Nullable
    private final String requestId;

    public ProductSwimlanesResponse() {
        this((List) null, (PageInfoResponse) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public ProductSwimlanesResponse(@Nullable @Json(name = "items") List<ItemResponse> list, @Nullable @Json(name = "page_info") PageInfoResponse pageInfoResponse, @Nullable @Json(name = "request_id") String str) {
        this.items = list;
        this.pageInfo = pageInfoResponse;
        this.requestId = str;
    }

    public static /* synthetic */ ProductSwimlanesResponse copy$default(ProductSwimlanesResponse productSwimlanesResponse, List<ItemResponse> list, PageInfoResponse pageInfoResponse, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = productSwimlanesResponse.items;
        }
        if ((i11 & 2) != 0) {
            pageInfoResponse = productSwimlanesResponse.pageInfo;
        }
        if ((i11 & 4) != 0) {
            str = productSwimlanesResponse.requestId;
        }
        return productSwimlanesResponse.copy(list, pageInfoResponse, str);
    }

    @Nullable
    public final List<ItemResponse> component1() {
        return this.items;
    }

    @Nullable
    public final PageInfoResponse component2() {
        return this.pageInfo;
    }

    @Nullable
    public final String component3() {
        return this.requestId;
    }

    @NotNull
    public final ProductSwimlanesResponse copy(@Nullable @Json(name = "items") List<ItemResponse> list, @Nullable @Json(name = "page_info") PageInfoResponse pageInfoResponse, @Nullable @Json(name = "request_id") String str) {
        return new ProductSwimlanesResponse(list, pageInfoResponse, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductSwimlanesResponse)) {
            return false;
        }
        ProductSwimlanesResponse productSwimlanesResponse = (ProductSwimlanesResponse) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) productSwimlanesResponse.items) && Intrinsics.areEqual((Object) this.pageInfo, (Object) productSwimlanesResponse.pageInfo) && Intrinsics.areEqual((Object) this.requestId, (Object) productSwimlanesResponse.requestId);
    }

    @Nullable
    public final List<ItemResponse> getItems() {
        return this.items;
    }

    @Nullable
    public final PageInfoResponse getPageInfo() {
        return this.pageInfo;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        List<ItemResponse> list = this.items;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        PageInfoResponse pageInfoResponse = this.pageInfo;
        int hashCode2 = (hashCode + (pageInfoResponse == null ? 0 : pageInfoResponse.hashCode())) * 31;
        String str = this.requestId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        List<ItemResponse> list = this.items;
        PageInfoResponse pageInfoResponse = this.pageInfo;
        String str = this.requestId;
        return "ProductSwimlanesResponse(items=" + list + ", pageInfo=" + pageInfoResponse + ", requestId=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductSwimlanesResponse(List list, PageInfoResponse pageInfoResponse, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : pageInfoResponse, (i11 & 4) != 0 ? null : str);
    }
}
