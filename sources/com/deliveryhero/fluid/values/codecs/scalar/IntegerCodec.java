package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/IntegerCodec;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "encoded", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "encode", "value", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegerCodec implements ValueCodec.Scalar<Integer> {
    @NotNull
    public static final IntegerCodec INSTANCE = new IntegerCodec();
    @NotNull
    private static final ValueType valueType = ValueType.INTEGER;

    private IntegerCodec() {
    }

    public /* bridge */ /* synthetic */ Object encode(Object obj) {
        return encode(((Number) obj).intValue());
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public Integer decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encoded");
        return Integer.valueOf(Integer.parseInt(str));
    }

    @NotNull
    public String encode(int i11) {
        return String.valueOf(i11);
    }
}
