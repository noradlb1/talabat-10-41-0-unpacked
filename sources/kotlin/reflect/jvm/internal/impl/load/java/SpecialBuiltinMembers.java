package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmName(name = "SpecialBuiltinMembers")
public final class SpecialBuiltinMembers {
    public static final boolean doesOverrideBuiltinWithDifferentJvmName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public static final String getJvmMethodNameIfSpecial(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor propertyIfAccessor;
        Name jvmName;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor overriddenBuiltinThatAffectsJvmName = getOverriddenBuiltinThatAffectsJvmName(callableMemberDescriptor);
        if (overriddenBuiltinThatAffectsJvmName == null || (propertyIfAccessor = DescriptorUtilsKt.getPropertyIfAccessor(overriddenBuiltinThatAffectsJvmName)) == null) {
            return null;
        }
        if (propertyIfAccessor instanceof PropertyDescriptor) {
            return ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyIfAccessor);
        }
        if (!(propertyIfAccessor instanceof SimpleFunctionDescriptor) || (jvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor) propertyIfAccessor)) == null) {
            return null;
        }
        return jvmName.asString();
    }

    private static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor callableMemberDescriptor) {
        if (KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor);
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(@NotNull T t11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(t11, "<this>");
        if (!SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(t11.getName()) && !BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(DescriptorUtilsKt.getPropertyIfAccessor(t11).getName())) {
            return null;
        }
        if (t11 instanceof PropertyDescriptor) {
            z11 = true;
        } else {
            z11 = t11 instanceof PropertyAccessorDescriptor;
        }
        if (z11) {
            return DescriptorUtilsKt.firstOverridden$default(t11, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1.INSTANCE, 1, (Object) null);
        }
        if (t11 instanceof SimpleFunctionDescriptor) {
            return DescriptorUtilsKt.firstOverridden$default(t11, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2.INSTANCE, 1, (Object) null);
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        T overriddenBuiltinWithDifferentJvmName = getOverriddenBuiltinWithDifferentJvmName(t11);
        if (overriddenBuiltinWithDifferentJvmName != null) {
            return overriddenBuiltinWithDifferentJvmName;
        }
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name2 = t11.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name2)) {
            return null;
        }
        return DescriptorUtilsKt.firstOverridden$default(t11, false, SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2.INSTANCE, 1, (Object) null);
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(@NotNull ClassDescriptor classDescriptor, @NotNull CallableDescriptor callableDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(callableDescriptor, "specialCallableDescriptor");
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        SimpleType defaultType = ((ClassDescriptor) containingDeclaration).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "specialCallableDescripto…ssDescriptor).defaultType");
        ClassDescriptor superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(classDescriptor);
        while (true) {
            boolean z11 = false;
            if (superClassDescriptor == null) {
                return false;
            }
            if (!(superClassDescriptor instanceof JavaClassDescriptor)) {
                if (TypeCheckingProcedure.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), defaultType) != null) {
                    z11 = true;
                }
                if (z11) {
                    return !KotlinBuiltIns.isBuiltIn(superClassDescriptor);
                }
            }
            superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(superClassDescriptor);
        }
    }

    public static final boolean isFromJava(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (isFromJava(callableMemberDescriptor) || KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return true;
        }
        return false;
    }
}
