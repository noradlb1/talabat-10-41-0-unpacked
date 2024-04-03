package com.huawei.hms.flutter.analytics.utils;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapUtils {
    private static final String TAG = "MapUtils";

    private MapUtils() {
    }

    public static String getString(String str, Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        Log.w(TAG, "toString | String value expected for " + str + ". ");
        return "";
    }

    private static void handleList(Bundle bundle, String str, List<?> list) {
        String simpleName = list.get(0).getClass().getSimpleName();
        if (simpleName.equals("HashMap")) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                arrayList.add(mapToBundle(objectToMap(list.get(i11)), true));
            }
            bundle.putParcelableArrayList(str, arrayList);
        } else if (simpleName.equals("String")) {
            bundle.putStringArrayList(str, toArrayList(toStringList(list)));
        } else if (simpleName.equals("Integer")) {
            bundle.putIntegerArrayList(str, toArrayList(toIntegerList(list)));
        } else {
            throw new IllegalArgumentException("inner Illegal value type. Key :" + str + ", valueType : " + list.getClass().getSimpleName());
        }
    }

    public static Bundle mapToBundle(@Nullable Map<String, Object> map, boolean z11) {
        Bundle bundle = new Bundle();
        if (map == null) {
            return bundle;
        }
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof String) {
                bundle.putString(str, (String) value);
            } else if (value instanceof Integer) {
                bundle.putInt(str, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(str, ((Long) value).longValue());
            } else if (value instanceof Double) {
                bundle.putDouble(str, ((Double) value).doubleValue());
            } else if (value instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Map) {
                if (!z11) {
                    bundle.putBundle(str, mapToBundle(objectToMap(value), true));
                } else {
                    Log.e(TAG, "Illegal value type. Key :" + str + ", only one nested bundle structure is allowed.");
                }
            } else if (value instanceof List) {
                List list = (List) value;
                if (list.size() != 0) {
                    handleList(bundle, str, list);
                } else {
                    Log.e(TAG, "Illegal value type. Key:" + str + ", must not be empty.");
                }
            } else {
                throw new IllegalArgumentException("Illegal value type. Key :" + str + ", valueType : " + value.getClass().getSimpleName());
            }
        }
        return bundle;
    }

    public static Map<String, Object> objectToMap(Object obj) {
        HashMap hashMap = new HashMap();
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                if (entry != null) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    private static <T> ArrayList<T> toArrayList(List<T> list) {
        return new ArrayList<>(list);
    }

    public static Boolean toBoolean(String str, Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        Log.w(TAG, "toBoolean | Boolean value expected for " + str + ". Returning false as default.");
        return Boolean.FALSE;
    }

    public static List<Integer> toIntegerList(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof ArrayList) {
            for (Object obj2 : ((ArrayList) obj).toArray()) {
                if (obj2 instanceof Integer) {
                    arrayList.add((Integer) obj2);
                } else {
                    Log.w(TAG, "toIntegerList | Unexpected type in list");
                }
            }
        } else {
            Log.w(TAG, "toIntegerList | A list was expected");
        }
        return arrayList;
    }

    public static Long toLong(String str, Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        Log.w(TAG, "toLong | Long value expected for " + str);
        return null;
    }

    public static List<String> toStringList(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof ArrayList) {
            for (Object obj2 : ((ArrayList) obj).toArray()) {
                if (obj2 instanceof String) {
                    arrayList.add(obj2.toString());
                } else {
                    Log.w(TAG, "toStringList |  Unexpected type in list");
                }
            }
        } else {
            Log.w(TAG, "toStringList | A list was expected");
        }
        return arrayList;
    }
}
