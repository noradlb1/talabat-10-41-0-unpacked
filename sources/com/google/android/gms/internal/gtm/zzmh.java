package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Map;

public final class zzmh extends zzhb {
    private final zzfj zzapc;
    private final zzcm zzasa;

    public zzmh(zzcm zzcm, zzfj zzfj) {
        this.zzasa = zzcm;
        this.zzapc = zzfj;
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzog zzog;
        Bundle bundle;
        String str;
        boolean z12 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 1 || zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        if (zzoaArr.length > 1) {
            zzog = zzoaArr[1];
        } else {
            zzog = zzog.zzaum;
        }
        zzog zzog2 = zzog.zzaum;
        if (zzog != zzog2 && !(zzog instanceof zzok)) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        zzee zzkt = this.zzapc.zzkt();
        String str2 = (String) zzoaArr[0].value();
        if (zzog != zzog2) {
            bundle = zzoo.zzk((Map<String, zzoa<?>>) (Map) ((zzok) zzog).value());
        } else {
            bundle = null;
        }
        try {
            this.zzasa.logEventInternalNoInterceptor(zzkt.zzkh(), str2, bundle, zzkt.currentTimeMillis());
        } catch (RemoteException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Error calling measurement proxy:".concat(valueOf);
            } else {
                str = new String("Error calling measurement proxy:");
            }
            zzev.zzav(str);
        }
        return zzog.zzaum;
    }
}
