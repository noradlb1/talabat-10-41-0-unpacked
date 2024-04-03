package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public final class EnumValue extends ConstantValue<Pair<? extends ClassId, ? extends Name>> {
    @NotNull
    private final ClassId enumClassId;
    @NotNull
    private final Name enumEntryName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumValue(@NotNull ClassId classId, @NotNull Name name2) {
        super(TuplesKt.to(classId, name2));
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name2, "enumEntryName");
        this.enumClassId = classId;
        this.enumEntryName = name2;
    }

    @NotNull
    public final Name getEnumEntryName() {
        return this.enumEntryName;
    }

    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, this.enumClassId);
        SimpleType simpleType = null;
        if (findClassAcrossModuleDependencies != null) {
            if (!DescriptorUtils.isEnumClass(findClassAcrossModuleDependencies)) {
                findClassAcrossModuleDependencies = null;
            }
            if (findClassAcrossModuleDependencies != null) {
                simpleType = findClassAcrossModuleDependencies.getDefaultType();
            }
        }
        if (simpleType != null) {
            return simpleType;
        }
        ErrorTypeKind errorTypeKind = ErrorTypeKind.ERROR_ENUM_TYPE;
        String classId = this.enumClassId.toString();
        Intrinsics.checkNotNullExpressionValue(classId, "enumClassId.toString()");
        String name2 = this.enumEntryName.toString();
        Intrinsics.checkNotNullExpressionValue(name2, "enumEntryName.toString()");
        return ErrorUtils.createErrorType(errorTypeKind, classId, name2);
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.enumClassId.getShortClassName());
        sb2.append('.');
        sb2.append(this.enumEntryName);
        return sb2.toString();
    }
}
