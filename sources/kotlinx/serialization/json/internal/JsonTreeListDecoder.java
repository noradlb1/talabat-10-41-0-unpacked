package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "desc", "", "index", "", "g", "tag", "Lkotlinx/serialization/json/JsonElement;", "j", "descriptor", "decodeElementIndex", "Lkotlinx/serialization/json/JsonArray;", "value", "Lkotlinx/serialization/json/JsonArray;", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "size", "I", "currentIndex", "Lkotlinx/serialization/json/Json;", "json", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
final class JsonTreeListDecoder extends AbstractJsonTreeDecoder {
    private int currentIndex = -1;
    private final int size = getValue().size();
    @NotNull
    private final JsonArray value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeListDecoder(@NotNull Json json, @NotNull JsonArray jsonArray) {
        super(json, jsonArray, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonArray, "value");
        this.value = jsonArray;
    }

    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i11 = this.currentIndex;
        if (i11 >= this.size - 1) {
            return -1;
        }
        int i12 = i11 + 1;
        this.currentIndex = i12;
        return i12;
    }

    @NotNull
    public String g(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        return String.valueOf(i11);
    }

    @NotNull
    public JsonArray getValue() {
        return this.value;
    }

    @NotNull
    public JsonElement j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        return getValue().get(Integer.parseInt(str));
    }
}
