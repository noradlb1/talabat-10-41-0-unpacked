package com.google.android.gms.internal.ads;

import java.io.IOException;

abstract class zzgnf<T, B> {
    public abstract int zza(T t11);

    public abstract int zzb(T t11);

    public abstract B zzc(Object obj);

    public abstract T zzd(Object obj);

    public abstract T zze(T t11, T t12);

    public abstract B zzf();

    public abstract T zzg(B b11);

    public abstract void zzh(B b11, int i11, int i12);

    public abstract void zzi(B b11, int i11, long j11);

    public abstract void zzj(B b11, int i11, T t11);

    public abstract void zzk(B b11, int i11, zzgjf zzgjf);

    public abstract void zzl(B b11, int i11, long j11);

    public abstract void zzm(Object obj);

    public abstract void zzn(Object obj, B b11);

    public abstract void zzo(Object obj, T t11);

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[LOOP:0: B:16:0x002f->B:19:0x003c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzp(B r7, com.google.android.gms.internal.ads.zzgmg r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.zzd()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0060
            if (r0 == r2) goto L_0x0058
            r3 = 2
            if (r0 == r3) goto L_0x0050
            r3 = 4
            r4 = 3
            if (r0 == r4) goto L_0x0028
            if (r0 == r3) goto L_0x0026
            r3 = 5
            if (r0 != r3) goto L_0x0021
            int r8 = r8.zzf()
            r6.zzh(r7, r1, r8)
            return r2
        L_0x0021:
            com.google.android.gms.internal.ads.zzgkw r7 = com.google.android.gms.internal.ads.zzgkx.zza()
            throw r7
        L_0x0026:
            r7 = 0
            return r7
        L_0x0028:
            java.lang.Object r0 = r6.zzf()
            int r4 = r1 << 3
            r3 = r3 | r4
        L_0x002f:
            int r4 = r8.zzc()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x003e
            boolean r4 = r6.zzp(r0, r8)
            if (r4 != 0) goto L_0x002f
        L_0x003e:
            int r8 = r8.zzd()
            if (r3 != r8) goto L_0x004b
            r6.zzg(r0)
            r6.zzj(r7, r1, r0)
            return r2
        L_0x004b:
            com.google.android.gms.internal.ads.zzgkx r7 = com.google.android.gms.internal.ads.zzgkx.zzb()
            throw r7
        L_0x0050:
            com.google.android.gms.internal.ads.zzgjf r8 = r8.zzp()
            r6.zzk(r7, r1, r8)
            return r2
        L_0x0058:
            long r3 = r8.zzk()
            r6.zzi(r7, r1, r3)
            return r2
        L_0x0060:
            long r3 = r8.zzl()
            r6.zzl(r7, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgnf.zzp(java.lang.Object, com.google.android.gms.internal.ads.zzgmg):boolean");
    }

    public abstract boolean zzq(zzgmg zzgmg);

    public abstract void zzr(T t11, zzgjt zzgjt) throws IOException;
}
