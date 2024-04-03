package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SimpleClassicTypeSystemContext implements ClassicTypeSystemContext {
    @NotNull
    public static final SimpleClassicTypeSystemContext INSTANCE = new SimpleClassicTypeSystemContext();

    private SimpleClassicTypeSystemContext() {
    }

    public boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2) {
        return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, typeConstructorMarker, typeConstructorMarker2);
    }

    public int argumentsCount(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, kotlinTypeMarker);
    }

    @NotNull
    public TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, simpleTypeMarker);
    }

    @Nullable
    public CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, simpleTypeMarker);
    }

    @Nullable
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, simpleTypeMarker);
    }

    @Nullable
    public DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, flexibleTypeMarker);
    }

    @Nullable
    public FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, kotlinTypeMarker);
    }

    @Nullable
    public RawTypeMarker asRawType(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asRawType(this, flexibleTypeMarker);
    }

    @Nullable
    public SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, kotlinTypeMarker);
    }

    @NotNull
    public TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, kotlinTypeMarker);
    }

    @Nullable
    public SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus) {
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, simpleTypeMarker, captureStatus);
    }

    @NotNull
    public CaptureStatus captureStatus(@NotNull CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, capturedTypeMarker);
    }

    @NotNull
    public KotlinTypeMarker createFlexibleType(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, simpleTypeMarker, simpleTypeMarker2);
    }

    @Nullable
    public List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(this, simpleTypeMarker, typeConstructorMarker);
    }

    @NotNull
    public TypeArgumentMarker get(@NotNull TypeArgumentListMarker typeArgumentListMarker, int i11) {
        return ClassicTypeSystemContext.DefaultImpls.get(this, typeArgumentListMarker, i11);
    }

    @NotNull
    public TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker kotlinTypeMarker, int i11) {
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, kotlinTypeMarker, i11);
    }

    @Nullable
    public TypeArgumentMarker getArgumentOrNull(@NotNull SimpleTypeMarker simpleTypeMarker, int i11) {
        return ClassicTypeSystemContext.DefaultImpls.getArgumentOrNull(this, simpleTypeMarker, i11);
    }

    @NotNull
    public List<TypeArgumentMarker> getArguments(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getArguments(this, kotlinTypeMarker);
    }

    @NotNull
    public FqNameUnsafe getClassFqNameUnsafe(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, typeConstructorMarker);
    }

    @NotNull
    public TypeParameterMarker getParameter(@NotNull TypeConstructorMarker typeConstructorMarker, int i11) {
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, typeConstructorMarker, i11);
    }

    @NotNull
    public List<TypeParameterMarker> getParameters(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getParameters(this, typeConstructorMarker);
    }

    @Nullable
    public PrimitiveType getPrimitiveArrayType(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, typeConstructorMarker);
    }

    @Nullable
    public PrimitiveType getPrimitiveType(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, typeConstructorMarker);
    }

    @NotNull
    public KotlinTypeMarker getRepresentativeUpperBound(@NotNull TypeParameterMarker typeParameterMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, typeParameterMarker);
    }

    @NotNull
    public KotlinTypeMarker getType(@NotNull TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getType(this, typeArgumentMarker);
    }

    @Nullable
    public TypeParameterMarker getTypeParameter(@NotNull TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, typeVariableTypeConstructorMarker);
    }

    @Nullable
    public TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, typeConstructorMarker);
    }

    @Nullable
    public KotlinTypeMarker getUnsubstitutedUnderlyingType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, kotlinTypeMarker);
    }

    @NotNull
    public List<KotlinTypeMarker> getUpperBounds(@NotNull TypeParameterMarker typeParameterMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, typeParameterMarker);
    }

    @NotNull
    public TypeVariance getVariance(@NotNull TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext) this, typeArgumentMarker);
    }

    public boolean hasAnnotation(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull FqName fqName) {
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, kotlinTypeMarker, fqName);
    }

    public boolean hasFlexibleNullability(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.hasFlexibleNullability(this, kotlinTypeMarker);
    }

    public boolean hasRecursiveBounds(@NotNull TypeParameterMarker typeParameterMarker, @Nullable TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, typeParameterMarker, typeConstructorMarker);
    }

    public boolean identicalArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, simpleTypeMarker, simpleTypeMarker2);
    }

    @NotNull
    public KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> list) {
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, list);
    }

    public boolean isAnyConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, typeConstructorMarker);
    }

    public boolean isCapturedType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isCapturedType(this, kotlinTypeMarker);
    }

    public boolean isClassType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isClassType(this, simpleTypeMarker);
    }

    public boolean isClassTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, typeConstructorMarker);
    }

    public boolean isDefinitelyNotNullType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isDefinitelyNotNullType(this, kotlinTypeMarker);
    }

    public boolean isDenotable(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, typeConstructorMarker);
    }

    public boolean isDynamic(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isDynamic(this, kotlinTypeMarker);
    }

    public boolean isError(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isError(this, kotlinTypeMarker);
    }

    public boolean isInlineClass(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, typeConstructorMarker);
    }

    public boolean isIntegerLiteralType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralType(this, simpleTypeMarker);
    }

    public boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isIntersection(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, typeConstructorMarker);
    }

    public boolean isMarkedNullable(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable((ClassicTypeSystemContext) this, kotlinTypeMarker);
    }

    public boolean isNotNullTypeParameter(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, kotlinTypeMarker);
    }

    public boolean isNothing(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isNothing(this, kotlinTypeMarker);
    }

    public boolean isNothingConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, typeConstructorMarker);
    }

    public boolean isNullableType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, kotlinTypeMarker);
    }

    public boolean isOldCapturedType(@NotNull CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, capturedTypeMarker);
    }

    public boolean isPrimitiveType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, simpleTypeMarker);
    }

    public boolean isProjectionNotNull(@NotNull CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, capturedTypeMarker);
    }

    public boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, simpleTypeMarker);
    }

    public boolean isStarProjection(@NotNull TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, typeArgumentMarker);
    }

    public boolean isStubType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, simpleTypeMarker);
    }

    public boolean isStubTypeForBuilderInference(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, simpleTypeMarker);
    }

    public boolean isTypeVariableType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, kotlinTypeMarker);
    }

    public boolean isUnderKotlinPackage(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, typeConstructorMarker);
    }

    @NotNull
    public SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, flexibleTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBoundIfFlexible(this, kotlinTypeMarker);
    }

    @Nullable
    public KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, capturedTypeMarker);
    }

    @NotNull
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, kotlinTypeMarker);
    }

    @NotNull
    public KotlinTypeMarker makeNullable(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.makeNullable(this, kotlinTypeMarker);
    }

    @NotNull
    public TypeCheckerState newTypeCheckerState(boolean z11, boolean z12) {
        return ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, z11, z12);
    }

    @NotNull
    public SimpleTypeMarker original(@NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.original(this, definitelyNotNullTypeMarker);
    }

    public int parametersCount(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, typeConstructorMarker);
    }

    @NotNull
    public Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, simpleTypeMarker);
    }

    @NotNull
    public TypeArgumentMarker projection(@NotNull CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.projection(this, capturedTypeConstructorMarker);
    }

    public int size(@NotNull TypeArgumentListMarker typeArgumentListMarker) {
        return ClassicTypeSystemContext.DefaultImpls.size(this, typeArgumentListMarker);
    }

    @NotNull
    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, simpleTypeMarker);
    }

    @NotNull
    public Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, typeConstructorMarker);
    }

    @NotNull
    public CapturedTypeConstructorMarker typeConstructor(@NotNull CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, capturedTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, flexibleTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.upperBoundIfFlexible(this, kotlinTypeMarker);
    }

    @NotNull
    public KotlinTypeMarker withNullability(@NotNull KotlinTypeMarker kotlinTypeMarker, boolean z11) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext) this, kotlinTypeMarker, z11);
    }

    @NotNull
    public TypeVariance getVariance(@NotNull TypeParameterMarker typeParameterMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext) this, typeParameterMarker);
    }

    public boolean isMarkedNullable(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable((ClassicTypeSystemContext) this, simpleTypeMarker);
    }

    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, kotlinTypeMarker);
    }

    @NotNull
    public SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z11) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext) this, simpleTypeMarker, z11);
    }

    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, simpleTypeMarker);
    }
}
