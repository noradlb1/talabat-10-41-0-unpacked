package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

final class zzchl implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzchm zza;
    private final String zzb;

    public zzchl(zzchm zzchm, String str) {
        this.zza = zzchm;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzchk zzchk : this.zza.zzb) {
                zzchk.zza.zzb(zzchk.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
