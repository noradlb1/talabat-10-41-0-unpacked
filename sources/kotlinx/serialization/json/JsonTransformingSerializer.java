package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/JsonTransformingSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonElement;", "element", "a", "b", "tSerializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
public abstract class JsonTransformingSerializer<T> implements KSerializer<T> {
    @NotNull
    private final KSerializer<T> tSerializer;

    public JsonTransformingSerializer(@NotNull KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "tSerializer");
        this.tSerializer = kSerializer;
    }

    @NotNull
    public JsonElement a(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return jsonElement;
    }

    @NotNull
    public JsonElement b(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return jsonElement;
    }

    @NotNull
    public final T deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder asJsonDecoder = JsonElementSerializersKt.asJsonDecoder(decoder);
        return asJsonDecoder.getJson().decodeFromJsonElement(this.tSerializer, a(asJsonDecoder.decodeJsonElement()));
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.tSerializer.getDescriptor();
    }

    public final void serialize(@NotNull Encoder encoder, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t11, "value");
        JsonEncoder asJsonEncoder = JsonElementSerializersKt.asJsonEncoder(encoder);
        asJsonEncoder.encodeJsonElement(b(TreeJsonEncoderKt.writeJson(asJsonEncoder.getJson(), t11, this.tSerializer)));
    }
}
