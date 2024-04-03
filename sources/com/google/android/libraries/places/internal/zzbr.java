package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.libraries.places.internal.zzcz;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

abstract class zzbr<TypeT, RequestT extends zzcz> extends zzam<TypeT, RequestT> {
    @Nullable
    private final Locale zza;
    private final String zzb;
    private final zzdl zzc;

    public zzbr(RequestT requestt, @Nullable Locale locale, String str, boolean z11, zzdl zzdl) {
        super(requestt);
        this.zza = locale;
        this.zzb = str;
        this.zzc = zzdl;
    }

    public static void zzg(Map<String, String> map, String str, @Nullable Object obj, @Nullable Object obj2) {
        String str2;
        if (obj != null) {
            str2 = obj.toString();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public final String zzc() {
        zzcd zzcd = new zzcd(zze(), this.zzb);
        zzcd.zza(this.zza);
        zzcd.zzb(zzf());
        return zzcd.zzc();
    }

    public final Map<String, String> zzd() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.zzc.zza());
        hashMap.put("X-Places-Android-Sdk", new String("2.5.0"));
        return hashMap;
    }

    public abstract String zze();

    public abstract Map<String, String> zzf();
}
