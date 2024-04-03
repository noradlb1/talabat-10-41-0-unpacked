package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzbqd extends zzaoj implements zzbqf {
    public zzbqd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    public final void zzA() throws RemoteException {
        zzbt(28, zza());
    }

    public final void zzB(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, bundle);
        zzbt(17, zza);
    }

    public final void zzC() throws RemoteException {
        zzbt(27, zza());
    }

    public final void zzD(zzbif zzbif) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbif);
        zzbt(26, zza);
    }

    public final void zzE(zzbit zzbit) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbit);
        zzbt(32, zza);
    }

    public final void zzF(zzbqc zzbqc) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbqc);
        zzbt(21, zza);
    }

    public final boolean zzG() throws RemoteException {
        Parcel zzbs = zzbs(30, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzH() throws RemoteException {
        Parcel zzbs = zzbs(24, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzI(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, bundle);
        Parcel zzbs = zzbs(16, zza);
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final double zze() throws RemoteException {
        Parcel zzbs = zzbs(8, zza());
        double readDouble = zzbs.readDouble();
        zzbs.recycle();
        return readDouble;
    }

    public final Bundle zzf() throws RemoteException {
        Parcel zzbs = zzbs(20, zza());
        Bundle bundle = (Bundle) zzaol.zza(zzbs, Bundle.CREATOR);
        zzbs.recycle();
        return bundle;
    }

    public final zzbiw zzg() throws RemoteException {
        Parcel zzbs = zzbs(31, zza());
        zzbiw zzb = zzbiv.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    public final zzbiz zzh() throws RemoteException {
        Parcel zzbs = zzbs(11, zza());
        zzbiz zzb = zzbiy.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzboa zzi() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 14
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IAttributionInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzboa
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzboa r1 = (com.google.android.gms.internal.ads.zzboa) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbny r2 = new com.google.android.gms.internal.ads.zzbny
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqd.zzi():com.google.android.gms.internal.ads.zzboa");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbof zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 29
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbof
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbof r1 = (com.google.android.gms.internal.ads.zzbof) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbod r2 = new com.google.android.gms.internal.ads.zzbod
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqd.zzj():com.google.android.gms.internal.ads.zzbof");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzboi zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 5
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzboi
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzboi r1 = (com.google.android.gms.internal.ads.zzboi) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzbog r2 = new com.google.android.gms.internal.ads.zzbog
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqd.zzk():com.google.android.gms.internal.ads.zzboi");
    }

    public final IObjectWrapper zzl() throws RemoteException {
        Parcel zzbs = zzbs(19, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzbs = zzbs(18, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final String zzn() throws RemoteException {
        Parcel zzbs = zzbs(7, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzo() throws RemoteException {
        Parcel zzbs = zzbs(4, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzp() throws RemoteException {
        Parcel zzbs = zzbs(6, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzq() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzr() throws RemoteException {
        Parcel zzbs = zzbs(12, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        Parcel zzbs = zzbs(10, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzt() throws RemoteException {
        Parcel zzbs = zzbs(9, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final List zzu() throws RemoteException {
        Parcel zzbs = zzbs(3, zza());
        ArrayList zzb = zzaol.zzb(zzbs);
        zzbs.recycle();
        return zzb;
    }

    public final List zzv() throws RemoteException {
        Parcel zzbs = zzbs(23, zza());
        ArrayList zzb = zzaol.zzb(zzbs);
        zzbs.recycle();
        return zzb;
    }

    public final void zzw() throws RemoteException {
        zzbt(22, zza());
    }

    public final void zzx() throws RemoteException {
        zzbt(13, zza());
    }

    public final void zzy(zzbij zzbij) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbij);
        zzbt(25, zza);
    }

    public final void zzz(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, bundle);
        zzbt(15, zza);
    }
}
