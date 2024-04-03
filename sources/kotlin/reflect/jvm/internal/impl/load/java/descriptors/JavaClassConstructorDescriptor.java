package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import net.bytebuddy.description.method.MethodDescription;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {
    private Boolean hasStableParameterNames;
    private Boolean hasSynthesizedParameterNames;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 11 || i11 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 11 || i11 == 18) ? 2 : 3)];
        switch (i11) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = FWFConstants.EXPLANATION_TYPE_KIND;
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i11 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i11 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i11) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String format = String.format(str, objArr);
        throw ((i11 == 11 || i11 == 18) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaClassConstructorDescriptor(@NotNull ClassDescriptor classDescriptor, @Nullable JavaClassConstructorDescriptor javaClassConstructorDescriptor, @NotNull Annotations annotations, boolean z11, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        super(classDescriptor, javaClassConstructorDescriptor, annotations, z11, kind, sourceElement);
        if (classDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (kind == null) {
            $$$reportNull$$$0(2);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(3);
        }
        this.hasStableParameterNames = null;
        this.hasSynthesizedParameterNames = null;
    }

    @NotNull
    public static JavaClassConstructorDescriptor createJavaConstructor(@NotNull ClassDescriptor classDescriptor, @NotNull Annotations annotations, boolean z11, @NotNull SourceElement sourceElement) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        if (annotations == null) {
            $$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        return new JavaClassConstructorDescriptor(classDescriptor, (JavaClassConstructorDescriptor) null, annotations, z11, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
    }

    @NotNull
    public JavaClassConstructorDescriptor d(@NotNull ClassDescriptor classDescriptor, @Nullable JavaClassConstructorDescriptor javaClassConstructorDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, @NotNull Annotations annotations) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(12);
        }
        if (kind == null) {
            $$$reportNull$$$0(13);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(14);
        }
        if (annotations == null) {
            $$$reportNull$$$0(15);
        }
        return new JavaClassConstructorDescriptor(classDescriptor, javaClassConstructorDescriptor, annotations, this.f24512d, kind, sourceElement);
    }

    @NotNull
    /* renamed from: e */
    public JavaClassConstructorDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name2, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (kind == null) {
            $$$reportNull$$$0(8);
        }
        if (annotations == null) {
            $$$reportNull$$$0(9);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(10);
        }
        if (kind == CallableMemberDescriptor.Kind.DECLARATION || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            JavaClassConstructorDescriptor d11 = d((ClassDescriptor) declarationDescriptor, (JavaClassConstructorDescriptor) functionDescriptor, kind, sourceElement, annotations);
            d11.setHasStableParameterNames(hasStableParameterNames());
            d11.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
            return d11;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + StringUtils.LF + "newOwner: " + declarationDescriptor + StringUtils.LF + "kind: " + kind);
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames.booleanValue();
    }

    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames.booleanValue();
    }

    public void setHasStableParameterNames(boolean z11) {
        this.hasStableParameterNames = Boolean.valueOf(z11);
    }

    public void setHasSynthesizedParameterNames(boolean z11) {
        this.hasSynthesizedParameterNames = Boolean.valueOf(z11);
    }

    @NotNull
    public JavaClassConstructorDescriptor enhance(@Nullable KotlinType kotlinType, @NotNull List<KotlinType> list, @NotNull KotlinType kotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType kotlinType3 = kotlinType;
        if (list == null) {
            $$$reportNull$$$0(16);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(17);
        }
        JavaClassConstructorDescriptor e11 = createSubstitutedCopy(getContainingDeclaration(), (FunctionDescriptor) null, getKind(), (Name) null, getAnnotations(), getSource());
        if (kotlinType3 == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(e11, kotlinType, Annotations.Companion.getEMPTY());
        }
        e11.initialize(receiverParameterDescriptor, getDispatchReceiverParameter(), CollectionsKt__CollectionsKt.emptyList(), getTypeParameters(), UtilKt.copyValueParameters(list, getValueParameters(), e11), kotlinType2, getModality(), getVisibility());
        if (pair != null) {
            e11.putInUserDataMap(pair.getFirst(), pair.getSecond());
        }
        return e11;
    }
}
