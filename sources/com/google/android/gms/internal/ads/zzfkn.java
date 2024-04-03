package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.google.android.exoplayer2.util.MimeTypes;

public final class zzfkn extends ContentObserver {
    private final Context zza;
    private final AudioManager zzb;
    private final zzfkl zzc;
    private float zzd;
    private final zzfkw zze;

    public zzfkn(Handler handler, Context context, zzfkl zzfkl, zzfkw zzfkw, byte[] bArr) {
        super(handler);
        this.zza = context;
        this.zzb = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.zzc = zzfkl;
        this.zze = zzfkw;
    }

    private final float zzc() {
        int streamVolume = this.zzb.getStreamVolume(3);
        int streamMaxVolume = this.zzb.getStreamMaxVolume(3);
        float f11 = 0.0f;
        if (streamMaxVolume > 0 && streamVolume > 0) {
            float f12 = ((float) streamVolume) / ((float) streamMaxVolume);
            f11 = 1.0f;
            if (f12 > 1.0f) {
                return f11;
            }
            return f12;
        }
        return f11;
    }

    private final void zzd() {
        this.zze.zzd(this.zzd);
    }

    public final void onChange(boolean z11) {
        super.onChange(z11);
        float zzc2 = zzc();
        if (zzc2 != this.zzd) {
            this.zzd = zzc2;
            zzd();
        }
    }

    public final void zza() {
        this.zzd = zzc();
        zzd();
        this.zza.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void zzb() {
        this.zza.getContentResolver().unregisterContentObserver(this);
    }
}
