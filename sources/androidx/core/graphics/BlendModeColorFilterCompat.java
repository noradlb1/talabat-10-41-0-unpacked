package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeUtils;

public class BlendModeColorFilterCompat {

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static ColorFilter a(int i11, Object obj) {
            return new BlendModeColorFilter(i11, (BlendMode) obj);
        }
    }

    private BlendModeColorFilterCompat() {
    }

    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int i11, @NonNull BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object a11 = BlendModeUtils.Api29Impl.a(blendModeCompat);
            if (a11 != null) {
                return Api29Impl.a(i11, a11);
            }
            return null;
        }
        PorterDuff.Mode a12 = BlendModeUtils.a(blendModeCompat);
        if (a12 != null) {
            return new PorterDuffColorFilter(i11, a12);
        }
        return null;
    }
}
