package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeAttribute<T extends TypeAttribute<T>> {
    @NotNull
    public abstract T add(@Nullable T t11);

    @NotNull
    public abstract KClass<? extends T> getKey();

    @Nullable
    public abstract T intersect(@Nullable T t11);
}
