package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001aP\u0010\r\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"ImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "toPixelMap", "Landroidx/compose/ui/graphics/PixelMap;", "startX", "startY", "buffer", "", "bufferOffset", "stride", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ImageBitmapKt {
    @NotNull
    /* renamed from: ImageBitmap-x__-hDU  reason: not valid java name */
    public static final ImageBitmap m3094ImageBitmapx__hDU(int i11, int i12, int i13, boolean z11, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return AndroidImageBitmap_androidKt.m2786ActualImageBitmapx__hDU(i11, i12, i13, z11, colorSpace);
    }

    /* renamed from: ImageBitmap-x__-hDU$default  reason: not valid java name */
    public static /* synthetic */ ImageBitmap m3095ImageBitmapx__hDU$default(int i11, int i12, int i13, boolean z11, ColorSpace colorSpace, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i13 = ImageBitmapConfig.Companion.m3090getArgb8888_sVssgQ();
        }
        if ((i14 & 8) != 0) {
            z11 = true;
        }
        if ((i14 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return m3094ImageBitmapx__hDU(i11, i12, i13, z11, colorSpace);
    }

    @NotNull
    public static final PixelMap toPixelMap(@NotNull ImageBitmap imageBitmap, int i11, int i12, int i13, int i14, @NotNull int[] iArr, int i15, int i16) {
        Intrinsics.checkNotNullParameter(imageBitmap, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "buffer");
        imageBitmap.readPixels(iArr, i11, i12, i13, i14, i15, i16);
        return new PixelMap(iArr, i13, i14, i15, i16);
    }

    public static /* synthetic */ PixelMap toPixelMap$default(ImageBitmap imageBitmap, int i11, int i12, int i13, int i14, int[] iArr, int i15, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i11 = 0;
        }
        if ((i17 & 2) != 0) {
            i12 = 0;
        }
        if ((i17 & 4) != 0) {
            i13 = imageBitmap.getWidth();
        }
        if ((i17 & 8) != 0) {
            i14 = imageBitmap.getHeight();
        }
        if ((i17 & 16) != 0) {
            iArr = new int[(i13 * i14)];
        }
        if ((i17 & 32) != 0) {
            i15 = 0;
        }
        if ((i17 & 64) != 0) {
            i16 = i13;
        }
        return toPixelMap(imageBitmap, i11, i12, i13, i14, iArr, i15, i16);
    }
}
