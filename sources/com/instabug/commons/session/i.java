package com.instabug.commons.session;

import com.instabug.commons.models.Incident;
import com.instabug.library.model.v3Session.IBGSessionData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class i {
    private static final String a(Incident.Type type) {
        switch (h.f46340a[type.ordinal()]) {
            case 1:
                return "anr";
            case 2:
                return "fh";
            case 3:
                return "f";
            case 4:
                return "nf";
            case 5:
                return "ndkc";
            case 6:
                return "ats";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final Map b(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            ArrayList arrayList = new ArrayList();
            for (e b11 : (Iterable) entry.getValue()) {
                String b12 = b11.b();
                if (b12 != null) {
                    arrayList.add(b12);
                }
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }

    private static final IBGSessionData c(Map map) {
        return new IBGSessionData("cd", a(map));
    }

    @NotNull
    public static final Map d(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "incidents");
        Map c11 = c(list);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(c11.size()));
        for (Map.Entry entry : c11.entrySet()) {
            linkedHashMap.put(entry.getKey(), a((List) entry.getValue()));
        }
        return linkedHashMap;
    }

    private static final IBGSessionData a(List list) {
        return c(b(b(list)));
    }

    @NotNull
    public static final Map c(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "incidents");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : list) {
            String d11 = ((e) next).d();
            Object obj = linkedHashMap.get(d11);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(d11, obj);
            }
            ((List) obj).add(next);
        }
        return linkedHashMap;
    }

    private static final JSONObject a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), (Object) new JSONArray((Collection<?>) (Collection) entry.getValue()));
        }
        return jSONObject;
    }

    private static final Map b(List list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : list) {
            Incident.Type c11 = ((e) next).c();
            Object obj = linkedHashMap.get(c11);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(c11, obj);
            }
            ((List) obj).add(next);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(a((Incident.Type) entry.getKey()), entry.getValue());
        }
        return linkedHashMap2;
    }
}
