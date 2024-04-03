package coil.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.Px;
import coil.util.Logger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J$\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J&\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J&\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcoil/bitmap/BitmapPool;", "", "clear", "", "get", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "getDirty", "getDirtyOrNull", "getOrNull", "put", "bitmap", "trimMemory", "level", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface BitmapPool {
    @NotNull
    public static final Companion Companion = Companion.f39694a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcoil/bitmap/BitmapPool$Companion;", "", "()V", "invoke", "Lcoil/bitmap/BitmapPool;", "maxSize", "", "create", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39694a = new Companion();

        private Companion() {
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "create")
        public final BitmapPool create(int i11) {
            return i11 == 0 ? new EmptyBitmapPool() : new RealBitmapPool(i11, (Set) null, (BitmapPoolStrategy) null, (Logger) null, 14, (DefaultConstructorMarker) null);
        }
    }

    void clear();

    @NotNull
    Bitmap get(@Px int i11, @Px int i12, @NotNull Bitmap.Config config);

    @NotNull
    Bitmap getDirty(@Px int i11, @Px int i12, @NotNull Bitmap.Config config);

    @Nullable
    Bitmap getDirtyOrNull(@Px int i11, @Px int i12, @NotNull Bitmap.Config config);

    @Nullable
    Bitmap getOrNull(@Px int i11, @Px int i12, @NotNull Bitmap.Config config);

    void put(@NotNull Bitmap bitmap);

    void trimMemory(int i11);
}
