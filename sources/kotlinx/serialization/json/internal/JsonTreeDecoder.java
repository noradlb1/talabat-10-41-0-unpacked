package kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "tag", "", "coerceInputValue", "absenceIsNull", "decodeElementIndex", "decodeNotNullMark", "desc", "g", "Lkotlinx/serialization/json/JsonElement;", "j", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "", "endStructure", "Lkotlinx/serialization/json/JsonObject;", "value", "Lkotlinx/serialization/json/JsonObject;", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "polyDiscriminator", "Ljava/lang/String;", "polyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "position", "I", "forceNull", "Z", "Lkotlinx/serialization/json/Json;", "json", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    private boolean forceNull;
    @Nullable
    private final SerialDescriptor polyDescriptor;
    @Nullable
    private final String polyDiscriminator;
    private int position;
    @NotNull
    private final JsonObject value;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : serialDescriptor);
    }

    private final boolean absenceIsNull(SerialDescriptor serialDescriptor, int i11) {
        boolean z11;
        if (getJson().getConfiguration().getExplicitNulls() || serialDescriptor.isElementOptional(i11) || !serialDescriptor.getElementDescriptor(i11).isNullable()) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.forceNull = z11;
        return z11;
    }

    private final boolean coerceInputValue(SerialDescriptor serialDescriptor, int i11, String str) {
        JsonPrimitive jsonPrimitive;
        Json json = getJson();
        SerialDescriptor elementDescriptor = serialDescriptor.getElementDescriptor(i11);
        if (!elementDescriptor.isNullable() && (j(str) instanceof JsonNull)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) elementDescriptor.getKind(), (Object) SerialKind.ENUM.INSTANCE)) {
            JsonElement j11 = j(str);
            String str2 = null;
            if (j11 instanceof JsonPrimitive) {
                jsonPrimitive = (JsonPrimitive) j11;
            } else {
                jsonPrimitive = null;
            }
            if (jsonPrimitive != null) {
                str2 = JsonElementKt.getContentOrNull(jsonPrimitive);
            }
            if (str2 != null && JsonNamesMapKt.getJsonNameIndex(elementDescriptor, json, str2) == -3) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (serialDescriptor == this.polyDescriptor) {
            return this;
        }
        return super.beginStructure(serialDescriptor);
    }

    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        while (this.position < serialDescriptor.getElementsCount()) {
            int i11 = this.position;
            this.position = i11 + 1;
            String h11 = getTag(serialDescriptor, i11);
            int i12 = this.position - 1;
            this.forceNull = false;
            if ((getValue().containsKey(h11) || absenceIsNull(serialDescriptor, i12)) && (!this.f26437a.getCoerceInputValues() || !coerceInputValue(serialDescriptor, i12, h11))) {
                return i12;
            }
        }
        return -1;
    }

    public boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    public void endStructure(@NotNull SerialDescriptor serialDescriptor) {
        Set<String> set;
        Set set2;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (!this.f26437a.getIgnoreUnknownKeys() && !(serialDescriptor.getKind() instanceof PolymorphicKind)) {
            if (!this.f26437a.getUseAlternativeNames()) {
                set = JsonInternalDependenciesKt.jsonCachedSerialNames(serialDescriptor);
            } else {
                Set<String> jsonCachedSerialNames = JsonInternalDependenciesKt.jsonCachedSerialNames(serialDescriptor);
                Map map = (Map) JsonSchemaCacheKt.getSchemaCache(getJson()).get(serialDescriptor, JsonNamesMapKt.getJsonAlternativeNamesKey());
                if (map != null) {
                    set2 = map.keySet();
                } else {
                    set2 = null;
                }
                if (set2 == null) {
                    set2 = SetsKt__SetsKt.emptySet();
                }
                set = SetsKt___SetsKt.plus(jsonCachedSerialNames, set2);
            }
            for (String next : getValue().keySet()) {
                if (!set.contains(next) && !Intrinsics.areEqual((Object) next, (Object) this.polyDiscriminator)) {
                    throw JsonExceptionsKt.UnknownKeyException(next, getValue().toString());
                }
            }
        }
    }

    @NotNull
    public String g(@NotNull SerialDescriptor serialDescriptor, int i11) {
        T t11;
        boolean z11;
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        String elementName = serialDescriptor.getElementName(i11);
        if (!this.f26437a.getUseAlternativeNames() || getValue().keySet().contains(elementName)) {
            return elementName;
        }
        Map map = (Map) JsonSchemaCacheKt.getSchemaCache(getJson()).getOrPut(serialDescriptor, JsonNamesMapKt.getJsonAlternativeNamesKey(), new JsonTreeDecoder$elementName$alternativeNamesMap$1(serialDescriptor));
        Iterator<T> it = getValue().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it.next();
            Integer num = (Integer) map.get((String) t11);
            if (num != null && num.intValue() == i11) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        String str = (String) t11;
        if (str == null) {
            return elementName;
        }
        return str;
    }

    @NotNull
    public JsonElement j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        return (JsonElement) MapsKt__MapsKt.getValue(getValue(), str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(@NotNull Json json, @NotNull JsonObject jsonObject, @Nullable String str, @Nullable SerialDescriptor serialDescriptor) {
        super(json, jsonObject, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonObject, "value");
        this.value = jsonObject;
        this.polyDiscriminator = str;
        this.polyDescriptor = serialDescriptor;
    }

    @NotNull
    public JsonObject getValue() {
        return this.value;
    }
}
