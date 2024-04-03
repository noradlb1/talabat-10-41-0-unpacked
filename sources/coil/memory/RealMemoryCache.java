package coil.memory;

import android.graphics.Bitmap;
import coil.bitmap.BitmapPool;
import coil.bitmap.BitmapReferenceCounter;
import coil.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001#B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0019\u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001cH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcoil/memory/RealMemoryCache;", "Lcoil/memory/MemoryCache;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "(Lcoil/memory/StrongMemoryCache;Lcoil/memory/WeakMemoryCache;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/bitmap/BitmapPool;)V", "getBitmapPool", "()Lcoil/bitmap/BitmapPool;", "maxSize", "", "getMaxSize", "()I", "getReferenceCounter", "()Lcoil/bitmap/BitmapReferenceCounter;", "size", "getSize", "getStrongMemoryCache", "()Lcoil/memory/StrongMemoryCache;", "getWeakMemoryCache", "()Lcoil/memory/WeakMemoryCache;", "clear", "", "get", "Landroid/graphics/Bitmap;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Value", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealMemoryCache implements MemoryCache {
    @NotNull
    private final BitmapPool bitmapPool;
    @NotNull
    private final BitmapReferenceCounter referenceCounter;
    @NotNull
    private final StrongMemoryCache strongMemoryCache;
    @NotNull
    private final WeakMemoryCache weakMemoryCache;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcoil/memory/RealMemoryCache$Value;", "", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "isSampled", "", "()Z", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Value {
        @NotNull
        Bitmap getBitmap();

        boolean isSampled();
    }

    public RealMemoryCache(@NotNull StrongMemoryCache strongMemoryCache2, @NotNull WeakMemoryCache weakMemoryCache2, @NotNull BitmapReferenceCounter bitmapReferenceCounter, @NotNull BitmapPool bitmapPool2) {
        Intrinsics.checkNotNullParameter(strongMemoryCache2, "strongMemoryCache");
        Intrinsics.checkNotNullParameter(weakMemoryCache2, "weakMemoryCache");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        Intrinsics.checkNotNullParameter(bitmapPool2, "bitmapPool");
        this.strongMemoryCache = strongMemoryCache2;
        this.weakMemoryCache = weakMemoryCache2;
        this.referenceCounter = bitmapReferenceCounter;
        this.bitmapPool = bitmapPool2;
    }

    public void clear() {
        this.strongMemoryCache.clearMemory();
        this.weakMemoryCache.clearMemory();
    }

    @Nullable
    public Bitmap get(@NotNull MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Value value = this.strongMemoryCache.get(key);
        if (value == null) {
            value = this.weakMemoryCache.get(key);
        }
        if (value == null) {
            return null;
        }
        Bitmap bitmap = value.getBitmap();
        getReferenceCounter().setValid(bitmap, false);
        return bitmap;
    }

    @NotNull
    public final BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public int getMaxSize() {
        return this.strongMemoryCache.getMaxSize();
    }

    @NotNull
    public final BitmapReferenceCounter getReferenceCounter() {
        return this.referenceCounter;
    }

    public int getSize() {
        return this.strongMemoryCache.getSize();
    }

    @NotNull
    public final StrongMemoryCache getStrongMemoryCache() {
        return this.strongMemoryCache;
    }

    @NotNull
    public final WeakMemoryCache getWeakMemoryCache() {
        return this.weakMemoryCache;
    }

    public boolean remove(@NotNull MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean remove = this.strongMemoryCache.remove(key);
        boolean remove2 = this.weakMemoryCache.remove(key);
        if (remove || remove2) {
            return true;
        }
        return false;
    }

    public void set(@NotNull MemoryCache.Key key, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.referenceCounter.setValid(bitmap, false);
        this.strongMemoryCache.set(key, bitmap, false);
        this.weakMemoryCache.remove(key);
    }
}
