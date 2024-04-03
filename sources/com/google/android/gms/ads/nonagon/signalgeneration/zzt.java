package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcch;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzfwm;
import java.util.Collections;
import javax.annotation.Nonnull;

final class zzt implements zzfwm<Uri> {
    final /* synthetic */ zzcch zza;
    final /* synthetic */ zzv zzb;

    public zzt(zzv zzv, zzcch zzcch) {
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
        Uri uri = (Uri) obj;
        try {
            this.zzb.zzz.getAndIncrement();
            this.zza.zzf(Collections.singletonList(uri));
            if (this.zzb.zzu) {
                zzv zzv = this.zzb;
                this.zzb.zzs.zzb(zzv.zzL(uri, zzv.zzC, "1").toString());
            }
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }
}
