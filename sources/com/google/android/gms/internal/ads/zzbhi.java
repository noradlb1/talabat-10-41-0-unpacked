package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbhi extends zzaoj implements zzbhk {
    public zzbhi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final void zzA() throws RemoteException {
        zzbt(11, zza());
    }

    public final void zzB() throws RemoteException {
        zzbt(6, zza());
    }

    public final void zzC(zzbgu zzbgu) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbgu);
        zzbt(20, zza);
    }

    public final void zzD(zzbgx zzbgx) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbgx);
        zzbt(7, zza);
    }

    public final void zzE(zzbho zzbho) throws RemoteException {
        throw null;
    }

    public final void zzF(zzbfi zzbfi) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfi);
        zzbt(13, zza);
    }

    public final void zzG(zzbhr zzbhr) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbhr);
        zzbt(8, zza);
    }

    public final void zzH(zzazw zzazw) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzazw);
        zzbt(40, zza);
    }

    public final void zzI(zzbfo zzbfo) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfo);
        zzbt(39, zza);
    }

    public final void zzJ(zzbhy zzbhy) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbhy);
        zzbt(45, zza);
    }

    public final void zzK(zzbjd zzbjd) throws RemoteException {
        throw null;
    }

    public final void zzL(boolean z11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzc(zza, z11);
        zzbt(34, zza);
    }

    public final void zzM(zzccb zzccb) throws RemoteException {
        throw null;
    }

    public final void zzN(boolean z11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzc(zza, z11);
        zzbt(22, zza);
    }

    public final void zzO(zzbme zzbme) throws RemoteException {
        throw null;
    }

    public final void zzP(zzbit zzbit) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbit);
        zzbt(42, zza);
    }

    public final void zzQ(zzcce zzcce, String str) throws RemoteException {
        throw null;
    }

    public final void zzR(String str) throws RemoteException {
        throw null;
    }

    public final void zzS(zzcem zzcem) throws RemoteException {
        throw null;
    }

    public final void zzT(String str) throws RemoteException {
        throw null;
    }

    public final void zzU(zzbkq zzbkq) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbkq);
        zzbt(29, zza);
    }

    public final void zzW(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(44, zza);
    }

    public final void zzX() throws RemoteException {
        throw null;
    }

    public final boolean zzY() throws RemoteException {
        Parcel zzbs = zzbs(23, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzZ() throws RemoteException {
        throw null;
    }

    public final boolean zzaa(zzbfd zzbfd) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfd);
        Parcel zzbs = zzbs(4, zza);
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final void zzab(zzbhv zzbhv) throws RemoteException {
        throw null;
    }

    public final Bundle zzd() throws RemoteException {
        throw null;
    }

    public final zzbfi zzg() throws RemoteException {
        Parcel zzbs = zzbs(12, zza());
        zzbfi zzbfi = (zzbfi) zzaol.zza(zzbs, zzbfi.CREATOR);
        zzbs.recycle();
        return zzbfi;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbgx zzi() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 33
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbgx
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbgx r1 = (com.google.android.gms.internal.ads.zzbgx) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbgv r2 = new com.google.android.gms.internal.ads.zzbgv
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhi.zzi():com.google.android.gms.internal.ads.zzbgx");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbhr zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 32
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbhr
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbhr r1 = (com.google.android.gms.internal.ads.zzbhr) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbhp r2 = new com.google.android.gms.internal.ads.zzbhp
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhi.zzj():com.google.android.gms.internal.ads.zzbhr");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbiw zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 41
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IResponseInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbiw
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbiw r1 = (com.google.android.gms.internal.ads.zzbiw) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbiu r2 = new com.google.android.gms.internal.ads.zzbiu
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhi.zzk():com.google.android.gms.internal.ads.zzbiw");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbiz zzl() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 26
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoController"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbiz
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbiz r1 = (com.google.android.gms.internal.ads.zzbiz) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbix r2 = new com.google.android.gms.internal.ads.zzbix
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhi.zzl():com.google.android.gms.internal.ads.zzbiz");
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbs = zzbs(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final String zzr() throws RemoteException {
        Parcel zzbs = zzbs(31, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        throw null;
    }

    public final String zzt() throws RemoteException {
        throw null;
    }

    public final void zzx() throws RemoteException {
        zzbt(2, zza());
    }

    public final void zzy(zzbfd zzbfd, zzbha zzbha) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfd);
        zzaol.zzf(zza, zzbha);
        zzbt(43, zza);
    }

    public final void zzz() throws RemoteException {
        zzbt(5, zza());
    }
}
