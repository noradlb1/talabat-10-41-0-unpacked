package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeResolverKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final FqName JAVA_LANG_CLASS_FQ_NAME = new FqName("java.lang.Class");

    @NotNull
    public static final TypeProjection makeStarProjection(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull JavaTypeAttributes javaTypeAttributes) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        if (javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(typeParameterDescriptor));
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    @NotNull
    public static final JavaTypeAttributes toAttributes(@NotNull TypeUsage typeUsage, boolean z11, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Set set;
        Intrinsics.checkNotNullParameter(typeUsage, "<this>");
        if (typeParameterDescriptor != null) {
            set = SetsKt__SetsJVMKt.setOf(typeParameterDescriptor);
        } else {
            set = null;
        }
        return new JavaTypeAttributes(typeUsage, (JavaTypeFlexibility) null, z11, set, (SimpleType) null, 18, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean z11, TypeParameterDescriptor typeParameterDescriptor, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            typeParameterDescriptor = null;
        }
        return toAttributes(typeUsage, z11, typeParameterDescriptor);
    }
}
