package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/BooleanCodec;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "encoded", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "encode", "value", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BooleanCodec implements ValueCodec.Scalar<Boolean> {
    @NotNull
    public static final BooleanCodec INSTANCE = new BooleanCodec();
    @NotNull
    private static final ValueType valueType = ValueType.BOOLEAN;

    private BooleanCodec() {
    }

    public /* bridge */ /* synthetic */ Object encode(Object obj) {
        return encode(((Boolean) obj).booleanValue());
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public Boolean decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encoded");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return Boolean.valueOf(StringsKt__StringsKt.toBooleanStrict(lowerCase));
    }

    @NotNull
    public String encode(boolean z11) {
        return String.valueOf(z11);
    }
}
