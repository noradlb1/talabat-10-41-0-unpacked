package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzcq<T> implements zzda<T> {
    private final zzck zzkw;
    private final boolean zzkx;
    private final zzds<?, ?> zzlg;
    private final zzar<?> zzlh;

    private zzcq(zzds<?, ?> zzds, zzar<?> zzar, zzck zzck) {
        this.zzlg = zzds;
        this.zzkx = zzar.zzf(zzck);
        this.zzlh = zzar;
        this.zzkw = zzck;
    }

    public static <T> zzcq<T> zzb(zzds<?, ?> zzds, zzar<?> zzar, zzck zzck) {
        return new zzcq<>(zzds, zzar, zzck);
    }

    public final boolean equals(T t11, T t12) {
        if (!this.zzlg.zzr(t11).equals(this.zzlg.zzr(t12))) {
            return false;
        }
        if (this.zzkx) {
            return this.zzlh.zzb((Object) t11).equals(this.zzlh.zzb((Object) t12));
        }
        return true;
    }

    public final int hashCode(T t11) {
        int hashCode = this.zzlg.zzr(t11).hashCode();
        if (this.zzkx) {
            return (hashCode * 53) + this.zzlh.zzb((Object) t11).hashCode();
        }
        return hashCode;
    }

    public final T newInstance() {
        return this.zzkw.zzbl().zzbe();
    }

    public final void zzd(T t11, T t12) {
        zzdc.zzb(this.zzlg, t11, t12);
        if (this.zzkx) {
            zzdc.zzb(this.zzlh, t11, t12);
        }
    }

    public final int zzn(T t11) {
        zzds<?, ?> zzds = this.zzlg;
        int zzs = zzds.zzs(zzds.zzr(t11)) + 0;
        if (this.zzkx) {
            return zzs + this.zzlh.zzb((Object) t11).zzav();
        }
        return zzs;
    }

    public final boolean zzp(T t11) {
        return this.zzlh.zzb((Object) t11).isInitialized();
    }

    public final void zzb(T t11, zzel zzel) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzlh.zzb((Object) t11).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzax zzax = (zzax) next.getKey();
            if (zzax.zzay() != zzem.MESSAGE || zzax.zzaz() || zzax.zzba()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzbn) {
                zzel.zzb(zzax.zzaw(), (Object) ((zzbn) next).zzbx().zzv());
            } else {
                zzel.zzb(zzax.zzaw(), next.getValue());
            }
        }
        zzds<?, ?> zzds = this.zzlg;
        zzds.zzd(zzds.zzr(t11), zzel);
    }

    public final void zzd(T t11) {
        this.zzlg.zzd(t11);
        this.zzlh.zzd(t11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.places.zzbc$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.places.zzr r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.places.zzbc r0 = (com.google.android.gms.internal.places.zzbc) r0
            com.google.android.gms.internal.places.zzdr r1 = r0.zzih
            com.google.android.gms.internal.places.zzdr r2 = com.google.android.gms.internal.places.zzdr.zzdh()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.places.zzdr r1 = com.google.android.gms.internal.places.zzdr.zzdi()
            r0.zzih = r1
        L_0x0011:
            com.google.android.gms.internal.places.zzbc$zzc r10 = (com.google.android.gms.internal.places.zzbc.zzc) r10
            r10.zzbm()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r11, r12, r14)
            int r2 = r14.zzdz
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.places.zzar<?> r12 = r9.zzlh
            com.google.android.gms.internal.places.zzap r0 = r14.zzec
            com.google.android.gms.internal.places.zzck r3 = r9.zzkw
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zzb(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.places.zzbc$zzf r0 = (com.google.android.gms.internal.places.zzbc.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.places.zzs.zzb((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzdr) r6, (com.google.android.gms.internal.places.zzr) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.places.zzcv.zzcq()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.places.zzs.zzb((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.places.zzr) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r11, r4, r14)
            int r5 = r14.zzdz
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.places.zzs.zzf(r11, r4, r14)
            java.lang.Object r2 = r14.zzeb
            com.google.android.gms.internal.places.zzw r2 = (com.google.android.gms.internal.places.zzw) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.places.zzcv.zzcq()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r11, r4, r14)
            int r12 = r14.zzdz
            com.google.android.gms.internal.places.zzar<?> r0 = r9.zzlh
            com.google.android.gms.internal.places.zzap r5 = r14.zzec
            com.google.android.gms.internal.places.zzck r6 = r9.zzkw
            java.lang.Object r0 = r0.zzb(r5, r6, r12)
            com.google.android.gms.internal.places.zzbc$zzf r0 = (com.google.android.gms.internal.places.zzbc.zzf) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.places.zzs.zzb((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.places.zzr) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzc(r12, r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.places.zzbk r10 = com.google.android.gms.internal.places.zzbk.zzbt()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzcq.zzb(java.lang.Object, byte[], int, int, com.google.android.gms.internal.places.zzr):void");
    }
}
