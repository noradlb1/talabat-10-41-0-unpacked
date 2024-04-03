package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;

public final class zzaf {
    private boolean zza = false;
    private float zzb = 1.0f;

    public static float zzb(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return ((float) streamVolume) / ((float) streamMaxVolume);
    }

    private final synchronized boolean zzf() {
        return this.zzb >= 0.0f;
    }

    public final synchronized float zza() {
        if (!zzf()) {
            return 1.0f;
        }
        return this.zzb;
    }

    public final synchronized void zzc(boolean z11) {
        this.zza = z11;
    }

    public final synchronized void zzd(float f11) {
        this.zzb = f11;
    }

    public final synchronized boolean zze() {
        return this.zza;
    }
}
