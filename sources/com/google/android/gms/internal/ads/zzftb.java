package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

public final class zzftb<E> extends zzfsl<E> {
    @CheckForNull
    Object[] zzd;
    private int zze;

    public zzftb() {
        super(4);
    }

    public final /* bridge */ /* synthetic */ zzfsm zzb(Object obj) {
        zze(obj);
        return this;
    }

    public final zzftb<E> zze(E e11) {
        int length;
        e11.getClass();
        if (this.zzd == null || zzftc.zzh(this.zzb) > (length = this.zzd.length)) {
            this.zzd = null;
            super.zza(e11);
            return this;
        }
        int i11 = length - 1;
        int hashCode = e11.hashCode();
        int zza = zzfsk.zza(hashCode);
        while (true) {
            int i12 = zza & i11;
            Object[] objArr = this.zzd;
            Object obj = objArr[i12];
            if (obj != null) {
                if (obj.equals(e11)) {
                    break;
                }
                zza = i12 + 1;
            } else {
                objArr[i12] = e11;
                this.zze += hashCode;
                super.zza(e11);
                break;
            }
        }
        return this;
    }

    public final zzftb<E> zzf(Iterable<? extends E> iterable) {
        if (this.zzd != null) {
            for (Object zze2 : iterable) {
                zze(zze2);
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.gms.internal.ads.zzfum} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzftc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.google.android.gms.internal.ads.zzfum} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.ads.zzfum} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzftc<E> zzg() {
        /*
            r8 = this;
            int r0 = r8.zzb
            if (r0 == 0) goto L_0x005d
            r1 = 1
            if (r0 == r1) goto L_0x004f
            java.lang.Object[] r2 = r8.zzd
            if (r2 == 0) goto L_0x003b
            int r0 = com.google.android.gms.internal.ads.zzftc.zzh(r0)
            java.lang.Object[] r2 = r8.zzd
            int r2 = r2.length
            if (r0 != r2) goto L_0x003b
            int r0 = r8.zzb
            java.lang.Object[] r2 = r8.zza
            int r2 = r2.length
            boolean r0 = com.google.android.gms.internal.ads.zzftc.zzq(r0, r2)
            if (r0 == 0) goto L_0x0028
            java.lang.Object[] r0 = r8.zza
            int r2 = r8.zzb
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            goto L_0x002a
        L_0x0028:
            java.lang.Object[] r0 = r8.zza
        L_0x002a:
            r3 = r0
            com.google.android.gms.internal.ads.zzfum r0 = new com.google.android.gms.internal.ads.zzfum
            int r4 = r8.zze
            java.lang.Object[] r5 = r8.zzd
            int r2 = r5.length
            int r6 = r2 + -1
            int r7 = r8.zzb
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0049
        L_0x003b:
            int r0 = r8.zzb
            java.lang.Object[] r2 = r8.zza
            com.google.android.gms.internal.ads.zzftc r0 = com.google.android.gms.internal.ads.zzftc.zzp(r0, r2)
            int r2 = r0.size()
            r8.zzb = r2
        L_0x0049:
            r8.zzc = r1
            r1 = 0
            r8.zzd = r1
            return r0
        L_0x004f:
            java.lang.Object[] r0 = r8.zza
            r1 = 0
            r0 = r0[r1]
            r0.getClass()
            com.google.android.gms.internal.ads.zzfur r1 = new com.google.android.gms.internal.ads.zzfur
            r1.<init>(r0)
            return r1
        L_0x005d:
            com.google.android.gms.internal.ads.zzfum<java.lang.Object> r0 = com.google.android.gms.internal.ads.zzfum.zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzftb.zzg():com.google.android.gms.internal.ads.zzftc");
    }

    public zzftb(int i11) {
        super(i11);
        this.zzd = new Object[zzftc.zzh(i11)];
    }
}
