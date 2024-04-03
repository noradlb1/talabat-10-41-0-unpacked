package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzesj implements Callable {
    public final /* synthetic */ zzesk zza;

    public /* synthetic */ zzesj(zzesk zzesk) {
        this.zza = zzesk;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzt.zzp();
        zzayz zzf = zzt.zzo().zzh().zzf();
        Bundle bundle = null;
        if (zzf != null && (!zzt.zzo().zzh().zzI() || !zzt.zzo().zzh().zzJ())) {
            if (zzf.zzh()) {
                zzf.zzg();
            }
            zzayp zza2 = zzf.zza();
            if (zza2 != null) {
                str2 = zza2.zzd();
                str = zza2.zze();
                str3 = zza2.zzf();
                if (str2 != null) {
                    zzt.zzo().zzh().zzu(str2);
                }
                if (str3 != null) {
                    zzt.zzo().zzh().zzw(str3);
                }
            } else {
                str2 = zzt.zzo().zzh().zzi();
                str3 = zzt.zzo().zzh().zzj();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzt.zzo().zzh().zzJ()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzt.zzo().zzh().zzI()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzesl(bundle);
    }
}
