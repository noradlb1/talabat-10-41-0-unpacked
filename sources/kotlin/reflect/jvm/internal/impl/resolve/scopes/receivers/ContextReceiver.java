package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContextReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    @NotNull
    private final CallableDescriptor declarationDescriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextReceiver(@NotNull CallableDescriptor callableDescriptor, @NotNull KotlinType kotlinType, @Nullable ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        Intrinsics.checkNotNullParameter(callableDescriptor, "declarationDescriptor");
        Intrinsics.checkNotNullParameter(kotlinType, "receiverType");
        this.declarationDescriptor = callableDescriptor;
    }

    @NotNull
    public CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    @NotNull
    public String toString() {
        return "Cxt { " + getDeclarationDescriptor() + " }";
    }
}
