package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "", "tag", "Lkotlinx/serialization/json/JsonElement;", "j", "Lkotlinx/serialization/json/JsonPrimitive;", "value", "Lkotlinx/serialization/json/JsonPrimitive;", "getValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/json/Json;", "json", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonPrimitive;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
final class JsonPrimitiveDecoder extends AbstractJsonTreeDecoder {
    @NotNull
    private final JsonPrimitive value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonPrimitiveDecoder(@NotNull Json json, @NotNull JsonPrimitive jsonPrimitive) {
        super(json, jsonPrimitive, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonPrimitive, "value");
        this.value = jsonPrimitive;
        e(TreeJsonEncoderKt.PRIMITIVE_TAG);
    }

    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return 0;
    }

    @NotNull
    public JsonElement j(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "tag");
        if (str == TreeJsonEncoderKt.PRIMITIVE_TAG) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return getValue();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }

    @NotNull
    public JsonPrimitive getValue() {
        return this.value;
    }
}
