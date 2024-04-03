package com.google.android.gms.ads.internal.util;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzfds;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzby {
    public static final zzbx<Map<String, ?>> zza = new zzbw();

    public static Bundle zza(JSONObject jSONObject) {
        String str;
        String str2;
        Bundle bundle;
        String str3;
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        Bundle bundle2 = new Bundle();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null) {
                if (opt instanceof Boolean) {
                    bundle2.putBoolean(next, ((Boolean) opt).booleanValue());
                } else if (opt instanceof Double) {
                    bundle2.putDouble(next, ((Double) opt).doubleValue());
                } else if (opt instanceof Integer) {
                    bundle2.putInt(next, ((Integer) opt).intValue());
                } else if (opt instanceof Long) {
                    bundle2.putLong(next, ((Long) opt).longValue());
                } else if (opt instanceof String) {
                    bundle2.putString(next, (String) opt);
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (jSONArray.length() != 0) {
                        int length = jSONArray.length();
                        int i11 = 0;
                        Object obj = null;
                        int i12 = 0;
                        while (obj == null && i12 < length) {
                            if (!jSONArray.isNull(i12)) {
                                obj = jSONArray.opt(i12);
                            } else {
                                obj = null;
                            }
                            i12++;
                        }
                        if (obj == null) {
                            String valueOf = String.valueOf(next);
                            if (valueOf.length() != 0) {
                                str3 = "Expected JSONArray with at least 1 non-null element for key:".concat(valueOf);
                            } else {
                                str3 = new String("Expected JSONArray with at least 1 non-null element for key:");
                            }
                            zzciz.zzj(str3);
                        } else if (obj instanceof JSONObject) {
                            Bundle[] bundleArr = new Bundle[length];
                            while (i11 < length) {
                                if (!jSONArray.isNull(i11)) {
                                    bundle = zza(jSONArray.optJSONObject(i11));
                                } else {
                                    bundle = null;
                                }
                                bundleArr[i11] = bundle;
                                i11++;
                            }
                            bundle2.putParcelableArray(next, bundleArr);
                        } else if (obj instanceof Number) {
                            double[] dArr = new double[jSONArray.length()];
                            while (i11 < length) {
                                dArr[i11] = jSONArray.optDouble(i11);
                                i11++;
                            }
                            bundle2.putDoubleArray(next, dArr);
                        } else if (obj instanceof CharSequence) {
                            String[] strArr = new String[length];
                            while (i11 < length) {
                                if (!jSONArray.isNull(i11)) {
                                    str2 = jSONArray.optString(i11);
                                } else {
                                    str2 = null;
                                }
                                strArr[i11] = str2;
                                i11++;
                            }
                            bundle2.putStringArray(next, strArr);
                        } else if (obj instanceof Boolean) {
                            boolean[] zArr = new boolean[length];
                            while (i11 < length) {
                                zArr[i11] = jSONArray.optBoolean(i11);
                                i11++;
                            }
                            bundle2.putBooleanArray(next, zArr);
                        } else {
                            zzciz.zzj(String.format("JSONArray with unsupported type %s for key:%s", new Object[]{obj.getClass().getCanonicalName(), next}));
                        }
                    }
                } else if (opt instanceof JSONObject) {
                    bundle2.putBundle(next, zza((JSONObject) opt));
                } else {
                    String valueOf2 = String.valueOf(next);
                    if (valueOf2.length() != 0) {
                        str = "Unsupported type for key:".concat(valueOf2);
                    } else {
                        str = new String("Unsupported type for key:");
                    }
                    zzciz.zzj(str);
                }
            }
        }
        return bundle2;
    }

    public static String zzb(String str, JSONObject jSONObject, String... strArr) {
        JSONObject zzm = zzm(jSONObject, strArr);
        if (zzm == null) {
            return "";
        }
        return zzm.optString(strArr[0], "");
    }

    @NonNull
    public static List<String> zzc(@Nullable JSONArray jSONArray, @Nullable List<String> list) throws JSONException {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                list.add(jSONArray.getString(i11));
            }
        }
        return list;
    }

    public static List<String> zzd(JsonReader jsonReader) throws IllegalStateException, IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(jsonReader.nextString());
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static JSONArray zze(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException {
        JSONArray jSONArray = new JSONArray();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            JsonToken peek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(peek)) {
                jSONArray.put((Object) zze(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(peek)) {
                jSONArray.put((Object) zzh(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(peek)) {
                jSONArray.put(jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(peek)) {
                jSONArray.put(jsonReader.nextDouble());
            } else if (JsonToken.STRING.equals(peek)) {
                jSONArray.put((Object) jsonReader.nextString());
            } else {
                throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(peek)));
            }
        }
        jsonReader.endArray();
        return jSONArray;
    }

    public static JSONObject zzf(JSONObject jSONObject, String str) throws JSONException {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, (Object) jSONObject2);
            return jSONObject2;
        }
    }

    public static JSONObject zzg(JSONObject jSONObject, String... strArr) {
        JSONObject zzm = zzm(jSONObject, strArr);
        if (zzm == null) {
            return null;
        }
        return zzm.optJSONObject(strArr[1]);
    }

    public static JSONObject zzh(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException {
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            JsonToken peek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(peek)) {
                jSONObject.put(nextName, (Object) zze(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(peek)) {
                jSONObject.put(nextName, (Object) zzh(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(peek)) {
                jSONObject.put(nextName, jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(peek)) {
                jSONObject.put(nextName, jsonReader.nextDouble());
            } else if (JsonToken.STRING.equals(peek)) {
                jSONObject.put(nextName, (Object) jsonReader.nextString());
            } else {
                throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(peek)));
            }
        }
        jsonReader.endObject();
        return jSONObject;
    }

    public static void zzi(JsonWriter jsonWriter, JSONArray jSONArray) throws IOException {
        try {
            jsonWriter.beginArray();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                Object obj = jSONArray.get(i11);
                if (obj instanceof String) {
                    jsonWriter.value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    zzj(jsonWriter, (JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    zzi(jsonWriter, (JSONArray) obj);
                } else {
                    String valueOf = String.valueOf(obj);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
                    sb2.append("unable to write field: ");
                    sb2.append(valueOf);
                    throw new JSONException(sb2.toString());
                }
            }
            jsonWriter.endArray();
        } catch (JSONException e11) {
            throw new IOException(e11);
        }
    }

    public static void zzj(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
        try {
            jsonWriter.beginObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    jsonWriter.name(next).value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.name(next).value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.name(next).value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    zzj(jsonWriter.name(next), (JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    zzi(jsonWriter.name(next), (JSONArray) obj);
                } else {
                    String valueOf = String.valueOf(obj);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
                    sb2.append("unable to write field: ");
                    sb2.append(valueOf);
                    throw new JSONException(sb2.toString());
                }
            }
            jsonWriter.endObject();
        } catch (JSONException e11) {
            throw new IOException(e11);
        }
    }

    public static boolean zzk(boolean z11, JSONObject jSONObject, String... strArr) {
        JSONObject zzm = zzm(jSONObject, strArr);
        if (zzm == null) {
            return false;
        }
        return zzm.optBoolean(strArr[strArr.length - 1], false);
    }

    public static String zzl(zzfds zzfds) {
        if (zzfds == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            zzn(jsonWriter, zzfds);
            jsonWriter.close();
            return stringWriter.toString();
        } catch (IOException e11) {
            zzciz.zzh("Error when writing JSON.", e11);
            return null;
        }
    }

    private static JSONObject zzm(JSONObject jSONObject, String[] strArr) {
        for (int i11 = 0; i11 < strArr.length - 1; i11++) {
            if (jSONObject == null) {
                return null;
            }
            jSONObject = jSONObject.optJSONObject(strArr[i11]);
        }
        return jSONObject;
    }

    private static void zzn(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
        } else if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
        } else if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            jsonWriter.value((String) obj);
        } else if (obj instanceof zzfds) {
            zzj(jsonWriter, ((zzfds) obj).zzd);
        } else if (obj instanceof Map) {
            jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    zzn(jsonWriter.name((String) key), entry.getValue());
                }
            }
            jsonWriter.endObject();
        } else if (obj instanceof List) {
            jsonWriter.beginArray();
            for (Object zzn : (List) obj) {
                zzn(jsonWriter, zzn);
            }
            jsonWriter.endArray();
        } else {
            jsonWriter.nullValue();
        }
    }
}
