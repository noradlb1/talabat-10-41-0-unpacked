package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorUtilsKt {
    @NotNull
    private static final Name RETENTION_PARAMETER_NAME;

    static {
        Name identifier = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"value\")");
        RETENTION_PARAMETER_NAME = identifier;
    }

    public static final boolean declaresOrInheritsDefaultValue(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics.checkNotNullParameter(valueParameterDescriptor, "<this>");
        Boolean ifAny = DFS.ifAny(CollectionsKt__CollectionsJVMKt.listOf(valueParameterDescriptor), DescriptorUtilsKt$declaresOrInheritsDefaultValue$1.INSTANCE, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(ifAny, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return ifAny.booleanValue();
    }

    @Nullable
    public static final CallableMemberDescriptor firstOverridden(@NotNull CallableMemberDescriptor callableMemberDescriptor, boolean z11, @NotNull Function1<? super CallableMemberDescriptor, Boolean> function1) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt__CollectionsJVMKt.listOf(callableMemberDescriptor), new DescriptorUtilsKt$firstOverridden$1(z11), new DescriptorUtilsKt$firstOverridden$2(new Ref.ObjectRef(), function1));
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return firstOverridden(callableMemberDescriptor, z11, function1);
    }

    @Nullable
    public static final FqName fqNameOrNull(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FqNameUnsafe fqNameUnsafe = getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe != null) {
            return fqNameUnsafe.toSafe();
        }
        return null;
    }

    @Nullable
    public static final ClassDescriptor getAnnotationClass(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassifierDescriptor declarationDescriptor = annotationDescriptor.getType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @NotNull
    public static final KotlinBuiltIns getBuiltIns(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return getModule(declarationDescriptor).getBuiltIns();
    }

    @Nullable
    public static final ClassId getClassId(@Nullable ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        ClassId classId;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new ClassId(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (classId = getClassId((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(classifierDescriptor.getName());
    }

    @NotNull
    public static final FqName getFqNameSafe(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FqName fqNameSafe = DescriptorUtils.getFqNameSafe(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(this)");
        return fqNameSafe;
    }

    @NotNull
    public static final FqNameUnsafe getFqNameUnsafe(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FqNameUnsafe fqName = DescriptorUtils.getFqName(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(this)");
        return fqName;
    }

    @Nullable
    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(@Nullable ClassDescriptor classDescriptor) {
        ValueClassRepresentation valueClassRepresentation = classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null;
        if (valueClassRepresentation instanceof InlineClassRepresentation) {
            return (InlineClassRepresentation) valueClassRepresentation;
        }
        return null;
    }

    @NotNull
    public static final KotlinTypeRefiner getKotlinTypeRefiner(@NotNull ModuleDescriptor moduleDescriptor) {
        TypeRefinementSupport typeRefinementSupport;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref ref = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (ref != null) {
            typeRefinementSupport = (TypeRefinementSupport) ref.getValue();
        } else {
            typeRefinementSupport = null;
        }
        if (typeRefinementSupport instanceof TypeRefinementSupport.Enabled) {
            return ((TypeRefinementSupport.Enabled) typeRefinementSupport).getTypeRefiner();
        }
        return KotlinTypeRefiner.Default.INSTANCE;
    }

    @NotNull
    public static final ModuleDescriptor getModule(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        ModuleDescriptor containingModule = DescriptorUtils.getContainingModule(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(containingModule, "getContainingModule(this)");
        return containingModule;
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> getParents(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return SequencesKt___SequencesKt.drop(getParentsWithSelf(declarationDescriptor), 1);
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return SequencesKt__SequencesKt.generateSequence(declarationDescriptor, DescriptorUtilsKt$parentsWithSelf$1.INSTANCE);
    }

    @NotNull
    public static final CallableMemberDescriptor getPropertyIfAccessor(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        Intrinsics.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    @Nullable
    public static final ClassDescriptor getSuperClassNotAny(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        for (KotlinType next : classDescriptor.getDefaultType().getConstructor().getSupertypes()) {
            if (!KotlinBuiltIns.isAnyOrNullableAny(next)) {
                ClassifierDescriptor declarationDescriptor = next.getConstructor().getDeclarationDescriptor();
                if (DescriptorUtils.isClassOrEnumClass(declarationDescriptor)) {
                    Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean isTypeRefinementEnabled(@NotNull ModuleDescriptor moduleDescriptor) {
        TypeRefinementSupport typeRefinementSupport;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref ref = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (ref == null || (typeRefinementSupport = (TypeRefinementSupport) ref.getValue()) == null || !typeRefinementSupport.isEnabled()) {
            return false;
        }
        return true;
    }

    @Nullable
    public static final ClassDescriptor resolveTopLevelClass(@NotNull ModuleDescriptor moduleDescriptor, @NotNull FqName fqName, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        fqName.isRoot();
        FqName parent = fqName.parent();
        Intrinsics.checkNotNullExpressionValue(parent, "topLevelClassFqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(parent).getMemberScope();
        Name shortName = fqName.shortName();
        Intrinsics.checkNotNullExpressionValue(shortName, "topLevelClassFqName.shortName()");
        ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(shortName, lookupLocation);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }
}
