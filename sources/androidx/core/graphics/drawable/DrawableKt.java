package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a,\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DrawableKt {
    @NotNull
    public static final Bitmap toBitmap(@NotNull Drawable drawable, @Px int i11, @Px int i12, @Nullable Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            } else if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                if (i11 == bitmapDrawable.getBitmap().getWidth() && i12 == bitmapDrawable.getBitmap().getHeight()) {
                    Bitmap bitmap = bitmapDrawable.getBitmap();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                    return bitmap;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i11, i12, true);
                Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(bitmap, width, height, true)");
                return createScaledBitmap;
            }
        }
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, Param.BOUNDS);
        int i13 = bounds.left;
        int i14 = bounds.top;
        int i15 = bounds.right;
        int i16 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, config);
        drawable.setBounds(0, 0, i11, i12);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i13, i14, i15, i16);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i11, int i12, Bitmap.Config config, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = drawable.getIntrinsicWidth();
        }
        if ((i13 & 2) != 0) {
            i12 = drawable.getIntrinsicHeight();
        }
        if ((i13 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i11, i12, config);
    }

    @Nullable
    public static final Bitmap toBitmapOrNull(@NotNull Drawable drawable, @Px int i11, @Px int i12, @Nullable Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        if (!(drawable instanceof BitmapDrawable) || ((BitmapDrawable) drawable).getBitmap() != null) {
            return toBitmap(drawable, i11, i12, config);
        }
        return null;
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i11, int i12, Bitmap.Config config, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = drawable.getIntrinsicWidth();
        }
        if ((i13 & 2) != 0) {
            i12 = drawable.getIntrinsicHeight();
        }
        if ((i13 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i11, i12, config);
    }

    public static final void updateBounds(@NotNull Drawable drawable, @Px int i11, @Px int i12, @Px int i13, @Px int i14) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        drawable.setBounds(i11, i12, i13, i14);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = drawable.getBounds().left;
        }
        if ((i15 & 2) != 0) {
            i12 = drawable.getBounds().top;
        }
        if ((i15 & 4) != 0) {
            i13 = drawable.getBounds().right;
        }
        if ((i15 & 8) != 0) {
            i14 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i11, i12, i13, i14);
    }
}
