package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0001\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u000e\u001a\u0019\u0010\u0010\u001a\u00020\u0011*\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0006*\u00020\u0011H\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0015\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"ActualImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "Landroid/graphics/Bitmap;", "asImageBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidImageBitmap_androidKt {
    @NotNull
    /* renamed from: ActualImageBitmap-x__-hDU  reason: not valid java name */
    public static final ImageBitmap m2786ActualImageBitmapx__hDU(int i11, int i12, int i13, boolean z11, @NotNull ColorSpace colorSpace) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap.Config r02 = m2787toBitmapConfig1JJdX4A(i13);
        if (Build.VERSION.SDK_INT >= 26) {
            bitmap = Api26Bitmap.m2822createBitmapx__hDU$ui_graphics_release(i11, i12, i13, z11, colorSpace);
        } else {
            bitmap = Bitmap.createBitmap((DisplayMetrics) null, i11, i12, r02);
            Intrinsics.checkNotNullExpressionValue(bitmap, "createBitmap(\n          …   bitmapConfig\n        )");
            bitmap.setHasAlpha(z11);
        }
        return new AndroidImageBitmap(bitmap);
    }

    @NotNull
    public static final Bitmap asAndroidBitmap(@NotNull ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(imageBitmap, "<this>");
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).getBitmap$ui_graphics_release();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    @NotNull
    public static final ImageBitmap asImageBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        return new AndroidImageBitmap(bitmap);
    }

    @NotNull
    /* renamed from: toBitmapConfig-1JJdX4A  reason: not valid java name */
    public static final Bitmap.Config m2787toBitmapConfig1JJdX4A(int i11) {
        ImageBitmapConfig.Companion companion = ImageBitmapConfig.Companion;
        if (ImageBitmapConfig.m3085equalsimpl0(i11, companion.m3090getArgb8888_sVssgQ())) {
            return Bitmap.Config.ARGB_8888;
        }
        if (ImageBitmapConfig.m3085equalsimpl0(i11, companion.m3089getAlpha8_sVssgQ())) {
            return Bitmap.Config.ALPHA_8;
        }
        if (ImageBitmapConfig.m3085equalsimpl0(i11, companion.m3093getRgb565_sVssgQ())) {
            return Bitmap.Config.RGB_565;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 26 && ImageBitmapConfig.m3085equalsimpl0(i11, companion.m3091getF16_sVssgQ())) {
            return Bitmap.Config.RGBA_F16;
        }
        if (i12 < 26 || !ImageBitmapConfig.m3085equalsimpl0(i11, companion.m3092getGpu_sVssgQ())) {
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.HARDWARE;
    }

    public static final int toImageConfig(@NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "<this>");
        if (config == Bitmap.Config.ALPHA_8) {
            return ImageBitmapConfig.Companion.m3089getAlpha8_sVssgQ();
        }
        if (config == Bitmap.Config.RGB_565) {
            return ImageBitmapConfig.Companion.m3093getRgb565_sVssgQ();
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return ImageBitmapConfig.Companion.m3090getArgb8888_sVssgQ();
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26 && config == Bitmap.Config.RGBA_F16) {
            return ImageBitmapConfig.Companion.m3091getF16_sVssgQ();
        }
        if (i11 < 26 || config != Bitmap.Config.HARDWARE) {
            return ImageBitmapConfig.Companion.m3090getArgb8888_sVssgQ();
        }
        return ImageBitmapConfig.Companion.m3092getGpu_sVssgQ();
    }
}
