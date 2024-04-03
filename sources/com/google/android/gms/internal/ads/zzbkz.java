package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

final class zzbkz extends zzblb<String> {
    public zzbkz(int i11, String str, String str2) {
        super(1, str, str2, (zzbla) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return jSONObject.optString(zzm(), (String) zzl());
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
            return (String) zzl();
        }
        String zzm2 = zzm();
        if (zzm2.length() != 0) {
            str2 = "com.google.android.gms.ads.flag.".concat(zzm2);
        } else {
            str2 = new String("com.google.android.gms.ads.flag.");
        }
        return bundle.getString(str2);
    }

    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(zzm(), (String) zzl());
    }

    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putString(zzm(), (String) obj);
    }
}
