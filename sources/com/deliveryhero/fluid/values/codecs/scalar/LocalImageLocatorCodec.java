package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/LocalImageLocatorCodec;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "encoded", "", "encode", "decoded", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocalImageLocatorCodec implements ValueCodec.Scalar<ImageLocator.Local> {
    @NotNull
    public static final LocalImageLocatorCodec INSTANCE = new LocalImageLocatorCodec();
    @NotNull
    private static final ValueType valueType = ValueType.LOCAL_IMAGE_LOCATOR;

    private LocalImageLocatorCodec() {
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public ImageLocator.Local decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encoded");
        throw new UnsupportedOperationException("Decoding literals are not supported for local images");
    }

    @NotNull
    public String encode(@NotNull ImageLocator.Local local) {
        Intrinsics.checkNotNullParameter(local, "decoded");
        throw new UnsupportedOperationException("Encoding literals are not supported for local images");
    }
}
