package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class VariableDescriptorImpl extends DeclarationDescriptorNonRootImpl implements VariableDescriptor {

    /* renamed from: b  reason: collision with root package name */
    public KotlinType f24560b;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str;
        int i12;
        Throwable th2;
        switch (i11) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i11) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i12 = 2;
                break;
            default:
                i12 = 3;
                break;
        }
        Object[] objArr = new Object[i12];
        switch (i11) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i11) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 10:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i11) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String format = String.format(str, objArr);
        switch (i11) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                th2 = new IllegalStateException(format);
                break;
            default:
                th2 = new IllegalArgumentException(format);
                break;
        }
        throw th2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VariableDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Name name2, @Nullable KotlinType kotlinType, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, name2, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name2 == null) {
            $$$reportNull$$$0(2);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(3);
        }
        this.f24560b = kotlinType;
    }

    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(9);
        }
        return emptyList;
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return null;
    }

    @NotNull
    public Collection<? extends CallableDescriptor> getOverriddenDescriptors() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            $$$reportNull$$$0(7);
        }
        return emptySet;
    }

    @NotNull
    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type == null) {
            $$$reportNull$$$0(10);
        }
        return type;
    }

    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.f24560b;
        if (kotlinType == null) {
            $$$reportNull$$$0(4);
        }
        return kotlinType;
    }

    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(8);
        }
        return emptyList;
    }

    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(6);
        }
        return emptyList;
    }

    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    public boolean isConst() {
        return false;
    }

    public void setOutType(KotlinType kotlinType) {
        this.f24560b = kotlinType;
    }

    @NotNull
    public VariableDescriptor getOriginal() {
        VariableDescriptor variableDescriptor = (VariableDescriptor) super.getOriginal();
        if (variableDescriptor == null) {
            $$$reportNull$$$0(5);
        }
        return variableDescriptor;
    }
}
