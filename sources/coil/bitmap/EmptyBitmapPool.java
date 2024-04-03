package coil.bitmap;

import android.graphics.Bitmap;
import coil.util.Bitmaps;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, d2 = {"Lcoil/bitmap/EmptyBitmapPool;", "Lcoil/bitmap/BitmapPool;", "()V", "assertNotHardware", "", "config", "Landroid/graphics/Bitmap$Config;", "clear", "get", "Landroid/graphics/Bitmap;", "width", "", "height", "getDirty", "getDirtyOrNull", "getOrNull", "put", "bitmap", "trimMemory", "level", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EmptyBitmapPool implements BitmapPool {
    private final void assertNotHardware(Bitmap.Config config) {
        if (!(!Bitmaps.isHardware(config))) {
            throw new IllegalArgumentException("Cannot create a mutable hardware bitmap.".toString());
        }
    }

    public void clear() {
    }

    @NotNull
    public Bitmap get(int i11, int i12, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        return getDirty(i11, i12, config);
    }

    @NotNull
    public Bitmap getDirty(int i11, int i12, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        assertNotHardware(config);
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    @Nullable
    public Bitmap getDirtyOrNull(int i11, int i12, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        assertNotHardware(config);
        return null;
    }

    @Nullable
    public Bitmap getOrNull(int i11, int i12, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        return getDirtyOrNull(i11, i12, config);
    }

    public void put(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        bitmap.recycle();
    }

    public void trimMemory(int i11) {
    }
}
