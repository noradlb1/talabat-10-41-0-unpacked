package com.talabat.talabatcommon.views.ratings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/ratings/RatingRange;", "", "start", "", "end", "(FF)V", "getEnd", "()F", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingRange {
    private final float end;
    private final float start;

    public RatingRange(float f11, float f12) {
        this.start = f11;
        this.end = f12;
    }

    public static /* synthetic */ RatingRange copy$default(RatingRange ratingRange, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = ratingRange.start;
        }
        if ((i11 & 2) != 0) {
            f12 = ratingRange.end;
        }
        return ratingRange.copy(f11, f12);
    }

    public final float component1() {
        return this.start;
    }

    public final float component2() {
        return this.end;
    }

    @NotNull
    public final RatingRange copy(float f11, float f12) {
        return new RatingRange(f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RatingRange)) {
            return false;
        }
        RatingRange ratingRange = (RatingRange) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.start), (Object) Float.valueOf(ratingRange.start)) && Intrinsics.areEqual((Object) Float.valueOf(this.end), (Object) Float.valueOf(ratingRange.end));
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getStart() {
        return this.start;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.start) * 31) + Float.floatToIntBits(this.end);
    }

    @NotNull
    public String toString() {
        float f11 = this.start;
        float f12 = this.end;
        return "RatingRange(start=" + f11 + ", end=" + f12 + ")";
    }
}
