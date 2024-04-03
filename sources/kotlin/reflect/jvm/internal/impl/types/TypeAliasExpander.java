package kotlin.reflect.jvm.internal.impl.types;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class TypeAliasExpander {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final TypeAliasExpander NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    @NotNull
    private final TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void assertRecursionDepth(int i11, TypeAliasDescriptor typeAliasDescriptor) {
            if (i11 > 100) {
                throw new AssertionError("Too deep recursion while expanding type alias " + typeAliasDescriptor.getName());
            }
        }
    }

    public TypeAliasExpander(@NotNull TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z11) {
        Intrinsics.checkNotNullParameter(typeAliasExpansionReportStrategy, "reportStrategy");
        this.reportStrategy = typeAliasExpansionReportStrategy;
        this.shouldCheckBounds = z11;
    }

    private final void checkRepeatedAnnotations(Annotations annotations, Annotations annotations2) {
        HashSet hashSet = new HashSet();
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(((AnnotationDescriptor) it.next()).getFqName());
        }
        Iterator it2 = annotations2.iterator();
        while (it2.hasNext()) {
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) it2.next();
            if (hashSet.contains(annotationDescriptor.getFqName())) {
                this.reportStrategy.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    private final void checkTypeArgumentsSubstitution(KotlinType kotlinType, KotlinType kotlinType2) {
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType2);
        Intrinsics.checkNotNullExpressionValue(create, "create(substitutedType)");
        int i11 = 0;
        for (Object next : kotlinType2.getArguments()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) next;
            if (!typeProjection.isStarProjection()) {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(type, "substitutedArgument.type");
                if (!TypeUtilsKt.containsTypeAliasParameters(type)) {
                    TypeProjection typeProjection2 = kotlinType.getArguments().get(i11);
                    TypeParameterDescriptor typeParameterDescriptor = kotlinType.getConstructor().getParameters().get(i11);
                    if (this.shouldCheckBounds) {
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.reportStrategy;
                        KotlinType type2 = typeProjection2.getType();
                        Intrinsics.checkNotNullExpressionValue(type2, "unsubstitutedArgument.type");
                        KotlinType type3 = typeProjection.getType();
                        Intrinsics.checkNotNullExpressionValue(type3, "substitutedArgument.type");
                        Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "typeParameter");
                        typeAliasExpansionReportStrategy.boundsViolationInSubstitution(create, type2, type3, typeParameterDescriptor);
                    }
                }
            }
            i11 = i12;
        }
    }

    private final DynamicType combineAttributes(DynamicType dynamicType, TypeAttributes typeAttributes) {
        return dynamicType.replaceAttributes(createdCombinedAttributes(dynamicType, typeAttributes));
    }

    private final SimpleType combineNullability(SimpleType simpleType, KotlinType kotlinType) {
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(simpleType, kotlinType.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return makeNullableIfNeeded;
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType simpleType, KotlinType kotlinType) {
        return combineAttributes(combineNullability(simpleType, kotlinType), kotlinType.getAttributes());
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion typeAliasExpansion, TypeAttributes typeAttributes, boolean z11) {
        TypeConstructor typeConstructor = typeAliasExpansion.getDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(typeAttributes, typeConstructor, typeAliasExpansion.getArguments(), z11, MemberScope.Empty.INSTANCE);
    }

    private final TypeAttributes createdCombinedAttributes(KotlinType kotlinType, TypeAttributes typeAttributes) {
        if (KotlinTypeKt.isError(kotlinType)) {
            return kotlinType.getAttributes();
        }
        return typeAttributes.add(kotlinType.getAttributes());
    }

    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, int i11) {
        UnwrappedType unwrap = typeProjection.getType().unwrap();
        if (DynamicTypesKt.isDynamic(unwrap)) {
            return typeProjection;
        }
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(unwrap);
        if (KotlinTypeKt.isError(asSimpleType) || !TypeUtilsKt.requiresTypeAliasExpansion(asSimpleType)) {
            return typeProjection;
        }
        TypeConstructor constructor = asSimpleType.getConstructor();
        ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
        constructor.getParameters().size();
        asSimpleType.getArguments().size();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        if (declarationDescriptor instanceof TypeAliasDescriptor) {
            TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) declarationDescriptor;
            int i12 = 0;
            if (typeAliasExpansion.isRecursion(typeAliasDescriptor)) {
                this.reportStrategy.recursiveTypeAlias(typeAliasDescriptor);
                Variance variance = Variance.INVARIANT;
                ErrorTypeKind errorTypeKind = ErrorTypeKind.RECURSIVE_TYPE_ALIAS;
                String name2 = typeAliasDescriptor.getName().toString();
                Intrinsics.checkNotNullExpressionValue(name2, "typeDescriptor.name.toString()");
                return new TypeProjectionImpl(variance, ErrorUtils.createErrorType(errorTypeKind, name2));
            }
            Iterable arguments = asSimpleType.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
            for (Object next : arguments) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(expandTypeProjection((TypeProjection) next, typeAliasExpansion, constructor.getParameters().get(i12), i11 + 1));
                i12 = i13;
            }
            SimpleType expandRecursively = expandRecursively(TypeAliasExpansion.Companion.create(typeAliasExpansion, typeAliasDescriptor, arrayList), asSimpleType.getAttributes(), asSimpleType.isMarkedNullable(), i11 + 1, false);
            SimpleType substituteArguments = substituteArguments(asSimpleType, typeAliasExpansion, i11);
            if (!DynamicTypesKt.isDynamic(expandRecursively)) {
                expandRecursively = SpecialTypesKt.withAbbreviation(expandRecursively, substituteArguments);
            }
            return new TypeProjectionImpl(typeProjection.getProjectionKind(), expandRecursively);
        }
        SimpleType substituteArguments2 = substituteArguments(asSimpleType, typeAliasExpansion, i11);
        checkTypeArgumentsSubstitution(asSimpleType, substituteArguments2);
        return new TypeProjectionImpl(typeProjection.getProjectionKind(), substituteArguments2);
    }

    private final SimpleType expandRecursively(TypeAliasExpansion typeAliasExpansion, TypeAttributes typeAttributes, boolean z11, int i11, boolean z12) {
        TypeProjection expandTypeProjection = expandTypeProjection(new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType()), typeAliasExpansion, (TypeParameterDescriptor) null, i11);
        KotlinType type = expandTypeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "expandedProjection.type");
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(type);
        if (KotlinTypeKt.isError(asSimpleType)) {
            return asSimpleType;
        }
        expandTypeProjection.getProjectionKind();
        checkRepeatedAnnotations(asSimpleType.getAnnotations(), AnnotationsTypeAttributeKt.getAnnotations(typeAttributes));
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(combineAttributes(asSimpleType, typeAttributes), z11);
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "expandedType.combineAttr…fNeeded(it, isNullable) }");
        if (z12) {
            return SpecialTypesKt.withAbbreviation(makeNullableIfNeeded, createAbbreviation(typeAliasExpansion, typeAttributes, z11));
        }
        return makeNullableIfNeeded;
    }

    private final TypeProjection expandTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int i11) {
        Variance variance;
        KotlinType kotlinType;
        Variance variance2;
        Variance variance3;
        Companion.assertRecursionDepth(i11, typeAliasExpansion.getDescriptor());
        if (typeProjection.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "underlyingProjection.type");
        TypeProjection replacement = typeAliasExpansion.getReplacement(type.getConstructor());
        if (replacement == null) {
            return expandNonArgumentTypeProjection(typeProjection, typeAliasExpansion, i11);
        }
        if (replacement.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection2, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection2;
        }
        UnwrappedType unwrap = replacement.getType().unwrap();
        Variance projectionKind = replacement.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(projectionKind, "argument.projectionKind");
        Variance projectionKind2 = typeProjection.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(projectionKind2, "underlyingProjection.projectionKind");
        if (!(projectionKind2 == projectionKind || projectionKind2 == (variance3 = Variance.INVARIANT))) {
            if (projectionKind == variance3) {
                projectionKind = projectionKind2;
            } else {
                this.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
            }
        }
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null) {
            variance = Variance.INVARIANT;
        }
        Intrinsics.checkNotNullExpressionValue(variance, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (!(variance == projectionKind || variance == (variance2 = Variance.INVARIANT))) {
            if (projectionKind == variance2) {
                projectionKind = variance2;
            } else {
                this.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
            }
        }
        checkRepeatedAnnotations(type.getAnnotations(), unwrap.getAnnotations());
        if (unwrap instanceof DynamicType) {
            kotlinType = combineAttributes((DynamicType) unwrap, type.getAttributes());
        } else {
            kotlinType = combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(unwrap), type);
        }
        return new TypeProjectionImpl(projectionKind, kotlinType);
    }

    private final SimpleType substituteArguments(SimpleType simpleType, TypeAliasExpansion typeAliasExpansion, int i11) {
        TypeConstructor constructor = simpleType.getConstructor();
        Iterable arguments = simpleType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
        int i12 = 0;
        for (Object next : arguments) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) next;
            TypeProjection expandTypeProjection = expandTypeProjection(typeProjection, typeAliasExpansion, constructor.getParameters().get(i12), i11 + 1);
            if (!expandTypeProjection.isStarProjection()) {
                expandTypeProjection = new TypeProjectionImpl(expandTypeProjection.getProjectionKind(), TypeUtils.makeNullableIfNeeded(expandTypeProjection.getType(), typeProjection.getType().isMarkedNullable()));
            }
            arrayList.add(expandTypeProjection);
            i12 = i13;
        }
        return TypeSubstitutionKt.replace$default(simpleType, arrayList, (TypeAttributes) null, 2, (Object) null);
    }

    @NotNull
    public final SimpleType expand(@NotNull TypeAliasExpansion typeAliasExpansion, @NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAliasExpansion, "typeAliasExpansion");
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        return expandRecursively(typeAliasExpansion, typeAttributes, false, 0, true);
    }

    private final SimpleType combineAttributes(SimpleType simpleType, TypeAttributes typeAttributes) {
        return KotlinTypeKt.isError(simpleType) ? simpleType : TypeSubstitutionKt.replace$default(simpleType, (List) null, createdCombinedAttributes(simpleType, typeAttributes), 1, (Object) null);
    }
}
