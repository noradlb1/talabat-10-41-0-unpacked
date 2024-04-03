package com.huawei.location.utils;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.util.SafeBase64;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class yn {
    public static String Vw(IMessageEntity iMessageEntity) {
        String str;
        Class cls = iMessageEntity.getClass();
        JSONObject jSONObject = new JSONObject();
        while (cls != null) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        boolean isAccessible = field.isAccessible();
                        field.setAccessible(true);
                        String name2 = field.getName();
                        Object obj = field.get(iMessageEntity);
                        field.setAccessible(isAccessible);
                        yn(name2, obj, jSONObject);
                    }
                }
                cls = cls.getSuperclass();
            } catch (SecurityException unused) {
                str = "catch SecurityException";
                LogConsole.e("JsonUtil", str);
                return JSONObjectInstrumentation.toString(jSONObject);
            } catch (IllegalAccessException unused2) {
                str = "catch IllegalAccessException";
                LogConsole.e("JsonUtil", str);
                return JSONObjectInstrumentation.toString(jSONObject);
            } catch (JSONException unused3) {
                str = "catch JSONException";
                LogConsole.e("JsonUtil", str);
                return JSONObjectInstrumentation.toString(jSONObject);
            }
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    private static Map Vw(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString("_map_"));
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < jSONArray.length(); i11 += 2) {
            Object newInstance = cls.newInstance();
            if (newInstance instanceof IMessageEntity) {
                hashMap.put(jSONArray.get(i11), yn(jSONArray.getString(i11 + 1), (IMessageEntity) newInstance));
            } else {
                hashMap.put(jSONArray.get(i11), jSONArray.get(i11 + 1));
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.core.aidl.IMessageEntity yn(java.lang.String r8, com.huawei.hms.core.aidl.IMessageEntity r9) {
        /*
            java.lang.String r0 = "JsonUtil"
            java.lang.Class r1 = r9.getClass()     // Catch:{ Exception -> 0x0043 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0043 }
            r2.<init>((java.lang.String) r8)     // Catch:{ Exception -> 0x0043 }
        L_0x000b:
            if (r1 == 0) goto L_0x0048
            java.lang.reflect.Field[] r8 = r1.getDeclaredFields()     // Catch:{ Exception -> 0x0043 }
            int r3 = r8.length     // Catch:{ Exception -> 0x0043 }
            r4 = 0
        L_0x0013:
            if (r4 >= r3) goto L_0x003e
            r5 = r8[r4]     // Catch:{ Exception -> 0x0043 }
            java.lang.Class<com.huawei.hms.core.aidl.annotation.Packed> r6 = com.huawei.hms.core.aidl.annotation.Packed.class
            boolean r6 = r5.isAnnotationPresent(r6)     // Catch:{ Exception -> 0x0043 }
            if (r6 == 0) goto L_0x003b
            yn((com.huawei.hms.core.aidl.IMessageEntity) r9, (java.lang.reflect.Field) r5, (org.json.JSONObject) r2)     // Catch:{ IllegalAccessException -> 0x0023 }
            goto L_0x003b
        L_0x0023:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0043 }
            r6.<init>()     // Catch:{ Exception -> 0x0043 }
            java.lang.String r7 = "jsonToEntity, set value of the field exception, field name:"
            r6.append(r7)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0043 }
            r6.append(r5)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0043 }
            com.huawei.location.lite.common.log.LogConsole.e(r0, r5)     // Catch:{ Exception -> 0x0043 }
        L_0x003b:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x003e:
            java.lang.Class r1 = r1.getSuperclass()     // Catch:{ Exception -> 0x0043 }
            goto L_0x000b
        L_0x0043:
            java.lang.String r8 = "catch Exception when parse jsonString"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r8)
        L_0x0048:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.utils.yn.yn(java.lang.String, com.huawei.hms.core.aidl.IMessageEntity):com.huawei.hms.core.aidl.IMessageEntity");
    }

    private static String yn(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Class cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean isAccessible = field.isAccessible();
                    field.setAccessible(true);
                    String name2 = field.getName();
                    Object obj = field.get(iMessageEntity);
                    field.setAccessible(isAccessible);
                    yn(name2, obj, jSONObject);
                }
            }
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    private static List<Object> yn(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i11 = jSONObject.getInt("_list_size_");
        int i12 = jSONObject.getInt("_val_type_");
        ArrayList arrayList = new ArrayList(i11);
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = jSONObject.get("_list_item_" + i13);
            if (i12 == 0 && (type instanceof ParameterizedType)) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    Object newInstance = ((Class) type2).newInstance();
                    if ((newInstance instanceof IMessageEntity) && (obj instanceof String)) {
                        obj = yn((String) obj, (IMessageEntity) newInstance);
                    }
                }
            } else if (i12 != 1) {
                LogConsole.d("JsonUtil", "readList");
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    private static boolean yn(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        if (!(obj instanceof String)) {
            if (obj instanceof Integer) {
                jSONObject.put(str, ((Integer) obj).intValue());
            } else if (!(obj instanceof Short) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Boolean) && !(obj instanceof JSONObject)) {
                if (obj instanceof byte[]) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("_val_type_", 2);
                    jSONObject2.put("_byte_", (Object) SafeBase64.encode((byte[]) obj, 2));
                    jSONObject.put(str, (Object) jSONObject2);
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("_val_type_", 1);
                    jSONObject3.put("_list_size_", list.size());
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        yn("_list_item_" + i11, list.get(i11), jSONObject3);
                        if (list.get(i11) instanceof IMessageEntity) {
                            jSONObject3.put("_val_type_", 0);
                        }
                    }
                    jSONObject.put(str, (Object) jSONObject3);
                } else if (obj instanceof Map) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object next : ((Map) obj).entrySet()) {
                        if (next instanceof Map.Entry) {
                            Object key = ((Map.Entry) next).getKey();
                            if (key instanceof IMessageEntity) {
                                key = yn((IMessageEntity) key);
                            }
                            jSONArray.put(key);
                        }
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("_val_type_", 3);
                    jSONObject4.put("_map_", (Object) JSONArrayInstrumentation.toString(jSONArray));
                    jSONObject.put(str, (Object) jSONObject4);
                } else {
                    if (obj instanceof IMessageEntity) {
                        try {
                            jSONObject.put(str, (Object) yn((IMessageEntity) obj));
                        } catch (IllegalAccessException unused) {
                            LogConsole.e("JsonUtil", "IllegalAccessException ");
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        jSONObject.put(str, obj);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[SYNTHETIC, Splitter:B:15:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void yn(com.huawei.hms.core.aidl.IMessageEntity r6, java.lang.reflect.Field r7, org.json.JSONObject r8) throws org.json.JSONException, java.lang.IllegalAccessException {
        /*
            java.lang.String r0 = "_val_type_"
            java.lang.String r1 = "JsonUtil"
            java.lang.String r2 = r7.getName()
            boolean r3 = r8.has(r2)
            r4 = 0
            if (r3 == 0) goto L_0x0014
        L_0x000f:
            java.lang.Object r8 = r8.get(r2)
            goto L_0x003f
        L_0x0014:
            java.lang.String r3 = "header"
            boolean r5 = r8.has(r3)
            if (r5 == 0) goto L_0x002b
            org.json.JSONObject r5 = r8.getJSONObject(r3)
            boolean r5 = r5.has(r2)
            if (r5 == 0) goto L_0x002b
        L_0x0026:
            org.json.JSONObject r8 = r8.getJSONObject(r3)
            goto L_0x000f
        L_0x002b:
            java.lang.String r3 = "body"
            boolean r5 = r8.has(r3)
            if (r5 == 0) goto L_0x003e
            org.json.JSONObject r5 = r8.getJSONObject(r3)
            boolean r5 = r5.has(r2)
            if (r5 == 0) goto L_0x003e
            goto L_0x0026
        L_0x003e:
            r8 = r4
        L_0x003f:
            r2 = 1
            if (r8 == 0) goto L_0x00d1
            java.lang.Class r3 = r7.getType()     // Catch:{ InstantiationException -> 0x00cc }
            java.lang.String r3 = r3.getName()     // Catch:{ InstantiationException -> 0x00cc }
            java.lang.String r5 = "com.huawei"
            boolean r3 = r3.startsWith(r5)     // Catch:{ InstantiationException -> 0x00cc }
            if (r3 == 0) goto L_0x0073
            java.lang.Class r3 = r7.getType()     // Catch:{ InstantiationException -> 0x00cc }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ InstantiationException -> 0x00cc }
            boolean r3 = r3 instanceof com.huawei.hms.core.aidl.IMessageEntity     // Catch:{ InstantiationException -> 0x00cc }
            if (r3 == 0) goto L_0x0073
            boolean r3 = r8 instanceof java.lang.String     // Catch:{ InstantiationException -> 0x00cc }
            if (r3 == 0) goto L_0x0073
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ InstantiationException -> 0x00cc }
            java.lang.Class r0 = r7.getType()     // Catch:{ InstantiationException -> 0x00cc }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ InstantiationException -> 0x00cc }
            com.huawei.hms.core.aidl.IMessageEntity r0 = (com.huawei.hms.core.aidl.IMessageEntity) r0     // Catch:{ InstantiationException -> 0x00cc }
            com.huawei.hms.core.aidl.IMessageEntity r4 = yn((java.lang.String) r8, (com.huawei.hms.core.aidl.IMessageEntity) r0)     // Catch:{ InstantiationException -> 0x00cc }
            goto L_0x00d1
        L_0x0073:
            boolean r3 = r8 instanceof org.json.JSONObject     // Catch:{ InstantiationException -> 0x00cc }
            if (r3 == 0) goto L_0x00ca
            r3 = r8
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ InstantiationException -> 0x00cc }
            boolean r3 = r3.has(r0)     // Catch:{ InstantiationException -> 0x00cc }
            if (r3 == 0) goto L_0x00ca
            r3 = r8
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ InstantiationException -> 0x00cc }
            int r0 = r3.getInt(r0)     // Catch:{ InstantiationException -> 0x00cc }
            if (r0 == r2) goto L_0x00bf
            if (r0 != 0) goto L_0x008c
            goto L_0x00bf
        L_0x008c:
            r3 = 2
            if (r0 != r3) goto L_0x009c
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ InstantiationException -> 0x00cc }
            java.lang.String r0 = "_byte_"
            java.lang.String r8 = r8.getString(r0)     // Catch:{ InstantiationException -> 0x00cc }
            byte[] r4 = com.huawei.secure.android.common.util.SafeBase64.decode((java.lang.String) r8, (int) r3)     // Catch:{ InstantiationException -> 0x00cc }
            goto L_0x00d1
        L_0x009c:
            r3 = 3
            if (r0 != r3) goto L_0x00aa
            java.lang.reflect.Type r0 = r7.getGenericType()     // Catch:{ InstantiationException -> 0x00cc }
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ InstantiationException -> 0x00cc }
            java.util.Map r4 = Vw(r0, r8)     // Catch:{ InstantiationException -> 0x00cc }
            goto L_0x00d1
        L_0x00aa:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ InstantiationException -> 0x00cc }
            r8.<init>()     // Catch:{ InstantiationException -> 0x00cc }
            java.lang.String r3 = "cannot support type : "
            r8.append(r3)     // Catch:{ InstantiationException -> 0x00cc }
            r8.append(r0)     // Catch:{ InstantiationException -> 0x00cc }
            java.lang.String r8 = r8.toString()     // Catch:{ InstantiationException -> 0x00cc }
            com.huawei.location.lite.common.log.LogConsole.e(r1, r8)     // Catch:{ InstantiationException -> 0x00cc }
            goto L_0x00d1
        L_0x00bf:
            java.lang.reflect.Type r0 = r7.getGenericType()     // Catch:{ InstantiationException -> 0x00cc }
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ InstantiationException -> 0x00cc }
            java.util.List r4 = yn((java.lang.reflect.Type) r0, (org.json.JSONObject) r8)     // Catch:{ InstantiationException -> 0x00cc }
            goto L_0x00d1
        L_0x00ca:
            r4 = r8
            goto L_0x00d1
        L_0x00cc:
            java.lang.String r8 = "catch InstantiationException"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r8)
        L_0x00d1:
            if (r4 == 0) goto L_0x00e0
            boolean r8 = r7.isAccessible()
            r7.setAccessible(r2)
            r7.set(r6, r4)
            r7.setAccessible(r8)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.utils.yn.yn(com.huawei.hms.core.aidl.IMessageEntity, java.lang.reflect.Field, org.json.JSONObject):void");
    }
}
