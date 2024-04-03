package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzevk implements zzevn<zzevm<Bundle>> {
    private final zzfxb zza;
    private final Context zzb;

    public zzevk(zzfxb zzfxb, Context context) {
        this.zza = zzfxb;
        this.zzb = context;
    }

    public static Bundle zza(Context context, JSONArray jSONArray) {
        int i11;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i12);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            int optInt = optJSONObject.optInt("type", -1);
            if (optInt == 0) {
                i11 = 1;
            } else if (optInt == 1) {
                i11 = 2;
            } else if (optInt != 2) {
                i11 = 0;
            } else {
                i11 = 3;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i11 != 0) {
                String[] split = optString2.split("/");
                int length = split.length;
                Object obj = null;
                if (length <= 2 && length != 0) {
                    if (length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    int i13 = i11 - 1;
                    if (i13 != 0) {
                        if (i13 != 1) {
                            if (obj instanceof Boolean) {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(optString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(optString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(optString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(optString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    public final zzfxa<zzevm<Bundle>> zzb() {
        return this.zza.zzb(new zzevj(this));
    }

    public final /* synthetic */ zzevm zzc() throws Exception {
        String str = (String) zzbgq.zzc().zzb(zzblj.zzeA);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new zzevi(zza(this.zzb, new JSONArray(str)));
        } catch (JSONException e11) {
            zzciz.zzf("JSON parsing error", e11);
            return null;
        }
    }
}
