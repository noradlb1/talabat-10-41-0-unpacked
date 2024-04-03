package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzbj;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.TimeUnit;

public final class zzcli {
    private final Context zza;
    private final String zzb;
    private final zzcjf zzc;
    @Nullable
    private final zzblv zzd;
    @Nullable
    private final zzbly zze;
    private final zzbj zzf;
    private final long[] zzg;
    private final String[] zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm;
    private zzcko zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq = -1;

    public zzcli(Context context, zzcjf zzcjf, String str, @Nullable zzbly zzbly, @Nullable zzblv zzblv) {
        zzbh zzbh = new zzbh();
        zzbh zzbh2 = zzbh;
        zzbh2.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbh2.zza("1_5", 1.0d, 5.0d);
        zzbh2.zza("5_10", 5.0d, 10.0d);
        zzbh2.zza("10_20", 10.0d, 20.0d);
        zzbh2.zza("20_30", 20.0d, 30.0d);
        zzbh2.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzf = zzbh.zzb();
        this.zza = context;
        this.zzc = zzcjf;
        this.zzb = str;
        this.zze = zzbly;
        this.zzd = zzblv;
        String str2 = (String) zzbgq.zzc().zzb(zzblj.zzv);
        if (str2 == null) {
            this.zzh = new String[0];
            this.zzg = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzh = new String[length];
        this.zzg = new long[length];
        for (int i11 = 0; i11 < split.length; i11++) {
            try {
                this.zzg[i11] = Long.parseLong(split[i11]);
            } catch (NumberFormatException e11) {
                zzciz.zzk("Unable to parse frame hash target time number.", e11);
                this.zzg[i11] = -1;
            }
        }
    }

    public final void zza(zzcko zzcko) {
        zzblq.zza(this.zze, this.zzd, "vpc2");
        this.zzi = true;
        this.zze.zzd("vpn", zzcko.zzj());
        this.zzn = zzcko;
    }

    public final void zzb() {
        if (this.zzi && !this.zzj) {
            zzblq.zza(this.zze, this.zzd, "vfr2");
            this.zzj = true;
        }
    }

    public final void zzc() {
        this.zzm = true;
        if (this.zzj && !this.zzk) {
            zzblq.zza(this.zze, this.zzd, "vfp2");
            this.zzk = true;
        }
    }

    public final void zzd() {
        String str;
        String str2;
        if (zzbnk.zza.zze().booleanValue() && !this.zzo) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzb);
            bundle.putString("player", this.zzn.zzj());
            for (zzbg next : this.zzf.zza()) {
                String valueOf = String.valueOf(next.zza);
                if (valueOf.length() != 0) {
                    str = "fps_c_".concat(valueOf);
                } else {
                    str = new String("fps_c_");
                }
                bundle.putString(str, Integer.toString(next.zze));
                String valueOf2 = String.valueOf(next.zza);
                if (valueOf2.length() != 0) {
                    str2 = "fps_p_".concat(valueOf2);
                } else {
                    str2 = new String("fps_p_");
                }
                bundle.putString(str2, Double.toString(next.zzd));
            }
            int i11 = 0;
            while (true) {
                long[] jArr = this.zzg;
                if (i11 < jArr.length) {
                    String str3 = this.zzh[i11];
                    if (str3 != null) {
                        bundle.putString("fh_".concat(Long.valueOf(jArr[i11]).toString()), str3);
                    }
                    i11++;
                } else {
                    zzt.zzp().zzn(this.zza, this.zzc.zza, "gmob-apps", bundle, true);
                    this.zzo = true;
                    return;
                }
            }
        }
    }

    public final void zze() {
        this.zzm = false;
    }

    public final void zzf(zzcko zzcko) {
        long j11;
        if (this.zzk && !this.zzl) {
            if (zze.zzc() && !this.zzl) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzblq.zza(this.zze, this.zzd, "vff2");
            this.zzl = true;
        }
        long nanoTime = zzt.zzA().nanoTime();
        if (this.zzm && this.zzp && this.zzq != -1) {
            this.zzf.zzb(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzq)));
        }
        this.zzp = this.zzm;
        this.zzq = nanoTime;
        long longValue = ((Long) zzbgq.zzc().zzb(zzblj.zzw)).longValue();
        long zza2 = (long) zzcko.zza();
        int i11 = 0;
        while (true) {
            String[] strArr = this.zzh;
            if (i11 >= strArr.length) {
                return;
            }
            if (strArr[i11] == null && longValue > Math.abs(zza2 - this.zzg[i11])) {
                String[] strArr2 = this.zzh;
                int i12 = 8;
                Bitmap bitmap = zzcko.getBitmap(8, 8);
                long j12 = 63;
                int i13 = 0;
                long j13 = 0;
                while (i13 < i12) {
                    int i14 = 0;
                    while (i14 < i12) {
                        int pixel = bitmap.getPixel(i14, i13);
                        if (Color.blue(pixel) + Color.red(pixel) + Color.green(pixel) > 128) {
                            j11 = 1;
                        } else {
                            j11 = 0;
                        }
                        j13 |= j11 << ((int) j12);
                        i14++;
                        j12--;
                        i12 = 8;
                    }
                    i13++;
                    i12 = 8;
                }
                strArr2[i11] = String.format("%016X", new Object[]{Long.valueOf(j13)});
                return;
            }
            zzcko zzcko2 = zzcko;
            i11++;
        }
    }
}
