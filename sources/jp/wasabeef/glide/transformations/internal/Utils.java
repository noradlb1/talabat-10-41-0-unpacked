package jp.wasabeef.glide.transformations.internal;

import android.content.res.Resources;

public final class Utils {
    private Utils() {
    }

    public static int toDp(int i11) {
        return i11 * ((int) Resources.getSystem().getDisplayMetrics().density);
    }
}
