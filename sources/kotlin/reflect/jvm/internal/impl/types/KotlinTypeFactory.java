package kotlin.reflect.jvm.internal.impl.types;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.tekartik.sqflite.Constant;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinTypeFactory {
    @NotNull
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;
    @NotNull
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();

    public static final class ExpandedTypeOrRefinedConstructor {
        @Nullable
        private final SimpleType expandedType;
        @Nullable
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(@Nullable SimpleType simpleType, @Nullable TypeConstructor typeConstructor) {
            this.expandedType = simpleType;
            this.refinedConstructor = typeConstructor;
        }

        @Nullable
        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        @Nullable
        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    private KotlinTypeFactory() {
    }

    @JvmStatic
    @NotNull
    public static final SimpleType computeExpandedType(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create((TypeAliasExpansion) null, typeAliasDescriptor, list), TypeAttributes.Companion.getEmpty());
    }

    private final MemberScope computeMemberScope(TypeConstructor typeConstructor, List<? extends TypeProjection> list, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return ((TypeParameterDescriptor) declarationDescriptor).getDefaultType().getMemberScope();
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            if (kotlinTypeRefiner == null) {
                kotlinTypeRefiner = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(declarationDescriptor));
            }
            if (list.isEmpty()) {
                return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor, kotlinTypeRefiner);
            }
            return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor, TypeConstructorSubstitution.Companion.create(typeConstructor, list), kotlinTypeRefiner);
        } else if (declarationDescriptor instanceof TypeAliasDescriptor) {
            ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE;
            String name2 = ((TypeAliasDescriptor) declarationDescriptor).getName().toString();
            Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name.toString()");
            return ErrorUtils.createErrorScope(errorScopeKind, true, name2);
        } else if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
        } else {
            throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor + " for constructor: " + typeConstructor);
        }
    }

    @JvmStatic
    @NotNull
    public static final UnwrappedType flexibleType(@NotNull SimpleType simpleType, @NotNull SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        if (Intrinsics.areEqual((Object) simpleType, (Object) simpleType2)) {
            return simpleType;
        }
        return new FlexibleTypeImpl(simpleType, simpleType2);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType integerLiteralType(@NotNull TypeAttributes typeAttributes, @NotNull IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z11) {
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(integerLiteralTypeConstructor, "constructor");
        return simpleTypeWithNonTrivialMemberScope(typeAttributes, integerLiteralTypeConstructor, CollectionsKt__CollectionsKt.emptyList(), z11, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }

    /* access modifiers changed from: private */
    public final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor typeConstructor, KotlinTypeRefiner kotlinTypeRefiner, List<? extends TypeProjection> list) {
        ClassifierDescriptor refineDescriptor;
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor == null || (refineDescriptor = kotlinTypeRefiner.refineDescriptor(declarationDescriptor)) == null) {
            return null;
        }
        if (refineDescriptor instanceof TypeAliasDescriptor) {
            return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) refineDescriptor, list), (TypeConstructor) null);
        }
        TypeConstructor refine = refineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new ExpandedTypeOrRefinedConstructor((SimpleType) null, refine);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleNotNullType(@NotNull TypeAttributes typeAttributes, @NotNull ClassDescriptor classDescriptor, @NotNull List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(typeAttributes, typeConstructor, (List) list, false, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final SimpleType simpleType(@NotNull TypeAttributes typeAttributes, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z11, @Nullable KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        if (!typeAttributes.isEmpty() || !list.isEmpty() || z11 || typeConstructor.getDeclarationDescriptor() == null) {
            return simpleTypeWithNonTrivialMemberScope(typeAttributes, typeConstructor, list, z11, INSTANCE.computeMemberScope(typeConstructor, list, kotlinTypeRefiner), new KotlinTypeFactory$simpleType$1(typeConstructor, list, typeAttributes, z11));
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor);
        SimpleType defaultType = declarationDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
        return defaultType;
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List list, boolean z11, KotlinTypeRefiner kotlinTypeRefiner, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(typeAttributes, typeConstructor, (List<? extends TypeProjection>) list, z11, kotlinTypeRefiner);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull TypeAttributes typeAttributes, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z11, @NotNull MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        TypeConstructor typeConstructor2 = typeConstructor;
        List<? extends TypeProjection> list2 = list;
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(typeConstructor2, list2, z11, memberScope, new KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(typeConstructor2, list2, typeAttributes, z11, memberScope));
        return typeAttributes.isEmpty() ? simpleTypeImpl : new SimpleTypeWithAttributes(simpleTypeImpl, typeAttributes);
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType simpleType, TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<TypeProjection> list, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        if ((i11 & 4) != 0) {
            typeConstructor = simpleType.getConstructor();
        }
        if ((i11 & 8) != 0) {
            list = simpleType.getArguments();
        }
        if ((i11 & 16) != 0) {
            z11 = simpleType.isMarkedNullable();
        }
        return simpleType(simpleType, typeAttributes, typeConstructor, (List<? extends TypeProjection>) list, z11);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleType(@NotNull SimpleType simpleType, @NotNull TypeAttributes typeAttributes, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z11) {
        Intrinsics.checkNotNullParameter(simpleType, "baseType");
        Intrinsics.checkNotNullParameter(typeAttributes, "annotations");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        return simpleType$default(typeAttributes, typeConstructor, (List) list, z11, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull TypeAttributes typeAttributes, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z11, @NotNull MemberScope memberScope, @NotNull Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(typeConstructor, list, z11, memberScope, function1);
        return typeAttributes.isEmpty() ? simpleTypeImpl : new SimpleTypeWithAttributes(simpleTypeImpl, typeAttributes);
    }
}
