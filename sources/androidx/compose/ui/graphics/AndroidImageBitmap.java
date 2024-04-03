package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0016J@\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u00020\f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/AndroidImageBitmap;", "Landroidx/compose/ui/graphics/ImageBitmap;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "getBitmap$ui_graphics_release", "()Landroid/graphics/Bitmap;", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getConfig-_sVssgQ", "()I", "hasAlpha", "", "getHasAlpha", "()Z", "height", "", "getHeight", "width", "getWidth", "prepareToDraw", "", "readPixels", "buffer", "", "startX", "startY", "bufferOffset", "stride", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidImageBitmap implements ImageBitmap {
    @NotNull
    private final Bitmap bitmap;

    public AndroidImageBitmap(@NotNull Bitmap bitmap2) {
        Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
        this.bitmap = bitmap2;
    }

    @NotNull
    public final Bitmap getBitmap$ui_graphics_release() {
        return this.bitmap;
    }

    @NotNull
    public ColorSpace getColorSpace() {
        if (Build.VERSION.SDK_INT < 26) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        Api26Bitmap api26Bitmap = Api26Bitmap.INSTANCE;
        return Api26Bitmap.composeColorSpace$ui_graphics_release(this.bitmap);
    }

    /* renamed from: getConfig-_sVssgQ  reason: not valid java name */
    public int m2785getConfig_sVssgQ() {
        Bitmap.Config config = this.bitmap.getConfig();
        Intrinsics.checkNotNullExpressionValue(config, "bitmap.config");
        return AndroidImageBitmap_androidKt.toImageConfig(config);
    }

    public boolean getHasAlpha() {
        return this.bitmap.hasAlpha();
    }

    public int getHeight() {
        return this.bitmap.getHeight();
    }

    public int getWidth() {
        return this.bitmap.getWidth();
    }

    public void prepareToDraw() {
        this.bitmap.prepareToDraw();
    }

    public void readPixels(@NotNull int[] iArr, int i11, int i12, int i13, int i14, int i15, int i16) {
        int[] iArr2 = iArr;
        Intrinsics.checkNotNullParameter(iArr, "buffer");
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(this);
        boolean z11 = false;
        if (Build.VERSION.SDK_INT >= 26 && asAndroidBitmap.getConfig() == Bitmap.Config.HARDWARE) {
            asAndroidBitmap = asAndroidBitmap.copy(Bitmap.Config.ARGB_8888, false);
            z11 = true;
        }
        boolean z12 = z11;
        asAndroidBitmap.getPixels(iArr, i15, i16, i11, i12, i13, i14);
        if (z12) {
            asAndroidBitmap.recycle();
        }
    }
}
