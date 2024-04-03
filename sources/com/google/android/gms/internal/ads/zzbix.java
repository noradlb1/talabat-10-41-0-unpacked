package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbix extends zzaoj implements zzbiz {
    public zzbix(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final float zze() throws RemoteException {
        throw null;
    }

    public final float zzf() throws RemoteException {
        throw null;
    }

    public final float zzg() throws RemoteException {
        throw null;
    }

    public final int zzh() throws RemoteException {
        Parcel zzbs = zzbs(5, zza());
        int readInt = zzbs.readInt();
        zzbs.recycle();
        return readInt;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbjc zzi() throws android.os.RemoteException {
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
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbjc
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbjc r1 = (com.google.android.gms.internal.ads.zzbjc) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbja r2 = new com.google.android.gms.internal.ads.zzbja
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbix.zzi():com.google.android.gms.internal.ads.zzbjc");
    }

    public final void zzj(boolean z11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzc(zza, z11);
        zzbt(3, zza);
    }

    public final void zzk() throws RemoteException {
        zzbt(2, zza());
    }

    public final void zzl() throws RemoteException {
        zzbt(1, zza());
    }

    public final void zzm(zzbjc zzbjc) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbjc);
        zzbt(8, zza);
    }

    public final void zzn() throws RemoteException {
        zzbt(13, zza());
    }

    public final boolean zzo() throws RemoteException {
        Parcel zzbs = zzbs(12, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzbs = zzbs(10, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzbs = zzbs(4, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }
}
