package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeWithEnhancementKt {
    @Nullable
    public static final KotlinType getEnhancement(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) kotlinType).getEnhancement();
        }
        return null;
    }

    @NotNull
    public static final UnwrappedType inheritEnhancement(@NotNull UnwrappedType unwrappedType, @NotNull KotlinType kotlinType, @NotNull Function1<? super KotlinType, ? extends KotlinType> function1) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        Intrinsics.checkNotNullParameter(kotlinType, "origin");
        Intrinsics.checkNotNullParameter(function1, "transform");
        KotlinType enhancement = getEnhancement(kotlinType);
        return wrapEnhancement(unwrappedType, enhancement != null ? (KotlinType) function1.invoke(enhancement) : null);
    }

    @NotNull
    public static final UnwrappedType wrapEnhancement(@NotNull UnwrappedType unwrappedType, @Nullable KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        if (unwrappedType instanceof TypeWithEnhancement) {
            return wrapEnhancement(((TypeWithEnhancement) unwrappedType).getOrigin(), kotlinType);
        }
        if (kotlinType == null || Intrinsics.areEqual((Object) kotlinType, (Object) unwrappedType)) {
            return unwrappedType;
        }
        if (unwrappedType instanceof SimpleType) {
            return new SimpleTypeWithEnhancement((SimpleType) unwrappedType, kotlinType);
        }
        if (unwrappedType instanceof FlexibleType) {
            return new FlexibleTypeWithEnhancement((FlexibleType) unwrappedType, kotlinType);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final UnwrappedType inheritEnhancement(@NotNull UnwrappedType unwrappedType, @NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        Intrinsics.checkNotNullParameter(kotlinType, "origin");
        return wrapEnhancement(unwrappedType, getEnhancement(kotlinType));
    }
}
