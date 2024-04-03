package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {
    public static final CallableDescriptor.UserDataKey<Boolean> HAS_ERASED_VALUE_PARAMETERS = new CallableDescriptor.UserDataKey<Boolean>() {
    };
    public static final CallableDescriptor.UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new CallableDescriptor.UserDataKey<ValueParameterDescriptor>() {
    };
    private final boolean isForRecordComponent;
    private ParameterNamesStatus parameterNamesStatus;

    public enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean isStable;
        public final boolean isSynthesized;

        private ParameterNamesStatus(boolean z11, boolean z12) {
            this.isStable = z11;
            this.isSynthesized = z12;
        }

        @NotNull
        public static ParameterNamesStatus get(boolean z11, boolean z12) {
            ParameterNamesStatus parameterNamesStatus = z11 ? z12 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z12 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (parameterNamesStatus == null) {
                $$$reportNull$$$0(0);
            }
            return parameterNamesStatus;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 13 || i11 == 18 || i11 == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 13 || i11 == 18 || i11 == 21) ? 2 : 3)];
        switch (i11) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 15:
                objArr[0] = FWFConstants.EXPLANATION_TYPE_KIND;
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = "source";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i11 == 13) {
            objArr[1] = "initialize";
        } else if (i11 == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i11 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i11) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 21:
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String format = String.format(str, objArr);
        throw ((i11 == 13 || i11 == 18 || i11 == 21) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaMethodDescriptor(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable SimpleFunctionDescriptor simpleFunctionDescriptor, @NotNull Annotations annotations, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z11) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations, name2, kind, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name2 == null) {
            $$$reportNull$$$0(2);
        }
        if (kind == null) {
            $$$reportNull$$$0(3);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(4);
        }
        this.parameterNamesStatus = null;
        this.isForRecordComponent = z11;
    }

    @NotNull
    public static JavaMethodDescriptor createJavaMethod(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Name name2, @NotNull SourceElement sourceElement, boolean z11) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(5);
        }
        if (annotations == null) {
            $$$reportNull$$$0(6);
        }
        if (name2 == null) {
            $$$reportNull$$$0(7);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(8);
        }
        return new JavaMethodDescriptor(declarationDescriptor, (SimpleFunctionDescriptor) null, annotations, name2, CallableMemberDescriptor.Kind.DECLARATION, sourceElement, z11);
    }

    @NotNull
    /* renamed from: d */
    public JavaMethodDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name2, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(14);
        }
        if (kind == null) {
            $$$reportNull$$$0(15);
        }
        if (annotations == null) {
            $$$reportNull$$$0(16);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(17);
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name2 == null) {
            name2 = getName();
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations, name2, kind, sourceElement, this.isForRecordComponent);
        javaMethodDescriptor.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return javaMethodDescriptor;
    }

    public boolean hasStableParameterNames() {
        return this.parameterNamesStatus.isStable;
    }

    public boolean hasSynthesizedParameterNames() {
        return this.parameterNamesStatus.isSynthesized;
    }

    @NotNull
    public SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<ReceiverParameterDescriptor> list, @NotNull List<? extends TypeParameterDescriptor> list2, @NotNull List<ValueParameterDescriptor> list3, @Nullable KotlinType kotlinType, @Nullable Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @Nullable Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        if (list == null) {
            $$$reportNull$$$0(9);
        }
        if (list2 == null) {
            $$$reportNull$$$0(10);
        }
        if (list3 == null) {
            $$$reportNull$$$0(11);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(12);
        }
        SimpleFunctionDescriptorImpl initialize = super.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, list3, kotlinType, modality, descriptorVisibility, map);
        setOperator(OperatorChecks.INSTANCE.check(initialize).isSuccess());
        if (initialize == null) {
            $$$reportNull$$$0(13);
        }
        return initialize;
    }

    public void setParameterNamesStatus(boolean z11, boolean z12) {
        this.parameterNamesStatus = ParameterNamesStatus.get(z11, z12);
    }

    @NotNull
    public JavaMethodDescriptor enhance(@Nullable KotlinType kotlinType, @NotNull List<KotlinType> list, @NotNull KotlinType kotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(20);
        }
        List<ValueParameterDescriptor> copyValueParameters = UtilKt.copyValueParameters(list, getValueParameters(), this);
        if (kotlinType == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(this, kotlinType, Annotations.Companion.getEMPTY());
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(copyValueParameters).setReturnType(kotlinType2).setExtensionReceiverParameter(receiverParameterDescriptor).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (pair != null) {
            javaMethodDescriptor.putInUserDataMap(pair.getFirst(), pair.getSecond());
        }
        if (javaMethodDescriptor == null) {
            $$$reportNull$$$0(21);
        }
        return javaMethodDescriptor;
    }
}
