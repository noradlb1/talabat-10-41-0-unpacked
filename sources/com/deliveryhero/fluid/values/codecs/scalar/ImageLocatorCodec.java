package com.deliveryhero.fluid.values.codecs.scalar;

import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/scalar/ImageLocatorCodec;", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Scalar;", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator;", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Remote;", "encoded", "", "encode", "decoded", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageLocatorCodec implements ValueCodec.Scalar<ImageLocator> {
    @NotNull
    public static final ImageLocatorCodec INSTANCE = new ImageLocatorCodec();
    @NotNull
    private static final ValueType valueType = ValueType.IMAGE_LOCATOR;

    private ImageLocatorCodec() {
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public ImageLocator.Remote decode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encoded");
        return new ImageLocator.Remote(str);
    }

    @NotNull
    public String encode(@NotNull ImageLocator imageLocator) {
        Intrinsics.checkNotNullParameter(imageLocator, "decoded");
        return ((ImageLocator.Remote) imageLocator).getUrl();
    }
}
