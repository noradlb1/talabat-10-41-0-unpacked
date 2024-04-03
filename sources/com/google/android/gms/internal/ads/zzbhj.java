package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbhj extends zzaok implements zzbhk {
    public zzbhj() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzbhk zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzbhk) {
            return (zzbhk) queryLocalInterface;
        }
        return new zzbhi(iBinder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: com.google.android.gms.internal.ads.zzbhv} */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzbgx] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzbhr] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzbgu] */
    /* JADX WARNING: type inference failed for: r5v22, types: [com.google.android.gms.internal.ads.zzbho] */
    /* JADX WARNING: type inference failed for: r5v27, types: [com.google.android.gms.internal.ads.zzbit] */
    /* JADX WARNING: type inference failed for: r5v32, types: [com.google.android.gms.internal.ads.zzbha] */
    /* JADX WARNING: type inference failed for: r5v37, types: [com.google.android.gms.internal.ads.zzbhy] */
    /* JADX WARNING: type inference failed for: r5v42 */
    /* JADX WARNING: type inference failed for: r5v43 */
    /* JADX WARNING: type inference failed for: r5v44 */
    /* JADX WARNING: type inference failed for: r5v45 */
    /* JADX WARNING: type inference failed for: r5v46 */
    /* JADX WARNING: type inference failed for: r5v47 */
    /* JADX WARNING: type inference failed for: r5v48 */
    /* JADX WARNING: type inference failed for: r5v49 */
    /* JADX WARNING: type inference failed for: r5v50 */
    /* JADX WARNING: type inference failed for: r5v51 */
    /* JADX WARNING: type inference failed for: r5v52 */
    /* JADX WARNING: type inference failed for: r5v53 */
    /* JADX WARNING: type inference failed for: r5v54 */
    /* JADX WARNING: type inference failed for: r5v55 */
    /* JADX WARNING: type inference failed for: r5v56 */
    /* JADX WARNING: type inference failed for: r5v57 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbQ(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x02af;
                case 2: goto L_0x02a8;
                case 3: goto L_0x029d;
                case 4: goto L_0x028a;
                case 5: goto L_0x0283;
                case 6: goto L_0x027c;
                case 7: goto L_0x025b;
                case 8: goto L_0x023a;
                case 9: goto L_0x0232;
                case 10: goto L_0x022d;
                case 11: goto L_0x0225;
                case 12: goto L_0x0219;
                case 13: goto L_0x0209;
                case 14: goto L_0x01f9;
                case 15: goto L_0x01e5;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x01d9;
                case 19: goto L_0x01c9;
                case 20: goto L_0x01a7;
                case 21: goto L_0x0185;
                case 22: goto L_0x0179;
                case 23: goto L_0x016d;
                case 24: goto L_0x015d;
                case 25: goto L_0x0151;
                case 26: goto L_0x0145;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x0135;
                case 30: goto L_0x0125;
                case 31: goto L_0x0119;
                case 32: goto L_0x010d;
                case 33: goto L_0x0101;
                case 34: goto L_0x00f5;
                case 35: goto L_0x00e9;
                case 36: goto L_0x00c7;
                case 37: goto L_0x00bb;
                case 38: goto L_0x00af;
                case 39: goto L_0x009f;
                case 40: goto L_0x008f;
                case 41: goto L_0x0083;
                case 42: goto L_0x0061;
                case 43: goto L_0x0038;
                case 44: goto L_0x0028;
                case 45: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x000d
            goto L_0x0020
        L_0x000d:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IFullScreenContentCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzbhy
            if (r5 == 0) goto L_0x001b
            r5 = r3
            com.google.android.gms.internal.ads.zzbhy r5 = (com.google.android.gms.internal.ads.zzbhy) r5
            goto L_0x0020
        L_0x001b:
            com.google.android.gms.internal.ads.zzbhw r5 = new com.google.android.gms.internal.ads.zzbhw
            r5.<init>(r2)
        L_0x0020:
            r1.zzJ(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0028:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zzW(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0038:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbfd> r2 = com.google.android.gms.internal.ads.zzbfd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaol.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbfd r2 = (com.google.android.gms.internal.ads.zzbfd) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0047
            goto L_0x0059
        L_0x0047:
            java.lang.String r5 = "com.google.android.gms.ads.internal.client.IAdLoadCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbha
            if (r0 == 0) goto L_0x0054
            com.google.android.gms.internal.ads.zzbha r5 = (com.google.android.gms.internal.ads.zzbha) r5
            goto L_0x0059
        L_0x0054:
            com.google.android.gms.internal.ads.zzbgy r5 = new com.google.android.gms.internal.ads.zzbgy
            r5.<init>(r3)
        L_0x0059:
            r1.zzy(r2, r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0061:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0068
            goto L_0x007b
        L_0x0068:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IOnPaidEventListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzbit
            if (r5 == 0) goto L_0x0076
            r5 = r3
            com.google.android.gms.internal.ads.zzbit r5 = (com.google.android.gms.internal.ads.zzbit) r5
            goto L_0x007b
        L_0x0076:
            com.google.android.gms.internal.ads.zzbir r5 = new com.google.android.gms.internal.ads.zzbir
            r5.<init>(r2)
        L_0x007b:
            r1.zzP(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0083:
            com.google.android.gms.internal.ads.zzbiw r2 = r1.zzk()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r4, r2)
            goto L_0x02b9
        L_0x008f:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzazw r2 = com.google.android.gms.internal.ads.zzazv.zze(r2)
            r1.zzH(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x009f:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbfo> r2 = com.google.android.gms.internal.ads.zzbfo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaol.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbfo r2 = (com.google.android.gms.internal.ads.zzbfo) r2
            r1.zzI(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x00af:
            java.lang.String r2 = r3.readString()
            r1.zzR(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x00bb:
            android.os.Bundle r2 = r1.zzd()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zze(r4, r2)
            goto L_0x02b9
        L_0x00c7:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00ce
            goto L_0x00e1
        L_0x00ce:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzbho
            if (r5 == 0) goto L_0x00dc
            r5 = r3
            com.google.android.gms.internal.ads.zzbho r5 = (com.google.android.gms.internal.ads.zzbho) r5
            goto L_0x00e1
        L_0x00dc:
            com.google.android.gms.internal.ads.zzbhm r5 = new com.google.android.gms.internal.ads.zzbhm
            r5.<init>(r2)
        L_0x00e1:
            r1.zzE(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x00e9:
            java.lang.String r2 = r1.zzt()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02b9
        L_0x00f5:
            boolean r2 = com.google.android.gms.internal.ads.zzaol.zzg(r3)
            r1.zzL(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0101:
            com.google.android.gms.internal.ads.zzbgx r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r4, r2)
            goto L_0x02b9
        L_0x010d:
            com.google.android.gms.internal.ads.zzbhr r2 = r1.zzj()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r4, r2)
            goto L_0x02b9
        L_0x0119:
            java.lang.String r2 = r1.zzr()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02b9
        L_0x0125:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbjd> r2 = com.google.android.gms.internal.ads.zzbjd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaol.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbjd r2 = (com.google.android.gms.internal.ads.zzbjd) r2
            r1.zzK(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0135:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbkq> r2 = com.google.android.gms.internal.ads.zzbkq.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaol.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbkq r2 = (com.google.android.gms.internal.ads.zzbkq) r2
            r1.zzU(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0145:
            com.google.android.gms.internal.ads.zzbiz r2 = r1.zzl()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r4, r2)
            goto L_0x02b9
        L_0x0151:
            java.lang.String r2 = r3.readString()
            r1.zzT(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x015d:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzcem r2 = com.google.android.gms.internal.ads.zzcel.zzb(r2)
            r1.zzS(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x016d:
            boolean r2 = r1.zzY()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzc(r4, r2)
            goto L_0x02b9
        L_0x0179:
            boolean r2 = com.google.android.gms.internal.ads.zzaol.zzg(r3)
            r1.zzN(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0185:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x018c
            goto L_0x019f
        L_0x018c:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzbhv
            if (r5 == 0) goto L_0x019a
            r5 = r3
            com.google.android.gms.internal.ads.zzbhv r5 = (com.google.android.gms.internal.ads.zzbhv) r5
            goto L_0x019f
        L_0x019a:
            com.google.android.gms.internal.ads.zzbhv r5 = new com.google.android.gms.internal.ads.zzbhv
            r5.<init>(r2)
        L_0x019f:
            r1.zzab(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x01a7:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x01ae
            goto L_0x01c1
        L_0x01ae:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzbgu
            if (r5 == 0) goto L_0x01bc
            r5 = r3
            com.google.android.gms.internal.ads.zzbgu r5 = (com.google.android.gms.internal.ads.zzbgu) r5
            goto L_0x01c1
        L_0x01bc:
            com.google.android.gms.internal.ads.zzbgs r5 = new com.google.android.gms.internal.ads.zzbgs
            r5.<init>(r2)
        L_0x01c1:
            r1.zzC(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x01c9:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbme r2 = com.google.android.gms.internal.ads.zzbmd.zzb(r2)
            r1.zzO(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x01d9:
            java.lang.String r2 = r1.zzs()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02b9
        L_0x01e5:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzcce r2 = com.google.android.gms.internal.ads.zzccd.zzb(r2)
            java.lang.String r3 = r3.readString()
            r1.zzQ(r2, r3)
            r4.writeNoException()
            goto L_0x02b9
        L_0x01f9:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzccb r2 = com.google.android.gms.internal.ads.zzcca.zzb(r2)
            r1.zzM(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0209:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbfi> r2 = com.google.android.gms.internal.ads.zzbfi.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaol.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbfi r2 = (com.google.android.gms.internal.ads.zzbfi) r2
            r1.zzF(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0219:
            com.google.android.gms.internal.ads.zzbfi r2 = r1.zzg()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zze(r4, r2)
            goto L_0x02b9
        L_0x0225:
            r1.zzA()
            r4.writeNoException()
            goto L_0x02b9
        L_0x022d:
            r4.writeNoException()
            goto L_0x02b9
        L_0x0232:
            r1.zzX()
            r4.writeNoException()
            goto L_0x02b9
        L_0x023a:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0241
            goto L_0x0254
        L_0x0241:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzbhr
            if (r5 == 0) goto L_0x024f
            r5 = r3
            com.google.android.gms.internal.ads.zzbhr r5 = (com.google.android.gms.internal.ads.zzbhr) r5
            goto L_0x0254
        L_0x024f:
            com.google.android.gms.internal.ads.zzbhp r5 = new com.google.android.gms.internal.ads.zzbhp
            r5.<init>(r2)
        L_0x0254:
            r1.zzG(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x025b:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0262
            goto L_0x0275
        L_0x0262:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzbgx
            if (r5 == 0) goto L_0x0270
            r5 = r3
            com.google.android.gms.internal.ads.zzbgx r5 = (com.google.android.gms.internal.ads.zzbgx) r5
            goto L_0x0275
        L_0x0270:
            com.google.android.gms.internal.ads.zzbgv r5 = new com.google.android.gms.internal.ads.zzbgv
            r5.<init>(r2)
        L_0x0275:
            r1.zzD(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x027c:
            r1.zzB()
            r4.writeNoException()
            goto L_0x02b9
        L_0x0283:
            r1.zzz()
            r4.writeNoException()
            goto L_0x02b9
        L_0x028a:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbfd> r2 = com.google.android.gms.internal.ads.zzbfd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaol.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbfd r2 = (com.google.android.gms.internal.ads.zzbfd) r2
            boolean r2 = r1.zzaa(r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzc(r4, r2)
            goto L_0x02b9
        L_0x029d:
            boolean r2 = r1.zzZ()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzc(r4, r2)
            goto L_0x02b9
        L_0x02a8:
            r1.zzx()
            r4.writeNoException()
            goto L_0x02b9
        L_0x02af:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzn()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r4, r2)
        L_0x02b9:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhj.zzbQ(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
