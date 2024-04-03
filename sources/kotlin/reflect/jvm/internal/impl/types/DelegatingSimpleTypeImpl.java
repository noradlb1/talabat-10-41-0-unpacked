package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;

public abstract class DelegatingSimpleTypeImpl extends DelegatingSimpleType {
    @NotNull
    private final SimpleType delegate;

    public DelegatingSimpleTypeImpl(@NotNull SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = simpleType;
    }

    @NotNull
    public SimpleType getDelegate() {
        return this.delegate;
    }

    @NotNull
    public SimpleType makeNullableAsSpecified(boolean z11) {
        if (z11 == isMarkedNullable()) {
            return this;
        }
        return getDelegate().makeNullableAsSpecified(z11).replaceAttributes(getAttributes());
    }

    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return typeAttributes != getAttributes() ? new SimpleTypeWithAttributes(this, typeAttributes) : this;
    }
}
