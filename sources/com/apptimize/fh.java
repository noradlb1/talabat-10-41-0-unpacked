package com.apptimize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fh {
    public static Object a(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            return a((JSONArray) obj);
        }
        if (obj instanceof JSONObject) {
            return a((JSONObject) obj);
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (JSONObject.NULL.equals(obj)) {
            return null;
        }
        return obj;
    }

    public static Map<String, Object> b(JSONObject jSONObject) throws JSONException {
        return a(jSONObject, Object.class);
    }

    private static Object b(Object obj) throws JSONException {
        if (obj instanceof Collection) {
            return a((Collection<Object>) (Collection) obj);
        }
        return obj instanceof Map ? a((Map<?, ?>) (Map) obj) : obj;
    }

    public static List<Object> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(a(jSONArray.get(i11)));
        }
        return arrayList;
    }

    public static Map<Object, Object> a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!(next == null || jSONObject.get(next) == null)) {
                hashMap.put(next, a(jSONObject.get(next)));
            }
        }
        return hashMap;
    }

    public static <T> Map<String, T> a(JSONObject jSONObject, Class<T> cls) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (cls.isInstance(obj)) {
                hashMap.put(next, cls.cast(obj));
            }
        }
        return hashMap;
    }

    public static <T> Map<String, T> a(String str, JSONObject jSONObject, Class<T> cls) throws JSONException {
        if (!jSONObject.has(str)) {
            return new HashMap();
        }
        return a(jSONObject.getJSONObject(str), cls);
    }

    public static JSONObject a(Map<?, ?> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (str != null) {
                jSONObject.put(str, b(next.getValue()));
            } else {
                throw new NullPointerException("key == null");
            }
        }
        return jSONObject;
    }

    public static JSONArray a(Collection<Object> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object b11 : collection) {
            jSONArray.put(b(b11));
        }
        return jSONArray;
    }

    public static boolean a(Object obj, Object obj2) throws JSONException {
        return ey.a(a(obj), a(obj2));
    }
}
