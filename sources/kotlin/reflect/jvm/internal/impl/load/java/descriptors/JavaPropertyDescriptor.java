package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaPropertyDescriptor extends PropertyDescriptorImpl implements JavaCallableMemberDescriptor {
    private KotlinType inType;
    private final boolean isStaticFinal;
    @Nullable
    private final Pair<CallableDescriptor.UserDataKey<?>, ?> singleUserData;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = i11 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i11 != 21 ? 3 : 2)];
        switch (i11) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = FWFConstants.EXPLANATION_TYPE_KIND;
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i11 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i11) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String format = String.format(str, objArr);
        throw (i11 != 21 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaPropertyDescriptor(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, boolean z11, @NotNull Name name2, @NotNull SourceElement sourceElement, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, boolean z12, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        super(declarationDescriptor, propertyDescriptor, annotations, modality, descriptorVisibility, z11, name2, kind, sourceElement, false, false, false, false, false, false);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (modality == null) {
            $$$reportNull$$$0(2);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(3);
        }
        if (name2 == null) {
            $$$reportNull$$$0(4);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        if (kind == null) {
            $$$reportNull$$$0(6);
        }
        this.inType = null;
        this.isStaticFinal = z12;
        this.singleUserData = pair;
    }

    @NotNull
    public static JavaPropertyDescriptor create(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, boolean z11, @NotNull Name name2, @NotNull SourceElement sourceElement, boolean z12) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (annotations == null) {
            $$$reportNull$$$0(8);
        }
        if (modality == null) {
            $$$reportNull$$$0(9);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(10);
        }
        if (name2 == null) {
            $$$reportNull$$$0(11);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(12);
        }
        return new JavaPropertyDescriptor(declarationDescriptor, annotations, modality, descriptorVisibility, z11, name2, sourceElement, (PropertyDescriptor) null, CallableMemberDescriptor.Kind.DECLARATION, z12, (Pair<CallableDescriptor.UserDataKey<?>, ?>) null);
    }

    @NotNull
    public PropertyDescriptorImpl b(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull Name name2, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (modality == null) {
            $$$reportNull$$$0(14);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(15);
        }
        if (kind == null) {
            $$$reportNull$$$0(16);
        }
        if (name2 == null) {
            $$$reportNull$$$0(17);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(18);
        }
        return new JavaPropertyDescriptor(declarationDescriptor, getAnnotations(), modality, descriptorVisibility, isVar(), name2, sourceElement, propertyDescriptor, kind, this.isStaticFinal, this.singleUserData);
    }

    @NotNull
    public JavaCallableMemberDescriptor enhance(@Nullable KotlinType kotlinType, @NotNull List<KotlinType> list, @NotNull KotlinType kotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        PropertyDescriptor propertyDescriptor;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        PropertySetterDescriptor propertySetterDescriptor;
        PropertyGetterDescriptor propertyGetterDescriptor;
        KotlinType kotlinType3 = kotlinType;
        KotlinType kotlinType4 = kotlinType2;
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        if (kotlinType4 == null) {
            $$$reportNull$$$0(20);
        }
        if (getOriginal() == this) {
            propertyDescriptor = null;
        } else {
            propertyDescriptor = getOriginal();
        }
        JavaPropertyDescriptor javaPropertyDescriptor = r5;
        JavaPropertyDescriptor javaPropertyDescriptor2 = new JavaPropertyDescriptor(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), propertyDescriptor, getKind(), this.isStaticFinal, pair);
        PropertyGetterDescriptorImpl getter = getGetter();
        if (getter != null) {
            Annotations annotations = getter.getAnnotations();
            Modality modality = getter.getModality();
            DescriptorVisibility visibility = getter.getVisibility();
            boolean isDefault = getter.isDefault();
            boolean isExternal = getter.isExternal();
            boolean isInline = getter.isInline();
            CallableMemberDescriptor.Kind kind = getKind();
            if (propertyDescriptor == null) {
                propertyGetterDescriptor = null;
            } else {
                propertyGetterDescriptor = propertyDescriptor.getGetter();
            }
            propertyGetterDescriptorImpl = r5;
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = new PropertyGetterDescriptorImpl(javaPropertyDescriptor, annotations, modality, visibility, isDefault, isExternal, isInline, kind, propertyGetterDescriptor, getter.getSource());
            propertyGetterDescriptorImpl.setInitialSignatureDescriptor(getter.getInitialSignatureDescriptor());
            propertyGetterDescriptorImpl.initialize(kotlinType4);
        } else {
            propertyGetterDescriptorImpl = null;
        }
        PropertySetterDescriptor setter = getSetter();
        if (setter != null) {
            Annotations annotations2 = setter.getAnnotations();
            Modality modality2 = setter.getModality();
            DescriptorVisibility visibility2 = setter.getVisibility();
            boolean isDefault2 = setter.isDefault();
            boolean isExternal2 = setter.isExternal();
            boolean isInline2 = setter.isInline();
            CallableMemberDescriptor.Kind kind2 = getKind();
            if (propertyDescriptor == null) {
                propertySetterDescriptor = null;
            } else {
                propertySetterDescriptor = propertyDescriptor.getSetter();
            }
            PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = r5;
            PropertySetterDescriptorImpl propertySetterDescriptorImpl3 = new PropertySetterDescriptorImpl(javaPropertyDescriptor, annotations2, modality2, visibility2, isDefault2, isExternal2, isInline2, kind2, propertySetterDescriptor, setter.getSource());
            PropertySetterDescriptorImpl propertySetterDescriptorImpl4 = propertySetterDescriptorImpl2;
            propertySetterDescriptorImpl4.setInitialSignatureDescriptor(propertySetterDescriptorImpl2.getInitialSignatureDescriptor());
            propertySetterDescriptorImpl4.initialize(setter.getValueParameters().get(0));
            propertySetterDescriptorImpl = propertySetterDescriptorImpl4;
        } else {
            propertySetterDescriptorImpl = null;
        }
        JavaPropertyDescriptor javaPropertyDescriptor3 = javaPropertyDescriptor;
        javaPropertyDescriptor3.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, getBackingField(), getDelegateField());
        javaPropertyDescriptor3.setSetterProjectedOut(isSetterProjectedOut());
        Function0<NullableLazyValue<ConstantValue<?>>> function0 = this.f24562e;
        if (function0 != null) {
            javaPropertyDescriptor3.setCompileTimeInitializer(this.f24561d, function0);
        }
        javaPropertyDescriptor3.setOverriddenDescriptors(getOverriddenDescriptors());
        if (kotlinType3 == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(this, kotlinType3, Annotations.Companion.getEMPTY());
        }
        javaPropertyDescriptor3.setType(kotlinType2, getTypeParameters(), getDispatchReceiverParameter(), receiverParameterDescriptor, CollectionsKt__CollectionsKt.emptyList());
        return javaPropertyDescriptor3;
    }

    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Pair<CallableDescriptor.UserDataKey<?>, ?> pair = this.singleUserData;
        if (pair == null || !pair.getFirst().equals(userDataKey)) {
            return null;
        }
        return this.singleUserData.getSecond();
    }

    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    public boolean isConst() {
        KotlinType type = getType();
        if (!this.isStaticFinal || !ConstUtil.canBeUsedForConstVal(type) || (TypeEnhancementKt.hasEnhancedNullability(type) && !KotlinBuiltIns.isString(type))) {
            return false;
        }
        return true;
    }

    public void setInType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(22);
        }
        this.inType = kotlinType;
    }
}
