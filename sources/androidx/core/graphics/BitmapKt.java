package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\b\u001a)\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\bø\u0001\u0000\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0014H\n\u001a\u001d\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\n\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\bH\b\u001a'\u0010\u001a\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0003H\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001c"}, d2 = {"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "get", "x", "y", "scale", "filter", "set", "color", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BitmapKt {
    @NotNull
    public static final Bitmap applyCanvas(@NotNull Bitmap bitmap, @NotNull Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull Point point) {
        int i11;
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(point, "p");
        int width = bitmap.getWidth();
        int i12 = point.x;
        return (i12 >= 0 && i12 < width) && (i11 = point.y) >= 0 && i11 < bitmap.getHeight();
    }

    @NotNull
    public static final Bitmap createBitmap(int i11, int i12, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i11, int i12, Bitmap.Config config, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(@NotNull Bitmap bitmap, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        return bitmap.getPixel(i11, i12);
    }

    @NotNull
    public static final Bitmap scale(@NotNull Bitmap bitmap, int i11, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i11, i12, z11);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i11, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            z11 = true;
        }
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i11, i12, z11);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(@NotNull Bitmap bitmap, int i11, int i12, @ColorInt int i13) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        bitmap.setPixel(i11, i12, i13);
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(pointF, "p");
        float f11 = pointF.x;
        if (f11 >= 0.0f && f11 < ((float) bitmap.getWidth())) {
            float f12 = pointF.y;
            return f12 >= 0.0f && f12 < ((float) bitmap.getHeight());
        }
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int i11, int i12, @NotNull Bitmap.Config config, boolean z11, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap a11 = Bitmap.createBitmap(i11, i12, config, z11, colorSpace);
        Intrinsics.checkNotNullExpressionValue(a11, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return a11;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i11, int i12, Bitmap.Config config, boolean z11, ColorSpace colorSpace, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i13 & 8) != 0) {
            z11 = true;
        }
        if ((i13 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            Intrinsics.checkNotNullExpressionValue(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap a11 = Bitmap.createBitmap(i11, i12, config, z11, colorSpace);
        Intrinsics.checkNotNullExpressionValue(a11, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return a11;
    }
}
