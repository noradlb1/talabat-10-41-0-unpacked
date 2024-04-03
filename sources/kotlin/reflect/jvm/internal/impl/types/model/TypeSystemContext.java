package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public interface TypeSystemContext extends TypeSystemOptimizationContext {

    public static final class DefaultImpls {
        @Nullable
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "constructor");
            return null;
        }

        @NotNull
        public static TypeArgumentMarker get(@NotNull TypeSystemContext typeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, int i11) {
            Intrinsics.checkNotNullParameter(typeArgumentListMarker, "$receiver");
            if (typeArgumentListMarker instanceof SimpleTypeMarker) {
                return typeSystemContext.getArgument((KotlinTypeMarker) typeArgumentListMarker, i11);
            }
            if (typeArgumentListMarker instanceof ArgumentList) {
                Object obj = ((ArgumentList) typeArgumentListMarker).get(i11);
                Intrinsics.checkNotNullExpressionValue(obj, "get(index)");
                return (TypeArgumentMarker) obj;
            }
            throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
        }

        @Nullable
        public static TypeArgumentMarker getArgumentOrNull(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, int i11) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            boolean z11 = false;
            if (i11 >= 0 && i11 < typeSystemContext.argumentsCount(simpleTypeMarker)) {
                z11 = true;
            }
            if (z11) {
                return typeSystemContext.getArgument(simpleTypeMarker, i11);
            }
            return null;
        }

        public static boolean hasFlexibleNullability(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker)) != typeSystemContext.isMarkedNullable(typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker))) {
                return true;
            }
            return false;
        }

        public static boolean isCapturedType(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            CapturedTypeMarker capturedTypeMarker;
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            if (asSimpleType != null) {
                capturedTypeMarker = typeSystemContext.asCapturedType(asSimpleType);
            } else {
                capturedTypeMarker = null;
            }
            if (capturedTypeMarker != null) {
                return true;
            }
            return false;
        }

        public static boolean isClassType(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            return typeSystemContext.isClassTypeConstructor(typeSystemContext.typeConstructor(simpleTypeMarker));
        }

        public static boolean isDefinitelyNotNullType(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker;
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            if (asSimpleType != null) {
                definitelyNotNullTypeMarker = typeSystemContext.asDefinitelyNotNullType(asSimpleType);
            } else {
                definitelyNotNullTypeMarker = null;
            }
            if (definitelyNotNullTypeMarker != null) {
                return true;
            }
            return false;
        }

        public static boolean isDynamic(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            DynamicTypeMarker dynamicTypeMarker;
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
            if (asFlexibleType != null) {
                dynamicTypeMarker = typeSystemContext.asDynamicType(asFlexibleType);
            } else {
                dynamicTypeMarker = null;
            }
            if (dynamicTypeMarker != null) {
                return true;
            }
            return false;
        }

        public static boolean isIntegerLiteralType(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            return typeSystemContext.isIntegerLiteralTypeConstructor(typeSystemContext.typeConstructor(simpleTypeMarker));
        }

        public static boolean isMarkedNullable(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (!(kotlinTypeMarker instanceof SimpleTypeMarker) || !typeSystemContext.isMarkedNullable((SimpleTypeMarker) kotlinTypeMarker)) {
                return false;
            }
            return true;
        }

        public static boolean isNothing(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (!typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(kotlinTypeMarker)) || typeSystemContext.isNullableType(kotlinTypeMarker)) {
                return false;
            }
            return true;
        }

        @NotNull
        public static SimpleTypeMarker lowerBoundIfFlexible(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            SimpleTypeMarker lowerBound;
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
            if (asFlexibleType != null && (lowerBound = typeSystemContext.lowerBound(asFlexibleType)) != null) {
                return lowerBound;
            }
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            Intrinsics.checkNotNull(asSimpleType);
            return asSimpleType;
        }

        public static int size(@NotNull TypeSystemContext typeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentListMarker, "$receiver");
            if (typeArgumentListMarker instanceof SimpleTypeMarker) {
                return typeSystemContext.argumentsCount((KotlinTypeMarker) typeArgumentListMarker);
            }
            if (typeArgumentListMarker instanceof ArgumentList) {
                return ((ArgumentList) typeArgumentListMarker).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            if (asSimpleType == null) {
                asSimpleType = typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker);
            }
            return typeSystemContext.typeConstructor(asSimpleType);
        }

        @NotNull
        public static SimpleTypeMarker upperBoundIfFlexible(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            SimpleTypeMarker upperBound;
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
            if (asFlexibleType != null && (upperBound = typeSystemContext.upperBound(asFlexibleType)) != null) {
                return upperBound;
            }
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            Intrinsics.checkNotNull(asSimpleType);
            return asSimpleType;
        }
    }

    boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2);

    int argumentsCount(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Nullable
    FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    RawTypeMarker asRawType(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus);

    @NotNull
    CaptureStatus captureStatus(@NotNull CapturedTypeMarker capturedTypeMarker);

    @Nullable
    List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    TypeArgumentMarker get(@NotNull TypeArgumentListMarker typeArgumentListMarker, int i11);

    @NotNull
    TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker kotlinTypeMarker, int i11);

    @Nullable
    TypeArgumentMarker getArgumentOrNull(@NotNull SimpleTypeMarker simpleTypeMarker, int i11);

    @NotNull
    List<TypeArgumentMarker> getArguments(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeParameterMarker getParameter(@NotNull TypeConstructorMarker typeConstructorMarker, int i11);

    @NotNull
    List<TypeParameterMarker> getParameters(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker getType(@NotNull TypeArgumentMarker typeArgumentMarker);

    @Nullable
    TypeParameterMarker getTypeParameter(@NotNull TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker);

    @Nullable
    TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    List<KotlinTypeMarker> getUpperBounds(@NotNull TypeParameterMarker typeParameterMarker);

    @NotNull
    TypeVariance getVariance(@NotNull TypeArgumentMarker typeArgumentMarker);

    @NotNull
    TypeVariance getVariance(@NotNull TypeParameterMarker typeParameterMarker);

    boolean hasFlexibleNullability(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean hasRecursiveBounds(@NotNull TypeParameterMarker typeParameterMarker, @Nullable TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> list);

    boolean isAnyConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isCapturedType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isClassType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isClassTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isDefinitelyNotNullType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isDenotable(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isDynamic(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isError(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isIntegerLiteralType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isIntersection(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isMarkedNullable(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isMarkedNullable(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isNotNullTypeParameter(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isNothing(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isNothingConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isNullableType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isOldCapturedType(@NotNull CapturedTypeMarker capturedTypeMarker);

    boolean isPrimitiveType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isProjectionNotNull(@NotNull CapturedTypeMarker capturedTypeMarker);

    boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isStarProjection(@NotNull TypeArgumentMarker typeArgumentMarker);

    boolean isStubType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isStubTypeForBuilderInference(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isTypeVariableType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker capturedTypeMarker);

    @NotNull
    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    SimpleTypeMarker original(@NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker);

    int parametersCount(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    TypeArgumentMarker projection(@NotNull CapturedTypeConstructorMarker capturedTypeConstructorMarker);

    int size(@NotNull TypeArgumentListMarker typeArgumentListMarker);

    @NotNull
    TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    CapturedTypeConstructorMarker typeConstructor(@NotNull CapturedTypeMarker capturedTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    KotlinTypeMarker withNullability(@NotNull KotlinTypeMarker kotlinTypeMarker, boolean z11);

    @NotNull
    SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z11);
}
