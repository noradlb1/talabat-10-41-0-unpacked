package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016R$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "g", "key", "Lkotlinx/serialization/json/JsonElement;", "element", "", "putElement", "getCurrent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "array", "Ljava/util/ArrayList;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
final class JsonTreeListEncoder extends AbstractJsonTreeEncoder {
    @NotNull
    private final ArrayList<JsonElement> array = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeListEncoder(@NotNull Json json, @NotNull Function1<? super JsonElement, Unit> function1) {
        super(json, function1, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(function1, "nodeConsumer");
    }

    @NotNull
    public String g(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return String.valueOf(i11);
    }

    @NotNull
    public JsonElement getCurrent() {
        return new JsonArray(this.array);
    }

    public void putElement(@NotNull String str, @NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        this.array.add(Integer.parseInt(str), jsonElement);
    }
}
