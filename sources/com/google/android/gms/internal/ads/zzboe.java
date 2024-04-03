package com.google.android.gms.internal.ads;

public abstract class zzboe extends zzaok implements zzbof {
    public zzboe() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbQ(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 2: goto L_0x006e;
                case 3: goto L_0x005f;
                case 4: goto L_0x0054;
                case 5: goto L_0x0049;
                case 6: goto L_0x003e;
                case 7: goto L_0x0033;
                case 8: goto L_0x0028;
                case 9: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x000d
            r1 = 0
            goto L_0x0021
        L_0x000d:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzbpq
            if (r4 == 0) goto L_0x001b
            r1 = r2
            com.google.android.gms.internal.ads.zzbpq r1 = (com.google.android.gms.internal.ads.zzbpq) r1
            goto L_0x0021
        L_0x001b:
            com.google.android.gms.internal.ads.zzbpq r2 = new com.google.android.gms.internal.ads.zzbpq
            r2.<init>(r1)
            r1 = r2
        L_0x0021:
            r0.zzl(r1)
            r3.writeNoException()
            goto L_0x0078
        L_0x0028:
            boolean r1 = r0.zzk()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzc(r3, r1)
            goto L_0x0078
        L_0x0033:
            com.google.android.gms.internal.ads.zzbiz r1 = r0.zzh()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r3, r1)
            goto L_0x0078
        L_0x003e:
            float r1 = r0.zzf()
            r3.writeNoException()
            r3.writeFloat(r1)
            goto L_0x0078
        L_0x0049:
            float r1 = r0.zzg()
            r3.writeNoException()
            r3.writeFloat(r1)
            goto L_0x0078
        L_0x0054:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzi()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r3, r1)
            goto L_0x0078
        L_0x005f:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzj(r1)
            r3.writeNoException()
            goto L_0x0078
        L_0x006e:
            float r1 = r0.zze()
            r3.writeNoException()
            r3.writeFloat(r1)
        L_0x0078:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzboe.zzbQ(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
