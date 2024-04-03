package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Iterator;

final class zzja {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Handler zzb;
    private final zziw zzc;
    private final AudioManager zzd;
    @Nullable
    private zziz zze;
    private int zzf = 3;
    private int zzg;
    private boolean zzh;

    public zzja(Context context, Handler handler, zziw zziw) {
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzb = handler;
        this.zzc = zziw;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        zzdy.zzb(audioManager);
        this.zzd = audioManager;
        this.zzg = zzg(audioManager, 3);
        this.zzh = zzi(audioManager, this.zzf);
        zziz zziz = new zziz(this, (zziy) null);
        try {
            applicationContext.registerReceiver(zziz, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.zze = zziz;
        } catch (RuntimeException e11) {
            zzep.zzb("StreamVolumeManager", "Error registering stream volume receiver", e11);
        }
    }

    private static int zzg(AudioManager audioManager, int i11) {
        try {
            return audioManager.getStreamVolume(i11);
        } catch (RuntimeException e11) {
            StringBuilder sb2 = new StringBuilder(60);
            sb2.append("Could not retrieve stream volume for stream type ");
            sb2.append(i11);
            zzep.zzb("StreamVolumeManager", sb2.toString(), e11);
            return audioManager.getStreamMaxVolume(i11);
        }
    }

    /* access modifiers changed from: private */
    public final void zzh() {
        int zzg2 = zzg(this.zzd, this.zzf);
        boolean zzi = zzi(this.zzd, this.zzf);
        if (this.zzg != zzg2 || this.zzh != zzi) {
            this.zzg = zzg2;
            this.zzh = zzi;
            Iterator it = ((zzir) this.zzc).zza.zzh.iterator();
            while (it.hasNext()) {
                ((zzbt) it.next()).zzr(zzg2, zzi);
            }
        }
    }

    private static boolean zzi(AudioManager audioManager, int i11) {
        if (zzfn.zza >= 23) {
            return audioManager.isStreamMute(i11);
        }
        if (zzg(audioManager, i11) == 0) {
            return true;
        }
        return false;
    }

    public final int zza() {
        return this.zzd.getStreamMaxVolume(this.zzf);
    }

    public final int zzb() {
        if (zzfn.zza >= 28) {
            return this.zzd.getStreamMinVolume(this.zzf);
        }
        return 0;
    }

    public final void zze() {
        zziz zziz = this.zze;
        if (zziz != null) {
            try {
                this.zza.unregisterReceiver(zziz);
            } catch (RuntimeException e11) {
                zzep.zzb("StreamVolumeManager", "Error unregistering stream volume receiver", e11);
            }
            this.zze = null;
        }
    }

    public final void zzf(int i11) {
        if (this.zzf != 3) {
            this.zzf = 3;
            zzh();
            zzir zzir = (zzir) this.zzc;
            zzo zzw = zziu.zzac(zzir.zza.zzl);
            if (!zzw.equals(zzir.zza.zzF)) {
                zzir.zza.zzF = zzw;
                Iterator it = zzir.zza.zzh.iterator();
                while (it.hasNext()) {
                    ((zzbt) it.next()).zzq(zzw);
                }
            }
        }
    }
}
