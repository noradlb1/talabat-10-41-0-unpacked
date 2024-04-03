package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzchm {
    @GuardedBy("this")
    private final Map<String, zzchl> zza = new HashMap();
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public final List<zzchk> zzb = new ArrayList();
    private final Context zzc;
    private final zzcgk zzd;

    public zzchm(Context context, zzcgk zzcgk) {
        this.zzc = context;
        this.zzd = zzcgk;
    }

    public final /* synthetic */ void zzb(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zze();
        }
    }

    public final synchronized void zzc(String str) {
        SharedPreferences sharedPreferences;
        if (!this.zza.containsKey(str)) {
            if ("__default__".equals(str)) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzc);
            } else {
                sharedPreferences = this.zzc.getSharedPreferences(str, 0);
            }
            zzchl zzchl = new zzchl(this, str);
            this.zza.put(str, zzchl);
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzchl);
        }
    }

    public final synchronized void zzd(zzchk zzchk) {
        this.zzb.add(zzchk);
    }
}
