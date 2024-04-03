package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {

    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {

        /* renamed from: id  reason: collision with root package name */
        private final int f24973id;
        @NotNull
        private final KClass<? extends K> key;

        public AbstractArrayMapAccessor(@NotNull KClass<? extends K> kClass, int i11) {
            Intrinsics.checkNotNullParameter(kClass, "key");
            this.key = kClass;
            this.f24973id = i11;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner, kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final T a(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V> r2) {
            /*
                r1 = this;
                java.lang.String r0 = "thisRef"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                kotlin.reflect.jvm.internal.impl.util.ArrayMap r2 = r2.a()
                int r0 = r1.f24973id
                java.lang.Object r2 = r2.get(r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner.AbstractArrayMapAccessor.a(kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner):java.lang.Object");
        }
    }

    @NotNull
    public abstract ArrayMap<V> a();

    @NotNull
    public abstract TypeRegistry<K, V> b();

    public final boolean isEmpty() {
        return a().getSize() == 0;
    }

    @NotNull
    public final Iterator<V> iterator() {
        return a().iterator();
    }
}
