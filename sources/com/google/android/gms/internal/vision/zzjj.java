package com.google.android.gms.internal.vision;

import java.io.IOException;

abstract class zzjj<T, B> {
    public abstract void zza(B b11, int i11, long j11);

    public abstract void zza(B b11, int i11, zzfh zzfh);

    public abstract void zza(B b11, int i11, T t11);

    public abstract void zza(T t11, zzkg zzkg) throws IOException;

    public abstract boolean zza(zzis zzis);

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[LOOP:0: B:16:0x002f->B:19:0x003c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(B r7, com.google.android.gms.internal.vision.zzis r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.getTag()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0061
            if (r0 == r2) goto L_0x0059
            r3 = 2
            if (r0 == r3) goto L_0x0051
            r3 = 4
            r4 = 3
            if (r0 == r4) goto L_0x0028
            if (r0 == r3) goto L_0x0026
            r3 = 5
            if (r0 != r3) goto L_0x0021
            int r8 = r8.zzea()
            r6.zzc(r7, r1, r8)
            return r2
        L_0x0021:
            com.google.android.gms.internal.vision.zzhb r7 = com.google.android.gms.internal.vision.zzhc.zzgr()
            throw r7
        L_0x0026:
            r7 = 0
            return r7
        L_0x0028:
            java.lang.Object r0 = r6.zzif()
            int r4 = r1 << 3
            r3 = r3 | r4
        L_0x002f:
            int r4 = r8.zzdu()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x003e
            boolean r4 = r6.zza(r0, (com.google.android.gms.internal.vision.zzis) r8)
            if (r4 != 0) goto L_0x002f
        L_0x003e:
            int r8 = r8.getTag()
            if (r3 != r8) goto L_0x004c
            java.lang.Object r8 = r6.zzn(r0)
            r6.zza(r7, (int) r1, r8)
            return r2
        L_0x004c:
            com.google.android.gms.internal.vision.zzhc r7 = com.google.android.gms.internal.vision.zzhc.zzgq()
            throw r7
        L_0x0051:
            com.google.android.gms.internal.vision.zzfh r8 = r8.zzed()
            r6.zza(r7, (int) r1, (com.google.android.gms.internal.vision.zzfh) r8)
            return r2
        L_0x0059:
            long r3 = r8.zzdz()
            r6.zzb(r7, r1, r3)
            return r2
        L_0x0061:
            long r3 = r8.zzdx()
            r6.zza(r7, (int) r1, (long) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjj.zza(java.lang.Object, com.google.android.gms.internal.vision.zzis):boolean");
    }

    public abstract void zzb(B b11, int i11, long j11);

    public abstract void zzc(B b11, int i11, int i12);

    public abstract void zzc(T t11, zzkg zzkg) throws IOException;

    public abstract void zzf(Object obj, T t11);

    public abstract void zzg(Object obj);

    public abstract void zzg(Object obj, B b11);

    public abstract T zzh(T t11, T t12);

    public abstract B zzif();

    public abstract T zzn(B b11);

    public abstract int zzr(T t11);

    public abstract T zzv(Object obj);

    public abstract B zzw(Object obj);

    public abstract int zzx(T t11);
}
