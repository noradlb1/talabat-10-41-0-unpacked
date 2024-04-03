package com.deliveryhero.fluid.values;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/fluid/values/LinearGradientOrientation.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class LinearGradientOrientation$$serializer implements GeneratedSerializer<LinearGradientOrientation> {
    @NotNull
    public static final LinearGradientOrientation$$serializer INSTANCE = new LinearGradientOrientation$$serializer();
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        EnumDescriptor enumDescriptor = new EnumDescriptor("com.deliveryhero.fluid.values.LinearGradientOrientation", 8);
        enumDescriptor.addElement("LEFT_RIGHT", false);
        enumDescriptor.addElement("BOTTOM_LEFT_TOP_RIGHT", false);
        enumDescriptor.addElement("BOTTOM_TOP", false);
        enumDescriptor.addElement("BOTTOM_RIGHT_TOP_LEFT", false);
        enumDescriptor.addElement("RIGHT_LEFT", false);
        enumDescriptor.addElement("TOP_RIGHT_BOTTOM_LEFT", false);
        enumDescriptor.addElement("TOP_BOTTOM", false);
        enumDescriptor.addElement("TOP_LEFT_BOTTOM_RIGHT", false);
        descriptor = enumDescriptor;
    }

    private LinearGradientOrientation$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    @NotNull
    public LinearGradientOrientation deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return LinearGradientOrientation.values()[decoder.decodeEnum(getDescriptor())];
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull LinearGradientOrientation linearGradientOrientation) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(linearGradientOrientation, "value");
        encoder.encodeEnum(getDescriptor(), linearGradientOrientation.ordinal());
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
