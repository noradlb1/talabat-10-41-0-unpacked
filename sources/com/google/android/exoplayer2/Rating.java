package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;
import g7.a1;

public abstract class Rating implements Bundleable {
    public static final Bundleable.Creator<Rating> CREATOR = new a1();
    static final String FIELD_RATING_TYPE = Util.intToStringMaxRadix(0);
    static final int RATING_TYPE_HEART = 0;
    static final int RATING_TYPE_PERCENTAGE = 1;
    static final int RATING_TYPE_STAR = 2;
    static final int RATING_TYPE_THUMB = 3;
    static final int RATING_TYPE_UNSET = -1;
    static final float RATING_UNSET = -1.0f;

    /* access modifiers changed from: private */
    public static Rating fromBundle(Bundle bundle) {
        int i11 = bundle.getInt(FIELD_RATING_TYPE, -1);
        if (i11 == 0) {
            return HeartRating.CREATOR.fromBundle(bundle);
        }
        if (i11 == 1) {
            return PercentageRating.CREATOR.fromBundle(bundle);
        }
        if (i11 == 2) {
            return StarRating.CREATOR.fromBundle(bundle);
        }
        if (i11 == 3) {
            return ThumbRating.CREATOR.fromBundle(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i11);
    }

    public abstract boolean isRated();
}
