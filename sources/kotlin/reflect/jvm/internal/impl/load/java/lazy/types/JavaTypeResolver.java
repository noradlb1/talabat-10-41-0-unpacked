package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.apptimize.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeResolver {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaResolverContext f24652c;
    @NotNull
    private final RawSubstitution rawSubstitution;
    @NotNull
    private final TypeParameterResolver typeParameterResolver;
    /* access modifiers changed from: private */
    @NotNull
    public final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public JavaTypeResolver(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull TypeParameterResolver typeParameterResolver2) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(typeParameterResolver2, "typeParameterResolver");
        this.f24652c = lazyJavaResolverContext;
        this.typeParameterResolver = typeParameterResolver2;
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser2 = new TypeParameterUpperBoundEraser((RawSubstitution) null, 1, (DefaultConstructorMarker) null);
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser2;
        this.rawSubstitution = new RawSubstitution(typeParameterUpperBoundEraser2);
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        Variance variance;
        if (!JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt___CollectionsKt.lastOrNull(javaClassifierType.getTypeArguments()))) {
            return false;
        }
        List<TypeParameterDescriptor> parameters = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt___CollectionsKt.lastOrNull(parameters);
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null || variance == Variance.OUT_VARIANCE) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if ((!r0.isEmpty()) != false) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r7, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r8, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r9) {
        /*
            r6 = this;
            boolean r0 = r7.isRaw()
            java.lang.String r1 = "constructor.parameters"
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0027
            java.util.List r0 = r7.getTypeArguments()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0025
            java.util.List r0 = r9.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r0 = r2
            goto L_0x0028
        L_0x0027:
            r0 = r3
        L_0x0028:
            java.util.List r4 = r9.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            if (r0 == 0) goto L_0x0036
            java.util.List r7 = r6.computeRawTypeArguments(r7, r4, r9, r8)
            return r7
        L_0x0036:
            int r8 = r4.size()
            java.util.List r9 = r7.getTypeArguments()
            int r9 = r9.size()
            r0 = 10
            if (r8 == r9) goto L_0x0086
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r4, r0)
            r7.<init>(r8)
            java.util.Iterator r8 = r4.iterator()
        L_0x0055:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0081
            java.lang.Object r9 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER
            java.lang.String[] r4 = new java.lang.String[r3]
            kotlin.reflect.jvm.internal.impl.name.Name r9 = r9.getName()
            java.lang.String r9 = r9.asString()
            java.lang.String r5 = "p.name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            r4[r2] = r9
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r9 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(r1, r4)
            r0.<init>(r9)
            r7.add(r0)
            goto L_0x0055
        L_0x0081:
            java.util.List r7 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r7)
            return r7
        L_0x0086:
            java.util.List r7 = r7.getTypeArguments()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.lang.Iterable r7 = kotlin.collections.CollectionsKt___CollectionsKt.withIndex(r7)
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r7, r0)
            r8.<init>(r9)
            java.util.Iterator r7 = r7.iterator()
        L_0x009d:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00d1
            java.lang.Object r9 = r7.next()
            kotlin.collections.IndexedValue r9 = (kotlin.collections.IndexedValue) r9
            int r0 = r9.component1()
            java.lang.Object r9 = r9.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r9
            r4.size()
            java.lang.Object r0 = r4.get(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r1 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r3 = 3
            r5 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r1 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r1, r2, r5, r3, r5)
            java.lang.String r3 = "parameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r9 = r6.transformToTypeProjection(r9, r1, r0)
            r8.add(r9)
            goto L_0x009d
        L_0x00d1:
            java.util.List r7 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):java.util.List");
    }

    private final List<TypeProjection> computeRawTypeArguments(JavaClassifierType javaClassifierType, List<? extends TypeParameterDescriptor> list, TypeConstructor typeConstructor, JavaTypeAttributes javaTypeAttributes) {
        TypeProjection typeProjection;
        JavaTypeAttributes javaTypeAttributes2;
        Iterable<TypeParameterDescriptor> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
            if (TypeUtilsKt.hasTypeParameterRecursiveBounds(typeParameterDescriptor, (TypeConstructor) null, javaTypeAttributes.getVisitedTypeParameters())) {
                typeProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            } else {
                LazyWrappedType lazyWrappedType = new LazyWrappedType(this.f24652c.getStorageManager(), new JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(this, typeParameterDescriptor, javaClassifierType, javaTypeAttributes, typeConstructor));
                RawSubstitution rawSubstitution2 = this.rawSubstitution;
                if (javaClassifierType.isRaw()) {
                    javaTypeAttributes2 = javaTypeAttributes;
                } else {
                    javaTypeAttributes2 = javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
                }
                typeProjection = rawSubstitution2.computeProjection(typeParameterDescriptor, javaTypeAttributes2, lazyWrappedType);
            }
            arrayList.add(typeProjection);
        }
        return arrayList;
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        TypeAttributes typeAttributes;
        if (simpleType == null || (typeAttributes = simpleType.getAttributes()) == null) {
            typeAttributes = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.f24652c, javaClassifierType, false, 4, (DefaultConstructorMarker) null));
        }
        TypeAttributes typeAttributes2 = typeAttributes;
        TypeConstructor computeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        TypeConstructor typeConstructor = null;
        if (computeTypeConstructor == null) {
            return null;
        }
        boolean isNullable = isNullable(javaTypeAttributes);
        if (simpleType != null) {
            typeConstructor = simpleType.getConstructor();
        }
        if (!Intrinsics.areEqual((Object) typeConstructor, (Object) computeTypeConstructor) || javaClassifierType.isRaw() || !isNullable) {
            return KotlinTypeFactory.simpleType$default(typeAttributes2, computeTypeConstructor, (List) computeArguments(javaClassifierType, javaTypeAttributes, computeTypeConstructor), isNullable, (KotlinTypeRefiner) null, 16, (Object) null);
        }
        return simpleType.makeNullableAsSpecified(true);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            FqName fqName = javaClass.getFqName();
            if (fqName != null) {
                ClassDescriptor mapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
                if (mapKotlinClass == null) {
                    mapKotlinClass = this.f24652c.getComponents().getModuleClassResolver().resolveClass(javaClass);
                }
                if (mapKotlinClass == null || (typeConstructor = mapKotlinClass.getTypeConstructor()) == null) {
                    return createNotFoundClass(javaClassifierType);
                }
                return typeConstructor;
            }
            throw new AssertionError("Class type should have a FQ name: " + classifier);
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter != null) {
                return resolveTypeParameter.getTypeConstructor();
            }
            return null;
        } else {
            throw new IllegalStateException("Unknown classifier kind: " + classifier);
        }
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor typeConstructor = this.f24652c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt__CollectionsJVMKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "c.components.deserialize…istOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final boolean isConflictingArgumentFor(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) {
            return false;
        }
        return true;
    }

    private final boolean isNullable(JavaTypeAttributes javaTypeAttributes) {
        if (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return false;
        }
        return true;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        if (javaTypeAttributes.isForAnnotationParameter() && Intrinsics.areEqual((Object) fqName, (Object) JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME)) {
            return this.f24652c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.f24652c.getModule().getBuiltIns(), (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            return null;
        }
        if (!javaToKotlinClassMapper.isReadOnly(mapJavaToKotlin$default) || (javaTypeAttributes.getFlexibility() != JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND && javaTypeAttributes.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE && !argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, mapJavaToKotlin$default))) {
            return mapJavaToKotlin$default;
        }
        return javaToKotlinClassMapper.convertReadOnlyToMutable(mapJavaToKotlin$default);
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z11);
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        boolean z11;
        if (javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            z11 = false;
        } else {
            z11 = true;
        }
        boolean isRaw = javaClassifierType.isRaw();
        if (isRaw || z11) {
            SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), (SimpleType) null);
            if (computeSimpleJavaClassifierType == null) {
                return transformJavaClassifierType$errorType(javaClassifierType);
            }
            SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType);
            if (computeSimpleJavaClassifierType2 == null) {
                return transformJavaClassifierType$errorType(javaClassifierType);
            }
            if (isRaw) {
                return new RawTypeImpl(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
            }
            return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
        }
        SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, (SimpleType) null);
        if (computeSimpleJavaClassifierType3 != null) {
            return computeSimpleJavaClassifierType3;
        }
        return transformJavaClassifierType$errorType(javaClassifierType);
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType javaClassifierType) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, javaClassifierType.getPresentableText());
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        Variance variance;
        if (!(javaType instanceof JavaWildcardType)) {
            return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
        }
        JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
        JavaType bound = javaWildcardType.getBound();
        if (javaWildcardType.isExtends()) {
            variance = Variance.OUT_VARIANCE;
        } else {
            variance = Variance.IN_VARIANCE;
        }
        if (bound == null || isConflictingArgumentFor(variance, typeParameterDescriptor)) {
            return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
        }
        return TypeUtilsKt.createProjection(transformJavaType(bound, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null)), variance, typeParameterDescriptor);
    }

    @NotNull
    public final KotlinType transformArrayType(@NotNull JavaArrayType javaArrayType, @NotNull JavaTypeAttributes javaTypeAttributes, boolean z11) {
        JavaPrimitiveType javaPrimitiveType;
        PrimitiveType primitiveType;
        Variance variance;
        Intrinsics.checkNotNullParameter(javaArrayType, "arrayType");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        JavaType componentType = javaArrayType.getComponentType();
        if (componentType instanceof JavaPrimitiveType) {
            javaPrimitiveType = (JavaPrimitiveType) componentType;
        } else {
            javaPrimitiveType = null;
        }
        if (javaPrimitiveType != null) {
            primitiveType = javaPrimitiveType.getType();
        } else {
            primitiveType = null;
        }
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.f24652c, javaArrayType, true);
        if (primitiveType != null) {
            SimpleType primitiveArrayKotlinType = this.f24652c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(primitiveType);
            Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            TypeUtilsKt.replaceAnnotations(primitiveArrayKotlinType, Annotations.Companion.create(CollectionsKt___CollectionsKt.plus(lazyJavaAnnotations, (LazyJavaAnnotations) primitiveArrayKotlinType.getAnnotations())));
            if (javaTypeAttributes.isForAnnotationParameter()) {
                return primitiveArrayKotlinType;
            }
            return KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
        }
        KotlinType transformJavaType = transformJavaType(componentType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaTypeAttributes.isForAnnotationParameter(), (TypeParameterDescriptor) null, 2, (Object) null));
        if (javaTypeAttributes.isForAnnotationParameter()) {
            if (z11) {
                variance = Variance.OUT_VARIANCE;
            } else {
                variance = Variance.INVARIANT;
            }
            SimpleType arrayType = this.f24652c.getModule().getBuiltIns().getArrayType(variance, transformJavaType, lazyJavaAnnotations);
            Intrinsics.checkNotNullExpressionValue(arrayType, "c.module.builtIns.getArr…mponentType, annotations)");
            return arrayType;
        }
        SimpleType arrayType2 = this.f24652c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, transformJavaType, lazyJavaAnnotations);
        Intrinsics.checkNotNullExpressionValue(arrayType2, "c.module.builtIns.getArr…mponentType, annotations)");
        return KotlinTypeFactory.flexibleType(arrayType2, this.f24652c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, transformJavaType, lazyJavaAnnotations).makeNullableAsSpecified(true));
    }

    @NotNull
    public final KotlinType transformJavaType(@Nullable JavaType javaType, @NotNull JavaTypeAttributes javaTypeAttributes) {
        KotlinType transformJavaType;
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                simpleType = this.f24652c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                simpleType = this.f24652c.getModule().getBuiltIns().getUnitType();
            }
            Intrinsics.checkNotNullExpressionValue(simpleType, "{\n                val pr…ns.unitType\n            }");
            return simpleType;
        } else if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, javaTypeAttributes);
        } else {
            if (javaType instanceof JavaArrayType) {
                return transformArrayType$default(this, (JavaArrayType) javaType, javaTypeAttributes, false, 4, (Object) null);
            } else if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                if (bound != null && (transformJavaType = transformJavaType(bound, javaTypeAttributes)) != null) {
                    return transformJavaType;
                }
                SimpleType defaultBound = this.f24652c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound, "c.module.builtIns.defaultBound");
                return defaultBound;
            } else if (javaType == null) {
                SimpleType defaultBound2 = this.f24652c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound2, "c.module.builtIns.defaultBound");
                return defaultBound2;
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + javaType);
            }
        }
    }
}
