package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorEquivalenceForOverrides {
    @NotNull
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z11, boolean z12, boolean z13, KotlinTypeRefiner kotlinTypeRefiner, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z12 = true;
        }
        boolean z14 = z12;
        if ((i11 & 16) != 0) {
            z13 = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z11, z14, z13, kotlinTypeRefiner);
    }

    private final boolean areClassesEquivalent(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return Intrinsics.areEqual((Object) classDescriptor.getTypeConstructor(), (Object) classDescriptor2.getTypeConstructor());
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z12 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z11, z12);
    }

    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z11, Function2 function2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            function2 = DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1.INSTANCE;
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z11, function2);
    }

    private final boolean ownersEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean z11) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if ((containingDeclaration instanceof CallableMemberDescriptor) || (containingDeclaration2 instanceof CallableMemberDescriptor)) {
            return function2.invoke(containingDeclaration, containingDeclaration2).booleanValue();
        }
        return areEquivalent$default(this, containingDeclaration, containingDeclaration2, z11, false, 8, (Object) null);
    }

    private final SourceElement singleSource(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            callableDescriptor = (CallableMemberDescriptor) CollectionsKt___CollectionsKt.singleOrNull(overriddenDescriptors);
            if (callableDescriptor == null) {
                return null;
            }
        }
        return callableDescriptor.getSource();
    }

    public final boolean areCallableDescriptorsEquivalent(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, boolean z11, boolean z12, boolean z13, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "a");
        Intrinsics.checkNotNullParameter(callableDescriptor2, "b");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (Intrinsics.areEqual((Object) callableDescriptor, (Object) callableDescriptor2)) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) callableDescriptor.getName(), (Object) callableDescriptor2.getName())) {
            return false;
        }
        if (z12 && (callableDescriptor instanceof MemberDescriptor) && (callableDescriptor2 instanceof MemberDescriptor) && ((MemberDescriptor) callableDescriptor).isExpect() != ((MemberDescriptor) callableDescriptor2).isExpect()) {
            return false;
        }
        if ((Intrinsics.areEqual((Object) callableDescriptor.getContainingDeclaration(), (Object) callableDescriptor2.getContainingDeclaration()) && (!z11 || !Intrinsics.areEqual((Object) singleSource(callableDescriptor), (Object) singleSource(callableDescriptor2)))) || DescriptorUtils.isLocal(callableDescriptor) || DescriptorUtils.isLocal(callableDescriptor2) || !ownersEquivalent(callableDescriptor, callableDescriptor2, DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1.INSTANCE, z11)) {
            return false;
        }
        OverridingUtil create = OverridingUtil.create(kotlinTypeRefiner, new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(z11, callableDescriptor, callableDescriptor2));
        Intrinsics.checkNotNullExpressionValue(create, "a: CallableDescriptor,\n …= a && y == b }\n        }");
        OverridingUtil.OverrideCompatibilityInfo.Result result = create.isOverridableBy(callableDescriptor, callableDescriptor2, (ClassDescriptor) null, !z13).getResult();
        OverridingUtil.OverrideCompatibilityInfo.Result result2 = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (result == result2 && create.isOverridableBy(callableDescriptor2, callableDescriptor, (ClassDescriptor) null, !z13).getResult() == result2) {
            return true;
        }
        return false;
    }

    public final boolean areEquivalent(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2, boolean z11, boolean z12) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return areClassesEquivalent((ClassDescriptor) declarationDescriptor, (ClassDescriptor) declarationDescriptor2);
        }
        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z11, (Function2) null, 8, (Object) null);
        } else if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z11, z12, false, KotlinTypeRefiner.Default.INSTANCE, 16, (Object) null);
        } else if (!(declarationDescriptor instanceof PackageFragmentDescriptor) || !(declarationDescriptor2 instanceof PackageFragmentDescriptor)) {
            return Intrinsics.areEqual((Object) declarationDescriptor, (Object) declarationDescriptor2);
        } else {
            return Intrinsics.areEqual((Object) ((PackageFragmentDescriptor) declarationDescriptor).getFqName(), (Object) ((PackageFragmentDescriptor) declarationDescriptor2).getFqName());
        }
    }

    @JvmOverloads
    public final boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeParameterDescriptor typeParameterDescriptor2, boolean z11) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "a");
        Intrinsics.checkNotNullParameter(typeParameterDescriptor2, "b");
        return areTypeParametersEquivalent$default(this, typeParameterDescriptor, typeParameterDescriptor2, z11, (Function2) null, 8, (Object) null);
    }

    @JvmOverloads
    public final boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeParameterDescriptor typeParameterDescriptor2, boolean z11, @NotNull Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "a");
        Intrinsics.checkNotNullParameter(typeParameterDescriptor2, "b");
        Intrinsics.checkNotNullParameter(function2, "equivalentCallables");
        if (Intrinsics.areEqual((Object) typeParameterDescriptor, (Object) typeParameterDescriptor2)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) typeParameterDescriptor.getContainingDeclaration(), (Object) typeParameterDescriptor2.getContainingDeclaration()) || !ownersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, function2, z11)) {
            return false;
        }
        if (typeParameterDescriptor.getIndex() == typeParameterDescriptor2.getIndex()) {
            return true;
        }
        return false;
    }
}
