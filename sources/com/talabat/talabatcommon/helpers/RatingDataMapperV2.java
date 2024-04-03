package com.talabat.talabatcommon.helpers;

import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/helpers/RatingDataMapperV2;", "", "()V", "RATING_GOOD", "", "RATING_OK", "RATING_VERY_GOOD", "drawableResourceFromRating", "", "rating", "textFromRating", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingDataMapperV2 {
    @NotNull
    public static final RatingDataMapperV2 INSTANCE = new RatingDataMapperV2();
    public static final float RATING_GOOD = 3.7f;
    public static final float RATING_OK = 2.7f;
    public static final float RATING_VERY_GOOD = 4.5f;

    private RatingDataMapperV2() {
    }

    public final int drawableResourceFromRating(float f11) {
        if (f11 <= 2.7f) {
            return R.drawable.ic_vendor_rate_ok;
        }
        if (f11 <= 3.7f) {
            return R.drawable.ic_vendor_rate_good;
        }
        if (f11 <= 4.5f) {
            return R.drawable.ic_vendor_rate_very_good;
        }
        return R.drawable.ic_vendor_rate_amazing;
    }

    public final int textFromRating(float f11) {
        if (f11 <= 2.7f) {
            return com.talabat.localization.R.string.rate_fair;
        }
        if (f11 <= 3.7f) {
            return com.talabat.localization.R.string.rate_okay;
        }
        if (f11 <= 4.5f) {
            return com.talabat.localization.R.string.rate_very_good;
        }
        return com.talabat.localization.R.string.rate_amazing;
    }
}
