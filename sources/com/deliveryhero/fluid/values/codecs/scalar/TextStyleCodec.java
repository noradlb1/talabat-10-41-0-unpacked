package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import com.deliveryhero.fluid.widgets.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/TextStyleCodec;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "Lcom/deliveryhero/fluid/widgets/text/TextStyle;", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "", "encoded", "", "encode", "decoded", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextStyleCodec implements ValueCodec.Scalar<TextStyle> {
    @NotNull
    public static final TextStyleCodec INSTANCE = new TextStyleCodec();
    @NotNull
    private static final ValueType valueType = ValueType.TEXT_STYLE;

    private TextStyleCodec() {
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public Void decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encoded");
        throw new UnsupportedOperationException("TextStyle literals are unsupported");
    }

    @NotNull
    public Void encode(@NotNull TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "decoded");
        throw new UnsupportedOperationException("TextStyle literals are unsupported");
    }
}
