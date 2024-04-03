package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

final class zzbky extends zzblb<Float> {
    public zzbky(int i11, String str, Float f11) {
        super(1, str, f11, (zzbla) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(zzm(), (double) ((Float) zzl()).floatValue()));
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
            return (Float) zzl();
        }
        String zzm2 = zzm();
        if (zzm2.length() != 0) {
            str2 = "com.google.android.gms.ads.flag.".concat(zzm2);
        } else {
            str2 = new String("com.google.android.gms.ads.flag.");
        }
        return Float.valueOf(bundle.getFloat(str2));
    }

    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(zzm(), ((Float) zzl()).floatValue()));
    }

    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putFloat(zzm(), ((Float) obj).floatValue());
    }
}
