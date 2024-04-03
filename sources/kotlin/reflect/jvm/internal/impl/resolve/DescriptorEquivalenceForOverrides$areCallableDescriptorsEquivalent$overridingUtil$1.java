package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1 implements KotlinTypeChecker.TypeConstructorEquality {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f24788a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallableDescriptor f24789b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallableDescriptor f24790c;

    public DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(boolean z11, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        this.f24788a = z11;
        this.f24789b = callableDescriptor;
        this.f24790c = callableDescriptor2;
    }

    public final boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
        Intrinsics.checkNotNullParameter(typeConstructor, "c1");
        Intrinsics.checkNotNullParameter(typeConstructor2, "c2");
        if (Intrinsics.areEqual((Object) typeConstructor, (Object) typeConstructor2)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        ClassifierDescriptor declarationDescriptor2 = typeConstructor2.getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor) || !(declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return false;
        }
        boolean z11 = this.f24788a;
        final CallableDescriptor callableDescriptor = this.f24789b;
        final CallableDescriptor callableDescriptor2 = this.f24790c;
        return DescriptorEquivalenceForOverrides.INSTANCE.areTypeParametersEquivalent((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z11, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() {
            @NotNull
            public final Boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
                return Boolean.valueOf(Intrinsics.areEqual((Object) declarationDescriptor, (Object) callableDescriptor) && Intrinsics.areEqual((Object) declarationDescriptor2, (Object) callableDescriptor2));
            }
        });
    }
}
