package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeMapDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "desc", "", "index", "", "g", "descriptor", "decodeElementIndex", "tag", "Lkotlinx/serialization/json/JsonElement;", "j", "", "endStructure", "Lkotlinx/serialization/json/JsonObject;", "value", "Lkotlinx/serialization/json/JsonObject;", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "", "keys", "Ljava/util/List;", "size", "I", "position", "Lkotlinx/serialization/json/Json;", "json", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
final class JsonTreeMapDecoder extends JsonTreeDecoder {
    @NotNull
    private final List<String> keys;
    private int position = -1;
    private final int size;
    @NotNull
    private final JsonObject value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeMapDecoder(@NotNull Json json, @NotNull JsonObject jsonObject) {
        super(json, jsonObject, (String) null, (SerialDescriptor) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonObject, "value");
        this.value = jsonObject;
        List<String> list = CollectionsKt___CollectionsKt.toList(getValue().keySet());
        this.keys = list;
        this.size = list.size() * 2;
    }

    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i11 = this.position;
        if (i11 >= this.size - 1) {
            return -1;
        }
        int i12 = i11 + 1;
        this.position = i12;
        return i12;
    }

    public void endStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    @NotNull
    public String g(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        return this.keys.get(i11 / 2);
    }

    @NotNull
    public JsonElement j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        if (this.position % 2 == 0) {
            return JsonElementKt.JsonPrimitive(str);
        }
        return (JsonElement) MapsKt__MapsKt.getValue(getValue(), str);
    }

    @NotNull
    public JsonObject getValue() {
        return this.value;
    }
}
