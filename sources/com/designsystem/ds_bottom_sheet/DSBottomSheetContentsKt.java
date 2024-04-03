package com.designsystem.ds_bottom_sheet;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000¨\u0006\u0005"}, d2 = {"dpToPx", "", "dp", "resources", "Landroid/content/res/Resources;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSBottomSheetContentsKt {
    public static final int dpToPx(int i11, @Nullable Resources resources) {
        DisplayMetrics displayMetrics;
        float f11 = (float) i11;
        float f12 = 0.0f;
        if (!(resources == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            f12 = displayMetrics.density;
        }
        return (int) (f11 * f12);
    }
}
