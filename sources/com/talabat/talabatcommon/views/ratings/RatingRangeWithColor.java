package com.talabat.talabatcommon.views.ratings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/views/ratings/RatingRangeWithColor;", "", "range", "Lcom/talabat/talabatcommon/views/ratings/RatingRange;", "color", "", "(Lcom/talabat/talabatcommon/views/ratings/RatingRange;I)V", "getColor", "()I", "getRange", "()Lcom/talabat/talabatcommon/views/ratings/RatingRange;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingRangeWithColor {
    private final int color;
    @NotNull
    private final RatingRange range;

    public RatingRangeWithColor(@NotNull RatingRange ratingRange, int i11) {
        Intrinsics.checkNotNullParameter(ratingRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        this.range = ratingRange;
        this.color = i11;
    }

    public static /* synthetic */ RatingRangeWithColor copy$default(RatingRangeWithColor ratingRangeWithColor, RatingRange ratingRange, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            ratingRange = ratingRangeWithColor.range;
        }
        if ((i12 & 2) != 0) {
            i11 = ratingRangeWithColor.color;
        }
        return ratingRangeWithColor.copy(ratingRange, i11);
    }

    @NotNull
    public final RatingRange component1() {
        return this.range;
    }

    public final int component2() {
        return this.color;
    }

    @NotNull
    public final RatingRangeWithColor copy(@NotNull RatingRange ratingRange, int i11) {
        Intrinsics.checkNotNullParameter(ratingRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        return new RatingRangeWithColor(ratingRange, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RatingRangeWithColor)) {
            return false;
        }
        RatingRangeWithColor ratingRangeWithColor = (RatingRangeWithColor) obj;
        return Intrinsics.areEqual((Object) this.range, (Object) ratingRangeWithColor.range) && this.color == ratingRangeWithColor.color;
    }

    public final int getColor() {
        return this.color;
    }

    @NotNull
    public final RatingRange getRange() {
        return this.range;
    }

    public int hashCode() {
        return (this.range.hashCode() * 31) + this.color;
    }

    @NotNull
    public String toString() {
        RatingRange ratingRange = this.range;
        int i11 = this.color;
        return "RatingRangeWithColor(range=" + ratingRange + ", color=" + i11 + ")";
    }
}
