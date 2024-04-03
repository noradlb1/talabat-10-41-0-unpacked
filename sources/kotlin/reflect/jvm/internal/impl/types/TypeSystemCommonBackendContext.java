package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TypeSystemCommonBackendContext extends TypeSystemContext {

    public static final class DefaultImpls {
        @NotNull
        public static KotlinTypeMarker makeNullable(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            SimpleTypeMarker withNullability;
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            SimpleTypeMarker asSimpleType = typeSystemCommonBackendContext.asSimpleType(kotlinTypeMarker);
            if (asSimpleType == null || (withNullability = typeSystemCommonBackendContext.withNullability(asSimpleType, true)) == null) {
                return kotlinTypeMarker;
            }
            return withNullability;
        }
    }

    @Nullable
    FqNameUnsafe getClassFqNameUnsafe(@NotNull TypeConstructorMarker typeConstructorMarker);

    @Nullable
    PrimitiveType getPrimitiveArrayType(@NotNull TypeConstructorMarker typeConstructorMarker);

    @Nullable
    PrimitiveType getPrimitiveType(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker getRepresentativeUpperBound(@NotNull TypeParameterMarker typeParameterMarker);

    @Nullable
    KotlinTypeMarker getUnsubstitutedUnderlyingType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean hasAnnotation(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull FqName fqName);

    boolean isInlineClass(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isUnderKotlinPackage(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker makeNullable(@NotNull KotlinTypeMarker kotlinTypeMarker);
}
