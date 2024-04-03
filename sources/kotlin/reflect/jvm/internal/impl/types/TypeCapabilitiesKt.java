package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeCapabilitiesKt {
    @Nullable
    public static final CustomTypeParameter getCustomTypeParameter(@NotNull KotlinType kotlinType) {
        CustomTypeParameter customTypeParameter;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof CustomTypeParameter) {
            customTypeParameter = (CustomTypeParameter) unwrap;
        } else {
            customTypeParameter = null;
        }
        if (customTypeParameter == null || !customTypeParameter.isTypeParameter()) {
            return null;
        }
        return customTypeParameter;
    }

    public static final boolean isCustomTypeParameter(@NotNull KotlinType kotlinType) {
        CustomTypeParameter customTypeParameter;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof CustomTypeParameter) {
            customTypeParameter = (CustomTypeParameter) unwrap;
        } else {
            customTypeParameter = null;
        }
        if (customTypeParameter != null) {
            return customTypeParameter.isTypeParameter();
        }
        return false;
    }
}
