package com.google.android.gms.internal.ads;

public abstract class zzcfb extends zzaok implements zzcfc {
    public zzcfb() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbQ(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x0045;
                case 2: goto L_0x0041;
                case 3: goto L_0x0021;
                case 4: goto L_0x0019;
                case 5: goto L_0x000d;
                case 6: goto L_0x0009;
                case 7: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            r0.zze()
            goto L_0x0048
        L_0x0009:
            r0.zzf()
            goto L_0x0048
        L_0x000d:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbew> r1 = com.google.android.gms.internal.ads.zzbew.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzaol.zza(r2, r1)
            com.google.android.gms.internal.ads.zzbew r1 = (com.google.android.gms.internal.ads.zzbew) r1
            r0.zzi(r1)
            goto L_0x0048
        L_0x0019:
            int r1 = r2.readInt()
            r0.zzh(r1)
            goto L_0x0048
        L_0x0021:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0029
            r1 = 0
            goto L_0x003d
        L_0x0029:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzcew
            if (r4 == 0) goto L_0x0037
            r1 = r2
            com.google.android.gms.internal.ads.zzcew r1 = (com.google.android.gms.internal.ads.zzcew) r1
            goto L_0x003d
        L_0x0037:
            com.google.android.gms.internal.ads.zzceu r2 = new com.google.android.gms.internal.ads.zzceu
            r2.<init>(r1)
            r1 = r2
        L_0x003d:
            r0.zzk(r1)
            goto L_0x0048
        L_0x0041:
            r0.zzg()
            goto L_0x0048
        L_0x0045:
            r0.zzj()
        L_0x0048:
            r3.writeNoException()
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfb.zzbQ(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
