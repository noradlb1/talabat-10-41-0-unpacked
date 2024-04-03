package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AbstractStubType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeUtilsKt {
    @NotNull
    public static final TypeProjection asTypeProjection(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return new TypeProjectionImpl(kotlinType);
    }

    public static final boolean contains(@NotNull KotlinType kotlinType, @NotNull Function1<? super UnwrappedType, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return TypeUtils.contains(kotlinType, function1);
    }

    private static final boolean containsSelfTypeParameter(KotlinType kotlinType, TypeConstructor typeConstructor, Set<? extends TypeParameterDescriptor> set) {
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters;
        List<TypeParameterDescriptor> list;
        TypeParameterDescriptor typeParameterDescriptor;
        boolean z11;
        boolean z12;
        if (Intrinsics.areEqual((Object) kotlinType.getConstructor(), (Object) typeConstructor)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters) {
            classifierDescriptorWithTypeParameters = (ClassifierDescriptorWithTypeParameters) declarationDescriptor;
        } else {
            classifierDescriptorWithTypeParameters = null;
        }
        if (classifierDescriptorWithTypeParameters != null) {
            list = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        } else {
            list = null;
        }
        Iterable<IndexedValue> withIndex = CollectionsKt___CollectionsKt.withIndex(kotlinType.getArguments());
        if (!(withIndex instanceof Collection) || !((Collection) withIndex).isEmpty()) {
            for (IndexedValue indexedValue : withIndex) {
                int component1 = indexedValue.component1();
                TypeProjection typeProjection = (TypeProjection) indexedValue.component2();
                if (list != null) {
                    typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt___CollectionsKt.getOrNull(list, component1);
                } else {
                    typeParameterDescriptor = null;
                }
                if (typeParameterDescriptor == null || set == null || !set.contains(typeParameterDescriptor)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11 || typeProjection.isStarProjection()) {
                    z12 = false;
                    continue;
                } else {
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "argument.type");
                    z12 = containsSelfTypeParameter(type, typeConstructor, set);
                    continue;
                }
                if (z12) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean containsTypeAliasParameters(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, TypeUtilsKt$containsTypeAliasParameters$1.INSTANCE);
    }

    @NotNull
    public static final TypeProjection createProjection(@NotNull KotlinType kotlinType, @NotNull Variance variance, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Variance variance2;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        Intrinsics.checkNotNullParameter(variance, "projectionKind");
        if (typeParameterDescriptor != null) {
            variance2 = typeParameterDescriptor.getVariance();
        } else {
            variance2 = null;
        }
        if (variance2 == variance) {
            variance = Variance.INVARIANT;
        }
        return new TypeProjectionImpl(variance, kotlinType);
    }

    @NotNull
    public static final Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds(@NotNull KotlinType kotlinType, @Nullable Set<? extends TypeParameterDescriptor> set) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        extractTypeParametersFromUpperBounds(kotlinType, kotlinType, linkedHashSet, set);
        return linkedHashSet;
    }

    @NotNull
    public static final KotlinBuiltIns getBuiltIns(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinBuiltIns builtIns = kotlinType.getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "constructor.builtIns");
        return builtIns;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX WARNING: type inference failed for: r4v3, types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getRepresentativeUpperBound(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.List r0 = r7.getUpperBounds()
            java.lang.String r1 = "upperBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            r0.isEmpty()
            java.util.List r0 = r7.getUpperBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0020:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0055
            java.lang.Object r2 = r0.next()
            r4 = r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r4.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getDeclarationDescriptor()
            boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r5 == 0) goto L_0x003d
            r3 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
        L_0x003d:
            r4 = 0
            if (r3 != 0) goto L_0x0041
            goto L_0x0052
        L_0x0041:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r5 == r6) goto L_0x0052
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r3 == r5) goto L_0x0052
            r4 = 1
        L_0x0052:
            if (r4 == 0) goto L_0x0020
            r3 = r2
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            if (r3 != 0) goto L_0x006c
            java.util.List r7 = r7.getUpperBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.first(r7)
            java.lang.String r0 = "upperBounds.first()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r3 = r7
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        return hasTypeParameterRecursiveBounds$default(typeParameterDescriptor, (TypeConstructor) null, (Set) null, 6, (Object) null);
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(@NotNull TypeParameterDescriptor typeParameterDescriptor, @Nullable TypeConstructor typeConstructor, @Nullable Set<? extends TypeParameterDescriptor> set) {
        boolean z11;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
        Iterable<KotlinType> iterable = upperBounds;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (KotlinType kotlinType : iterable) {
            Intrinsics.checkNotNullExpressionValue(kotlinType, "upperBound");
            if (!containsSelfTypeParameter(kotlinType, typeParameterDescriptor.getDefaultType().getConstructor(), set) || (typeConstructor != null && !Intrinsics.areEqual((Object) kotlinType.getConstructor(), (Object) typeConstructor))) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(TypeParameterDescriptor typeParameterDescriptor, TypeConstructor typeConstructor, Set set, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typeConstructor = null;
        }
        if ((i11 & 4) != 0) {
            set = null;
        }
        return hasTypeParameterRecursiveBounds(typeParameterDescriptor, typeConstructor, set);
    }

    public static final boolean isStubType(@NotNull KotlinType kotlinType) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof AbstractStubType) {
            return true;
        }
        if (!(kotlinType instanceof DefinitelyNotNullType) || !(((DefinitelyNotNullType) kotlinType).getOriginal() instanceof AbstractStubType)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    public static final boolean isStubTypeForBuilderInference(@NotNull KotlinType kotlinType) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof StubTypeForBuilderInference) {
            return true;
        }
        if (!(kotlinType instanceof DefinitelyNotNullType) || !(((DefinitelyNotNullType) kotlinType).getOriginal() instanceof StubTypeForBuilderInference)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    public static final boolean isSubtypeOf(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(kotlinType2, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType, kotlinType2);
    }

    public static final boolean isTypeAliasParameter(@NotNull ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "<this>");
        if (!(classifierDescriptor instanceof TypeParameterDescriptor) || !(((TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor)) {
            return false;
        }
        return true;
    }

    public static final boolean isTypeParameter(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.isTypeParameter(kotlinType);
    }

    public static final boolean isUnresolvedType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        if (!(kotlinType instanceof ErrorType) || !((ErrorType) kotlinType).getKind().isUnresolved()) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final KotlinType makeNotNullable(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(this)");
        return makeNotNullable;
    }

    @NotNull
    public static final KotlinType makeNullable(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinType makeNullable = TypeUtils.makeNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNullable, "makeNullable(this)");
        return makeNullable;
    }

    @NotNull
    public static final KotlinType replaceAnnotations(@NotNull KotlinType kotlinType, @NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        if (!kotlinType.getAnnotations().isEmpty() || !annotations.isEmpty()) {
            return kotlinType.unwrap().replaceAttributes(TypeAttributesKt.replaceAnnotations(kotlinType.getAttributes(), annotations));
        }
        return kotlinType;
    }

    @NotNull
    public static final KotlinType replaceArgumentsWithStarProjectionOrMapped(@NotNull KotlinType kotlinType, @NotNull TypeSubstitutor typeSubstitutor, @NotNull Map<TypeConstructor, ? extends TypeProjection> map, @NotNull Variance variance, @Nullable Set<? extends TypeParameterDescriptor> set) {
        UnwrappedType unwrappedType;
        TypeSubstitutor typeSubstitutor2 = typeSubstitutor;
        Map<TypeConstructor, ? extends TypeProjection> map2 = map;
        Variance variance2 = variance;
        Set<? extends TypeParameterDescriptor> set2 = set;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(typeSubstitutor2, "substitutor");
        Intrinsics.checkNotNullParameter(map2, "substitutionMap");
        Intrinsics.checkNotNullParameter(variance2, "variance");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            SimpleType lowerBound = flexibleType.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable = parameters;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
                    TypeProjection typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor.getIndex());
                    if ((set2 != null && set2.contains(typeParameterDescriptor)) || typeProjection == null || !map2.containsKey(typeProjection.getType().getConstructor())) {
                        typeProjection = new StarProjectionImpl(typeParameterDescriptor);
                    }
                    arrayList.add(typeProjection);
                }
                lowerBound = TypeSubstitutionKt.replace$default(lowerBound, arrayList, (TypeAttributes) null, 2, (Object) null);
            }
            SimpleType upperBound = flexibleType.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable2 = parameters2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                for (TypeParameterDescriptor typeParameterDescriptor2 : iterable2) {
                    TypeProjection typeProjection2 = (TypeProjection) CollectionsKt___CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor2.getIndex());
                    if ((set2 != null && set2.contains(typeParameterDescriptor2)) || typeProjection2 == null || !map2.containsKey(typeProjection2.getType().getConstructor())) {
                        typeProjection2 = new StarProjectionImpl(typeParameterDescriptor2);
                    }
                    arrayList2.add(typeProjection2);
                }
                upperBound = TypeSubstitutionKt.replace$default(upperBound, arrayList2, (TypeAttributes) null, 2, (Object) null);
            }
            unwrappedType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) unwrap;
            if (simpleType.getConstructor().getParameters().isEmpty() || simpleType.getConstructor().getDeclarationDescriptor() == null) {
                unwrappedType = simpleType;
            } else {
                List<TypeParameterDescriptor> parameters3 = simpleType.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable3 = parameters3;
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable3, 10));
                for (TypeParameterDescriptor typeParameterDescriptor3 : iterable3) {
                    TypeProjection typeProjection3 = (TypeProjection) CollectionsKt___CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor3.getIndex());
                    if ((set2 != null && set2.contains(typeParameterDescriptor3)) || typeProjection3 == null || !map2.containsKey(typeProjection3.getType().getConstructor())) {
                        typeProjection3 = new StarProjectionImpl(typeParameterDescriptor3);
                    }
                    arrayList3.add(typeProjection3);
                }
                unwrappedType = TypeSubstitutionKt.replace$default(simpleType, arrayList3, (TypeAttributes) null, 2, (Object) null);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        KotlinType safeSubstitute = typeSubstitutor2.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap), variance2);
        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "replaceArgumentsByParame…ubstitute(it, variance) }");
        return safeSubstitute;
    }

    @NotNull
    public static final KotlinType replaceArgumentsWithStarProjections(@NotNull KotlinType kotlinType) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            SimpleType lowerBound = flexibleType.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable = parameters;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (TypeParameterDescriptor starProjectionImpl : iterable) {
                    arrayList.add(new StarProjectionImpl(starProjectionImpl));
                }
                lowerBound = TypeSubstitutionKt.replace$default(lowerBound, arrayList, (TypeAttributes) null, 2, (Object) null);
            }
            SimpleType upperBound = flexibleType.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable2 = parameters2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                for (TypeParameterDescriptor starProjectionImpl2 : iterable2) {
                    arrayList2.add(new StarProjectionImpl(starProjectionImpl2));
                }
                upperBound = TypeSubstitutionKt.replace$default(upperBound, arrayList2, (TypeAttributes) null, 2, (Object) null);
            }
            simpleType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType2 = (SimpleType) unwrap;
            boolean isEmpty = simpleType2.getConstructor().getParameters().isEmpty();
            simpleType = simpleType2;
            if (!isEmpty) {
                ClassifierDescriptor declarationDescriptor = simpleType2.getConstructor().getDeclarationDescriptor();
                simpleType = simpleType2;
                if (declarationDescriptor != null) {
                    List<TypeParameterDescriptor> parameters3 = simpleType2.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                    Iterable<TypeParameterDescriptor> iterable3 = parameters3;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable3, 10));
                    for (TypeParameterDescriptor starProjectionImpl3 : iterable3) {
                        arrayList3.add(new StarProjectionImpl(starProjectionImpl3));
                    }
                    simpleType = TypeSubstitutionKt.replace$default(simpleType2, arrayList3, (TypeAttributes) null, 2, (Object) null);
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(simpleType, unwrap);
    }

    public static final boolean requiresTypeAliasExpansion(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, TypeUtilsKt$requiresTypeAliasExpansion$1.INSTANCE);
    }

    public static final boolean shouldBeUpdated(@Nullable KotlinType kotlinType) {
        return kotlinType == null || contains(kotlinType, TypeUtilsKt$shouldBeUpdated$1.INSTANCE);
    }

    private static final void extractTypeParametersFromUpperBounds(KotlinType kotlinType, KotlinType kotlinType2, Set<TypeParameterDescriptor> set, Set<? extends TypeParameterDescriptor> set2) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
            ClassifierDescriptor declarationDescriptor2 = kotlinType.getConstructor().getDeclarationDescriptor();
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = declarationDescriptor2 instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor2 : null;
            List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
            int i11 = 0;
            for (TypeProjection next : kotlinType.getArguments()) {
                int i12 = i11 + 1;
                TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters != null ? (TypeParameterDescriptor) CollectionsKt___CollectionsKt.getOrNull(declaredTypeParameters, i11) : null;
                if (!((typeParameterDescriptor == null || set2 == null || !set2.contains(typeParameterDescriptor)) ? false : true) && !next.isStarProjection() && !CollectionsKt___CollectionsKt.contains(set, next.getType().getConstructor().getDeclarationDescriptor()) && !Intrinsics.areEqual((Object) next.getType().getConstructor(), (Object) kotlinType2.getConstructor())) {
                    KotlinType type = next.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "argument.type");
                    extractTypeParametersFromUpperBounds(type, kotlinType2, set, set2);
                }
                i11 = i12;
            }
        } else if (!Intrinsics.areEqual((Object) kotlinType.getConstructor(), (Object) kotlinType2.getConstructor())) {
            set.add(declarationDescriptor);
        } else {
            for (KotlinType next2 : ((TypeParameterDescriptor) declarationDescriptor).getUpperBounds()) {
                Intrinsics.checkNotNullExpressionValue(next2, "upperBound");
                extractTypeParametersFromUpperBounds(next2, kotlinType2, set, set2);
            }
        }
    }
}
