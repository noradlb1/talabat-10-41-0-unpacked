package com.talabat.feature.darkstoresvendor.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponse;", "", "range", "", "tiers", "", "Lcom/talabat/feature/darkstoresvendor/data/model/DeliveryFeeTierResponse;", "tags", "Lcom/talabat/feature/darkstoresvendor/data/model/BasketTagsResponse;", "(Ljava/lang/String;Ljava/util/List;Lcom/talabat/feature/darkstoresvendor/data/model/BasketTagsResponse;)V", "getRange", "()Ljava/lang/String;", "getTags", "()Lcom/talabat/feature/darkstoresvendor/data/model/BasketTagsResponse;", "getTiers", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketDeliveryFeeTierInfoResponse {
    @Nullable
    private final String range;
    @Nullable
    private final BasketTagsResponse tags;
    @Nullable
    private final List<DeliveryFeeTierResponse> tiers;

    public BasketDeliveryFeeTierInfoResponse() {
        this((String) null, (List) null, (BasketTagsResponse) null, 7, (DefaultConstructorMarker) null);
    }

    public BasketDeliveryFeeTierInfoResponse(@Nullable @Json(name = "range") String str, @Nullable @Json(name = "tiers") List<DeliveryFeeTierResponse> list, @Nullable @Json(name = "tags") BasketTagsResponse basketTagsResponse) {
        this.range = str;
        this.tiers = list;
        this.tags = basketTagsResponse;
    }

    public static /* synthetic */ BasketDeliveryFeeTierInfoResponse copy$default(BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse, String str, List<DeliveryFeeTierResponse> list, BasketTagsResponse basketTagsResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = basketDeliveryFeeTierInfoResponse.range;
        }
        if ((i11 & 2) != 0) {
            list = basketDeliveryFeeTierInfoResponse.tiers;
        }
        if ((i11 & 4) != 0) {
            basketTagsResponse = basketDeliveryFeeTierInfoResponse.tags;
        }
        return basketDeliveryFeeTierInfoResponse.copy(str, list, basketTagsResponse);
    }

    @Nullable
    public final String component1() {
        return this.range;
    }

    @Nullable
    public final List<DeliveryFeeTierResponse> component2() {
        return this.tiers;
    }

    @Nullable
    public final BasketTagsResponse component3() {
        return this.tags;
    }

    @NotNull
    public final BasketDeliveryFeeTierInfoResponse copy(@Nullable @Json(name = "range") String str, @Nullable @Json(name = "tiers") List<DeliveryFeeTierResponse> list, @Nullable @Json(name = "tags") BasketTagsResponse basketTagsResponse) {
        return new BasketDeliveryFeeTierInfoResponse(str, list, basketTagsResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasketDeliveryFeeTierInfoResponse)) {
            return false;
        }
        BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse = (BasketDeliveryFeeTierInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.range, (Object) basketDeliveryFeeTierInfoResponse.range) && Intrinsics.areEqual((Object) this.tiers, (Object) basketDeliveryFeeTierInfoResponse.tiers) && Intrinsics.areEqual((Object) this.tags, (Object) basketDeliveryFeeTierInfoResponse.tags);
    }

    @Nullable
    public final String getRange() {
        return this.range;
    }

    @Nullable
    public final BasketTagsResponse getTags() {
        return this.tags;
    }

    @Nullable
    public final List<DeliveryFeeTierResponse> getTiers() {
        return this.tiers;
    }

    public int hashCode() {
        String str = this.range;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<DeliveryFeeTierResponse> list = this.tiers;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        BasketTagsResponse basketTagsResponse = this.tags;
        if (basketTagsResponse != null) {
            i11 = basketTagsResponse.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.range;
        List<DeliveryFeeTierResponse> list = this.tiers;
        BasketTagsResponse basketTagsResponse = this.tags;
        return "BasketDeliveryFeeTierInfoResponse(range=" + str + ", tiers=" + list + ", tags=" + basketTagsResponse + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasketDeliveryFeeTierInfoResponse(String str, List list, BasketTagsResponse basketTagsResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : basketTagsResponse);
    }
}
