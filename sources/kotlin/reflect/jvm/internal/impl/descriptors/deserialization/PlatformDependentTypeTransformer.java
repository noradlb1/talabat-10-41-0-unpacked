package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public interface PlatformDependentTypeTransformer {

    public static final class None implements PlatformDependentTypeTransformer {
        @NotNull
        public static final None INSTANCE = new None();

        private None() {
        }

        @NotNull
        public SimpleType transformPlatformType(@NotNull ClassId classId, @NotNull SimpleType simpleType) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(simpleType, "computedType");
            return simpleType;
        }
    }

    @NotNull
    SimpleType transformPlatformType(@NotNull ClassId classId, @NotNull SimpleType simpleType);
}
