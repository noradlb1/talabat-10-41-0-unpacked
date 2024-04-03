package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeEnhancement {
    @NotNull
    private final JavaResolverSettings javaResolverSettings;

    public static final class Result {
        private final int subtreeSize;
        @Nullable
        private final KotlinType type;

        public Result(@Nullable KotlinType kotlinType, int i11) {
            this.type = kotlinType;
            this.subtreeSize = i11;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        @Nullable
        public final KotlinType getType() {
            return this.type;
        }
    }

    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        @Nullable
        private final SimpleType type;

        public SimpleResult(@Nullable SimpleType simpleType, int i11, boolean z11) {
            this.type = simpleType;
            this.subtreeSize = i11;
            this.forWarnings = z11;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        @Nullable
        public final SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(@NotNull JavaResolverSettings javaResolverSettings2) {
        Intrinsics.checkNotNullParameter(javaResolverSettings2, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings2;
    }

    public static /* synthetic */ SimpleResult a(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i11, TypeComponentPosition typeComponentPosition, boolean z11, boolean z12, int i12, Object obj) {
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i11, typeComponentPosition, (i12 & 8) != 0 ? false : z11, (i12 & 16) != 0 ? false : z12);
    }

    private final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i11, TypeComponentPosition typeComponentPosition, boolean z11, boolean z12) {
        boolean z13;
        TypeConstructor typeConstructor;
        boolean z14;
        boolean z15;
        EnhancedTypeAnnotations enhancedTypeAnnotations;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        Result result;
        TypeProjection typeProjection;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        TypeComponentPosition typeComponentPosition2 = typeComponentPosition;
        boolean z22 = z12;
        boolean shouldEnhance = TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        if (!z22 || !z11) {
            z13 = true;
        } else {
            z13 = false;
        }
        KotlinType kotlinType = null;
        if (!shouldEnhance && simpleType.getArguments().isEmpty()) {
            return new SimpleResult((SimpleType) null, 1, false);
        }
        ClassifierDescriptor declarationDescriptor = simpleType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new SimpleResult((SimpleType) null, 1, false);
        }
        JavaTypeQualifiers invoke = function12.invoke(Integer.valueOf(i11));
        ClassifierDescriptor access$enhanceMutability = TypeEnhancementKt.enhanceMutability(declarationDescriptor, invoke, typeComponentPosition2);
        Boolean access$getEnhancedNullability = TypeEnhancementKt.getEnhancedNullability(invoke, typeComponentPosition2);
        if (access$enhanceMutability == null || (typeConstructor = access$enhanceMutability.getTypeConstructor()) == null) {
            typeConstructor = simpleType.getConstructor();
        }
        TypeConstructor typeConstructor2 = typeConstructor;
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "enhancedClassifier?.typeConstructor ?: constructor");
        int i12 = i11 + 1;
        Iterable arguments = simpleType.getArguments();
        List<TypeParameterDescriptor> parameters = typeConstructor2.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        Iterable iterable = parameters;
        Iterator it = arguments.iterator();
        Iterator it2 = iterable.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it2.next();
            TypeProjection typeProjection2 = (TypeProjection) next;
            if (!z13) {
                z21 = z13;
                result = new Result(kotlinType, 0);
            } else {
                z21 = z13;
                if (!typeProjection2.isStarProjection()) {
                    result = enhancePossiblyFlexible(typeProjection2.getType().unwrap(), function12, i12, z22);
                } else if (function12.invoke(Integer.valueOf(i12)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                    UnwrappedType unwrap = typeProjection2.getType().unwrap();
                    result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(unwrap).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(unwrap).makeNullableAsSpecified(true)), 1);
                } else {
                    result = new Result((KotlinType) null, 1);
                }
            }
            i12 += result.getSubtreeSize();
            if (result.getType() != null) {
                KotlinType type = result.getType();
                Variance projectionKind = typeProjection2.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
            } else if (access$enhanceMutability != null && !typeProjection2.isStarProjection()) {
                KotlinType type2 = typeProjection2.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "arg.type");
                Variance projectionKind2 = typeProjection2.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
            } else if (access$enhanceMutability != null) {
                typeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            } else {
                typeProjection = null;
            }
            arrayList.add(typeProjection);
            function12 = function1;
            z13 = z21;
            kotlinType = null;
        }
        int i13 = i12 - i11;
        if (access$enhanceMutability == null && access$getEnhancedNullability == null) {
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (((TypeProjection) it3.next()) == null) {
                        z19 = true;
                        continue;
                    } else {
                        z19 = false;
                        continue;
                    }
                    if (!z19) {
                        z18 = false;
                        break;
                    }
                }
            }
            z18 = true;
            if (z18) {
                return new SimpleResult((SimpleType) null, i13, false);
            }
        }
        Annotations[] annotationsArr = new Annotations[3];
        annotationsArr[0] = simpleType.getAnnotations();
        EnhancedTypeAnnotations access$getENHANCED_MUTABILITY_ANNOTATIONS$p = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
        if (access$enhanceMutability != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (!z14) {
            access$getENHANCED_MUTABILITY_ANNOTATIONS$p = null;
        }
        annotationsArr[1] = access$getENHANCED_MUTABILITY_ANNOTATIONS$p;
        EnhancedTypeAnnotations access$getENHANCED_NULLABILITY_ANNOTATIONS$p = TypeEnhancementKt.ENHANCED_NULLABILITY_ANNOTATIONS;
        if (access$getEnhancedNullability != null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            enhancedTypeAnnotations = access$getENHANCED_NULLABILITY_ANNOTATIONS$p;
        } else {
            enhancedTypeAnnotations = null;
        }
        annotationsArr[2] = enhancedTypeAnnotations;
        TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt__CollectionsKt.listOfNotNull((T[]) annotationsArr)));
        Iterable arguments2 = simpleType.getArguments();
        Iterator it4 = arrayList.iterator();
        Iterator it5 = arguments2.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments2, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            TypeProjection typeProjection3 = (TypeProjection) it5.next();
            TypeProjection typeProjection4 = (TypeProjection) next2;
            if (typeProjection4 != null) {
                typeProjection3 = typeProjection4;
            }
            arrayList2.add(typeProjection3);
        }
        if (access$getEnhancedNullability != null) {
            z16 = access$getEnhancedNullability.booleanValue();
        } else {
            z16 = simpleType.isMarkedNullable();
        }
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor2, (List) arrayList2, z16, (KotlinTypeRefiner) null, 16, (Object) null);
        if (invoke.getDefinitelyNotNull()) {
            simpleType$default = notNullTypeParameter(simpleType$default);
        }
        if (access$getEnhancedNullability == null || !invoke.isNullabilityQualifierForWarning()) {
            z17 = false;
        } else {
            z17 = true;
        }
        return new SimpleResult(simpleType$default, i13, z17);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
        if (r13 == null) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r13, int r14, boolean r15) {
        /*
            r11 = this;
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r12)
            r1 = 0
            if (r0 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r13 = 1
            r12.<init>(r1, r13)
            return r12
        L_0x000e:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            if (r0 == 0) goto L_0x00ad
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.RawType
            r9 = r12
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r9 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r9
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getLowerBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r2 = r11
            r4 = r13
            r5 = r14
            r7 = r0
            r8 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r10 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getUpperBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r13 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            r10.getSubtreeSize()
            r13.getSubtreeSize()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L_0x0043
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r13.getType()
            if (r14 != 0) goto L_0x0043
            goto L_0x00a3
        L_0x0043:
            boolean r14 = r10.getForWarnings()
            if (r14 != 0) goto L_0x0085
            boolean r14 = r13.getForWarnings()
            if (r14 == 0) goto L_0x0050
            goto L_0x0085
        L_0x0050:
            if (r0 == 0) goto L_0x006c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.getType()
            if (r12 != 0) goto L_0x005e
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r9.getLowerBound()
        L_0x005e:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 != 0) goto L_0x0068
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.getUpperBound()
        L_0x0068:
            r1.<init>(r12, r13)
            goto L_0x00a3
        L_0x006c:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.getType()
            if (r12 != 0) goto L_0x0076
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r9.getLowerBound()
        L_0x0076:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 != 0) goto L_0x0080
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.getUpperBound()
        L_0x0080:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r12, r13)
            goto L_0x00a3
        L_0x0085:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 == 0) goto L_0x0098
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L_0x0092
            r14 = r13
        L_0x0092:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r13 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r14, r13)
            if (r13 != 0) goto L_0x009f
        L_0x0098:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r10.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
        L_0x009f:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r13)
        L_0x00a3:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            int r13 = r10.getSubtreeSize()
            r12.<init>(r1, r13)
            goto L_0x00df
        L_0x00ad:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto L_0x00e0
            r2 = r12
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r6 = 0
            r8 = 8
            r9 = 0
            r1 = r11
            r3 = r13
            r4 = r14
            r7 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r13 = a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r14 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            boolean r15 = r13.getForWarnings()
            if (r15 == 0) goto L_0x00d3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = r13.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r15)
            goto L_0x00d7
        L_0x00d3:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r13.getType()
        L_0x00d7:
            int r13 = r13.getSubtreeSize()
            r14.<init>(r12, r13)
            r12 = r14
        L_0x00df:
            return r12
        L_0x00e0:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.jvm.functions.Function1, int, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result");
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameterImpl(simpleType);
    }

    @Nullable
    public final KotlinType enhance(@NotNull KotlinType kotlinType, @NotNull Function1<? super Integer, JavaTypeQualifiers> function1, boolean z11) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), function1, 0, z11).getType();
    }
}
