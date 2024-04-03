package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcch;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzfwm;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nonnull;

final class zzs implements zzfwm<ArrayList<Uri>> {
    final /* synthetic */ zzcch zza;
    final /* synthetic */ zzv zzb;

    public zzs(zzv zzv, zzcch zzcch) {
        this.zzb = zzv;
        this.zza = zzcch;
    }

    public final void zza(Throwable th2) {
        String str;
        try {
            zzcch zzcch = this.zza;
            String valueOf = String.valueOf(th2.getMessage());
            if (valueOf.length() != 0) {
                str = "Internal error: ".concat(valueOf);
            } else {
                str = new String("Internal error: ");
            }
            zzcch.zze(str);
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzb.zzt) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (zzv.zzE(uri)) {
                        zzv zzv = this.zzb;
                        this.zzb.zzs.zzb(zzv.zzL(uri, zzv.zzC, "1").toString());
                    }
                }
            }
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }
}
