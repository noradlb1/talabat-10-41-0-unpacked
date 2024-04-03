package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OperatorChecks$checks$3 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$3 INSTANCE = new OperatorChecks$checks$3();

    public OperatorChecks$checks$3() {
        super(1);
    }

    @Nullable
    public final String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(functionDescriptor, "$this$$receiver");
        ReceiverParameterDescriptor dispatchReceiverParameter = functionDescriptor.getDispatchReceiverParameter();
        if (dispatchReceiverParameter == null) {
            dispatchReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        }
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        boolean z12 = false;
        if (dispatchReceiverParameter != null) {
            KotlinType returnType = functionDescriptor.getReturnType();
            if (returnType != null) {
                KotlinType type = dispatchReceiverParameter.getType();
                Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
                z11 = TypeUtilsKt.isSubtypeOf(returnType, type);
            } else {
                z11 = false;
            }
            if (z11 || operatorChecks.incDecCheckForExpectClass(functionDescriptor, dispatchReceiverParameter)) {
                z12 = true;
            }
        }
        if (!z12) {
            return "receiver must be a supertype of the return type";
        }
        return null;
    }
}
