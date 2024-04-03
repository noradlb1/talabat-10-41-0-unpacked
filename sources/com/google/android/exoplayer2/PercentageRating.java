package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import g7.u0;

public final class PercentageRating extends Rating {
    public static final Bundleable.Creator<PercentageRating> CREATOR = new u0();
    private static final String FIELD_PERCENT = Util.intToStringMaxRadix(1);
    private static final int TYPE = 1;
    private final float percent;

    public PercentageRating() {
        this.percent = -1.0f;
    }

    /* access modifiers changed from: private */
    public static PercentageRating fromBundle(Bundle bundle) {
        boolean z11 = true;
        if (bundle.getInt(Rating.FIELD_RATING_TYPE, -1) != 1) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        float f11 = bundle.getFloat(FIELD_PERCENT, -1.0f);
        if (f11 == -1.0f) {
            return new PercentageRating();
        }
        return new PercentageRating(f11);
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof PercentageRating) && this.percent == ((PercentageRating) obj).percent) {
            return true;
        }
        return false;
    }

    public float getPercent() {
        return this.percent;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.percent));
    }

    public boolean isRated() {
        return this.percent != -1.0f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.FIELD_RATING_TYPE, 1);
        bundle.putFloat(FIELD_PERCENT, this.percent);
        return bundle;
    }

    public PercentageRating(@FloatRange(from = 0.0d, to = 100.0d) float f11) {
        Assertions.checkArgument(f11 >= 0.0f && f11 <= 100.0f, "percent must be in the range of [0, 100]");
        this.percent = f11;
    }
}
