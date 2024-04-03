package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    private final DeclarationDescriptor containingDeclaration;
    private ReceiverValue value;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 3 || i11 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 3 || i11 == 4) ? 2 : 3)];
        switch (i11) {
            case 1:
                objArr[0] = "value";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            case 6:
                objArr[0] = "outType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i11 == 3) {
            objArr[1] = "getValue";
        } else if (i11 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (!(i11 == 3 || i11 == 4)) {
            if (i11 == 5) {
                objArr[2] = "copy";
            } else if (i11 != 6) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            } else {
                objArr[2] = "setOutType";
            }
        }
        String format = String.format(str, objArr);
        throw ((i11 == 3 || i11 == 4) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiverParameterDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull ReceiverValue receiverValue, @NotNull Annotations annotations) {
        super(annotations);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (receiverValue == null) {
            $$$reportNull$$$0(1);
        }
        if (annotations == null) {
            $$$reportNull$$$0(2);
        }
        this.containingDeclaration = declarationDescriptor;
        this.value = receiverValue;
    }

    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        return declarationDescriptor;
    }

    @NotNull
    public ReceiverValue getValue() {
        ReceiverValue receiverValue = this.value;
        if (receiverValue == null) {
            $$$reportNull$$$0(3);
        }
        return receiverValue;
    }
}
