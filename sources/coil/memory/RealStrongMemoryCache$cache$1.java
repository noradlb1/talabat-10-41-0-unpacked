package coil.memory;

import androidx.collection.LruCache;
import coil.memory.MemoryCache;
import coil.memory.RealStrongMemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0014¨\u0006\u000e"}, d2 = {"coil/memory/RealStrongMemoryCache$cache$1", "Landroidx/collection/LruCache;", "Lcoil/memory/MemoryCache$Key;", "Lcoil/memory/RealStrongMemoryCache$InternalValue;", "", "evicted", "key", "oldValue", "newValue", "", "a", "value", "", "b", "coil-base_release"}, k = 1, mv = {1, 5, 1})
public final class RealStrongMemoryCache$cache$1 extends LruCache<MemoryCache.Key, RealStrongMemoryCache.InternalValue> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RealStrongMemoryCache f39781a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f39782b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealStrongMemoryCache$cache$1(RealStrongMemoryCache realStrongMemoryCache, int i11) {
        super(i11);
        this.f39781a = realStrongMemoryCache;
        this.f39782b = i11;
    }

    /* renamed from: a */
    public void entryRemoved(boolean z11, @NotNull MemoryCache.Key key, @NotNull RealStrongMemoryCache.InternalValue internalValue, @Nullable RealStrongMemoryCache.InternalValue internalValue2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(internalValue, "oldValue");
        if (!this.f39781a.referenceCounter.decrement(internalValue.getBitmap())) {
            this.f39781a.weakMemoryCache.set(key, internalValue.getBitmap(), internalValue.isSampled(), internalValue.getSize());
        }
    }

    /* renamed from: b */
    public int sizeOf(@NotNull MemoryCache.Key key, @NotNull RealStrongMemoryCache.InternalValue internalValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(internalValue, "value");
        return internalValue.getSize();
    }
}
