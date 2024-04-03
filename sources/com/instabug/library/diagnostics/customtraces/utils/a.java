package com.instabug.library.diagnostics.customtraces.utils;

import com.facebook.appevents.UserDataStore;
import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    @NotNull
    public static final JSONArray a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) a((IBGCustomTrace) it.next()));
        }
        return jSONArray;
    }

    @Nullable
    public static final List b(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONArray optJSONArray = jSONObject.optJSONArray("tl");
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.getJSONObject(i)");
            arrayList.add(a(jSONObject2));
            i11 = i12;
        }
        return arrayList;
    }

    @NotNull
    public static final JSONObject a(@NotNull IBGCustomTrace iBGCustomTrace) {
        Intrinsics.checkNotNullParameter(iBGCustomTrace, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("n", (Object) iBGCustomTrace.getName());
        jSONObject.put(UserDataStore.STATE, iBGCustomTrace.getStartTime());
        jSONObject.put("dmus", iBGCustomTrace.getDuration());
        jSONObject.put("bg", iBGCustomTrace.getStartedInBG() && iBGCustomTrace.getEndedInBG());
        JSONObject a11 = a((HashMap) iBGCustomTrace.getAttributes());
        if (a11 != null) {
            jSONObject.put("att", (Object) a11);
        }
        return jSONObject;
    }

    @Nullable
    public static final JSONObject a(@NotNull HashMap hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        JSONObject jSONObject = null;
        if (!(!hashMap.isEmpty())) {
            hashMap = null;
        }
        if (hashMap != null) {
            jSONObject = new JSONObject();
            for (String str : hashMap.keySet()) {
                jSONObject.put(str, hashMap.get(str));
            }
        }
        return jSONObject;
    }

    @NotNull
    public static final IBGCustomTrace a(@NotNull JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(jSONObject2, "<this>");
        String optString = jSONObject2.optString("n", "");
        long optLong = jSONObject2.optLong(UserDataStore.STATE, 0);
        long optLong2 = jSONObject2.optLong("dmus", -1);
        Intrinsics.checkNotNullExpressionValue(optString, "optString(CustomTracesMappingKeys.NAME, \"\")");
        return new IBGCustomTrace(0, optString, 0, 0, optLong2, false, false, (HashMap) null, optLong, 237, (DefaultConstructorMarker) null);
    }
}
