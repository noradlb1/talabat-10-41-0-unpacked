package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeSubstitutor {
    public static final TypeSubstitutor EMPTY = create(TypeSubstitution.EMPTY);
    @NotNull
    private final TypeSubstitution substitution;

    /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24961a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$VarianceConflictType[] r0 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.VarianceConflictType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24961a = r0
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$VarianceConflictType r1 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.VarianceConflictType.OUT_IN_IN_POSITION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24961a     // Catch:{ NoSuchFieldError -> 0x001d }
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$VarianceConflictType r1 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.VarianceConflictType.IN_IN_OUT_POSITION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24961a     // Catch:{ NoSuchFieldError -> 0x0028 }
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$VarianceConflictType r1 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.VarianceConflictType.NO_CONFLICT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.AnonymousClass2.<clinit>():void");
        }
    }

    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str;
        int i12;
        Throwable th2;
        if (!(i11 == 1 || i11 == 2 || i11 == 8 || i11 == 34 || i11 == 37)) {
            switch (i11) {
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (i11) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                        default:
                            switch (i11) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    break;
                                default:
                                    switch (i11) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                            }
                    }
            }
        }
        str = "@NotNull method %s.%s must not return null";
        if (!(i11 == 1 || i11 == 2 || i11 == 8 || i11 == 34 || i11 == 37)) {
            switch (i11) {
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (i11) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                        default:
                            switch (i11) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    break;
                                default:
                                    switch (i11) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            i12 = 3;
                                            break;
                                    }
                            }
                    }
            }
        }
        i12 = 2;
        Object[] objArr = new Object[i12];
        switch (i11) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 3:
                objArr[0] = "first";
                break;
            case 4:
                objArr[0] = "second";
                break;
            case 5:
                objArr[0] = "substitutionContext";
                break;
            case 6:
                objArr[0] = "context";
                break;
            case 9:
            case 14:
                objArr[0] = "type";
                break;
            case 10:
            case 15:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 16:
            case 17:
            case 36:
                objArr[0] = "typeProjection";
                break;
            case 18:
            case 28:
                objArr[0] = "originalProjection";
                break;
            case 26:
                objArr[0] = "originalType";
                break;
            case 27:
                objArr[0] = "substituted";
                break;
            case 33:
                objArr[0] = "annotations";
                break;
            case 35:
            case 38:
                objArr[0] = "typeParameterVariance";
                break;
            case 39:
                objArr[0] = "projectionKind";
                break;
            default:
                objArr[0] = "substitution";
                break;
        }
        if (i11 == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i11 == 2) {
            objArr[1] = "replaceWithContravariantApproximatingSubstitution";
        } else if (i11 == 8) {
            objArr[1] = "getSubstitution";
        } else if (i11 != 34) {
            if (i11 != 37) {
                switch (i11) {
                    case 11:
                    case 12:
                    case 13:
                        objArr[1] = "safeSubstitute";
                        break;
                    default:
                        switch (i11) {
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                                objArr[1] = "unsafeSubstitute";
                                break;
                            default:
                                switch (i11) {
                                    case 29:
                                    case 30:
                                    case 31:
                                    case 32:
                                        objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                        break;
                                    default:
                                        switch (i11) {
                                            case 40:
                                            case 41:
                                            case 42:
                                                break;
                                            default:
                                                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                                break;
                                        }
                                }
                        }
                }
            }
            objArr[1] = "combine";
        } else {
            objArr[1] = "filterOutUnsafeVariance";
        }
        switch (i11) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                break;
            case 3:
            case 4:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 7:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
            case 9:
            case 10:
                objArr[2] = "safeSubstitute";
                break;
            case 14:
            case 15:
            case 16:
                objArr[2] = "substitute";
                break;
            case 17:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 18:
                objArr[2] = "unsafeSubstitute";
                break;
            case 26:
            case 27:
            case 28:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 33:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 35:
            case 36:
            case 38:
            case 39:
                objArr[2] = "combine";
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        if (!(i11 == 1 || i11 == 2 || i11 == 8 || i11 == 34 || i11 == 37)) {
            switch (i11) {
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (i11) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                        default:
                            switch (i11) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    break;
                                default:
                                    switch (i11) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            th2 = new IllegalArgumentException(format);
                                            break;
                                    }
                            }
                    }
            }
        }
        th2 = new IllegalStateException(format);
        throw th2;
    }

    public TypeSubstitutor(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(7);
        }
        this.substitution = typeSubstitution;
    }

    private static void assertRecursionDepth(int i11, TypeProjection typeProjection, TypeSubstitution typeSubstitution) {
        if (i11 > 100) {
            throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(typeProjection) + "; substitution: " + safeToString(typeSubstitution));
        }
    }

    @NotNull
    public static Variance combine(@NotNull Variance variance, @NotNull TypeProjection typeProjection) {
        if (variance == null) {
            $$$reportNull$$$0(35);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(36);
        }
        if (!typeProjection.isStarProjection()) {
            return combine(variance, typeProjection.getProjectionKind());
        }
        Variance variance2 = Variance.OUT_VARIANCE;
        if (variance2 == null) {
            $$$reportNull$$$0(37);
        }
        return variance2;
    }

    private static VarianceConflictType conflictType(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    @NotNull
    public static TypeSubstitutor create(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(0);
        }
        return new TypeSubstitutor(typeSubstitution);
    }

    @NotNull
    public static TypeSubstitutor createChainedSubstitutor(@NotNull TypeSubstitution typeSubstitution, @NotNull TypeSubstitution typeSubstitution2) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(3);
        }
        if (typeSubstitution2 == null) {
            $$$reportNull$$$0(4);
        }
        return create(DisjointKeysUnionTypeSubstitution.create(typeSubstitution, typeSubstitution2));
    }

    @NotNull
    private static Annotations filterOutUnsafeVariance(@NotNull Annotations annotations) {
        if (annotations == null) {
            $$$reportNull$$$0(33);
        }
        if (!annotations.hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
            return annotations;
        }
        return new FilteredAnnotations(annotations, new Function1<FqName, Boolean>() {
            private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"}));
            }

            public Boolean invoke(@NotNull FqName fqName) {
                if (fqName == null) {
                    $$$reportNull$$$0(0);
                }
                return Boolean.valueOf(!fqName.equals(StandardNames.FqNames.unsafeVariance));
            }
        });
    }

    @NotNull
    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(@NotNull KotlinType kotlinType, @NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeProjection typeProjection2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(26);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(27);
        }
        if (typeProjection2 == null) {
            $$$reportNull$$$0(28);
        }
        if (!kotlinType.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
            if (typeProjection == null) {
                $$$reportNull$$$0(29);
            }
            return typeProjection;
        }
        TypeConstructor constructor = typeProjection.getType().getConstructor();
        if (!(constructor instanceof NewCapturedTypeConstructor)) {
            return typeProjection;
        }
        TypeProjection projection = ((NewCapturedTypeConstructor) constructor).getProjection();
        Variance projectionKind = projection.getProjectionKind();
        VarianceConflictType conflictType = conflictType(typeProjection2.getProjectionKind(), projectionKind);
        VarianceConflictType varianceConflictType = VarianceConflictType.OUT_IN_IN_POSITION;
        if (conflictType == varianceConflictType) {
            return new TypeProjectionImpl(projection.getType());
        }
        if (typeParameterDescriptor != null && conflictType(typeParameterDescriptor.getVariance(), projectionKind) == varianceConflictType) {
            return new TypeProjectionImpl(projection.getType());
        }
        return typeProjection;
    }

    private static String safeToString(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th2) {
            if (!ExceptionUtilsKt.isProcessCanceledException(th2)) {
                return "[Exception while computing toString(): " + th2 + "]";
            }
            throw th2;
        }
    }

    private TypeProjection substituteCompoundType(TypeProjection typeProjection, int i11) throws SubstitutionException {
        KotlinType kotlinType;
        KotlinType type = typeProjection.getType();
        Variance projectionKind = typeProjection.getProjectionKind();
        if (type.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(type);
        if (abbreviation != null) {
            kotlinType = replaceWithNonApproximatingSubstitution().substitute(abbreviation, Variance.INVARIANT);
        } else {
            kotlinType = null;
        }
        KotlinType replace = TypeSubstitutionKt.replace(type, (List<? extends TypeProjection>) substituteTypeArguments(type.getConstructor().getParameters(), type.getArguments(), i11), this.substitution.filterAnnotations(type.getAnnotations()));
        if ((replace instanceof SimpleType) && (kotlinType instanceof SimpleType)) {
            replace = SpecialTypesKt.withAbbreviation((SimpleType) replace, (SimpleType) kotlinType);
        }
        return new TypeProjectionImpl(projectionKind, replace);
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> list, List<TypeProjection> list2, int i11) throws SubstitutionException {
        Variance variance;
        ArrayList arrayList = new ArrayList(list.size());
        boolean z11 = false;
        for (int i12 = 0; i12 < list.size(); i12++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i12);
            TypeProjection typeProjection = list2.get(i12);
            TypeProjection unsafeSubstitute = unsafeSubstitute(typeProjection, typeParameterDescriptor, i11 + 1);
            int i13 = AnonymousClass2.f24961a[conflictType(typeParameterDescriptor.getVariance(), unsafeSubstitute.getProjectionKind()).ordinal()];
            if (i13 == 1 || i13 == 2) {
                unsafeSubstitute = TypeUtils.makeStarProjection(typeParameterDescriptor);
            } else if (i13 == 3 && typeParameterDescriptor.getVariance() != (variance = Variance.INVARIANT) && !unsafeSubstitute.isStarProjection()) {
                unsafeSubstitute = new TypeProjectionImpl(variance, unsafeSubstitute.getType());
            }
            if (unsafeSubstitute != typeProjection) {
                z11 = true;
            }
            arrayList.add(unsafeSubstitute);
        }
        if (!z11) {
            return list2;
        }
        return arrayList;
    }

    @NotNull
    private TypeProjection unsafeSubstitute(@NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, int i11) throws SubstitutionException {
        TypeProjection typeProjection2;
        KotlinType kotlinType;
        if (typeProjection == null) {
            $$$reportNull$$$0(18);
        }
        assertRecursionDepth(i11, typeProjection, this.substitution);
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
            UnwrappedType origin = typeWithEnhancement.getOrigin();
            KotlinType enhancement = typeWithEnhancement.getEnhancement();
            TypeProjection unsafeSubstitute = unsafeSubstitute(new TypeProjectionImpl(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i11 + 1);
            if (unsafeSubstitute.isStarProjection()) {
                return unsafeSubstitute;
            }
            return new TypeProjectionImpl(unsafeSubstitute.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(unsafeSubstitute.getType().unwrap(), substitute(enhancement, typeProjection.getProjectionKind())));
        }
        if (!DynamicTypesKt.isDynamic(type) && !(type.unwrap() instanceof RawType)) {
            TypeProjection typeProjection3 = this.substitution.get(type);
            if (typeProjection3 != null) {
                typeProjection2 = projectedTypeForConflictedTypeWithUnsafeVariance(type, typeProjection3, typeParameterDescriptor, typeProjection);
            } else {
                typeProjection2 = null;
            }
            Variance projectionKind = typeProjection.getProjectionKind();
            if (typeProjection2 == null && FlexibleTypesKt.isFlexible(type) && !TypeCapabilitiesKt.isCustomTypeParameter(type)) {
                FlexibleType asFlexibleType = FlexibleTypesKt.asFlexibleType(type);
                int i12 = i11 + 1;
                TypeProjection unsafeSubstitute2 = unsafeSubstitute(new TypeProjectionImpl(projectionKind, asFlexibleType.getLowerBound()), typeParameterDescriptor, i12);
                TypeProjection unsafeSubstitute3 = unsafeSubstitute(new TypeProjectionImpl(projectionKind, asFlexibleType.getUpperBound()), typeParameterDescriptor, i12);
                Variance projectionKind2 = unsafeSubstitute2.getProjectionKind();
                if (unsafeSubstitute2.getType() == asFlexibleType.getLowerBound() && unsafeSubstitute3.getType() == asFlexibleType.getUpperBound()) {
                    return typeProjection;
                }
                return new TypeProjectionImpl(projectionKind2, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(unsafeSubstitute2.getType()), TypeSubstitutionKt.asSimpleType(unsafeSubstitute3.getType())));
            } else if (!KotlinBuiltIns.isNothing(type) && !KotlinTypeKt.isError(type)) {
                if (typeProjection2 != null) {
                    VarianceConflictType conflictType = conflictType(projectionKind, typeProjection2.getProjectionKind());
                    if (!CapturedTypeConstructorKt.isCaptured(type)) {
                        int i13 = AnonymousClass2.f24961a[conflictType.ordinal()];
                        if (i13 == 1) {
                            throw new SubstitutionException("Out-projection in in-position");
                        } else if (i13 == 2) {
                            return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                        }
                    }
                    CustomTypeParameter customTypeParameter = TypeCapabilitiesKt.getCustomTypeParameter(type);
                    if (typeProjection2.isStarProjection()) {
                        return typeProjection2;
                    }
                    if (customTypeParameter != null) {
                        kotlinType = customTypeParameter.substitutionResult(typeProjection2.getType());
                    } else {
                        kotlinType = TypeUtils.makeNullableIfNeeded(typeProjection2.getType(), type.isMarkedNullable());
                    }
                    if (!type.getAnnotations().isEmpty()) {
                        kotlinType = TypeUtilsKt.replaceAnnotations(kotlinType, new CompositeAnnotations(kotlinType.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(type.getAnnotations()))));
                    }
                    if (conflictType == VarianceConflictType.NO_CONFLICT) {
                        projectionKind = combine(projectionKind, typeProjection2.getProjectionKind());
                    }
                    return new TypeProjectionImpl(projectionKind, kotlinType);
                }
                typeProjection = substituteCompoundType(typeProjection, i11);
                if (typeProjection == null) {
                    $$$reportNull$$$0(25);
                }
            }
        }
        return typeProjection;
    }

    @NotNull
    public TypeSubstitution getSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if (typeSubstitution == null) {
            $$$reportNull$$$0(8);
        }
        return typeSubstitution;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    @NotNull
    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if (!(typeSubstitution instanceof IndexedParametersSubstitution) || !typeSubstitution.approximateContravariantCapturedTypes()) {
            return this;
        }
        return new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.substitution).getParameters(), ((IndexedParametersSubstitution) this.substitution).getArguments(), false));
    }

    @NotNull
    public KotlinType safeSubstitute(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(9);
        }
        if (variance == null) {
            $$$reportNull$$$0(10);
        }
        if (isEmpty()) {
            if (kotlinType == null) {
                $$$reportNull$$$0(11);
            }
            return kotlinType;
        }
        try {
            KotlinType type = unsafeSubstitute(new TypeProjectionImpl(variance, kotlinType), (TypeParameterDescriptor) null, 0).getType();
            if (type == null) {
                $$$reportNull$$$0(12);
            }
            return type;
        } catch (SubstitutionException e11) {
            ErrorType createErrorType = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, e11.getMessage());
            if (createErrorType == null) {
                $$$reportNull$$$0(13);
            }
            return createErrorType;
        }
    }

    @Nullable
    public KotlinType substitute(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(14);
        }
        if (variance == null) {
            $$$reportNull$$$0(15);
        }
        TypeProjection substitute = substitute(new TypeProjectionImpl(variance, getSubstitution().prepareTopLevelType(kotlinType, variance)));
        if (substitute == null) {
            return null;
        }
        return substitute.getType();
    }

    @Nullable
    public TypeProjection substituteWithoutApproximation(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(17);
        }
        if (isEmpty()) {
            return typeProjection;
        }
        try {
            return unsafeSubstitute(typeProjection, (TypeParameterDescriptor) null, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }

    @NotNull
    public static TypeSubstitutor create(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(6);
        }
        return create(TypeConstructorSubstitution.create(kotlinType.getConstructor(), kotlinType.getArguments()));
    }

    @NotNull
    public static Variance combine(@NotNull Variance variance, @NotNull Variance variance2) {
        if (variance == null) {
            $$$reportNull$$$0(38);
        }
        if (variance2 == null) {
            $$$reportNull$$$0(39);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                $$$reportNull$$$0(40);
            }
            return variance2;
        } else if (variance2 == variance3) {
            if (variance == null) {
                $$$reportNull$$$0(41);
            }
            return variance;
        } else if (variance == variance2) {
            if (variance2 == null) {
                $$$reportNull$$$0(42);
            }
            return variance2;
        } else {
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and " + "projection kind '" + variance2 + "' cannot be combined");
        }
    }

    @Nullable
    public TypeProjection substitute(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(16);
        }
        TypeProjection substituteWithoutApproximation = substituteWithoutApproximation(typeProjection);
        if (this.substitution.approximateCapturedTypes() || this.substitution.approximateContravariantCapturedTypes()) {
            return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(substituteWithoutApproximation, this.substitution.approximateContravariantCapturedTypes());
        }
        return substituteWithoutApproximation;
    }
}
