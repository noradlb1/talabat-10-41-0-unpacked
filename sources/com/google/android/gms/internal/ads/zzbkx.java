package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

final class zzbkx extends zzblb<Long> {
    public zzbkx(int i11, String str, Long l11) {
        super(1, str, l11, (zzbla) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(zzm(), ((Long) zzl()).longValue()));
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
            return (Long) zzl();
        }
        String zzm2 = zzm();
        if (zzm2.length() != 0) {
            str2 = "com.google.android.gms.ads.flag.".concat(zzm2);
        } else {
            str2 = new String("com.google.android.gms.ads.flag.");
        }
        return Long.valueOf(bundle.getLong(str2));
    }

    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(zzm(), ((Long) zzl()).longValue()));
    }

    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putLong(zzm(), ((Long) obj).longValue());
    }
}
