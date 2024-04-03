package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {
    private final ClassDescriptor descriptor;
    private final ImplicitClassReceiver receiverValue;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 1 || i11 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 1 || i11 == 2) ? 2 : 3)];
        if (i11 == 1 || i11 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i11 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i11 == 1) {
            objArr[1] = "getValue";
        } else if (i11 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (!(i11 == 1 || i11 == 2)) {
            if (i11 != 3) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        throw ((i11 == 1 || i11 == 2) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyClassReceiverParameterDescriptor(@NotNull ClassDescriptor classDescriptor) {
        super(Annotations.Companion.getEMPTY());
        if (classDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        this.descriptor = classDescriptor;
        this.receiverValue = new ImplicitClassReceiver(classDescriptor, (ImplicitClassReceiver) null);
    }

    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = this.descriptor;
        if (classDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        return classDescriptor;
    }

    @NotNull
    public ReceiverValue getValue() {
        ImplicitClassReceiver implicitClassReceiver = this.receiverValue;
        if (implicitClassReceiver == null) {
            $$$reportNull$$$0(1);
        }
        return implicitClassReceiver;
    }

    public String toString() {
        return "class " + this.descriptor.getName() + "::this";
    }
}
