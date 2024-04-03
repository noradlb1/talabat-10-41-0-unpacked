package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

public final /* synthetic */ class zzaoc implements PackageManager.OnChecksumsReadyListener {
    public final /* synthetic */ zzfxi zza;

    public /* synthetic */ zzaoc(zzfxi zzfxi) {
        this.zza = zzfxi;
    }

    public final void onChecksumsReady(List list) {
        zzfxi zzfxi = this.zza;
        if (list == null) {
            zzfxi.zzs(null);
            return;
        }
        try {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                ApkChecksum apkChecksum = (ApkChecksum) list.get(i11);
                if (apkChecksum.getType() == 8) {
                    zzfxi.zzs(zzamv.zzc(apkChecksum.getValue()));
                    return;
                }
            }
            zzfxi.zzs(null);
        } catch (Throwable unused) {
            zzfxi.zzs(null);
        }
    }
}
