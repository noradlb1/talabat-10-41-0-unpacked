package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.security.CertificateUtil;

final class zzeq implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzet zzf;

    public zzeq(zzet zzet, int i11, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzet;
        this.zza = i11;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzfi zzm = this.zzf.zzt.zzm();
        if (zzm.zzy()) {
            zzet zzet = this.zzf;
            if (zzet.zza == 0) {
                if (zzet.zzt.zzf().zzy()) {
                    zzet zzet2 = this.zzf;
                    zzet2.zzt.zzay();
                    zzet2.zza = 'C';
                } else {
                    zzet zzet3 = this.zzf;
                    zzet3.zzt.zzay();
                    zzet3.zza = 'c';
                }
            }
            zzet zzet4 = this.zzf;
            if (zzet4.zzb < 0) {
                zzet4.zzt.zzf().zzh();
                zzet4.zzb = 79000;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzet zzet5 = this.zzf;
            String str = ExifInterface.GPS_MEASUREMENT_2D + charAt + zzet5.zza + zzet5.zzb + CertificateUtil.DELIMITER + zzet.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            if (str.length() > 1024) {
                str = this.zzb.substring(0, 1024);
            }
            zzfg zzfg = zzm.zzb;
            if (zzfg != null) {
                zzfg.zzb(str, 1);
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzr(), "Persisted config not initialized. Not logging error/warn");
    }
}
