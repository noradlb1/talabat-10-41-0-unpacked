package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

final class zzbkw extends zzblb<Integer> {
    public zzbkw(int i11, String str, Integer num) {
        super(1, str, num, (zzbla) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(zzm(), ((Integer) zzl()).intValue()));
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
            return (Integer) zzl();
        }
        String zzm2 = zzm();
        if (zzm2.length() != 0) {
            str2 = "com.google.android.gms.ads.flag.".concat(zzm2);
        } else {
            str2 = new String("com.google.android.gms.ads.flag.");
        }
        return Integer.valueOf(bundle.getInt(str2));
    }

    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(zzm(), ((Integer) zzl()).intValue()));
    }

    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putInt(zzm(), ((Integer) obj).intValue());
    }
}
