package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import g7.n3;

public final class ThumbRating extends Rating {
    public static final Bundleable.Creator<ThumbRating> CREATOR = new n3();
    private static final String FIELD_IS_THUMBS_UP = Util.intToStringMaxRadix(2);
    private static final String FIELD_RATED = Util.intToStringMaxRadix(1);
    private static final int TYPE = 3;
    private final boolean isThumbsUp;
    private final boolean rated;

    public ThumbRating() {
        this.rated = false;
        this.isThumbsUp = false;
    }

    /* access modifiers changed from: private */
    public static ThumbRating fromBundle(Bundle bundle) {
        boolean z11;
        if (bundle.getInt(Rating.FIELD_RATING_TYPE, -1) == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        if (bundle.getBoolean(FIELD_RATED, false)) {
            return new ThumbRating(bundle.getBoolean(FIELD_IS_THUMBS_UP, false));
        }
        return new ThumbRating();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        if (this.isThumbsUp == thumbRating.isThumbsUp && this.rated == thumbRating.rated) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.rated), Boolean.valueOf(this.isThumbsUp));
    }

    public boolean isRated() {
        return this.rated;
    }

    public boolean isThumbsUp() {
        return this.isThumbsUp;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.FIELD_RATING_TYPE, 3);
        bundle.putBoolean(FIELD_RATED, this.rated);
        bundle.putBoolean(FIELD_IS_THUMBS_UP, this.isThumbsUp);
        return bundle;
    }

    public ThumbRating(boolean z11) {
        this.rated = true;
        this.isThumbsUp = z11;
    }
}
