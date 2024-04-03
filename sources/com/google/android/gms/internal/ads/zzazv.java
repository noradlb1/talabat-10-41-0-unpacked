package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzazv extends zzaok implements zzazw {
    public zzazv() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzazw zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        if (queryLocalInterface instanceof zzazw) {
            return (zzazw) queryLocalInterface;
        }
        return new zzazu(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbQ(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 1
            if (r2 == r5) goto L_0x001b
            r0 = 2
            if (r2 == r0) goto L_0x0017
            r0 = 3
            if (r2 == r0) goto L_0x000b
            r2 = 0
            return r2
        L_0x000b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbew> r2 = com.google.android.gms.internal.ads.zzbew.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaol.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbew r2 = (com.google.android.gms.internal.ads.zzbew) r2
            r1.zzc(r2)
            goto L_0x003a
        L_0x0017:
            r3.readInt()
            goto L_0x003a
        L_0x001b:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0023
            r2 = 0
            goto L_0x0037
        L_0x0023:
            java.lang.String r3 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zzazt
            if (r0 == 0) goto L_0x0031
            r2 = r3
            com.google.android.gms.internal.ads.zzazt r2 = (com.google.android.gms.internal.ads.zzazt) r2
            goto L_0x0037
        L_0x0031:
            com.google.android.gms.internal.ads.zzazr r3 = new com.google.android.gms.internal.ads.zzazr
            r3.<init>(r2)
            r2 = r3
        L_0x0037:
            r1.zzd(r2)
        L_0x003a:
            r4.writeNoException()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazv.zzbQ(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
