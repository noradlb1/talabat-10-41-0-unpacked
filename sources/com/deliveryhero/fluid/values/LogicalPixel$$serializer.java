package com.deliveryhero.fluid.values;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/fluid/values/LogicalPixel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class LogicalPixel$$serializer implements GeneratedSerializer<LogicalPixel> {
    @NotNull
    public static final LogicalPixel$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        LogicalPixel$$serializer logicalPixel$$serializer = new LogicalPixel$$serializer();
        INSTANCE = logicalPixel$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deliveryhero.fluid.values.LogicalPixel", logicalPixel$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LogicalPixel$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{FloatSerializer.INSTANCE};
    }

    @NotNull
    public LogicalPixel deserialize(@NotNull Decoder decoder) {
        float f11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i11 = 1;
        if (beginStructure.decodeSequentially()) {
            f11 = beginStructure.decodeFloatElement(descriptor2, 0);
        } else {
            f11 = 0.0f;
            int i12 = 0;
            while (i11 != 0) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    i11 = 0;
                } else if (decodeElementIndex == 0) {
                    f11 = beginStructure.decodeFloatElement(descriptor2, 0);
                    i12 |= 1;
                } else {
                    throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i11 = i12;
        }
        beginStructure.endStructure(descriptor2);
        return new LogicalPixel(i11, f11, (SerializationConstructorMarker) null);
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull LogicalPixel logicalPixel) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(logicalPixel, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LogicalPixel.write$Self(logicalPixel, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
