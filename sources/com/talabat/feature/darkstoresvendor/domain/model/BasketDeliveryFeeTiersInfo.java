package com.talabat.feature.darkstoresvendor.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "", "range", "", "basketDeliveryFreeTiers", "", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFreeTier;", "tags", "Lcom/talabat/feature/darkstoresvendor/domain/model/Tags;", "(Ljava/lang/String;Ljava/util/List;Lcom/talabat/feature/darkstoresvendor/domain/model/Tags;)V", "getBasketDeliveryFreeTiers", "()Ljava/util/List;", "getRange", "()Ljava/lang/String;", "getTags", "()Lcom/talabat/feature/darkstoresvendor/domain/model/Tags;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketDeliveryFeeTiersInfo {
    @NotNull
    private final List<BasketDeliveryFreeTier> basketDeliveryFreeTiers;
    @NotNull
    private final String range;
    @NotNull
    private final Tags tags;

    public BasketDeliveryFeeTiersInfo(@NotNull String str, @NotNull List<BasketDeliveryFreeTier> list, @NotNull Tags tags2) {
        Intrinsics.checkNotNullParameter(str, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        Intrinsics.checkNotNullParameter(list, "basketDeliveryFreeTiers");
        Intrinsics.checkNotNullParameter(tags2, "tags");
        this.range = str;
        this.basketDeliveryFreeTiers = list;
        this.tags = tags2;
    }

    public static /* synthetic */ BasketDeliveryFeeTiersInfo copy$default(BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo, String str, List<BasketDeliveryFreeTier> list, Tags tags2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = basketDeliveryFeeTiersInfo.range;
        }
        if ((i11 & 2) != 0) {
            list = basketDeliveryFeeTiersInfo.basketDeliveryFreeTiers;
        }
        if ((i11 & 4) != 0) {
            tags2 = basketDeliveryFeeTiersInfo.tags;
        }
        return basketDeliveryFeeTiersInfo.copy(str, list, tags2);
    }

    @NotNull
    public final String component1() {
        return this.range;
    }

    @NotNull
    public final List<BasketDeliveryFreeTier> component2() {
        return this.basketDeliveryFreeTiers;
    }

    @NotNull
    public final Tags component3() {
        return this.tags;
    }

    @NotNull
    public final BasketDeliveryFeeTiersInfo copy(@NotNull String str, @NotNull List<BasketDeliveryFreeTier> list, @NotNull Tags tags2) {
        Intrinsics.checkNotNullParameter(str, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        Intrinsics.checkNotNullParameter(list, "basketDeliveryFreeTiers");
        Intrinsics.checkNotNullParameter(tags2, "tags");
        return new BasketDeliveryFeeTiersInfo(str, list, tags2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasketDeliveryFeeTiersInfo)) {
            return false;
        }
        BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo = (BasketDeliveryFeeTiersInfo) obj;
        return Intrinsics.areEqual((Object) this.range, (Object) basketDeliveryFeeTiersInfo.range) && Intrinsics.areEqual((Object) this.basketDeliveryFreeTiers, (Object) basketDeliveryFeeTiersInfo.basketDeliveryFreeTiers) && Intrinsics.areEqual((Object) this.tags, (Object) basketDeliveryFeeTiersInfo.tags);
    }

    @NotNull
    public final List<BasketDeliveryFreeTier> getBasketDeliveryFreeTiers() {
        return this.basketDeliveryFreeTiers;
    }

    @NotNull
    public final String getRange() {
        return this.range;
    }

    @NotNull
    public final Tags getTags() {
        return this.tags;
    }

    public int hashCode() {
        return (((this.range.hashCode() * 31) + this.basketDeliveryFreeTiers.hashCode()) * 31) + this.tags.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.range;
        List<BasketDeliveryFreeTier> list = this.basketDeliveryFreeTiers;
        Tags tags2 = this.tags;
        return "BasketDeliveryFeeTiersInfo(range=" + str + ", basketDeliveryFreeTiers=" + list + ", tags=" + tags2 + ")";
    }
}
