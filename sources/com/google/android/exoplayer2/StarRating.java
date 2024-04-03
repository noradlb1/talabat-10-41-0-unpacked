package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import g7.l3;

public final class StarRating extends Rating {
    public static final Bundleable.Creator<StarRating> CREATOR = new l3();
    private static final String FIELD_MAX_STARS = Util.intToStringMaxRadix(1);
    private static final String FIELD_STAR_RATING = Util.intToStringMaxRadix(2);
    private static final int MAX_STARS_DEFAULT = 5;
    private static final int TYPE = 2;
    @IntRange(from = 1)
    private final int maxStars;
    private final float starRating;

    public StarRating(@IntRange(from = 1) int i11) {
        Assertions.checkArgument(i11 > 0, "maxStars must be a positive integer");
        this.maxStars = i11;
        this.starRating = -1.0f;
    }

    /* access modifiers changed from: private */
    public static StarRating fromBundle(Bundle bundle) {
        boolean z11;
        if (bundle.getInt(Rating.FIELD_RATING_TYPE, -1) == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        int i11 = bundle.getInt(FIELD_MAX_STARS, 5);
        float f11 = bundle.getFloat(FIELD_STAR_RATING, -1.0f);
        if (f11 == -1.0f) {
            return new StarRating(i11);
        }
        return new StarRating(i11, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating2 = (StarRating) obj;
        if (this.maxStars == starRating2.maxStars && this.starRating == starRating2.starRating) {
            return true;
        }
        return false;
    }

    @IntRange(from = 1)
    public int getMaxStars() {
        return this.maxStars;
    }

    public float getStarRating() {
        return this.starRating;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.maxStars), Float.valueOf(this.starRating));
    }

    public boolean isRated() {
        return this.starRating != -1.0f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.FIELD_RATING_TYPE, 2);
        bundle.putInt(FIELD_MAX_STARS, this.maxStars);
        bundle.putFloat(FIELD_STAR_RATING, this.starRating);
        return bundle;
    }

    public StarRating(@IntRange(from = 1) int i11, @FloatRange(from = 0.0d) float f11) {
        boolean z11 = true;
        Assertions.checkArgument(i11 > 0, "maxStars must be a positive integer");
        Assertions.checkArgument((f11 < 0.0f || f11 > ((float) i11)) ? false : z11, "starRating is out of range [0, maxStars]");
        this.maxStars = i11;
        this.starRating = f11;
    }
}
