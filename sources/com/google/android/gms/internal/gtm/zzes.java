package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzes extends zzn implements zzer {
    public zzes() {
        super("com.google.android.gms.tagmanager.internal.ITagManagerService");
    }

    public static zzer zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.internal.ITagManagerService");
        if (queryLocalInterface instanceof zzer) {
            return (zzer) queryLocalInterface;
        }
        return new zzet(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
        /*
            r7 = this;
            r11 = 1
            if (r8 == r11) goto L_0x0065
            r0 = 2
            if (r8 == r0) goto L_0x0039
            r0 = 3
            if (r8 == r0) goto L_0x0035
            r0 = 101(0x65, float:1.42E-43)
            if (r8 == r0) goto L_0x0017
            r9 = 102(0x66, float:1.43E-43)
            if (r8 == r9) goto L_0x0013
            r8 = 0
            return r8
        L_0x0013:
            r7.dispatch()
            goto L_0x0074
        L_0x0017:
            java.lang.String r1 = r9.readString()
            android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.gtm.zzo.zza((android.os.Parcel) r9, r8)
            r2 = r8
            android.os.Bundle r2 = (android.os.Bundle) r2
            java.lang.String r3 = r9.readString()
            long r4 = r9.readLong()
            boolean r6 = com.google.android.gms.internal.gtm.zzo.zza(r9)
            r0 = r7
            r0.zza(r1, r2, r3, r4, r6)
            goto L_0x0074
        L_0x0035:
            r7.zzkm()
            goto L_0x0074
        L_0x0039:
            java.lang.String r8 = r9.readString()
            java.lang.String r0 = r9.readString()
            java.lang.String r1 = r9.readString()
            android.os.IBinder r9 = r9.readStrongBinder()
            if (r9 != 0) goto L_0x004d
            r9 = 0
            goto L_0x0061
        L_0x004d:
            java.lang.String r2 = "com.google.android.gms.tagmanager.internal.ITagManagerLoadContainerCallback"
            android.os.IInterface r2 = r9.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.gtm.zzeo
            if (r3 == 0) goto L_0x005b
            r9 = r2
            com.google.android.gms.internal.gtm.zzeo r9 = (com.google.android.gms.internal.gtm.zzeo) r9
            goto L_0x0061
        L_0x005b:
            com.google.android.gms.internal.gtm.zzeq r2 = new com.google.android.gms.internal.gtm.zzeq
            r2.<init>(r9)
            r9 = r2
        L_0x0061:
            r7.zza(r8, r0, r1, r9)
            goto L_0x0074
        L_0x0065:
            java.lang.String r8 = r9.readString()
            java.lang.String r0 = r9.readString()
            java.lang.String r9 = r9.readString()
            r7.zzc(r8, r0, r9)
        L_0x0074:
            r10.writeNoException()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzes.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
