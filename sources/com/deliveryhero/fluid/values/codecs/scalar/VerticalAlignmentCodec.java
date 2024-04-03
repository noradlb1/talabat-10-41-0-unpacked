package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.Enumeration;
import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.widgets.containers.VerticalAlignment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/VerticalAlignmentCodec;", "Lcom/deliveryhero/fluid/values/codecs/scalar/EnumerationCodec;", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "()V", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalAlignmentCodec extends EnumerationCodec<VerticalAlignment> {
    @NotNull
    public static final VerticalAlignmentCodec INSTANCE = new VerticalAlignmentCodec();

    private VerticalAlignmentCodec() {
        super((Enumeration[]) VerticalAlignment.values(), ValueType.VERTICAL_ALIGNMENT);
    }
}
