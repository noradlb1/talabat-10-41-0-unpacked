package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

final class zzbkv extends zzblb<Boolean> {
    public zzbkv(int i11, String str, Boolean bool) {
        super(i11, str, bool, (zzbla) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(zzm(), ((Boolean) zzl()).booleanValue()));
    }

    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        String str;
        String str2;
        String zzm = zzm();
        if (zzm.length() != 0) {
            str = "com.google.android.gms.ads.flag.".concat(zzm);
        } else {
            str = new String("com.google.android.gms.ads.flag.");
        }
        if (!bundle.containsKey(str)) {
            return (Boolean) zzl();
        }
        String zzm2 = zzm();
        if (zzm2.length() != 0) {
            str2 = "com.google.android.gms.ads.flag.".concat(zzm2);
        } else {
            str2 = new String("com.google.android.gms.ads.flag.");
        }
        return Boolean.valueOf(bundle.getBoolean(str2));
    }

    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(zzm(), ((Boolean) zzl()).booleanValue()));
    }

    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putBoolean(zzm(), ((Boolean) obj).booleanValue());
    }
}
