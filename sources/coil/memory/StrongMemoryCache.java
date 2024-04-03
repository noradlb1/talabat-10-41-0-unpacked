package coil.memory;

import android.graphics.Bitmap;
import coil.bitmap.BitmapReferenceCounter;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import coil.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\b\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcoil/memory/StrongMemoryCache;", "", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "trimMemory", "level", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface StrongMemoryCache {
    @NotNull
    public static final Companion Companion = Companion.f39783a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\r"}, d2 = {"Lcoil/memory/StrongMemoryCache$Companion;", "", "()V", "invoke", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "maxSize", "", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39783a = new Companion();

        private Companion() {
        }

        @NotNull
        public final StrongMemoryCache invoke(@NotNull WeakMemoryCache weakMemoryCache, @NotNull BitmapReferenceCounter bitmapReferenceCounter, int i11, @Nullable Logger logger) {
            Intrinsics.checkNotNullParameter(weakMemoryCache, "weakMemoryCache");
            Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
            if (i11 > 0) {
                return new RealStrongMemoryCache(weakMemoryCache, bitmapReferenceCounter, i11, logger);
            }
            if (weakMemoryCache instanceof RealWeakMemoryCache) {
                return new ForwardingStrongMemoryCache(weakMemoryCache);
            }
            return EmptyStrongMemoryCache.INSTANCE;
        }
    }

    void clearMemory();

    @Nullable
    RealMemoryCache.Value get(@NotNull MemoryCache.Key key);

    int getMaxSize();

    int getSize();

    boolean remove(@NotNull MemoryCache.Key key);

    void set(@NotNull MemoryCache.Key key, @NotNull Bitmap bitmap, boolean z11);

    void trimMemory(int i11);
}
