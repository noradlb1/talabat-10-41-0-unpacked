package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0007H\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\tH\u0000¨\u0006\u000e"}, d2 = {"defer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "deferred", "Lkotlin/Function0;", "verify", "", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "asJsonDecoder", "Lkotlinx/serialization/json/JsonDecoder;", "asJsonEncoder", "Lkotlinx/serialization/json/JsonEncoder;", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class JsonElementSerializersKt {
    @NotNull
    public static final JsonDecoder asJsonDecoder(@NotNull Decoder decoder) {
        JsonDecoder jsonDecoder;
        Intrinsics.checkNotNullParameter(decoder, "<this>");
        if (decoder instanceof JsonDecoder) {
            jsonDecoder = (JsonDecoder) decoder;
        } else {
            jsonDecoder = null;
        }
        if (jsonDecoder != null) {
            return jsonDecoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.getOrCreateKotlinClass(decoder.getClass()));
    }

    @NotNull
    public static final JsonEncoder asJsonEncoder(@NotNull Encoder encoder) {
        JsonEncoder jsonEncoder;
        Intrinsics.checkNotNullParameter(encoder, "<this>");
        if (encoder instanceof JsonEncoder) {
            jsonEncoder = (JsonEncoder) encoder;
        } else {
            jsonEncoder = null;
        }
        if (jsonEncoder != null) {
            return jsonEncoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.getOrCreateKotlinClass(encoder.getClass()));
    }

    /* access modifiers changed from: private */
    public static final SerialDescriptor defer(Function0<? extends SerialDescriptor> function0) {
        return new JsonElementSerializersKt$defer$1(function0);
    }

    /* access modifiers changed from: private */
    public static final void verify(Encoder encoder) {
        asJsonEncoder(encoder);
    }

    /* access modifiers changed from: private */
    public static final void verify(Decoder decoder) {
        asJsonDecoder(decoder);
    }
}
