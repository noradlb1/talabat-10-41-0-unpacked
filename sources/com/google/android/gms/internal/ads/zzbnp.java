package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

public final class zzbnp {
    private final Context zza;

    public zzbnp(Context context) {
        this.zza = context;
    }

    public final void zza(zzcda zzcda) {
        String str;
        String str2;
        try {
            ((zzbnq) zzcjd.zzb(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", zzbno.zza)).zze(zzcda);
        } catch (zzcjc e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(valueOf);
            } else {
                str = new String("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:");
            }
            zzciz.zzj(str);
        } catch (RemoteException e12) {
            String valueOf2 = String.valueOf(e12.getMessage());
            if (valueOf2.length() != 0) {
                str2 = "Error calling setFlagsAccessedBeforeInitializedListener: ".concat(valueOf2);
            } else {
                str2 = new String("Error calling setFlagsAccessedBeforeInitializedListener: ");
            }
            zzciz.zzj(str2);
        }
    }
}
