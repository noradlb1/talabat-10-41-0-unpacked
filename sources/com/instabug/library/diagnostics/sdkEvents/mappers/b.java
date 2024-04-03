package com.instabug.library.diagnostics.sdkEvents.mappers;

import com.instabug.library.diagnostics.sdkEvents.models.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class b {
    @NotNull
    public static final JSONArray a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "events");
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) a((a) it.next()));
        }
        return jSONArray;
    }

    private static final JSONObject a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", (Object) aVar.b());
        jSONObject.put("count", aVar.a());
        return jSONObject;
    }

    @NotNull
    public static final List a(@Nullable JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                a a11 = a(jSONArray.getJSONObject(i11));
                if (a11 != null) {
                    arrayList.add(a11);
                }
                i11 = i12;
            }
        }
        return arrayList;
    }

    private static final a a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("key", "");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(EVENT_KEY_KEY, \"\")");
            boolean z11 = false;
            a aVar = new a(optString, jSONObject.optInt("count", 0));
            if ((!StringsKt__StringsJVMKt.isBlank(aVar.b())) && aVar.a() > 0) {
                z11 = true;
            }
            if (z11) {
                return aVar;
            }
        }
        return null;
    }
}
