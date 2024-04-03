package com.instabug.library.util.extenstions;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class d {
    @NotNull
    public static final JSONArray a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return new JSONArray((Collection<?>) list);
    }

    @NotNull
    public static final JSONObject a(@NotNull Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    @NotNull
    public static final Map a(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "key");
            linkedHashMap.put(next, jSONObject.get(next));
        }
        return linkedHashMap;
    }
}
