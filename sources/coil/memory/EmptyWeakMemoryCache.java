package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¨\u0006\u0013"}, d2 = {"Lcoil/memory/EmptyWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "()V", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "bitmap", "Landroid/graphics/Bitmap;", "set", "isSampled", "size", "", "trimMemory", "level", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EmptyWeakMemoryCache implements WeakMemoryCache {
    @NotNull
    public static final EmptyWeakMemoryCache INSTANCE = new EmptyWeakMemoryCache();

    private EmptyWeakMemoryCache() {
    }

    public void clearMemory() {
    }

    @Nullable
    public RealMemoryCache.Value get(@NotNull MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    public boolean remove(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return false;
    }

    public boolean remove(@NotNull MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return false;
    }

    public void set(@NotNull MemoryCache.Key key, @NotNull Bitmap bitmap, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    public void trimMemory(int i11) {
    }
}
