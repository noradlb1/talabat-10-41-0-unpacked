package com.huawei.agconnect.https.adapter;

import com.huawei.agconnect.https.annotation.Result;
import com.huawei.agconnect.https.h;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONDecodeUtil {
    private static Object buildObjByType(Class<?> cls) throws IllegalAccessException, InstantiationException, JSONException {
        boolean isInterface = cls.isInterface();
        Class<ArrayList> cls2 = cls;
        if (isInterface) {
            if (cls.equals(List.class)) {
                cls2 = ArrayList.class;
            } else if (cls.equals(Set.class)) {
                cls2 = HashSet.class;
            } else if (cls.equals(Map.class)) {
                cls2 = HashMap.class;
            } else {
                throw new JSONException("the type of " + cls + "cannot be interface");
            }
        }
        return cls2.newInstance();
    }

    public static <T> T getObject(String str, Class<T> cls) throws JSONException, IllegalAccessException, InstantiationException {
        Class<? super T> superclass;
        T newInstance = cls.newInstance();
        JSONObject jSONObject = new JSONObject(str);
        Class<? super T> cls2 = cls;
        do {
            Field[] declaredFields = cls2.getDeclaredFields();
            if (declaredFields.length > 0) {
                for (final Field field : declaredFields) {
                    String name2 = field.getName();
                    if (!jSONObject.has(name2)) {
                        Class cls3 = Result.class;
                        if (field.isAnnotationPresent(cls3)) {
                            name2 = ((Result) field.getAnnotation(cls3)).value();
                        }
                    }
                    if (jSONObject.has(name2)) {
                        if (!field.isAccessible()) {
                            AccessController.doPrivileged(new PrivilegedAction() {
                                public Object run() {
                                    field.setAccessible(true);
                                    return null;
                                }
                            });
                        }
                        Object value = getValue(jSONObject.optString(name2), field.getGenericType());
                        if (value != null) {
                            field.set(newInstance, value);
                        }
                    }
                }
            }
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != Object.class);
        return newInstance;
    }

    private static Object getValue(String str, Type type) throws IllegalAccessException, JSONException, InstantiationException {
        if (h.a(str)) {
            return null;
        }
        Class<?> a11 = h.a(type);
        int i11 = 0;
        if (isCollectionType(a11)) {
            Object buildObjByType = buildObjByType(a11);
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            while (i11 < length) {
                ((Collection) buildObjByType).add(getValue(jSONArray.optString(i11), type2));
                i11++;
            }
            return buildObjByType;
        } else if (isMapType(a11)) {
            Object buildObjByType2 = buildObjByType(a11);
            Type type3 = ((ParameterizedType) type).getActualTypeArguments()[1];
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                ((Map) buildObjByType2).put(next, getValue(jSONObject.optString(next), type3));
            }
            return buildObjByType2;
        } else if (!a11.isArray()) {
            return getValue2(str, a11);
        } else {
            Class<?> componentType = a11.getComponentType();
            JSONArray jSONArray2 = new JSONArray(str);
            int length2 = jSONArray2.length();
            Object newInstance = Array.newInstance(componentType, length2);
            while (i11 < length2) {
                Array.set(newInstance, i11, getValue(jSONArray2.optString(i11), componentType));
                i11++;
            }
            return newInstance;
        }
    }

    private static Object getValue2(String str, Type type) throws IllegalAccessException, JSONException, InstantiationException {
        Class<?> a11 = h.a(type);
        if (isIntType(a11)) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else if (isDoubleType(a11)) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException unused2) {
                return Double.valueOf(0.0d);
            }
        } else if (isFloat(a11)) {
            return Float.valueOf(Float.parseFloat(str));
        } else {
            if (isBooleanType(a11)) {
                return Boolean.valueOf(Boolean.parseBoolean(str));
            }
            if (!isLongType(a11)) {
                return isStringType(a11) ? isNull(str) ? "" : String.valueOf(str) : getObject(str, a11);
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused3) {
                return 0L;
            }
        }
    }

    private static boolean isBooleanType(Class<?> cls) {
        return cls == Boolean.TYPE || cls == Boolean.class;
    }

    private static boolean isCollectionType(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }

    private static boolean isDoubleType(Class<?> cls) {
        return cls == Double.TYPE || cls == Double.class;
    }

    private static boolean isFloat(Class<?> cls) {
        return cls == Float.TYPE || cls == Float.class;
    }

    private static boolean isIntType(Class<?> cls) {
        return cls == Integer.TYPE || cls == Integer.class;
    }

    private static boolean isLongType(Class<?> cls) {
        return cls == Long.TYPE || cls == Long.class;
    }

    private static boolean isMapType(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }

    private static boolean isNull(String str) {
        return "null".equals(str) || h.a(str);
    }

    private static boolean isStringType(Class<?> cls) {
        return cls == String.class;
    }
}
