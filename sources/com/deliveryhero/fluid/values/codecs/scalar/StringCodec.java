package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/StringCodec;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "encoded", "encode", "decoded", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StringCodec implements ValueCodec.Scalar<String> {
    @NotNull
    public static final StringCodec INSTANCE = new StringCodec();
    @NotNull
    private static final ValueType valueType = ValueType.STRING;

    private StringCodec() {
    }

    @NotNull
    public String decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encoded");
        return str;
    }

    @NotNull
    public String encode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "decoded");
        return str;
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }
}
