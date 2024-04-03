package com.google.android.gms.internal.vision;

import android.content.SharedPreferences;

final /* synthetic */ class zzbm implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzbj zzha;

    public zzbm(zzbj zzbj) {
        this.zzha = zzbj;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zzha.zza(sharedPreferences, str);
    }
}
