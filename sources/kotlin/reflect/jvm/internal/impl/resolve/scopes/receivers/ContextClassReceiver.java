package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    @NotNull
    private final ClassDescriptor classDescriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextClassReceiver(@NotNull ClassDescriptor classDescriptor2, @NotNull KotlinType kotlinType, @Nullable ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        Intrinsics.checkNotNullParameter(classDescriptor2, "classDescriptor");
        Intrinsics.checkNotNullParameter(kotlinType, "receiverType");
        this.classDescriptor = classDescriptor2;
    }

    @NotNull
    public String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}
