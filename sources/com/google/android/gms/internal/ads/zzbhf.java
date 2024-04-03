package com.google.android.gms.internal.ads;

public abstract class zzbhf extends zzaok implements zzbhg {
    public zzbhf() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: com.google.android.gms.internal.ads.zzbhv} */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzbgx] */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbQ(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x00f9;
                case 2: goto L_0x00d8;
                case 3: goto L_0x00c9;
                case 4: goto L_0x00ba;
                case 5: goto L_0x009f;
                case 6: goto L_0x0090;
                case 7: goto L_0x006e;
                case 8: goto L_0x0056;
                case 9: goto L_0x0046;
                case 10: goto L_0x0036;
                case 11: goto L_0x0004;
                case 12: goto L_0x0004;
                case 13: goto L_0x0026;
                case 14: goto L_0x0016;
                case 15: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.AdManagerAdViewOptions> r1 = com.google.android.gms.ads.formats.AdManagerAdViewOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzaol.zza(r2, r1)
            com.google.android.gms.ads.formats.AdManagerAdViewOptions r1 = (com.google.android.gms.ads.formats.AdManagerAdViewOptions) r1
            r0.zzm(r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0016:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbui r1 = com.google.android.gms.internal.ads.zzbuh.zzb(r1)
            r0.zzi(r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0026:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbtz> r1 = com.google.android.gms.internal.ads.zzbtz.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzaol.zza(r2, r1)
            com.google.android.gms.internal.ads.zzbtz r1 = (com.google.android.gms.internal.ads.zzbtz) r1
            r0.zzn(r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0036:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbpw r1 = com.google.android.gms.internal.ads.zzbpv.zzb(r1)
            r0.zzk(r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0046:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.PublisherAdViewOptions> r1 = com.google.android.gms.ads.formats.PublisherAdViewOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzaol.zza(r2, r1)
            com.google.android.gms.ads.formats.PublisherAdViewOptions r1 = (com.google.android.gms.ads.formats.PublisherAdViewOptions) r1
            r0.zzp(r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0056:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbpt r1 = com.google.android.gms.internal.ads.zzbps.zzb(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbfi> r4 = com.google.android.gms.internal.ads.zzbfi.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaol.zza(r2, r4)
            com.google.android.gms.internal.ads.zzbfi r2 = (com.google.android.gms.internal.ads.zzbfi) r2
            r0.zzj(r1, r2)
            r3.writeNoException()
            goto L_0x0103
        L_0x006e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0075
            goto L_0x0088
        L_0x0075:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzbhv
            if (r4 == 0) goto L_0x0083
            r4 = r2
            com.google.android.gms.internal.ads.zzbhv r4 = (com.google.android.gms.internal.ads.zzbhv) r4
            goto L_0x0088
        L_0x0083:
            com.google.android.gms.internal.ads.zzbhv r4 = new com.google.android.gms.internal.ads.zzbhv
            r4.<init>(r1)
        L_0x0088:
            r0.zzq(r4)
            r3.writeNoException()
            goto L_0x0103
        L_0x0090:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbnw> r1 = com.google.android.gms.internal.ads.zzbnw.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzaol.zza(r2, r1)
            com.google.android.gms.internal.ads.zzbnw r1 = (com.google.android.gms.internal.ads.zzbnw) r1
            r0.zzo(r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x009f:
            java.lang.String r1 = r2.readString()
            android.os.IBinder r4 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbpp r4 = com.google.android.gms.internal.ads.zzbpo.zzb(r4)
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbpm r2 = com.google.android.gms.internal.ads.zzbpl.zzb(r2)
            r0.zzh(r1, r4, r2)
            r3.writeNoException()
            goto L_0x0103
        L_0x00ba:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbpj r1 = com.google.android.gms.internal.ads.zzbpi.zzb(r1)
            r0.zzg(r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x00c9:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbpg r1 = com.google.android.gms.internal.ads.zzbpf.zzb(r1)
            r0.zzf(r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x00d8:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00df
            goto L_0x00f2
        L_0x00df:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzbgx
            if (r4 == 0) goto L_0x00ed
            r4 = r2
            com.google.android.gms.internal.ads.zzbgx r4 = (com.google.android.gms.internal.ads.zzbgx) r4
            goto L_0x00f2
        L_0x00ed:
            com.google.android.gms.internal.ads.zzbgv r4 = new com.google.android.gms.internal.ads.zzbgv
            r4.<init>(r1)
        L_0x00f2:
            r0.zzl(r4)
            r3.writeNoException()
            goto L_0x0103
        L_0x00f9:
            com.google.android.gms.internal.ads.zzbhd r1 = r0.zze()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzaol.zzf(r3, r1)
        L_0x0103:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhf.zzbQ(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
