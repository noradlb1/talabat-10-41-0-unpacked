package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class CompanionObjectMappingUtilsKt {
    public static final boolean isMappedIntrinsicCompanionObject(@NotNull CompanionObjectMapping companionObjectMapping, @NotNull ClassDescriptor classDescriptor) {
        ClassId classId;
        Intrinsics.checkNotNullParameter(companionObjectMapping, "<this>");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            Set<ClassId> classIds = companionObjectMapping.getClassIds();
            ClassId classId2 = DescriptorUtilsKt.getClassId(classDescriptor);
            if (classId2 != null) {
                classId = classId2.getOuterClassId();
            } else {
                classId = null;
            }
            if (CollectionsKt___CollectionsKt.contains(classIds, classId)) {
                return true;
            }
        }
        return false;
    }
}
