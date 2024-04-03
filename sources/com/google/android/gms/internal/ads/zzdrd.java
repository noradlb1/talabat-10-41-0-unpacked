package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.Map;

public final /* synthetic */ class zzdrd implements zzbrt {
    public final /* synthetic */ zzdre zza;
    public final /* synthetic */ zzbqc zzb;

    public /* synthetic */ zzdrd(zzdre zzdre, zzbqc zzbqc) {
        this.zza = zzdre;
        this.zzb = zzbqc;
    }

    public final void zza(Object obj, Map map) {
        zzdre zzdre = this.zza;
        zzbqc zzbqc = this.zzb;
        try {
            zzdre.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzciz.zzg("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzdre.zza = (String) map.get("id");
        String str = (String) map.get(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ID);
        if (zzbqc == null) {
            zzciz.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzbqc.zzf(str);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
