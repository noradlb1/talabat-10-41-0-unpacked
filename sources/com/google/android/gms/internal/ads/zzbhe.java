package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class zzbhe extends zzaoj implements zzbhg {
    public zzbhe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbhd zze() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 1
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzbs(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbhd
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzbhd r1 = (com.google.android.gms.internal.ads.zzbhd) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzbhb r2 = new com.google.android.gms.internal.ads.zzbhb
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhe.zze():com.google.android.gms.internal.ads.zzbhd");
    }

    public final void zzf(zzbpg zzbpg) throws RemoteException {
        throw null;
    }

    public final void zzg(zzbpj zzbpj) throws RemoteException {
        throw null;
    }

    public final void zzh(String str, zzbpp zzbpp, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaol.zzf(zza, zzbpp);
        zzaol.zzf(zza, zzbpm);
        zzbt(5, zza);
    }

    public final void zzi(zzbui zzbui) throws RemoteException {
        throw null;
    }

    public final void zzj(zzbpt zzbpt, zzbfi zzbfi) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbpt);
        zzaol.zzd(zza, zzbfi);
        zzbt(8, zza);
    }

    public final void zzk(zzbpw zzbpw) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbpw);
        zzbt(10, zza);
    }

    public final void zzl(zzbgx zzbgx) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzf(zza, zzbgx);
        zzbt(2, zza);
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, adManagerAdViewOptions);
        zzbt(15, zza);
    }

    public final void zzn(zzbtz zzbtz) throws RemoteException {
        throw null;
    }

    public final void zzo(zzbnw zzbnw) throws RemoteException {
        Parcel zza = zza();
        zzaol.zzd(zza, zzbnw);
        zzbt(6, zza);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        throw null;
    }

    public final void zzq(zzbhv zzbhv) throws RemoteException {
        throw null;
    }
}
