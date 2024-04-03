package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcex extends zzaoj implements zzcez {
    public zzcex(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final Bundle zzb() throws RemoteException {
        Parcel zzbs = zzbs(9, zza());
        Bundle bundle = (Bundle) zzaol.zza(zzbs, Bundle.CREATOR);
        zzbs.recycle();
        return bundle;
    }

    public final zzbiw zzc() throws RemoteException {
        Parcel zzbs = zzbs(12, zza());
        zzbiw zzb = zzbiv.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzcew zzd() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 11
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzcew
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzcew r1 = (com.google.android.gms.internal.ads.zzcew) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzceu r2 = new com.google.android.gms.internal.ads.zzceu
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcex.zzd():com.google.android.gms.internal.ads.zzcew");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final void zzf(zzbfd zzbfd, zzcfg zzcfg) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, zzcfg);
        zzbt(1, zza);
    }

    public final void zzg(zzbfd zzbfd, zzcfg zzcfg) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, zzcfg);
        zzbt(14, zza);
    }

    public final void zzh(boolean z11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzc(zza, z11);
        zzbt(15, zza);
    }

    public final void zzi(zzbiq zzbiq) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbiq);
        zzbt(8, zza);
    }

    public final void zzj(zzbit zzbit) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbit);
        zzbt(13, zza);
    }

    public final void zzk(zzcfc zzcfc) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzcfc);
        zzbt(2, zza);
    }

    public final void zzl(zzcfn zzcfn) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzcfn);
        zzbt(7, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(5, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z11) throws RemoteException {
        throw null;
    }

    public final boolean zzo() throws RemoteException {
        throw null;
    }

    public final void zzp(zzcfh zzcfh) throws RemoteException {
        throw null;
    }
}
