package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "", "items", "", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionItemResponse;", "metadata", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataResponse;", "pageInfo", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/PageInfoResponse;", "(Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataResponse;Lcom/talabat/feature/darkstores/vendorslanding/data/model/PageInfoResponse;)V", "getItems", "()Ljava/util/List;", "getMetadata", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataResponse;", "getPageInfo", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/PageInfoResponse;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMissionResponse {
    @Nullable
    private final List<LifestyleMissionItemResponse> items;
    @Nullable
    private final MetadataResponse metadata;
    @Nullable
    private final PageInfoResponse pageInfo;

    public LifestyleMissionResponse(@Nullable @Json(name = "items") List<LifestyleMissionItemResponse> list, @Nullable @Json(name = "metadata") MetadataResponse metadataResponse, @Nullable @Json(name = "page_info") PageInfoResponse pageInfoResponse) {
        this.items = list;
        this.metadata = metadataResponse;
        this.pageInfo = pageInfoResponse;
    }

    public static /* synthetic */ LifestyleMissionResponse copy$default(LifestyleMissionResponse lifestyleMissionResponse, List<LifestyleMissionItemResponse> list, MetadataResponse metadataResponse, PageInfoResponse pageInfoResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = lifestyleMissionResponse.items;
        }
        if ((i11 & 2) != 0) {
            metadataResponse = lifestyleMissionResponse.metadata;
        }
        if ((i11 & 4) != 0) {
            pageInfoResponse = lifestyleMissionResponse.pageInfo;
        }
        return lifestyleMissionResponse.copy(list, metadataResponse, pageInfoResponse);
    }

    @Nullable
    public final List<LifestyleMissionItemResponse> component1() {
        return this.items;
    }

    @Nullable
    public final MetadataResponse component2() {
        return this.metadata;
    }

    @Nullable
    public final PageInfoResponse component3() {
        return this.pageInfo;
    }

    @NotNull
    public final LifestyleMissionResponse copy(@Nullable @Json(name = "items") List<LifestyleMissionItemResponse> list, @Nullable @Json(name = "metadata") MetadataResponse metadataResponse, @Nullable @Json(name = "page_info") PageInfoResponse pageInfoResponse) {
        return new LifestyleMissionResponse(list, metadataResponse, pageInfoResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LifestyleMissionResponse)) {
            return false;
        }
        LifestyleMissionResponse lifestyleMissionResponse = (LifestyleMissionResponse) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) lifestyleMissionResponse.items) && Intrinsics.areEqual((Object) this.metadata, (Object) lifestyleMissionResponse.metadata) && Intrinsics.areEqual((Object) this.pageInfo, (Object) lifestyleMissionResponse.pageInfo);
    }

    @Nullable
    public final List<LifestyleMissionItemResponse> getItems() {
        return this.items;
    }

    @Nullable
    public final MetadataResponse getMetadata() {
        return this.metadata;
    }

    @Nullable
    public final PageInfoResponse getPageInfo() {
        return this.pageInfo;
    }

    public int hashCode() {
        List<LifestyleMissionItemResponse> list = this.items;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        MetadataResponse metadataResponse = this.metadata;
        int hashCode2 = (hashCode + (metadataResponse == null ? 0 : metadataResponse.hashCode())) * 31;
        PageInfoResponse pageInfoResponse = this.pageInfo;
        if (pageInfoResponse != null) {
            i11 = pageInfoResponse.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        List<LifestyleMissionItemResponse> list = this.items;
        MetadataResponse metadataResponse = this.metadata;
        PageInfoResponse pageInfoResponse = this.pageInfo;
        return "LifestyleMissionResponse(items=" + list + ", metadata=" + metadataResponse + ", pageInfo=" + pageInfoResponse + ")";
    }
}
