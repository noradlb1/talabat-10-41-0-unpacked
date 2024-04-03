package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/collection/LruCacheKt$lruCache$4", "Landroidx/collection/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "collection-ktx"}, k = 1, mv = {1, 1, 13})
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f1028a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f1029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function4 f1030c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1031d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(Function2 function2, Function1 function1, Function4 function4, int i11, int i12) {
        super(i12);
        this.f1028a = function2;
        this.f1029b = function1;
        this.f1030c = function4;
        this.f1031d = i11;
    }

    @Nullable
    public V create(@NotNull K k11) {
        Intrinsics.checkParameterIsNotNull(k11, "key");
        return this.f1029b.invoke(k11);
    }

    public void entryRemoved(boolean z11, @NotNull K k11, @NotNull V v11, @Nullable V v12) {
        Intrinsics.checkParameterIsNotNull(k11, "key");
        Intrinsics.checkParameterIsNotNull(v11, "oldValue");
        this.f1030c.invoke(Boolean.valueOf(z11), k11, v11, v12);
    }

    public int sizeOf(@NotNull K k11, @NotNull V v11) {
        Intrinsics.checkParameterIsNotNull(k11, "key");
        Intrinsics.checkParameterIsNotNull(v11, "value");
        return ((Number) this.f1028a.invoke(k11, v11)).intValue();
    }
}
