package com.talabat.talabatcommon.extentions;

import com.facebook.internal.NativeProtocol;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\bø\u0001\u0000\u001a\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00052\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\t*\u00020\u00052\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\u000e\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\b\u001a\u00020\t\u001a\u001a\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\t0\t*\u00020\u00052\u0006\u0010\b\u001a\u00020\t\u001a\u0016\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012*\u00020\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"forEachObject", "", "Lcom/google/gson/JsonArray;", "action", "Lkotlin/Function1;", "Lcom/google/gson/JsonObject;", "getInt", "", "key", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "getString", "requireFloat", "", "requireInt", "requireString", "kotlin.jvm.PlatformType", "toFlatStringMap", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class JsonExtensionsKt {
    public static final void forEachObject(@NotNull JsonArray jsonArray, @NotNull Function1<? super JsonObject, Unit> function1) {
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(jsonArray, "<this>");
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        Iterator it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement jsonElement = (JsonElement) it.next();
            if (jsonElement instanceof JsonObject) {
                jsonObject = (JsonObject) jsonElement;
            } else {
                jsonObject = null;
            }
            if (jsonObject != null) {
                function1.invoke(jsonObject);
            }
        }
    }

    @Nullable
    public static final Integer getInt(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (!jsonObject.has(str) || !jsonObject.get(str).isJsonPrimitive()) {
            return null;
        }
        return Integer.valueOf(jsonObject.get(str).getAsInt());
    }

    @Nullable
    public static final String getString(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (!jsonObject.has(str) || !jsonObject.get(str).isJsonPrimitive()) {
            return null;
        }
        return jsonObject.get(str).getAsString();
    }

    public static final float requireFloat(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return jsonObject.get(str).getAsFloat();
    }

    public static final int requireInt(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return jsonObject.get(str).getAsInt();
    }

    public static final String requireString(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return jsonObject.get(str).getAsString();
    }

    @NotNull
    public static final Map<String, String> toFlatStringMap(@NotNull JsonObject jsonObject) {
        String str;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Set<String> keySet = jsonObject.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10)), 16));
        for (T next : keySet) {
            try {
                str = jsonObject.getAsJsonPrimitive((String) next).getAsString();
            } catch (ClassCastException unused) {
                str = "";
            }
            linkedHashMap.put(next, str);
        }
        return linkedHashMap;
    }
}
