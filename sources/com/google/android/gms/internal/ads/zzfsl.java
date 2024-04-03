package com.google.android.gms.internal.ads;

import java.util.Arrays;

class zzfsl<E> extends zzfsm<E> {
    Object[] zza;
    int zzb = 0;
    boolean zzc;

    public zzfsl(int i11) {
        this.zza = new Object[i11];
    }

    private final void zze(int i11) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i11) {
            this.zza = Arrays.copyOf(objArr, zzfsm.zzd(length, i11));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public final zzfsl<E> zza(E e11) {
        e11.getClass();
        zze(this.zzb + 1);
        Object[] objArr = this.zza;
        int i11 = this.zzb;
        this.zzb = i11 + 1;
        objArr[i11] = e11;
        return this;
    }

    public /* bridge */ /* synthetic */ zzfsm zzb(Object obj) {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfsm<E> zzc(java.lang.Iterable<? extends E> r3) {
        /*
            r2 = this;
            int r0 = r2.zzb
            int r1 = r3.size()
            int r0 = r0 + r1
            r2.zze(r0)
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zzfsn
            if (r0 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
        L_0x0012:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0020
            java.lang.Object r0 = r3.next()
            r2.zzb(r0)
            goto L_0x0012
        L_0x0020:
            return r2
        L_0x0021:
            com.google.android.gms.internal.ads.zzfsn r3 = (com.google.android.gms.internal.ads.zzfsn) r3
            java.lang.Object[] r0 = r2.zza
            int r1 = r2.zzb
            int r3 = r3.zza(r0, r1)
            r2.zzb = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfsl.zzc(java.lang.Iterable):com.google.android.gms.internal.ads.zzfsm");
    }
}
