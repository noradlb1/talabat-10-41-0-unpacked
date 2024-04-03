package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public final class ULongValue extends UnsignedValueConstant<Long> {
    public ULongValue(long j11) {
        super(Long.valueOf(j11));
    }

    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, StandardNames.FqNames.uLong);
        if (findClassAcrossModuleDependencies != null) {
            simpleType = findClassAcrossModuleDependencies.getDefaultType();
        } else {
            simpleType = null;
        }
        if (simpleType == null) {
            return ErrorUtils.createErrorType(ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, "ULong");
        }
        return simpleType;
    }

    @NotNull
    public String toString() {
        return ((Number) getValue()).longValue() + ".toULong()";
    }
}
