package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JA\u0010\u0011\u001a\u00020\u0006\"\b\b\u0000\u0010\t*\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0004H\u0016R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00148\u0004X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "", "key", "Lkotlinx/serialization/json/JsonElement;", "element", "", "putElement", "", "T", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "value", "encodeNullableSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "getCurrent", "", "content", "Ljava/util/Map;", "w", "()Ljava/util/Map;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
class JsonTreeEncoder extends AbstractJsonTreeEncoder {
    @NotNull
    private final Map<String, JsonElement> content = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeEncoder(@NotNull Json json, @NotNull Function1<? super JsonElement, Unit> function1) {
        super(json, function1, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(function1, "nodeConsumer");
    }

    public <T> void encodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor, int i11, @NotNull SerializationStrategy<? super T> serializationStrategy, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (t11 != null || this.f26438a.getExplicitNulls()) {
            super.encodeNullableSerializableElement(serialDescriptor, i11, serializationStrategy, t11);
        }
    }

    @NotNull
    public JsonElement getCurrent() {
        return new JsonObject(this.content);
    }

    public void putElement(@NotNull String str, @NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        this.content.put(str, jsonElement);
    }

    @NotNull
    public final Map<String, JsonElement> w() {
        return this.content;
    }
}
