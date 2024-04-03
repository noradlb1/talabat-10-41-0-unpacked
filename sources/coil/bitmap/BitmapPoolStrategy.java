package coil.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.Px;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0003H&J$\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u0010"}, d2 = {"Lcoil/bitmap/BitmapPoolStrategy;", "", "get", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "put", "", "bitmap", "removeLast", "stringify", "", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface BitmapPoolStrategy {
    @NotNull
    public static final Companion Companion = Companion.f39695a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"Lcoil/bitmap/BitmapPoolStrategy$Companion;", "", "()V", "invoke", "Lcoil/bitmap/BitmapPoolStrategy;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39695a = new Companion();

        private Companion() {
        }

        @NotNull
        public final BitmapPoolStrategy invoke() {
            return new SizeStrategy();
        }
    }

    @Nullable
    Bitmap get(@Px int i11, @Px int i12, @NotNull Bitmap.Config config);

    void put(@NotNull Bitmap bitmap);

    @Nullable
    Bitmap removeLast();

    @NotNull
    String stringify(@Px int i11, @Px int i12, @NotNull Bitmap.Config config);

    @NotNull
    String stringify(@NotNull Bitmap bitmap);
}
