package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaToKotlinClassMapper {
    @NotNull
    public static final JavaToKotlinClassMapper INSTANCE = new JavaToKotlinClassMapper();

    private JavaToKotlinClassMapper() {
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper javaToKotlinClassMapper, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            num = null;
        }
        return javaToKotlinClassMapper.mapJavaToKotlin(fqName, kotlinBuiltIns, num);
    }

    @NotNull
    public final ClassDescriptor convertMutableToReadOnly(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, AnalyticsAttribute.MUTABLE);
        FqName mutableToReadOnly = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(DescriptorUtils.getFqName(classDescriptor));
        if (mutableToReadOnly != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(mutableToReadOnly);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a " + AnalyticsAttribute.MUTABLE + " collection");
    }

    @NotNull
    public final ClassDescriptor convertReadOnlyToMutable(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "readOnly");
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqName(classDescriptor));
        if (readOnlyToMutable != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(readOnlyToMutable);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a " + "read-only" + " collection");
    }

    public final boolean isMutable(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, AnalyticsAttribute.MUTABLE);
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(classDescriptor));
    }

    public final boolean isReadOnly(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(classDescriptor));
    }

    @Nullable
    public final ClassDescriptor mapJavaToKotlin(@NotNull FqName fqName, @NotNull KotlinBuiltIns kotlinBuiltIns, @Nullable Integer num) {
        ClassId classId;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (num == null || !Intrinsics.areEqual((Object) fqName, (Object) JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
            classId = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName);
        } else {
            classId = StandardNames.getFunctionClassId(num.intValue());
        }
        if (classId != null) {
            return kotlinBuiltIns.getBuiltInClassByFqName(classId.asSingleFqName());
        }
        return null;
    }

    @NotNull
    public final Collection<ClassDescriptor> mapPlatformClass(@NotNull FqName fqName, @NotNull KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        ClassDescriptor mapJavaToKotlin$default = mapJavaToKotlin$default(this, fqName, kotlinBuiltIns, (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            return SetsKt__SetsKt.emptySet();
        }
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(mapJavaToKotlin$default));
        if (readOnlyToMutable == null) {
            return SetsKt__SetsJVMKt.setOf(mapJavaToKotlin$default);
        }
        ClassDescriptor builtInClassByFqName = kotlinBuiltIns.getBuiltInClassByFqName(readOnlyToMutable);
        Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return CollectionsKt__CollectionsKt.listOf(mapJavaToKotlin$default, builtInClassByFqName);
    }
}
