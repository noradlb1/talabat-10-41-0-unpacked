package com.deliveryhero.fluid.content.serializers;

import com.deliveryhero.fluid.template.data.KJsonFlattener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/fluid/content/serializers/ScalarValuesSerializer;", "Lkotlinx/serialization/KSerializer;", "", "", "()V", "delegateSerializer", "Lkotlinx/serialization/json/JsonElement;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScalarValuesSerializer implements KSerializer<Map<String, ? extends String>> {
    @NotNull
    private final KSerializer<Map<String, JsonElement>> delegateSerializer;
    @NotNull
    private final SerialDescriptor descriptor;

    public ScalarValuesSerializer() {
        KTypeProjection.Companion companion = KTypeProjection.Companion;
        KSerializer<Object> serializer = SerializersKt.serializer(Reflection.typeOf(Map.class, companion.invariant(Reflection.typeOf(String.class)), companion.invariant(Reflection.typeOf(JsonElement.class))));
        this.delegateSerializer = serializer;
        this.descriptor = SerialDescriptorsKt.SerialDescriptor("Values", serializer.getDescriptor());
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public Map<String, String> deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return KJsonFlattener.INSTANCE.flatten((Map) decoder.decodeSerializableValue(this.delegateSerializer));
    }

    public void serialize(@NotNull Encoder encoder, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(map, "value");
        throw new UnsupportedOperationException("Serializing a flattened scalar values is currently unsupported");
    }
}
