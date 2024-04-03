package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzbpa extends zzaoj implements zzbpc {
    public zzbpa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final zzbiz zze() throws RemoteException {
        Parcel zzbs = zzbs(7, zza());
        zzbiz zzb = zzbiy.zzb(zzbs.readStrongBinder());
        zzbs.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzboi zzf(java.lang.String r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            r0.writeString(r4)
            r4 = 2
            android.os.Parcel r4 = r3.zzbs(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzboi
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzboi r0 = (com.google.android.gms.internal.ads.zzboi) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzbog r1 = new com.google.android.gms.internal.ads.zzbog
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpa.zzf(java.lang.String):com.google.android.gms.internal.ads.zzboi");
    }

    public final IObjectWrapper zzg() throws RemoteException {
        Parcel zzbs = zzbs(9, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbs.readStrongBinder());
        zzbs.recycle();
        return asInterface;
    }

    public final String zzh() throws RemoteException {
        Parcel zzbs = zzbs(4, zza());
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final String zzi(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbs = zzbs(1, zza);
        String readString = zzbs.readString();
        zzbs.recycle();
        return readString;
    }

    public final List<String> zzj() throws RemoteException {
        Parcel zzbs = zzbs(3, zza());
        ArrayList<String> createStringArrayList = zzbs.createStringArrayList();
        zzbs.recycle();
        return createStringArrayList;
    }

    public final void zzk() throws RemoteException {
        zzbt(8, zza());
    }

    public final void zzl() throws RemoteException {
        zzbt(15, zza());
    }

    public final void zzm(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbt(5, zza);
    }

    public final void zzn() throws RemoteException {
        zzbt(6, zza());
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        zzbt(14, zza);
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzbs = zzbs(12, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, iObjectWrapper);
        Parcel zzbs = zzbs(10, zza);
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }

    public final boolean zzr() throws RemoteException {
        Parcel zzbs = zzbs(13, zza());
        boolean zzg = zzaol.zzg(zzbs);
        zzbs.recycle();
        return zzg;
    }
}
