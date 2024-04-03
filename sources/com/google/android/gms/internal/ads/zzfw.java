package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;

final class zzfw {
    private final AudioManager zza;
    private final zzfu zzb;
    @Nullable
    private zzfv zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzfw(Context context, Handler handler, zzfv zzfv) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzfv;
        this.zzb = new zzfu(this, handler);
        this.zzd = 0;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzfw zzfw, int i11) {
        if (i11 == -3 || i11 == -2) {
            if (i11 != -2) {
                zzfw.zzg(3);
                return;
            }
            zzfw.zzf(0);
            zzfw.zzg(2);
        } else if (i11 == -1) {
            zzfw.zzf(-1);
            zzfw.zze();
        } else if (i11 != 1) {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Unknown focus change type: ");
            sb2.append(i11);
            Log.w("AudioFocusManager", sb2.toString());
        } else {
            zzfw.zzg(1);
            zzfw.zzf(1);
        }
    }

    private final void zze() {
        if (this.zzd != 0) {
            if (zzfn.zza < 26) {
                this.zza.abandonAudioFocus(this.zzb);
            }
            zzg(0);
        }
    }

    private final void zzf(int i11) {
        zzfv zzfv = this.zzc;
        if (zzfv != null) {
            zzir zzir = (zzir) zzfv;
            boolean zzaa = zzir.zza.zzaa();
            zzir.zza.zzah(zzaa, i11, zziu.zzab(zzaa, i11));
        }
    }

    private final void zzg(int i11) {
        if (this.zzd != i11) {
            this.zzd = i11;
            float f11 = i11 == 3 ? 0.2f : 1.0f;
            if (this.zze != f11) {
                this.zze = f11;
                zzfv zzfv = this.zzc;
                if (zzfv != null) {
                    ((zzir) zzfv).zza.zzaf();
                }
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z11, int i11) {
        zze();
        return z11 ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }
}
