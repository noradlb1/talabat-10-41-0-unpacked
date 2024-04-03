package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzflg {
    static float zza = Resources.getSystem().getDisplayMetrics().density;
    private static WindowManager zzb;
    private static final String[] zzc = {Param.X, Param.Y, "width", "height"};

    public static JSONObject zza(int i11, int i12, int i13, int i14) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Param.X, (double) (((float) i11) / zza));
            jSONObject.put(Param.Y, (double) (((float) i12) / zza));
            jSONObject.put("width", (double) (((float) i13) / zza));
            jSONObject.put("height", (double) (((float) i14) / zza));
        } catch (JSONException e11) {
            zzflh.zza("Error with creating viewStateObject", e11);
        }
        return jSONObject;
    }

    public static void zzb(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", (Object) str);
        } catch (JSONException e11) {
            zzflh.zza("Error with setting ad session id", e11);
        }
    }

    public static void zzc(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", (Object) optJSONArray);
            }
            optJSONArray.put((Object) jSONObject2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static void zzd(JSONObject jSONObject, zzflk zzflk) {
        zzfks zza2 = zzflk.zza();
        JSONArray jSONArray = new JSONArray();
        ArrayList<String> zzb2 = zzflk.zzb();
        int size = zzb2.size();
        for (int i11 = 0; i11 < size; i11++) {
            jSONArray.put((Object) zzb2.get(i11));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", (Object) jSONArray);
            jSONObject.put("friendlyObstructionClass", (Object) zza2.zzd());
            jSONObject.put("friendlyObstructionPurpose", (Object) zza2.zza());
            jSONObject.put("friendlyObstructionReason", (Object) zza2.zzc());
        } catch (JSONException e11) {
            zzflh.zza("Error with setting friendly obstruction", e11);
        }
    }

    public static void zze(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", (Object) str);
        } catch (JSONException e11) {
            zzflh.zza("Error with setting not visible reason", e11);
        }
    }

    public static void zzf(Context context) {
        if (context != null) {
            zza = context.getResources().getDisplayMetrics().density;
            zzb = (WindowManager) context.getSystemService("window");
        }
    }

    public static void zzg(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e11) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 47);
            sb2.append("JSONException during JSONObject.put for name [");
            sb2.append(str);
            sb2.append("]");
            zzflh.zza(sb2.toString(), e11);
        }
    }

    public static void zzh(JSONObject jSONObject) {
        float f11;
        float f12;
        if (zzb != null) {
            Point point = new Point(0, 0);
            zzb.getDefaultDisplay().getRealSize(point);
            float f13 = zza;
            f11 = ((float) point.x) / f13;
            f12 = ((float) point.y) / f13;
        } else {
            f11 = 0.0f;
            f12 = 0.0f;
        }
        try {
            jSONObject.put("width", (double) f11);
            jSONObject.put("height", (double) f12);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static boolean zzi(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject != null && jSONObject2 != null) {
            String[] strArr = zzc;
            int i11 = 0;
            while (true) {
                if (i11 < 4) {
                    String str = strArr[i11];
                    if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                        break;
                    }
                    i11++;
                } else if (jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""))) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
                    if (optJSONArray != null || optJSONArray2 != null) {
                        if (zzj(optJSONArray, optJSONArray2)) {
                            int i12 = 0;
                            while (true) {
                                if (i12 < optJSONArray.length()) {
                                    if (!optJSONArray.optString(i12, "").equals(optJSONArray2.optString(i12, ""))) {
                                        break;
                                    }
                                    i12++;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("childViews");
                    JSONArray optJSONArray4 = jSONObject2.optJSONArray("childViews");
                    if (!(optJSONArray3 == null && optJSONArray4 == null)) {
                        if (zzj(optJSONArray3, optJSONArray4)) {
                            int i13 = 0;
                            while (i13 < optJSONArray3.length()) {
                                if (zzi(optJSONArray3.optJSONObject(i13), optJSONArray4.optJSONObject(i13))) {
                                    i13++;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzj(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
