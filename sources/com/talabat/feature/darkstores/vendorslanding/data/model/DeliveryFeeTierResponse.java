package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/DeliveryFeeTierResponse;", "", "from", "", "to", "totalDeliveryFee", "tags", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/TierTagsResponse;", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/talabat/feature/darkstores/vendorslanding/data/model/TierTagsResponse;)V", "getFrom", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTags", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/TierTagsResponse;", "getTo", "getTotalDeliveryFee", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/talabat/feature/darkstores/vendorslanding/data/model/TierTagsResponse;)Lcom/talabat/feature/darkstores/vendorslanding/data/model/DeliveryFeeTierResponse;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryFeeTierResponse {
    @Nullable
    private final Float from;
    @Nullable
    private final TierTagsResponse tags;
    @Nullable

    /* renamed from: to  reason: collision with root package name */
    private final Float f58436to;
    @Nullable
    private final Float totalDeliveryFee;

    public DeliveryFeeTierResponse() {
        this((Float) null, (Float) null, (Float) null, (TierTagsResponse) null, 15, (DefaultConstructorMarker) null);
    }

    public DeliveryFeeTierResponse(@Nullable @Json(name = "from") Float f11, @Nullable @Json(name = "to") Float f12, @Nullable @Json(name = "total_delivery_fee") Float f13, @Nullable @Json(name = "tags") TierTagsResponse tierTagsResponse) {
        this.from = f11;
        this.f58436to = f12;
        this.totalDeliveryFee = f13;
        this.tags = tierTagsResponse;
    }

    public static /* synthetic */ DeliveryFeeTierResponse copy$default(DeliveryFeeTierResponse deliveryFeeTierResponse, Float f11, Float f12, Float f13, TierTagsResponse tierTagsResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = deliveryFeeTierResponse.from;
        }
        if ((i11 & 2) != 0) {
            f12 = deliveryFeeTierResponse.f58436to;
        }
        if ((i11 & 4) != 0) {
            f13 = deliveryFeeTierResponse.totalDeliveryFee;
        }
        if ((i11 & 8) != 0) {
            tierTagsResponse = deliveryFeeTierResponse.tags;
        }
        return deliveryFeeTierResponse.copy(f11, f12, f13, tierTagsResponse);
    }

    @Nullable
    public final Float component1() {
        return this.from;
    }

    @Nullable
    public final Float component2() {
        return this.f58436to;
    }

    @Nullable
    public final Float component3() {
        return this.totalDeliveryFee;
    }

    @Nullable
    public final TierTagsResponse component4() {
        return this.tags;
    }

    @NotNull
    public final DeliveryFeeTierResponse copy(@Nullable @Json(name = "from") Float f11, @Nullable @Json(name = "to") Float f12, @Nullable @Json(name = "total_delivery_fee") Float f13, @Nullable @Json(name = "tags") TierTagsResponse tierTagsResponse) {
        return new DeliveryFeeTierResponse(f11, f12, f13, tierTagsResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryFeeTierResponse)) {
            return false;
        }
        DeliveryFeeTierResponse deliveryFeeTierResponse = (DeliveryFeeTierResponse) obj;
        return Intrinsics.areEqual((Object) this.from, (Object) deliveryFeeTierResponse.from) && Intrinsics.areEqual((Object) this.f58436to, (Object) deliveryFeeTierResponse.f58436to) && Intrinsics.areEqual((Object) this.totalDeliveryFee, (Object) deliveryFeeTierResponse.totalDeliveryFee) && Intrinsics.areEqual((Object) this.tags, (Object) deliveryFeeTierResponse.tags);
    }

    @Nullable
    public final Float getFrom() {
        return this.from;
    }

    @Nullable
    public final TierTagsResponse getTags() {
        return this.tags;
    }

    @Nullable
    public final Float getTo() {
        return this.f58436to;
    }

    @Nullable
    public final Float getTotalDeliveryFee() {
        return this.totalDeliveryFee;
    }

    public int hashCode() {
        Float f11 = this.from;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Float f12 = this.f58436to;
        int hashCode2 = (hashCode + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.totalDeliveryFee;
        int hashCode3 = (hashCode2 + (f13 == null ? 0 : f13.hashCode())) * 31;
        TierTagsResponse tierTagsResponse = this.tags;
        if (tierTagsResponse != null) {
            i11 = tierTagsResponse.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        Float f11 = this.from;
        Float f12 = this.f58436to;
        Float f13 = this.totalDeliveryFee;
        TierTagsResponse tierTagsResponse = this.tags;
        return "DeliveryFeeTierResponse(from=" + f11 + ", to=" + f12 + ", totalDeliveryFee=" + f13 + ", tags=" + tierTagsResponse + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeliveryFeeTierResponse(Float f11, Float f12, Float f13, TierTagsResponse tierTagsResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : f11, (i11 & 2) != 0 ? null : f12, (i11 & 4) != 0 ? null : f13, (i11 & 8) != 0 ? null : tierTagsResponse);
    }
}
