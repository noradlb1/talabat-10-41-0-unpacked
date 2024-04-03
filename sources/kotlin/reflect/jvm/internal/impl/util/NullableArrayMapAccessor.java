package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullableArrayMapAccessor<K, V, T extends V> extends AbstractArrayMapOwner.AbstractArrayMapAccessor<K, V, T> implements ReadOnlyProperty<AbstractArrayMapOwner<K, V>, V> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NullableArrayMapAccessor(@NotNull KClass<? extends K> kClass, int i11) {
        super(kClass, i11);
        Intrinsics.checkNotNullParameter(kClass, "key");
    }

    @Nullable
    public T getValue(@NotNull AbstractArrayMapOwner<K, V> abstractArrayMapOwner, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(abstractArrayMapOwner, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return a(abstractArrayMapOwner);
    }
}
