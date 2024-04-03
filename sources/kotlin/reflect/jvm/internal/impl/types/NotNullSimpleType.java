package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;

final class NotNullSimpleType extends DelegatingSimpleTypeImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotNullSimpleType(@NotNull SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
    }

    public boolean isMarkedNullable() {
        return false;
    }

    @NotNull
    public NotNullSimpleType replaceDelegate(@NotNull SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        return new NotNullSimpleType(simpleType);
    }
}
