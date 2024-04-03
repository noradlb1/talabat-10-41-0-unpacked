package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassicBuiltinSpecialProperties {
    @NotNull
    public static final ClassicBuiltinSpecialProperties INSTANCE = new ClassicBuiltinSpecialProperties();

    private ClassicBuiltinSpecialProperties() {
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(CallableMemberDescriptor callableMemberDescriptor) {
        if (CollectionsKt___CollectionsKt.contains(BuiltinSpecialProperties.INSTANCE.getSPECIAL_FQ_NAMES(), DescriptorUtilsKt.fqNameOrNull(callableMemberDescriptor)) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (!KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
        Iterable<CallableMemberDescriptor> iterable = overriddenDescriptors;
        if (!((Collection) iterable).isEmpty()) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : iterable) {
                ClassicBuiltinSpecialProperties classicBuiltinSpecialProperties = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(callableMemberDescriptor2, "it");
                if (classicBuiltinSpecialProperties.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final String getBuiltinSpecialPropertyGetterName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Name name2;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
        CallableMemberDescriptor firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor), false, ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1.INSTANCE, 1, (Object) null);
        if (firstOverridden$default == null || (name2 = BuiltinSpecialProperties.INSTANCE.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(DescriptorUtilsKt.getFqNameSafe(firstOverridden$default))) == null) {
            return null;
        }
        return name2.asString();
    }

    public final boolean hasBuiltinSpecialPropertyFqName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        if (!BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(callableMemberDescriptor.getName())) {
            return false;
        }
        return hasBuiltinSpecialPropertyFqNameImpl(callableMemberDescriptor);
    }
}
