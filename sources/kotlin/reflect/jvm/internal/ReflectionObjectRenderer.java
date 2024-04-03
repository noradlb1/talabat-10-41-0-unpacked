package kotlin.reflect.jvm.internal;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u001c\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ReflectionObjectRenderer {
    @NotNull
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
    @NotNull
    private static final DescriptorRenderer renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
            iArr[KParameter.Kind.INSTANCE.ordinal()] = 2;
            iArr[KParameter.Kind.VALUE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ReflectionObjectRenderer() {
    }

    private final void appendReceiverType(StringBuilder sb2, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            KotlinType type = receiverParameterDescriptor.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            sb2.append(renderType(type));
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        }
    }

    private final void appendReceivers(StringBuilder sb2, CallableDescriptor callableDescriptor) {
        boolean z11;
        ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        appendReceiverType(sb2, instanceReceiverParameter);
        if (instanceReceiverParameter == null || extensionReceiverParameter == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            sb2.append("(");
        }
        appendReceiverType(sb2, extensionReceiverParameter);
        if (z11) {
            sb2.append(")");
        }
    }

    private final String renderCallable(CallableDescriptor callableDescriptor) {
        if (callableDescriptor instanceof PropertyDescriptor) {
            return renderProperty((PropertyDescriptor) callableDescriptor);
        }
        if (callableDescriptor instanceof FunctionDescriptor) {
            return renderFunction((FunctionDescriptor) callableDescriptor);
        }
        throw new IllegalStateException(("Illegal callable: " + callableDescriptor).toString());
    }

    @NotNull
    public final String renderFunction(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb2, functionDescriptor);
        DescriptorRenderer descriptorRenderer = renderer;
        Name name2 = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
        sb2.append(descriptorRenderer.renderName(name2, true));
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
        Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(valueParameters, sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "(", ")", 0, (CharSequence) null, ReflectionObjectRenderer$renderFunction$1$1.INSTANCE, 48, (Object) null);
        sb2.append(": ");
        KotlinType returnType = functionDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        sb2.append(reflectionObjectRenderer.renderType(returnType));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public final String renderLambda(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "invoke");
        StringBuilder sb2 = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb2, functionDescriptor);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "invoke.valueParameters");
        Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(valueParameters, sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "(", ")", 0, (CharSequence) null, ReflectionObjectRenderer$renderLambda$1$1.INSTANCE, 48, (Object) null);
        sb2.append(" -> ");
        KotlinType returnType = functionDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        sb2.append(reflectionObjectRenderer.renderType(returnType));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public final String renderParameter(@NotNull KParameterImpl kParameterImpl) {
        Intrinsics.checkNotNullParameter(kParameterImpl, "parameter");
        StringBuilder sb2 = new StringBuilder();
        int i11 = WhenMappings.$EnumSwitchMapping$0[kParameterImpl.getKind().ordinal()];
        if (i11 == 1) {
            sb2.append("extension receiver parameter");
        } else if (i11 == 2) {
            sb2.append("instance parameter");
        } else if (i11 == 3) {
            sb2.append("parameter #" + kParameterImpl.getIndex() + ' ' + kParameterImpl.getName());
        }
        sb2.append(" of ");
        sb2.append(INSTANCE.renderCallable(kParameterImpl.getCallable().getDescriptor()));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public final String renderProperty(@NotNull PropertyDescriptor propertyDescriptor) {
        String str;
        Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        if (propertyDescriptor.isVar()) {
            str = "var ";
        } else {
            str = "val ";
        }
        sb2.append(str);
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendReceivers(sb2, propertyDescriptor);
        DescriptorRenderer descriptorRenderer = renderer;
        Name name2 = propertyDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
        sb2.append(descriptorRenderer.renderName(name2, true));
        sb2.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "descriptor.type");
        sb2.append(reflectionObjectRenderer.renderType(type));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public final String renderType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return renderer.renderType(kotlinType);
    }
}
