package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OperatorChecks$checks$1 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$1 INSTANCE = new OperatorChecks$checks$1();

    public OperatorChecks$checks$1() {
        super(1);
    }

    @Nullable
    public final String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "$this$$receiver");
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.lastOrNull(valueParameters);
        boolean z11 = false;
        if (valueParameterDescriptor != null) {
            if (!DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null) {
                z11 = true;
            }
        }
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        if (!z11) {
            return "last parameter should not have a default value or be a vararg";
        }
        return null;
    }
}
