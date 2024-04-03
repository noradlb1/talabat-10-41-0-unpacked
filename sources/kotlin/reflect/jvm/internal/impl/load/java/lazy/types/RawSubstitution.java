package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RawSubstitution extends TypeSubstitution {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final JavaTypeAttributes lowerTypeAttr;
    @NotNull
    private static final JavaTypeAttributes upperTypeAttr;
    @NotNull
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        lowerTypeAttr = JavaTypeResolverKt.toAttributes$default(typeUsage, false, (TypeParameterDescriptor) null, 3, (Object) null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        upperTypeAttr = JavaTypeResolverKt.toAttributes$default(typeUsage, false, (TypeParameterDescriptor) null, 3, (Object) null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    public RawSubstitution() {
        this((TypeParameterUpperBoundEraser) null, 1, (DefaultConstructorMarker) null);
    }

    public RawSubstitution(@Nullable TypeParameterUpperBoundEraser typeParameterUpperBoundEraser2) {
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser2 == null ? new TypeParameterUpperBoundEraser(this) : typeParameterUpperBoundEraser2;
    }

    public static /* synthetic */ KotlinType a(RawSubstitution rawSubstitution, KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            javaTypeAttributes = new JavaTypeAttributes(TypeUsage.COMMON, (JavaTypeFlexibility) null, false, (Set) null, (SimpleType) null, 30, (DefaultConstructorMarker) null);
        }
        return rawSubstitution.eraseType(kotlinType, javaTypeAttributes);
    }

    public static /* synthetic */ TypeProjection computeProjection$default(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            kotlinType = rawSubstitution.typeParameterUpperBoundEraser.getErasedUpperBound$descriptors_jvm(typeParameterDescriptor, true, javaTypeAttributes);
            Intrinsics.checkNotNullExpressionValue(kotlinType, "typeParameterUpperBoundE…eter, isRaw = true, attr)");
        }
        return rawSubstitution.computeProjection(typeParameterDescriptor, javaTypeAttributes, kotlinType);
    }

    /* access modifiers changed from: private */
    public final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(SimpleType simpleType, ClassDescriptor classDescriptor, JavaTypeAttributes javaTypeAttributes) {
        if (simpleType.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.to(simpleType, Boolean.FALSE);
        }
        if (KotlinBuiltIns.isArray(simpleType)) {
            TypeProjection typeProjection = simpleType.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "componentTypeProjection.type");
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(simpleType.getAttributes(), simpleType.getConstructor(), CollectionsKt__CollectionsJVMKt.listOf(new TypeProjectionImpl(projectionKind, eraseType(type, javaTypeAttributes))), simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null), Boolean.FALSE);
        } else if (KotlinTypeKt.isError(simpleType)) {
            return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, simpleType.getConstructor().toString()), Boolean.FALSE);
        } else {
            MemberScope memberScope = classDescriptor.getMemberScope(this);
            Intrinsics.checkNotNullExpressionValue(memberScope, "declaration.getMemberScope(this)");
            TypeAttributes attributes = simpleType.getAttributes();
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "declaration.typeConstructor");
            List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "declaration.typeConstructor.parameters");
            Iterable<TypeParameterDescriptor> iterable = parameters;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
                arrayList.add(computeProjection$default(this, typeParameterDescriptor, javaTypeAttributes, (KotlinType) null, 4, (Object) null));
            }
            return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, typeConstructor, arrayList, simpleType.isMarkedNullable(), memberScope, new RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(classDescriptor, this, simpleType, javaTypeAttributes)), Boolean.TRUE);
        }
    }

    private final KotlinType eraseType(KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            KotlinType erasedUpperBound$descriptors_jvm = this.typeParameterUpperBoundEraser.getErasedUpperBound$descriptors_jvm((TypeParameterDescriptor) declarationDescriptor, true, javaTypeAttributes);
            Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "typeParameterUpperBoundE…tion, isRaw = true, attr)");
            return eraseType(erasedUpperBound$descriptors_jvm, javaTypeAttributes);
        } else if (declarationDescriptor instanceof ClassDescriptor) {
            ClassifierDescriptor declarationDescriptor2 = FlexibleTypesKt.upperIfFlexible(kotlinType).getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor2 instanceof ClassDescriptor) {
                Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(kotlinType), (ClassDescriptor) declarationDescriptor, lowerTypeAttr);
                SimpleType component1 = eraseInflexibleBasedOnClassDescriptor.component1();
                boolean booleanValue = eraseInflexibleBasedOnClassDescriptor.component2().booleanValue();
                Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(kotlinType), (ClassDescriptor) declarationDescriptor2, upperTypeAttr);
                SimpleType component12 = eraseInflexibleBasedOnClassDescriptor2.component1();
                boolean booleanValue2 = eraseInflexibleBasedOnClassDescriptor2.component2().booleanValue();
                if (booleanValue || booleanValue2) {
                    return new RawTypeImpl(component1, component12);
                }
                return KotlinTypeFactory.flexibleType(component1, component12);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + '\"').toString());
        } else {
            throw new IllegalStateException(("Unexpected declaration kind: " + declarationDescriptor).toString());
        }
    }

    @NotNull
    public final TypeProjection computeProjection(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull JavaTypeAttributes javaTypeAttributes, @NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "parameter");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        Intrinsics.checkNotNullParameter(kotlinType, "erasedUpperBound");
        int i11 = WhenMappings.$EnumSwitchMapping$0[javaTypeAttributes.getFlexibility().ordinal()];
        if (i11 == 1) {
            return new TypeProjectionImpl(Variance.INVARIANT, kotlinType);
        }
        if (i11 != 2 && i11 != 3) {
            throw new NoWhenBranchMatchedException();
        } else if (!typeParameterDescriptor.getVariance().getAllowsOutPosition()) {
            return new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType());
        } else {
            List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "erasedUpperBound.constructor.parameters");
            if (!parameters.isEmpty()) {
                return new TypeProjectionImpl(Variance.OUT_VARIANCE, kotlinType);
            }
            return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
        }
    }

    public boolean isEmpty() {
        return false;
    }

    @NotNull
    public TypeProjectionImpl get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        return new TypeProjectionImpl(a(this, kotlinType, (JavaTypeAttributes) null, 2, (Object) null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : typeParameterUpperBoundEraser2);
    }
}
