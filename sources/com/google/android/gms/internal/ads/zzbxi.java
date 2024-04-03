package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public final class zzbxi extends zzaoj implements zzbxk {
    public zzbxi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(zzbfd zzbfd, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzB(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzbfd);
        zza.writeString(str);
        zzaol.zzf(zza, zzbxn);
        zzbt(32, zza);
    }

    public final void zzC(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(21, zza);
    }

    public final void zzD() throws RemoteException {
        zzbt(8, zza());
    }

    public final void zzE() throws RemoteException {
        zzbt(9, zza());
    }

    public final void zzF(boolean z11) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzc(zza, z11);
        zzbt(25, zza);
    }

    public final void zzG() throws RemoteException {
        zzbt(4, zza());
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(37, zza);
    }

    public final void zzI(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(30, zza);
    }

    public final void zzJ() throws RemoteException {
        zzbt(12, zza());
    }

    public final boolean zzK() throws RemoteException {
        Parcel zzbs = zzbs(22, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzL() throws RemoteException {
        Parcel zzbs = zzbs(13, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbxs zzM() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 15
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbxs
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbxs r1 = (com.google.android.gms.internal.ads.zzbxs) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbxs r2 = new com.google.android.gms.internal.ads.zzbxs
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxi.zzM():com.google.android.gms.internal.ads.zzbxs");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbxt zzN() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 16
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbxt
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbxt r1 = (com.google.android.gms.internal.ads.zzbxt) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbxt r2 = new com.google.android.gms.internal.ads.zzbxt
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxi.zzN():com.google.android.gms.internal.ads.zzbxt");
    }

    public final Bundle zze() throws RemoteException {
        throw null;
    }

    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    public final zzbiz zzh() throws RemoteException {
        Parcel zzbs = zzbs(26, zza());
        zzbiz zzb = zzbiy.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    public final zzbpc zzi() throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbxq zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 36
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbxq
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbxq r1 = (com.google.android.gms.internal.ads.zzbxq) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbxo r2 = new com.google.android.gms.internal.ads.zzbxo
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxi.zzj():com.google.android.gms.internal.ads.zzbxq");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbxw zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 27
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbxw
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbxw r1 = (com.google.android.gms.internal.ads.zzbxw) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbxu r2 = new com.google.android.gms.internal.ads.zzbxu
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxi.zzk():com.google.android.gms.internal.ads.zzbxw");
    }

    public final zzcab zzl() throws RemoteException {
        Parcel zzbs = zzbs(33, zza());
        zzcab zzcab = (zzcab) zzaol.zza(zzbs, zzcab.CREATOR);
        zzbs.recycle();
        return zzcab;
    }

    public final zzcab zzm() throws RemoteException {
        Parcel zzbs = zzbs(34, zza());
        zzcab zzcab = (zzcab) zzaol.zza(zzbs, zzcab.CREATOR);
        zzbs.recycle();
        return zzcab;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbs = zzbs(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final void zzo() throws RemoteException {
        zzbt(5, zza());
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzcer zzcer, String str2) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzbfd);
        zza.writeString((String) null);
        zzaol.zzf(zza, zzcer);
        zza.writeString(str2);
        zzbt(10, zza);
    }

    public final void zzq(IObjectWrapper iObjectWrapper, zzbtr zzbtr, List<zzbtx> list) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzbtr);
        zza.writeTypedList(list);
        zzbt(31, zza);
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzcer zzcer, List<String> list) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzf(zza, zzcer);
        zza.writeStringList(list);
        zzbt(23, zza);
    }

    public final void zzs(zzbfd zzbfd, String str) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbfd);
        zza.writeString(str);
        zzbt(11, zza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        throw null;
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzbfi);
        zzaol.zzd(zza, zzbfd);
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzf(zza, zzbxn);
        zzbt(6, zza);
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzbfi zzbfi, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzbfi);
        zzaol.zzd(zza, zzbfd);
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzf(zza, zzbxn);
        zzbt(35, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        throw null;
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, String str2, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzbfd);
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzf(zza, zzbxn);
        zzbt(7, zza);
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, String str2, zzbxn zzbxn, zzbnw zzbnw, List<String> list) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzbfd);
        zza.writeString(str);
        zza.writeString(str2);
        zzaol.zzf(zza, zzbxn);
        zzaol.zzd(zza, zzbnw);
        zza.writeStringList(list);
        zzbt(14, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzbfd zzbfd, String str, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzaol.zzd(zza, zzbfd);
        zza.writeString(str);
        zzaol.zzf(zza, zzbxn);
        zzbt(28, zza);
    }
}
