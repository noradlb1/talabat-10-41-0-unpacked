package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import g7.o0;

public final class HeartRating extends Rating {
    public static final Bundleable.Creator<HeartRating> CREATOR = new o0();
    private static final String FIELD_IS_HEART = Util.intToStringMaxRadix(2);
    private static final String FIELD_RATED = Util.intToStringMaxRadix(1);
    private static final int TYPE = 0;
    private final boolean isHeart;
    private final boolean rated;

    public HeartRating() {
        this.rated = false;
        this.isHeart = false;
    }

    /* access modifiers changed from: private */
    public static HeartRating fromBundle(Bundle bundle) {
        boolean z11;
        if (bundle.getInt(Rating.FIELD_RATING_TYPE, -1) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        if (bundle.getBoolean(FIELD_RATED, false)) {
            return new HeartRating(bundle.getBoolean(FIELD_IS_HEART, false));
        }
        return new HeartRating();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        if (this.isHeart == heartRating.isHeart && this.rated == heartRating.rated) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.rated), Boolean.valueOf(this.isHeart));
    }

    public boolean isHeart() {
        return this.isHeart;
    }

    public boolean isRated() {
        return this.rated;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.FIELD_RATING_TYPE, 0);
        bundle.putBoolean(FIELD_RATED, this.rated);
        bundle.putBoolean(FIELD_IS_HEART, this.isHeart);
        return bundle;
    }

    public HeartRating(boolean z11) {
        this.rated = true;
        this.isHeart = z11;
    }
}
