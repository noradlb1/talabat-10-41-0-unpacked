package com.google.android.gms.internal.ads;

public abstract class zzbub extends zzaok implements zzbuc {
    public zzbub() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbQ(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 3
            if (r2 == r5) goto L_0x005d
            r5 = 4
            if (r2 == r5) goto L_0x0056
            r5 = 5
            if (r2 == r5) goto L_0x002b
            r5 = 6
            if (r2 == r5) goto L_0x001c
            r3 = 7
            if (r2 == r3) goto L_0x0011
            r2 = 0
            return r2
        L_0x0011:
            com.google.android.gms.internal.ads.zzbof r2 = r1.zzc()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r4, r2)
            goto L_0x0067
        L_0x001c:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zze(r2)
            r4.writeNoException()
            goto L_0x0067
        L_0x002b:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x003b
            r3 = 0
            goto L_0x004f
        L_0x003b:
            java.lang.String r5 = "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbuf
            if (r0 == 0) goto L_0x0049
            r3 = r5
            com.google.android.gms.internal.ads.zzbuf r3 = (com.google.android.gms.internal.ads.zzbuf) r3
            goto L_0x004f
        L_0x0049:
            com.google.android.gms.internal.ads.zzbud r5 = new com.google.android.gms.internal.ads.zzbud
            r5.<init>(r3)
            r3 = r5
        L_0x004f:
            r1.zzf(r2, r3)
            r4.writeNoException()
            goto L_0x0067
        L_0x0056:
            r1.zzd()
            r4.writeNoException()
            goto L_0x0067
        L_0x005d:
            com.google.android.gms.internal.ads.zzbiz r2 = r1.zzb()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r4, r2)
        L_0x0067:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbub.zzbQ(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
