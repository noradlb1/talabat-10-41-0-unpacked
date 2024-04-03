package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExpandedTypeUtilsKt {
    @Nullable
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "inlineClassType");
        return computeExpandedTypeInner(typeSystemCommonBackendContext, kotlinTypeMarker, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker kotlinTypeMarker2;
        boolean z11;
        KotlinTypeMarker kotlinTypeMarker3;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!hashSet.add(typeConstructor)) {
            return null;
        }
        TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructor);
        if (typeParameterClassifier != null) {
            KotlinTypeMarker representativeUpperBound = typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier);
            kotlinTypeMarker2 = computeExpandedTypeInner(typeSystemCommonBackendContext, representativeUpperBound, hashSet);
            if (kotlinTypeMarker2 == null) {
                return null;
            }
            if (typeSystemCommonBackendContext.isInlineClass(typeSystemCommonBackendContext.typeConstructor(representativeUpperBound)) || ((representativeUpperBound instanceof SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) representativeUpperBound))) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((kotlinTypeMarker2 instanceof SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) kotlinTypeMarker2) && typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && z11) {
                kotlinTypeMarker3 = typeSystemCommonBackendContext.makeNullable(representativeUpperBound);
            } else if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker2) && typeSystemCommonBackendContext.isMarkedNullable(kotlinTypeMarker)) {
                kotlinTypeMarker3 = typeSystemCommonBackendContext.makeNullable(kotlinTypeMarker2);
            }
            return kotlinTypeMarker3;
        } else if (!typeSystemCommonBackendContext.isInlineClass(typeConstructor)) {
            return kotlinTypeMarker;
        } else {
            KotlinTypeMarker unsubstitutedUnderlyingType = typeSystemCommonBackendContext.getUnsubstitutedUnderlyingType(kotlinTypeMarker);
            if (unsubstitutedUnderlyingType == null || (kotlinTypeMarker2 = computeExpandedTypeInner(typeSystemCommonBackendContext, unsubstitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker)) {
                if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker2)) {
                    return kotlinTypeMarker;
                }
                if (!(kotlinTypeMarker2 instanceof SimpleTypeMarker) || !typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) kotlinTypeMarker2)) {
                    return typeSystemCommonBackendContext.makeNullable(kotlinTypeMarker2);
                }
                return kotlinTypeMarker;
            }
        }
        return kotlinTypeMarker2;
    }
}
