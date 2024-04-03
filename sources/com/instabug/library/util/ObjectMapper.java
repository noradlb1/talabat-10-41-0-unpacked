package com.instabug.library.util;

import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ObjectMapper {
    @Nullable
    public static <T extends Cacheable> T fromJson(@Nullable String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            T t11 = (Cacheable) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            t11.fromJson(str);
            return t11;
        } catch (JSONException e11) {
            if (e11.getMessage() == null) {
                return null;
            }
            InstabugSDKLogger.e("IBG-Core", "Error while parsing json", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            InstabugSDKLogger.e("IBG-Core", "The object must have a public default constructor", e12);
            return null;
        } catch (IllegalAccessException e13) {
            InstabugSDKLogger.e("IBG-Core", "The object must have a public default constructor", e13);
            return null;
        } catch (InstantiationException e14) {
            InstabugSDKLogger.e("IBG-Core", "The object must have a public default constructor", e14);
            return null;
        } catch (InvocationTargetException e15) {
            InstabugSDKLogger.e("IBG-Core", "The object must have a public default constructor", e15);
            return null;
        }
    }

    @Nullable
    public static String toJson(Cacheable cacheable) {
        try {
            return cacheable.toJson();
        } catch (JSONException e11) {
            if (e11.getMessage() == null) {
                return null;
            }
            InstabugSDKLogger.e("IBG-Core", e11.getMessage(), e11);
            return null;
        }
    }

    public static JSONObject toJson(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Core", "JSONException while converting map to json: " + e11.getMessage());
            }
        }
        return jSONObject;
    }
}
