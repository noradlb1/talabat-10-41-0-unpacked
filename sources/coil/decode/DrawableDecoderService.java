package coil.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.WorkerThread;
import coil.bitmap.BitmapPool;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Scale;
import coil.size.Size;
import coil.util.Bitmaps;
import coil.util.Extensions;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil/decode/DrawableDecoderService;", "", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "(Lcoil/bitmap/BitmapPool;)V", "convert", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Landroid/graphics/Bitmap$Config;", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "isConfigValid", "bitmap", "isSizeValid", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DrawableDecoderService {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_SIZE = 512;
    @NotNull
    private final BitmapPool bitmapPool;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/decode/DrawableDecoderService$Companion;", "", "()V", "DEFAULT_SIZE", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DrawableDecoderService(@NotNull BitmapPool bitmapPool2) {
        Intrinsics.checkNotNullParameter(bitmapPool2, "bitmapPool");
        this.bitmapPool = bitmapPool2;
    }

    private final boolean isConfigValid(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == Bitmaps.toSoftware(config);
    }

    private final boolean isSizeValid(boolean z11, Size size, Bitmap bitmap, Scale scale) {
        if (z11 || (size instanceof OriginalSize) || Intrinsics.areEqual((Object) size, (Object) DecodeUtils.computePixelSize(bitmap.getWidth(), bitmap.getHeight(), size, scale))) {
            return true;
        }
        return false;
    }

    @NotNull
    @WorkerThread
    public final Bitmap convert(@NotNull Drawable drawable, @NotNull Bitmap.Config config, @NotNull Size size, @NotNull Scale scale, boolean z11) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(scale, "scale");
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            if (isConfigValid(bitmap, config) && isSizeValid(z11, size, bitmap, scale)) {
                return bitmap;
            }
        }
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "drawable.mutate()");
        int width = Extensions.getWidth(mutate);
        int i11 = 512;
        if (width <= 0) {
            width = 512;
        }
        int height = Extensions.getHeight(mutate);
        if (height > 0) {
            i11 = height;
        }
        PixelSize computePixelSize = DecodeUtils.computePixelSize(width, i11, size, scale);
        int component1 = computePixelSize.component1();
        int component2 = computePixelSize.component2();
        Bitmap bitmap2 = this.bitmapPool.get(component1, component2, Bitmaps.toSoftware(config));
        Rect bounds = mutate.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, Param.BOUNDS);
        int i12 = bounds.left;
        int i13 = bounds.top;
        int i14 = bounds.right;
        int i15 = bounds.bottom;
        mutate.setBounds(0, 0, component1, component2);
        mutate.draw(new Canvas(bitmap2));
        mutate.setBounds(i12, i13, i14, i15);
        return bitmap2;
    }
}
