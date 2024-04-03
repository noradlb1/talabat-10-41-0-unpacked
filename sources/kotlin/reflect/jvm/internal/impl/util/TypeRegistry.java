package kotlin.reflect.jvm.internal.impl.util;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

public abstract class TypeRegistry<K, V> {
    /* access modifiers changed from: private */
    @NotNull
    public final AtomicInteger idCounter = new AtomicInteger(0);
    @NotNull
    private final ConcurrentHashMap<KClass<? extends K>, Integer> idPerType = new ConcurrentHashMap<>();

    @NotNull
    public final Collection<Integer> a() {
        Collection<Integer> values = this.idPerType.values();
        Intrinsics.checkNotNullExpressionValue(values, "idPerType.values");
        return values;
    }

    public abstract <T extends K> int customComputeIfAbsent(@NotNull ConcurrentHashMap<KClass<? extends K>, Integer> concurrentHashMap, @NotNull KClass<T> kClass, @NotNull Function1<? super KClass<? extends K>, Integer> function1);

    @NotNull
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(@NotNull KClass<KK> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new NullableArrayMapAccessor<>(kClass, getId(kClass));
    }

    public final <T extends K> int getId(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return customComputeIfAbsent(this.idPerType, kClass, new TypeRegistry$getId$1(this));
    }
}
