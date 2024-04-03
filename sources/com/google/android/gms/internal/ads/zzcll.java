package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;

@TargetApi(14)
public final class zzcll implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager zza;
    private final zzclk zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private float zzf = 1.0f;

    public zzcll(Context context, zzclk zzclk) {
        this.zza = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.zzb = zzclk;
    }

    private final void zzf() {
        boolean z11 = false;
        if (!this.zzd || this.zze || this.zzf <= 0.0f) {
            if (this.zzc) {
                AudioManager audioManager = this.zza;
                if (audioManager != null) {
                    if (audioManager.abandonAudioFocus(this) == 0) {
                        z11 = true;
                    }
                    this.zzc = z11;
                }
                this.zzb.zzn();
            }
        } else if (!this.zzc) {
            AudioManager audioManager2 = this.zza;
            if (audioManager2 != null) {
                if (audioManager2.requestAudioFocus(this, 3, 2) == 1) {
                    z11 = true;
                }
                this.zzc = z11;
            }
            this.zzb.zzn();
        }
    }

    public final void onAudioFocusChange(int i11) {
        this.zzc = i11 > 0;
        this.zzb.zzn();
    }

    public final float zza() {
        float f11 = this.zze ? 0.0f : this.zzf;
        if (this.zzc) {
            return f11;
        }
        return 0.0f;
    }

    public final void zzb() {
        this.zzd = true;
        zzf();
    }

    public final void zzc() {
        this.zzd = false;
        zzf();
    }

    public final void zzd(boolean z11) {
        this.zze = z11;
        zzf();
    }

    public final void zze(float f11) {
        this.zzf = f11;
        zzf();
    }
}
