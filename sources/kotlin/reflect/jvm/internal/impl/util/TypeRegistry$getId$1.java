package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

public final class TypeRegistry$getId$1 extends Lambda implements Function1<KClass<? extends K>, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeRegistry<K, V> f24978g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeRegistry$getId$1(TypeRegistry<K, V> typeRegistry) {
        super(1);
        this.f24978g = typeRegistry;
    }

    @NotNull
    public final Integer invoke(@NotNull KClass<? extends K> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "it");
        return Integer.valueOf(this.f24978g.idCounter.getAndIncrement());
    }
}
