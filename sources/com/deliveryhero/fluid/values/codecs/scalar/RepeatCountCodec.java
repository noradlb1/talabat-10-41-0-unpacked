package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import com.deliveryhero.fluid.widgets.lottie.RepeatCount;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/RepeatCountCodec;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount;", "()V", "INFINITE", "", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "encoded", "encode", "decoded", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RepeatCountCodec implements ValueCodec.Scalar<RepeatCount> {
    @NotNull
    public static final String INFINITE = "infinite";
    @NotNull
    public static final RepeatCountCodec INSTANCE = new RepeatCountCodec();
    @NotNull
    private static final ValueType valueType = ValueType.REPEAT_COUNT;

    private RepeatCountCodec() {
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public RepeatCount decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encoded");
        if (Intrinsics.areEqual((Object) str, (Object) INFINITE)) {
            return RepeatCount.Infinite.INSTANCE;
        }
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        return new RepeatCount.Finite(intOrNull != null ? intOrNull.intValue() : 0);
    }

    @NotNull
    public String encode(@NotNull RepeatCount repeatCount) {
        Intrinsics.checkNotNullParameter(repeatCount, "decoded");
        if (repeatCount instanceof RepeatCount.Infinite) {
            return INFINITE;
        }
        if (repeatCount instanceof RepeatCount.Finite) {
            return String.valueOf(((RepeatCount.Finite) repeatCount).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }
}
