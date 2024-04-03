package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MethodSignatureMappingKt {
    private static final void appendErasedType(StringBuilder sb2, KotlinType kotlinType) {
        sb2.append(mapToJvmType(kotlinType));
    }

    @NotNull
    public static final String computeJvmDescriptor(@NotNull FunctionDescriptor functionDescriptor, boolean z11, boolean z12) {
        String str;
        Intrinsics.checkNotNullParameter(functionDescriptor, "<this>");
        StringBuilder sb2 = new StringBuilder();
        if (z12) {
            if (functionDescriptor instanceof ConstructorDescriptor) {
                str = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            } else {
                str = functionDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(str, "name.asString()");
            }
            sb2.append(str);
        }
        sb2.append("(");
        ReceiverParameterDescriptor extensionReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "it.type");
            appendErasedType(sb2, type);
        }
        for (ValueParameterDescriptor type2 : functionDescriptor.getValueParameters()) {
            KotlinType type3 = type2.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "parameter.type");
            appendErasedType(sb2, type3);
        }
        sb2.append(")");
        if (z11) {
            if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType(functionDescriptor)) {
                sb2.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else {
                KotlinType returnType = functionDescriptor.getReturnType();
                Intrinsics.checkNotNull(returnType);
                appendErasedType(sb2, returnType);
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor functionDescriptor, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        return computeJvmDescriptor(functionDescriptor, z11, z12);
    }

    @Nullable
    public static final String computeJvmSignature(@NotNull CallableDescriptor callableDescriptor) {
        ClassDescriptor classDescriptor;
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        if (containingDeclaration instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) containingDeclaration;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor == null || classDescriptor.getName().isSpecial()) {
            return null;
        }
        CallableDescriptor original = callableDescriptor.getOriginal();
        if (original instanceof SimpleFunctionDescriptor) {
            simpleFunctionDescriptor = (SimpleFunctionDescriptor) original;
        } else {
            simpleFunctionDescriptor = null;
        }
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, classDescriptor, computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, (Object) null));
    }

    public static final boolean forceSingleValueParameterBoxing(@NotNull CallableDescriptor callableDescriptor) {
        JvmType.Primitive primitive;
        FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava;
        Intrinsics.checkNotNullParameter(callableDescriptor, "f");
        if (!(callableDescriptor instanceof FunctionDescriptor)) {
            return false;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
        if (!Intrinsics.areEqual((Object) functionDescriptor.getName().asString(), (Object) ProductAction.ACTION_REMOVE) || functionDescriptor.getValueParameters().size() != 1 || SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) callableDescriptor)) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "f.original.valueParameters");
        KotlinType type = ((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single(valueParameters)).getType();
        Intrinsics.checkNotNullExpressionValue(type, "f.original.valueParameters.single().type");
        JvmType mapToJvmType = mapToJvmType(type);
        JvmPrimitiveType jvmPrimitiveType = null;
        if (mapToJvmType instanceof JvmType.Primitive) {
            primitive = (JvmType.Primitive) mapToJvmType;
        } else {
            primitive = null;
        }
        if (primitive != null) {
            jvmPrimitiveType = primitive.getJvmPrimitiveType();
        }
        if (jvmPrimitiveType != JvmPrimitiveType.INT || (overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(functionDescriptor)) == null) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "overridden.original.valueParameters");
        KotlinType type2 = ((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single(valueParameters2)).getType();
        Intrinsics.checkNotNullExpressionValue(type2, "overridden.original.valueParameters.single().type");
        JvmType mapToJvmType2 = mapToJvmType(type2);
        DeclarationDescriptor containingDeclaration = overriddenBuiltinFunctionWithErasedValueParametersInJava.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "overridden.containingDeclaration");
        if (!Intrinsics.areEqual((Object) DescriptorUtilsKt.getFqNameUnsafe(containingDeclaration), (Object) StandardNames.FqNames.mutableCollection.toUnsafe()) || !(mapToJvmType2 instanceof JvmType.Object) || !Intrinsics.areEqual((Object) ((JvmType.Object) mapToJvmType2).getInternalName(), (Object) TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME)) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String getInternalName(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = DescriptorUtilsKt.getFqNameSafe(classDescriptor).toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "fqNameSafe.toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava == null) {
            return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default(classDescriptor, (TypeMappingConfiguration) null, 2, (Object) null);
        }
        String internalName = JvmClassName.byClassId(mapKotlinToJava).getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "byClassId(it).internalName");
        return internalName;
    }

    @NotNull
    public static final JvmType mapToJvmType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return (JvmType) DescriptorBasedTypeSignatureMappingKt.mapType$default(kotlinType, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, (JvmDescriptorTypeWriter) null, (Function3) null, 32, (Object) null);
    }
}
