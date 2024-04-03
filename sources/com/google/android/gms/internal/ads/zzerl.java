package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.ads.internal.zzt;

public final class zzerl implements zzevn<zzerm> {
    private final zzfxb zza;
    private final Context zzb;

    public zzerl(zzfxb zzfxb, Context context) {
        this.zza = zzfxb;
        this.zzb = context;
    }

    public final /* synthetic */ zzerm zza() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        return new zzerm(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzt.zzr().zza(), zzt.zzr().zze());
    }

    public final zzfxa<zzerm> zzb() {
        return this.zza.zzb(new zzerk(this));
    }
}
