package com.deliveryhero.fluid.template.data;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/template/data/KJsonFlattener;", "", "()V", "flatten", "", "", "values", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KJsonFlattener {
    @NotNull
    public static final KJsonFlattener INSTANCE = new KJsonFlattener();

    private KJsonFlattener() {
    }

    private static final void flatten$addFlattenKeyValue(Map<String, String> map, String str, JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            for (Map.Entry entry : ((JsonObject) jsonElement).entrySet()) {
                flatten$addFlattenKeyValue(map, str + '.' + ((String) entry.getKey()), (JsonElement) entry.getValue());
            }
        } else if (jsonElement instanceof JsonArray) {
            int i11 = 0;
            for (Object next : (Iterable) jsonElement) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                flatten$addFlattenKeyValue(map, str + '.' + i11, (JsonElement) next);
                i11 = i12;
            }
        } else {
            map.put(str, ((JsonPrimitive) jsonElement).getContent());
        }
    }

    @NotNull
    public final Map<String, String> flatten(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() instanceof JsonElement) {
                flatten$addFlattenKeyValue(linkedHashMap, (String) entry.getKey(), (JsonElement) entry.getValue());
            } else {
                linkedHashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return linkedHashMap;
    }
}
